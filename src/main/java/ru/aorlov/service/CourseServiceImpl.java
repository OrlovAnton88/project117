package ru.aorlov.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aorlov.model.Course;
import ru.aorlov.repository.CourseRepository;

import javax.annotation.Resource;
import java.util.List;

import static ru.aorlov.repository.CourseSpecification.nameIs;

/**
 * Created by anton on 12.10.14.
 */
@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    @Resource
    CourseRepository courseRepository;

    @Override
    public Course create(Course cource) {

        return courseRepository.save(cource);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();

    }

    @Override
    public Course find(String name) {
        return courseRepository.findOne(nameIs(name));

    }
}
