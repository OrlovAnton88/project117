package ru.aorlov.service;

import ru.aorlov.model.User;

import java.util.List;

/**
 * Created by anton on 12.10.14.
 */
public interface UserService {

    public User save(User user);

    public List<User>  save(List<User> users);

    public void update(List<User> users);

    public List<User> findAll();
}
