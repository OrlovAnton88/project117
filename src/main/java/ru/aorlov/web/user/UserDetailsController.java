package ru.aorlov.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by antonorlov on 23/11/14.
 */
@Controller
public class UserDetailsController {
    @RequestMapping(value = "/user_details", method = RequestMethod.GET)
    public String showDetailsPage() {
        return "user/user_details";
    }
}
