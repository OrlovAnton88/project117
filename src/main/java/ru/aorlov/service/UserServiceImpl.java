package ru.aorlov.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aorlov.model.HtmlAcademyUser;
import ru.aorlov.repository.UserRepository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static ru.aorlov.repository.UserSpecification.nameIs;

/**
 * Created by anton on 12.10.14.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserRepository userRepository;

    @Override
    @Transactional
    public HtmlAcademyUser save(HtmlAcademyUser user) {
        return userRepository.save(user);
    }


    @Override
    @Transactional(readOnly = true)
    public List<HtmlAcademyUser> save(List<HtmlAcademyUser> users) {
        List<HtmlAcademyUser> toReturn = new ArrayList<HtmlAcademyUser>();
        for (HtmlAcademyUser user : users) {
            if (userRepository.findOne(nameIs(user.getUserName())) == null) {
                toReturn.add(userRepository.save(user));
            }
        }
        return toReturn;
    }

    @Override
    @Transactional(readOnly = true)
    public List<HtmlAcademyUser> findAll() {

        return userRepository.findAll(sortByScoreDesc());
    }

    private Sort sortByScoreDesc() {
        return new Sort(Sort.Direction.DESC, "scores");
    }

    ;


    @Transactional
    @Override
    public void update(List<HtmlAcademyUser> users) {

        for (HtmlAcademyUser user : users) {
            HtmlAcademyUser userDb = userRepository.findOne(nameIs(user.getUserName()));
            user.setScores(user.getScores());
            user.setCoursesFinished(user.getCoursesFinished());
            user.setUserApproofs(user.getUserApproofs());
        }

    }

    @Transactional(readOnly = true)
    @Override
    public HtmlAcademyUser findOne(Long id) {
        return userRepository.findOne(id);
    }
}
