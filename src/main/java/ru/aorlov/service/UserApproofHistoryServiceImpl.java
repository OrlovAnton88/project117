package ru.aorlov.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aorlov.model.User;
import ru.aorlov.model.UserApproofHistory;
import ru.aorlov.repository.UserApproofHistoryRepository;
import ru.aorlov.repository.UserApproofHistorySpecification;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.data.jpa.domain.Specifications.where;

/**
 * Created by anton on 23.10.14.
 */
@Service
public class UserApproofHistoryServiceImpl implements UserApproofHistoryService {

    @Resource
    UserApproofHistoryRepository userApproofHistoryRepository;

    @Transactional
    @Override
    public UserApproofHistory create(UserApproofHistory userApproofHistory) {
        return userApproofHistoryRepository.save(userApproofHistory);
    }

    @Transactional
    @Override
    public List<UserApproofHistory> findAll() {
        return userApproofHistoryRepository.findAll();
    }

    @Transactional
    @Override
    public List<UserApproofHistory> findAllByUser(User user) {
        return userApproofHistoryRepository.findAll(where(UserApproofHistorySpecification.userIs(user)));

    }
}
