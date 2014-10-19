package ru.aorlov.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.aorlov.dto.MaterialDTO;
import ru.aorlov.model.studymaterial.Category;
import ru.aorlov.model.studymaterial.Material;
import ru.aorlov.service.studymaterial.CategoryService;
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
    protected static final String MATERIAL_LIST_VIEW = "/material/material_list";
    protected static final String REQUEST_MAPPING_LIST = "/material";
    private static final String VIEW_REDIRECT_PREFIX = "redirect:";

    protected static final String FEEDBACK_MESSAGE_KEY_MATERIAL_CREATED = "feedback.message.material.created";
    protected static final String FEEDBACK_MESSAGE_KEY_MATERIAL_DELETED = "feedback.message.material.deleted";
    protected static final String FEEDBACK_MESSAGE_KEY_MATERIAL_EDITED = "feedback.message.material.edited";
    private static final String FLASH_FEEDBACK_MESSAGE = "feedbackMessage";

    @Resource
    private MessageSource messageSource;

    @Resource
    MaterialService materialService;

    @Resource
    CategoryService categoryService;

    @RequestMapping(value = "/material/create", method = RequestMethod.GET)
    public String showCreateMaterialForm(Model model) {

        LOGGER.debug("showCreateMaterialForm invoked");

       List<Category> categories =  categoryService.findAll();
        model.addAttribute(MODEL_ATTRIBUTE_CATEGORIES, categories);
        model.addAttribute(MODEL_ATTRIBUTE_MATERIAL, new MaterialDTO());

        return MATERIAL_ADD_FORM_VIEW;
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

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Category.class, new CategoryEditor(this.categoryService));
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

}