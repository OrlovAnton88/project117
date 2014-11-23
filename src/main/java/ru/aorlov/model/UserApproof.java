package ru.aorlov.model;

import javax.persistence.*;

/**
 * Created by anton on 05.10.14.
 */

@Entity
@Table(name = "user_approof")
public class UserApproof {

    public UserApproof() {

    }

    public UserApproof(int passedTasks, HtmlAcademyUser htmlAcademyUser, String userApproofName) {
        this.passedTasks = passedTasks;
        this.htmlAcademyUser = htmlAcademyUser;
        this.userApproofName = userApproofName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userApproofId;

    @Column
    private int passedTasks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private HtmlAcademyUser htmlAcademyUser;


    public String getUserApproofName() {
        return userApproofName;
    }

    public void setUserApproofName(String approofName) {
        this.userApproofName = approofName;
    }

    @Column
    private String userApproofName;


    public Approof getApproof() {
        return approof;
    }

    public void setApproof(Approof approof) {
        this.approof = approof;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approof_id")
    private Approof approof;

    @Column
    boolean isPassed;

    public Long getUserApproofId() {
        return userApproofId;
    }

    public void setUserApproofId(Long id) {
        this.userApproofId = id;
    }

    public HtmlAcademyUser getUser() {
        return htmlAcademyUser;
    }

    public void setUser(HtmlAcademyUser user) {
        this.htmlAcademyUser = user;
    }

    public int getPassedTasks() {
        return passedTasks;
    }

    public void setPassedTasks(int passedTasks) {
        this.passedTasks = passedTasks;
    }
}
