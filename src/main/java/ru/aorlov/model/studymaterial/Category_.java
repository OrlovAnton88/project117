package ru.aorlov.model.studymaterial;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Created by anton on 18.10.14.
 */
@StaticMetamodel(Category.class)
public class Category_ {

    public static volatile SingularAttribute<Category, String> name;
}
