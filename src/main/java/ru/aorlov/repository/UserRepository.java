package ru.aorlov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.aorlov.model.User;

/**
 * Created by anton on 12.10.14.
 */
public interface UserRepository  extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
}
