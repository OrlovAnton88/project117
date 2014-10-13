package ru.aorlov.model;

import javax.persistence.*;

/**
 * Created by anton on 05.10.14.
 */

@Entity
@Table(name = "USER_APPROOF")
public class UserApproof {

    public UserApproof() {

    }

    public UserApproof(int passedTasks, User user, String userApproofName) {
        this.passedTasks = passedTasks;
        this.user = user;
        this.userApproofName = userApproofName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userApproofId;

    @Column
    private int passedTasks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="USER_ID")
    private User user;


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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "approofName")
    private Approof approof;


    @Column
    boolean isPassed;

    public Long getUserApproofId() {
        return userApproofId;
    }

    public void setUserApproofId(Long id) {
        this.userApproofId = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //    public Approof getApproof() {
//        return approof;
//    }
//
//    public void setApproof(Approof approof) {
//        this.approof = approof;
//    }

    public int getPassedTasks() {
        return passedTasks;
    }

    public void setPassedTasks(int passedTasks) {
        this.passedTasks = passedTasks;
    }

//    public boolean isPassed() {
//        if (getApproof().getTotalTasks() == getPassedTasks()) {
//            return true;
//        }
//        return false;
//    }

//    @Override
//    public String toString() {
//        return "UserApproof{" +
//                "id=" + userApproofId +
//                ", approof=" + approof +
//                ", passedTasks=" + passedTasks +
//                ", isPassed=" + isPassed +
//                '}';
//    }
}
