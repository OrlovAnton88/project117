package ru.aorlov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.aorlov.model.UserApproofHistory;

/**
 * Created by anton on 23.10.14.
 */
@Repository
public interface UserApproofHistoryRepository extends JpaRepository<UserApproofHistory, Long>,
        JpaSpecificationExecutor<UserApproofHistory> {


}
