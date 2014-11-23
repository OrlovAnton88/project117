package ru.aorlov.web.user;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.security.SocialAuthenticationToken;
import org.springframework.social.vkontakte.api.VKontakte;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.social.facebook.api.Facebook;

import javax.inject.Inject;
import java.security.Principal;

/**
 * Created by antonorlov on 23/11/14.
 */
@Controller
public class UserProfileController {

    @Inject
    private ConnectionRepository connectionRepository;

    @RequestMapping(value = "/user_details", method = RequestMethod.GET)
    public String showDetailsPage(Principal currentUser, Model model) {
        if (currentUser instanceof SocialAuthenticationToken) {
            SocialAuthenticationToken user = (SocialAuthenticationToken) currentUser;
            if ("facebook".equals(user.getProviderId())) {
                Connection<Facebook> connection = connectionRepository.findPrimaryConnection(Facebook.class);
                model.addAttribute("profile", connection.getApi().userOperations().getUserProfile());
                model.addAttribute("type", "facebook");
            } else if ("vkontakte".equals(user.getProviderId())) {
                Connection<VKontakte> connection = connectionRepository.findPrimaryConnection(VKontakte.class);
                model.addAttribute("profile", connection.getApi().usersOperations().getUser());
                model.addAttribute("type", "vkontakte");
            }
        }
//        Connection<VKontakte> connection = connectionRepository.findPrimaryConnection(VKontakte.class);

//        if (connection == null) {
//            return "redirect:/auth/vkontakte";
//        }

//        model.addAttribute("profile", connection.getApi().usersOperations().getUser());
//        return "twitter/profile";

        return "user/user_details";
    }
}
