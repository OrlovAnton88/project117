package ru.aorlov.service;

import ru.aorlov.model.Course;

import java.util.List;

/**
 * Created by anton on 12.10.14.
 */
public interface CourseService {

    public Course create(Course cource);

    public List<Course> findAll();

    public Course find(String name);
}
