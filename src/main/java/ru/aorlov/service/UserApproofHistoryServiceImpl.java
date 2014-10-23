package ru.aorlov.service;

import org.springframework.stereotype.Service;
import ru.aorlov.model.UserApproofHistory;
import ru.aorlov.repository.UserApproofHistoryRepository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by anton on 23.10.14.
 */
@Service
public class UserApproofHistoryServiceImpl implements UserApproofHistoryService {

    @Resource
    UserApproofHistoryRepository userApproofHistoryRepository;

    @Override
    public UserApproofHistory create(UserApproofHistory userApproofHistory) {
        return userApproofHistoryRepository.save(userApproofHistory);
    }

    @Override
    public List<UserApproofHistory> findAll() {
        return userApproofHistoryRepository.findAll();
    }

}
