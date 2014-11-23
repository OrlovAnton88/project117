package ru.aorlov.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.aorlov.model.HtmlAcademyUser;
import ru.aorlov.security.dto.CustomUserDetails;
import ru.aorlov.security.service.RepositoryUserDetailsService;
import ru.aorlov.service.UserService;
import ru.aorlov.social.model.UserAccount;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by anton on 23.11.14.
 */
@Controller
public class UserController {

    @Inject
    UserService haUserService;

    @Inject
    RepositoryUserDetailsService repositoryUserDetailsService;

    @RequestMapping(value = "/admin/list_users", method = RequestMethod.GET)
    public ModelAndView getUsers() {
        List<HtmlAcademyUser> haUsers = haUserService.findAll();
        List<UserAccount> regUsers = repositoryUserDetailsService.findAllUsers();

        ModelAndView modelAndView = new ModelAndView("/admin/list_users");
        return modelAndView;
    }
}
