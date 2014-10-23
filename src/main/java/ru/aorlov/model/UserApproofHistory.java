package ru.aorlov.model;

import javax.annotation.Nonnull;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by anton on 23.10.14.
 */
@Entity
public class UserApproofHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long uahId;

    @Column
    private int passedTasks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approof_id")
    private Approof approof;

    @Column
    @Nonnull
    private Date date;

    public UserApproofHistory() {
    }

    public UserApproofHistory(int passedTasks, User user, Approof approof, @Nonnull Date date) {
        this.passedTasks = passedTasks;
        this.user = user;
        this.approof = approof;
        this.date = date;
    }

    public long getUahId() {
        return uahId;
    }

    public void setUahId(long uahId) {
        this.uahId = uahId;
    }

    public int getPassedTasks() {
        return passedTasks;
    }

    public void setPassedTasks(int passedTasks) {
        this.passedTasks = passedTasks;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Approof getApproof() {
        return approof;
    }

    public void setApproof(Approof approof) {
        this.approof = approof;
    }

    @Nonnull
    public Date getDate() {
        return date;
    }

    public void setDate(@Nonnull Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "UserApproofHistory{" +
                "uahId=" + uahId +
                ", passedTasks=" + passedTasks +
                ", user=" + user +
                ", approof=" + approof +
                ", date=" + date +
                '}';
    }
}
