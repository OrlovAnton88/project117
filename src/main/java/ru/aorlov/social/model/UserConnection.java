package ru.aorlov.social.model;

import javax.annotation.Nonnull;
import javax.persistence.*;
import java.math.BigInteger;

/**
 * Created by anton on 23.11.14.
 */


//tod: autocreate table if not exists

//create table UserConnection (userId varchar(255) not null,
//        providerId varchar(255) not null,
//        providerUserId varchar(255),
//        rank int not null,
//        displayName varchar(255),
//        profileUrl varchar(512),
//        imageUrl varchar(512),
//        accessToken varchar(255) not null,
//        secret varchar(255),
//        refreshToken varchar(255),
//        expireTime bigint,
//        primary key (userId, providerId, providerUserId));
//        create unique index UserConnectionRank on UserConnection(userId, providerId, rank);

//@Entity
//@Table
////@Table(name="UserConnection",uniqueConstraints = {@UniqueConstraint(columnNames = {"userId","providerId", "providerUserId"})})
//@IdClass(UserConnectionId.class)
public class UserConnection {

    @EmbeddedId
    private UserConnectionId id;
    @Column
    private int rank;
    @Column
    private String displayName;
    @Column
    private String profileUrl;
    @Column
    private String imageUrl;

    //    @Nonnull
    @Column
    private String accessToken;
    @Column
    private String secret;
    @Column
    private String refreshToken;
    @Column
    private BigInteger expireTime;

    public UserConnection() {
    }

}
