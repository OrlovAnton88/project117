package ru.aorlov.web;

/**
 * Author:      oav <br>
 * Date:        07.10.14, 20:50 <br>
 * Company:     SofIT labs <br>
 * Revision:    $Id$ <br>
 * Description: <br>
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.aorlov.model.User;
import ru.aorlov.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
public class MainController {

    @Resource
    UserService userService;


    @RequestMapping("/index")
    public ModelAndView handleRequest(HttpServletRequest arg0,
                                      HttpServletResponse arg1) throws Exception {


        ModelAndView modelAndView = new ModelAndView("index");
//        htmlAcademyParser.parseSite();

        List<User> list = userService.findAll();
        modelAndView.addObject("userList", list);
        return modelAndView;
    }
//    public String hello(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "index";
//    }

}