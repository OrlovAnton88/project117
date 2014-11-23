package ru.aorlov.model.user;

import java.util.List;

/**
 * Created by antonorlov on 15/11/14.
 */
public class User {

    private Long userId;
    private String name;
    private String lastName;

    private List<UserAttributes> userAttributes;
    private boolean isSocicalAccountActive;
}
