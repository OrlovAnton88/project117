package ru.aorlov.service;

import ru.aorlov.model.HtmlAcademyUser;
import ru.aorlov.model.UserApproofHistory;

import java.util.Date;
import java.util.List;

/**
 * Created by anton on 23.10.14.
 */
public interface UserApproofHistoryService {

    public UserApproofHistory create(UserApproofHistory userApproofHistory);

    public List<UserApproofHistory> findAll();

    public List<UserApproofHistory> findAllByUser(HtmlAcademyUser user);

    public List<UserApproofHistory> getApproofHistorySince(HtmlAcademyUser user, Date date);

}
