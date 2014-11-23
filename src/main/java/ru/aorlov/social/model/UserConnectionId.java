package ru.aorlov.social.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by anton on 23.11.14.
 */

//@Embeddable
public class UserConnectionId implements Serializable {

    @Column
    private String userId;
    @Column
    private String providerId;
    @Column
    private String providerUserId;

}
