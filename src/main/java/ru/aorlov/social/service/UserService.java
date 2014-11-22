package ru.aorlov.social.service;

import ru.aorlov.social.dto.RegistrationForm;
import ru.aorlov.social.model.UserAccount;

/**
 * Created by anton on 10.11.14.
 */
public interface UserService {
    /**
     * Creates a new user account to the service.
     *
     * @param userAccountData The information of the created user account.
     * @return The information of the created user account.
     * @throws DuplicateEmailException Thrown when the email address is found from the database.
     */
    public UserAccount registerNewUserAccount(RegistrationForm userAccountData) throws DuplicateEmailException;

}
