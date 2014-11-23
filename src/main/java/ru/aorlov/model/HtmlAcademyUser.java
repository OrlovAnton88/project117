package ru.aorlov.model;

import javax.persistence.*;
import java.util.Comparator;
import java.util.List;

/**
 * Created by anton on 05.10.14.
 */

@Entity
@Table(name = "ha_user")
public class HtmlAcademyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", unique = true, nullable = false)
    private Long userId;

    @Column(unique = true, nullable = false)
    private String userName;

    @Column(unique = true, nullable = false)
    private String htmlAcademyLink;

    @Column
    private int scores;

    @Column
    private int coursesFinished;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "htmlAcademyUser")
    private List<UserApproof> userApproofs;


    public HtmlAcademyUser() {
    }


    public HtmlAcademyUser(String userName, String htmlAcademyLink, int scores, int coursesFinished) {
        this.userName = userName;
        this.htmlAcademyLink = htmlAcademyLink;
        this.scores = scores;
        this.coursesFinished = coursesFinished;
    }

    public String getHtmlAcademyLink() {
        return htmlAcademyLink;
    }

    public void setHtmlAcademyLink(String link) {
        this.htmlAcademyLink = link;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

    public List<UserApproof> getUserApproofs() {
        return userApproofs;
    }

    public int getCoursesFinished() {
        return coursesFinished;
    }

    public void setCoursesFinished(int courcesFinished) {
        coursesFinished = courcesFinished;
    }

    public void setUserApproofs(List<UserApproof> userApproofs) {
        this.userApproofs = userApproofs;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public static class ScoreComparatorDesc implements Comparator<HtmlAcademyUser> {
        public int compare(HtmlAcademyUser user1, HtmlAcademyUser user2) {
            if (user1.getScores() > user2.getScores()) {
                return -1;
            } else if (user1.getScores() == user2.getScores()) {
                return 0;
            } else {
                return 1;
            }
        }
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + userName + '\'' +
                ", scores=" + scores +
                ", coursesFinished=" + coursesFinished +
                ", courses=" + userApproofs +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HtmlAcademyUser user = (HtmlAcademyUser) o;

        if (coursesFinished != user.coursesFinished) return false;
        if (scores != user.scores) return false;
        if (!htmlAcademyLink.equals(user.htmlAcademyLink)) return false;
        if (userApproofs != null ? !userApproofs.equals(user.userApproofs) : user.userApproofs != null) return false;
        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (!userName.equals(user.userName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + userName.hashCode();
        result = 31 * result + htmlAcademyLink.hashCode();
        result = 31 * result + scores;
        result = 31 * result + coursesFinished;
        result = 31 * result + (userApproofs != null ? userApproofs.hashCode() : 0);
        return result;
    }
}
