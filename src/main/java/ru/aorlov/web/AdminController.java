package ru.aorlov.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.aorlov.HtmlAcademyParser;
import ru.aorlov.Links;
import ru.aorlov.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by anton on 12.10.14.
 */
@Controller
public class AdminController {

    @Resource
    UserService userService;

    @Autowired
    HtmlAcademyParser htmlAcademyParser;

    @RequestMapping("/admin")
    public ModelAndView showPage(HttpServletRequest arg0,
                                 HttpServletResponse arg1) throws Exception {
        ModelAndView modelAndView = new ModelAndView("admin");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/rescan", method = RequestMethod.GET)
    public String rescan(HttpServletRequest arg0,
                               HttpServletResponse arg1) throws Exception {
        htmlAcademyParser.cronRun();
        return "redirect:/admin";
    }


    @RequestMapping(value = "/admin/uploadUsers", method = RequestMethod.GET)
    public ModelAndView uploadUsers(HttpServletRequest arg0,
                                    HttpServletResponse arg1) throws Exception {
        htmlAcademyParser.loadUsers(Links.getLinks());
        ModelAndView modelAndView = new ModelAndView("admin");
        return modelAndView;
    }


    @RequestMapping(value = "/admin/uploadApproofs", method = RequestMethod.GET)
    public ModelAndView uploaduploadApproofs(HttpServletRequest arg0,
                                    HttpServletResponse arg1) throws Exception {
        htmlAcademyParser.loadApproofs();
        ModelAndView modelAndView = new ModelAndView("admin");
        return modelAndView;
    }

}
