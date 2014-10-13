package ru.aorlov.repository;

import org.springframework.data.jpa.domain.Specification;
import ru.aorlov.model.User;
import ru.aorlov.model.User_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by anton on 12.10.14.
 */
public class UserSpecification {

    public static Specification<User> nameIs(final String searchTerm) {

        return new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> courseRoot, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(cb.lower(courseRoot.<String>get(User_.userName)), searchTerm);
            }
        };
    }
}
