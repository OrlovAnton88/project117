package ru.aorlov.repository;

import org.springframework.data.jpa.domain.Specification;
import ru.aorlov.model.User;
import ru.aorlov.model.UserApproof;
import ru.aorlov.model.UserApproof_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by anton on 12.10.14.
 */
public class UserApproofSpecification {

    public static Specification<UserApproof> nameIs(final String searchTerm) {

        return new Specification<UserApproof>() {
            @Override
            public Predicate toPredicate(Root<UserApproof> courseRoot, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(cb.lower(courseRoot.<String>get(UserApproof_.userApproofName)), searchTerm);
            }
        };
    }

    public static Specification<UserApproof> userIs(final User searchTerm) {

        return new Specification<UserApproof>() {
            @Override
            public Predicate toPredicate(Root<UserApproof> courseRoot, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal((courseRoot.<User>get(UserApproof_.user)), searchTerm);
            }
        };
    }
}
