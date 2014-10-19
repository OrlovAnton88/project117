package ru.aorlov.model.studymaterial;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Created by anton on 18.10.14.
 */
@StaticMetamodel(Material.class)
public class Material_ {

    public static volatile SingularAttribute<Material, String> name;
}
