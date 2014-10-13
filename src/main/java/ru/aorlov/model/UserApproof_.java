package ru.aorlov.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Created by anton on 12.10.14.
 */

@StaticMetamodel(UserApproof.class)
public class UserApproof_ {


    public static volatile  SingularAttribute<UserApproof, Integer>  passedTasks;

    public static volatile  SingularAttribute<UserApproof, User>  user;

    public static volatile SingularAttribute<UserApproof, String> userApproofName;

}
