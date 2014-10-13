package ru.aorlov.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aorlov.model.User;
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
    public User save(User user) {
        return userRepository.save(user);
    }


    @Override
    @Transactional(readOnly = true)
    public List<User> save(List<User> users) {
        List<User> toReturn = new ArrayList<User>();
        for (User user : users) {
            if (userRepository.findOne(nameIs(user.getUserName())) == null) {
                toReturn.add(userRepository.save(user));
            }
        }
        return toReturn;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {


        return userRepository.findAll(sortByScoreDesc());
    }

    private Sort sortByScoreDesc() {
        return new Sort(Sort.Direction.DESC, "scores");
    };


    @Transactional
    @Override
    public void update(List<User> users) {

        for (User user : users) {
            User userDb = userRepository.findOne(nameIs(user.getUserName()));
            user.setScores(user.getScores());
            user.setCoursesFinished(user.getCoursesFinished());
            user.setUserApproofs(user.getUserApproofs());
        }

    }
}
