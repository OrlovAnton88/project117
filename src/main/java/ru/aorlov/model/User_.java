package ru.aorlov.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Created by anton on 12.10.14.
 */
@StaticMetamodel(User.class)
public class User_ {

    public static volatile SingularAttribute<User, String> userName;
}
