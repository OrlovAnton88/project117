package ru.aorlov.model;

import javax.persistence.*;

/**
 * Created by anton on 11.10.14.
 */
@Entity
@Table(name = "cource")
public class Course {

    public static final String HTML_ACADEMY = "html_academy";
    public static final String OFFLINE_HTML_COURCE = "offline_html_couse";

    public Course() {
    }


    public Course(String courceName, String description) {
        this.courceName = courceName;
        this.description = description;
    }

    @Id
    private String courceName;

    @Column(length = 300, nullable = false)
    private String description;


    public String getCourceName() {
        return courceName;
    }

    public void setCourceName(String name) {
        this.courceName = name;
    }

}
