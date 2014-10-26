package ru.aorlov.web;

/**
 * Author:      oav <br>
 * Date:        07.10.14, 20:50 <br>
 * Company:     SofIT labs <br>
 * Revision:    $Id$ <br>
 * Description: <br>
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ru.aorlov.HtmlAcademyParser;
import ru.aorlov.dto.UserDTO;
import ru.aorlov.model.TasksPerDate;
import ru.aorlov.model.User;
import ru.aorlov.model.UserApproofHistory;
import ru.aorlov.service.UserApproofHistoryService;
import ru.aorlov.service.UserService;
import ru.aorlov.util.LessonCalendar;
import ru.aorlov.util.TaskPerDateUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.util.Collections;
import java.util.List;


@Controller
@RequestMapping("/")
public class MainController {

    private final static Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @Resource
    UserService userService;


    @Autowired
    LessonCalendar lc;

    @Autowired
    HtmlAcademyParser htmlAcademyParser;

    @Resource
    UserApproofHistoryService userApproofHistoryService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String defaultPage() {
        return "redirect:/index";
    }


    @RequestMapping("/index")
    public ModelAndView handleRequest() throws Exception {


        ModelAndView modelAndView = new ModelAndView("index");

        List<User> list = userService.findAll();
        modelAndView.addObject("userList", list);
        return modelAndView;
    }

    @RequestMapping(value = "/index/rescan", method = RequestMethod.GET)
    public String rescan() throws Exception {
        htmlAcademyParser.manualRun();
        return "redirect:/index";
    }

    @RequestMapping(value = "/get_lesson_json", produces = "application/json")
    @ResponseBody
    public String getLessonJson() {
        return lc.getNextLessonAsJson();
    }

    @RequestMapping(value = "/get_history", method = RequestMethod.POST)
    @ResponseBody
    public String getHistory(HttpServletRequest request,
                             HttpServletResponse arg1) throws Exception {

        BufferedReader reader = request.getReader();
        Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy HH").create();

        UserDTO dto = gson.fromJson(reader, UserDTO.class);
        User user = userService.findOne(dto.getUserId());

        List<UserApproofHistory> list = userApproofHistoryService.findAllByUser(user);
        List<TasksPerDate> resultList = TaskPerDateUtil.getHistory(list);
        Collections.sort(resultList, new TasksPerDate.DateComporator());
        return gson.toJson(resultList);
    }


}