package ru.aorlov.social.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aorlov.social.model.UserAccount;

import javax.annotation.Resource;

/**
 * Created by anton on 09.11.14.
 */
@Resource
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    public UserAccount findByEmail(String email);

}
