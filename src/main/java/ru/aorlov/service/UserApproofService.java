package ru.aorlov.service;

import ru.aorlov.model.HtmlAcademyUser;
import ru.aorlov.model.UserApproof;

import java.util.List;

/**
 * Created by anton on 12.10.14.
 */
public interface UserApproofService {

    public UserApproof save(UserApproof userApproof);

    public List<UserApproof> findAll();

    public void deleteAll(HtmlAcademyUser user);
}
