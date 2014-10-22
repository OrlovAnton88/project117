package ru.aorlov.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.aorlov.dto.MaterialDTO;
import ru.aorlov.model.studymaterial.Category;
import ru.aorlov.model.studymaterial.Material;
import ru.aorlov.service.studymaterial.CategoryService;
import ru.aorlov.service.studymaterial.MaterialNotFoundException;
import ru.aorlov.service.studymaterial.MaterialService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;

/**
 * Created by anton on 18.10.14.
 */
@Controller
public class MaterialController {
    private final static Logger LOGGER = LoggerFactory
            .getLogger(MaterialController.class);

    private static final String MODEL_ATTRIBUTE_MATERIAL = "material";
    private static final String MODEL_ATTRIBUTE_MATERIALS = "materials";

    private static final String MODEL_ATTRIBUTE_CATEGORIES = "categories";
    private static final String MODEL_ATTRIBUTE_CATEGORY = "category";

    private static final String MATERIAL_ADD_FORM_VIEW = "/material/create";
    private static final String MATERIAL_EDIT_FORM_VIEW = "/material/edit";
    protected static final String MATERIAL_LIST_VIEW = "/material/material_list";
    protected static final String REQUEST_MAPPING_LIST = "/material/list";
    private static final String VIEW_REDIRECT_PREFIX = "redirect:";

    protected static final String FEEDBACK_MESSAGE_KEY_MATERIAL_CREATED = "feedback.message.material.created";
    protected static final String FEEDBACK_MESSAGE_KEY_MATERIAL_DELETED = "feedback.message.material.deleted";
    protected static final String FEEDBACK_MESSAGE_KEY_MATERIAL_EDITED = "feedback.message.material.edited";
    private static final String FLASH_FEEDBACK_MESSAGE = "feedbackMessage";
    private static final String FLASH_ERROR_MESSAGE = "errorMessage";


    protected static final String ERROR_MESSAGE_KEY_DELETED_MATERIAL_WAS_NOT_FOUND = "error.message.deleted.not.found";
    protected static final String ERROR_MESSAGE_KEY_EDITED_MATERIAL_WAS_NOT_FOUND = "error.message.edited.not.found";

    @Resource
    private MessageSource messageSource;

    @Resource
    MaterialService materialService;

    @Resource
    CategoryService categoryService;

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Category.class, new CategoryEditor(this.categoryService));
    }

    @RequestMapping(value = "/material/create", method = RequestMethod.GET)
    public String showCreateMaterialForm(Model model) {

        LOGGER.debug("showCreateMaterialForm invoked");

        List<Category> categories = categoryService.findAll();
        model.addAttribute(MODEL_ATTRIBUTE_CATEGORIES, categories);
        model.addAttribute(MODEL_ATTRIBUTE_MATERIAL, new MaterialDTO());

        return MATERIAL_ADD_FORM_VIEW;
    }

    //@Valid
    @RequestMapping(value = "/material/create", method = RequestMethod.POST)
    public String submitCreateMaterialForm(@ModelAttribute(MODEL_ATTRIBUTE_MATERIAL) MaterialDTO created,
                                           BindingResult bindingResult,
                                           RedirectAttributes attributes) {
        LOGGER.debug("Create person form was submitted with information: " + created);

        if (bindingResult.hasErrors()) {
            return MATERIAL_ADD_FORM_VIEW;
        }

        Material material = materialService.create(created);

        addFeedbackMessage(attributes, FEEDBACK_MESSAGE_KEY_MATERIAL_CREATED, material.getName());

        return createRedirectViewPath(REQUEST_MAPPING_LIST);
    }


    @RequestMapping(value = "/material/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id, RedirectAttributes attributes) {
        LOGGER.debug("Deleting material with id: " + id);

        try {
            Material deleted = materialService.delete(id);

            addFeedbackMessage(attributes, FEEDBACK_MESSAGE_KEY_MATERIAL_DELETED, deleted.getName());
        } catch (MaterialNotFoundException e) {
            LOGGER.debug("No person found with id: " + id);
            addErrorMessage(attributes, ERROR_MESSAGE_KEY_DELETED_MATERIAL_WAS_NOT_FOUND);
        }

        return createRedirectViewPath(REQUEST_MAPPING_LIST);
    }

    @RequestMapping(value = "/material/edit/{id}", method = RequestMethod.GET)
    public String showEditPersonForm(@PathVariable("id") Long id, Model model, RedirectAttributes attributes) {
        LOGGER.debug("Rendering edit person form for person with id: " + id);

        Material material = materialService.find(id);
        if (material == null) {
            LOGGER.debug("No person found with id: " + id);
            addErrorMessage(attributes, ERROR_MESSAGE_KEY_EDITED_MATERIAL_WAS_NOT_FOUND);
            return createRedirectViewPath(REQUEST_MAPPING_LIST);
        }
        List<Category> categories = categoryService.findAll();
        model.addAttribute(MODEL_ATTRIBUTE_MATERIAL, constructFormObject(material));
        model.addAttribute(MODEL_ATTRIBUTE_CATEGORIES, categories);

        return MATERIAL_EDIT_FORM_VIEW;
    }

    @RequestMapping(value = "/material/edit", method = RequestMethod.POST)
    public String submitEditMaterialForm(@ModelAttribute(MODEL_ATTRIBUTE_MATERIAL) MaterialDTO updated,
                                         BindingResult bindingResult,
                                         RedirectAttributes attributes) {
        LOGGER.debug("Edit material form was submitted with information: " + updated);

        if (bindingResult.hasErrors()) {
            LOGGER.debug("Edit person form contains validation errors. Rendering form view.");
            return MATERIAL_EDIT_FORM_VIEW;
        }

        try {
            Material material = materialService.update(updated);
            addFeedbackMessage(attributes, FEEDBACK_MESSAGE_KEY_MATERIAL_EDITED, material.getName());
        } catch (MaterialNotFoundException e) {
            LOGGER.debug("No person was found with id: " + updated.getId());
            addErrorMessage(attributes, ERROR_MESSAGE_KEY_EDITED_MATERIAL_WAS_NOT_FOUND);
        }

        return createRedirectViewPath(REQUEST_MAPPING_LIST);
    }


    private MaterialDTO constructFormObject(Material material) {
        MaterialDTO formObject = new MaterialDTO();

        formObject.setId(material.getMeterialId());
        formObject.setName(material.getName());
        formObject.setCategory(material.getCategory());
        formObject.setHtmlText(material.getHtmlText());

        return formObject;
    }


//    @Autowired
//    private ConversionService conversionService;
//    @InitBinder
//    protected void initBinder(ServletRequestDataBinder binder) {
//        binder.setConversionService(conversionService);
//    }

	/*@InitBinder
    protected void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd-MM-yyyy"), true));
		binder.registerCustomEditor(SportType.class, new SportTypeEditorSupport(reservationService));
	}*/


    @RequestMapping(value = "/material/list", method = RequestMethod.GET)
    public String listMaterials(Model model) {
        LOGGER.debug("Rendering material list page");

        List<Material> materials = materialService.findAll();
        model.addAttribute(MODEL_ATTRIBUTE_MATERIALS, materials);

        return MATERIAL_LIST_VIEW;


    }

    protected String createRedirectViewPath(String path) {
        StringBuilder builder = new StringBuilder();
        builder.append(VIEW_REDIRECT_PREFIX);
        builder.append(path);
        return builder.toString();
    }

    protected void addFeedbackMessage(RedirectAttributes model, String code, Object... params) {
        LOGGER.debug("Adding feedback message with code: " + code + " and params: " + params);
        Locale current = LocaleContextHolder.getLocale();
        LOGGER.debug("Current locale is " + current);
        String localizedFeedbackMessage = messageSource.getMessage(code, params, current);
        LOGGER.debug("Localized message is: " + localizedFeedbackMessage);
        model.addFlashAttribute(FLASH_FEEDBACK_MESSAGE, localizedFeedbackMessage);
    }

    protected void addErrorMessage(RedirectAttributes model, String code, Object... params) {
        LOGGER.debug("adding error message with code: " + code + " and params: " + params);
        Locale current = LocaleContextHolder.getLocale();
        LOGGER.debug("Current locale is " + current);
        String localizedErrorMessage = messageSource.getMessage(code, params, current);
        LOGGER.debug("Localized message is: " + localizedErrorMessage);
        model.addFlashAttribute(FLASH_ERROR_MESSAGE, localizedErrorMessage);
    }


}
