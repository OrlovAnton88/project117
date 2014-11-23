package ru.aorlov.repository;

import org.springframework.data.jpa.domain.Specification;
import ru.aorlov.model.HtmlAcademyUser;
import ru.aorlov.model.HtmlAcademyUser_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by anton on 12.10.14.
 */
public class UserSpecification {

    public static Specification<HtmlAcademyUser> nameIs(final String searchTerm) {

        return new Specification<HtmlAcademyUser>() {
            @Override
            public Predicate toPredicate(Root<HtmlAcademyUser> courseRoot, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(cb.lower(courseRoot.<String>get(HtmlAcademyUser_.userName)), searchTerm);
            }
        };
    }
}
