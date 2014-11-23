package ru.aorlov.security.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.aorlov.security.dto.CustomUserDetails;
import ru.aorlov.social.model.UserAccount;
import ru.aorlov.social.repository.UserAccountRepository;

import java.util.List;

/**
 * Created by anton on 09.11.14.
 */
public class RepositoryUserDetailsService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryUserDetailsService.class);

    private UserAccountRepository userAccountRepository;

    @Autowired
    public RepositoryUserDetailsService(UserAccountRepository userAccountRepository) {

        this.userAccountRepository = userAccountRepository;
    }

    /**
     * Loads the user information.
     *
     * @param username The username of the requested user.
     * @return The information of the user.
     * @throws UsernameNotFoundException Thrown if no user is found with the given username.
     */

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        LOGGER.debug("Loading user by username: {}", username);

        UserAccount user = userAccountRepository.findByEmail(username);
        LOGGER.debug("Found user: {}", user);

        if (user == null) {
            throw new UsernameNotFoundException("No user found with username: " + username);
        }

        CustomUserDetails principal = CustomUserDetails.getBuilder()
                .firstName(user.getFirstName())
                .id(user.getId())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .role(user.getRole())
                .socialSignInProvider(user.getSignInProvider())
                .username(user.getEmail())
                .build();

        LOGGER.debug("Returning user details: {}", principal);

        return principal;

    }

    public List<UserAccount> findAllUsers() {
        LOGGER.debug("Loading all users");
        return userAccountRepository.findAll();
    }
}
