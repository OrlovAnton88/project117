package ru.aorlov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.aorlov.model.UserApproof;

/**
 * Created by anton on 12.10.14.
 */
public interface UserApproofRepository extends JpaRepository<UserApproof, Long>, JpaSpecificationExecutor<UserApproof> {
}
