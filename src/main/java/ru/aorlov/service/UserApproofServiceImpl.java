package ru.aorlov.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aorlov.model.UserApproof;
import ru.aorlov.repository.UserApproofRepository;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.data.jpa.domain.Specifications.where;
import static ru.aorlov.repository.UserApproofSpecification.*;

/**
 * Created by anton on 12.10.14.
 */
@Service
@Transactional
public class UserApproofServiceImpl implements UserApproofService {


    @Resource
    UserApproofRepository userApproofRepository;

    @Transactional
    @Override
    public UserApproof save(UserApproof userApproof) {

        UserApproof userApproofDb = userApproofRepository.findOne(where(nameIs(userApproof.getUserApproofName())).and(userIs(userApproof.getUser())));

        if (userApproofDb == null) {
            return userApproofRepository.save(userApproof);
        } else {
            userApproofDb.setPassedTasks(userApproof.getPassedTasks());
            userApproofDb.setUserApproofName(userApproof.getUserApproofName());
            return userApproofDb;
        }
    }

    @Transactional
    @Override
    public List<UserApproof> findAll() {
        return userApproofRepository.findAll();
    }
}
