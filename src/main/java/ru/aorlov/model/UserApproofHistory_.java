package ru.aorlov.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

/**
 * Created by anton on 23.10.14.
 */

@StaticMetamodel(UserApproofHistory.class)
public class UserApproofHistory_ {

    public static volatile SingularAttribute<UserApproofHistory, Long> uahId;

    public static volatile SingularAttribute<UserApproofHistory, Integer> passedTasks;

    public static volatile SingularAttribute<UserApproof, User> user;

    public static volatile SingularAttribute<UserApproof, Approof> approof;

    public static volatile SingularAttribute<UserApproofHistory, Date> date;

}
