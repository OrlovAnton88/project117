package ru.aorlov.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Created by anton on 12.10.14.
 */
@StaticMetamodel(Course.class)
public class Course_ {
    public static volatile SingularAttribute<Course, String> courceName;

    public static volatile SingularAttribute<Course, String> description;
}


