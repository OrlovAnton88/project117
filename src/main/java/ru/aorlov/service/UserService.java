package ru.aorlov.service;

import ru.aorlov.model.HtmlAcademyUser;

import java.util.List;

/**
 * Created by anton on 12.10.14.
 */
public interface UserService {

    public HtmlAcademyUser save(HtmlAcademyUser user);

    public List<HtmlAcademyUser> save(List<HtmlAcademyUser> users);

    public void update(List<HtmlAcademyUser> users);

    public List<HtmlAcademyUser> findAll();

    public HtmlAcademyUser findOne(Long id);
}
