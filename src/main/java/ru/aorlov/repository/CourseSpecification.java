package ru.aorlov.repository;

import org.springframework.data.jpa.domain.Specification;
import ru.aorlov.model.Course;
import ru.aorlov.model.Course_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by anton on 12.10.14.
 */
public class CourseSpecification {

    public static Specification<Course> nameIs(final String searchTerm) {

        return new Specification<Course>() {
            @Override
            public Predicate toPredicate(Root<Course> courseRoot, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(cb.lower(courseRoot.<String>get(Course_.courceName)), searchTerm);
            }
        };
    }
}
