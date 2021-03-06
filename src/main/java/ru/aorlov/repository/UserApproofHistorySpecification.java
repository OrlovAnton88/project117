package ru.aorlov.repository;

import org.springframework.data.jpa.domain.Specification;
import ru.aorlov.model.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;

/**
 * Created by anton on 26.10.14.
 */
public class UserApproofHistorySpecification {

    public static Specification<UserApproofHistory> userIs(final HtmlAcademyUser searchTerm) {

        return new Specification<UserApproofHistory>() {
            @Override
            public Predicate toPredicate(Root<UserApproofHistory> courseRoot, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal((courseRoot.<HtmlAcademyUser>get(UserApproofHistory_.user)), searchTerm);
            }
        };
    }

    public static Specification<UserApproofHistory> since(final Date date) {

        return new Specification<UserApproofHistory>() {
            @Override
            public Predicate toPredicate(Root<UserApproofHistory> courseRoot, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.greaterThan((courseRoot.get(UserApproofHistory_.date)), date);
            }
        };
    }

}
