package ru.aorlov.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.aorlov.model.studymaterial.Material;
import ru.aorlov.service.studymaterial.MaterialService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author:      oav <br>
 * Date:        24.10.14, 21:02 <br>
 * Company:     SofIT labs <br>
 * Revision:    $Id$ <br>
 * Description: <br>
 */
@Controller
public class MaterialController {

    @Resource
    MaterialService materialService;

    @RequestMapping("/study_materials")
    public ModelAndView getPage() throws Exception {


        ModelAndView modelAndView = new ModelAndView("study_materials");

        List<Material> list = materialService.findAll();
        Material material = list.get(0);
        modelAndView.addObject("materialList", list);
        modelAndView.addObject("material", material);
        return modelAndView;
    }

    @RequestMapping(value = "/study_materials&material={meterialId}", method = RequestMethod.GET)
    public ModelAndView getMaterial(@PathVariable Long meterialId) throws Exception {


        ModelAndView modelAndView = new ModelAndView("study_materials");

        Material material = materialService.find(meterialId);
        List<Material> list = materialService.findAll();
        modelAndView.addObject("materialList", list);
        modelAndView.addObject("material", material);
        return modelAndView;
    }



}
