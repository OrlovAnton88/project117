package ru.aorlov.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by anton on 15.11.14.
 */

@Controller
public class TestController {

    @RequestMapping(value = "/test-form")
    public ModelAndView test(HttpServletRequest arg0,
                             HttpServletResponse arg1) {

        String name = arg0.getParameter("name");

        String lastName = arg0.getParameter("lastName");

        System.out.println("test");
        ModelAndView modelAndView = new ModelAndView("formtest");
        modelAndView.addObject("name", name);
        modelAndView.addObject("lastName", lastName);
        return modelAndView;
    }
//    @RequestMapping(value = "/test-form?name={name}&lastName={lastName}", method = RequestMethod.GET)
//    public String formTest(@PathVariable String name,
//                           @PathVariable String lastName){
//
//
//        return "<html>\n" +
//                "<body>\n" +
//                "\t<h2>Test</h2>\n" +
//                " \n" +
//                "\tИмя : " + name + "\n" +
//                " \n" +
//                "</body>\n" +
//                "</html>";
//
//    }


}
