package ru.aorlov.dto;

import ru.aorlov.model.UserApproof;

import java.util.List;

/**
 * Created by anton on 12.10.14.
 */
public class UserDTO {

    private String userName;

    private String codeAcademyLink;

    private int scores;

    private int coursesFinished;

    private List<UserApproof> userApproofs;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCodeAcademyLink() {
        return codeAcademyLink;
    }

    public void setCodeAcademyLink(String codeAcademyLink) {
        this.codeAcademyLink = codeAcademyLink;
    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

    public int getCoursesFinished() {
        return coursesFinished;
    }

    public void setCoursesFinished(int coursesFinished) {
        this.coursesFinished = coursesFinished;
    }

    public List<UserApproof> getUserApproofs() {
        return userApproofs;
    }

    public void setUserApproofs(List<UserApproof> userApproofs) {
        this.userApproofs = userApproofs;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userName='" + userName + '\'' +
                ", codeAcademyLink='" + codeAcademyLink + '\'' +
                ", scores=" + scores +
                ", coursesFinished=" + coursesFinished +
                ", userApproofs=" + userApproofs +
                '}';
    }
}
