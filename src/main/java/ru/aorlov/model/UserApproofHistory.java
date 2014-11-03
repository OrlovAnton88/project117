package ru.aorlov.model;

import com.google.gson.annotations.Expose;

import javax.annotation.Nonnull;
import javax.persistence.*;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by anton on 23.10.14.
 */
@Entity
@Table(name = "user_approof_history", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "date", "approof_id"})})
public class UserApproofHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long uahId;

    @Column
    @Expose
    private int passedTasks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approof_id")
    private Approof approof;

    @Column(name = "date")
    @Nonnull
    @Expose
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

    public static class DateComporator implements Comparator<UserApproofHistory> {
        public int compare(UserApproofHistory userApproofHistory1, UserApproofHistory userApproofHistory2) {
            return userApproofHistory1.getDate().compareTo(userApproofHistory2.getDate());
        }
    }
}
