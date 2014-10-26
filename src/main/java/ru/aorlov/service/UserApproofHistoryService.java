package ru.aorlov.service;

import ru.aorlov.model.User;
import ru.aorlov.model.UserApproofHistory;

import java.util.List;

/**
 * Created by anton on 23.10.14.
 */
public interface UserApproofHistoryService {

    public UserApproofHistory create(UserApproofHistory userApproofHistory);

    public List<UserApproofHistory> findAll();

    public List<UserApproofHistory> findAllByUser(User user);

}
