package ru.aorlov.model;

import javax.persistence.*;

/**
 * Created by anton on 12.10.14.
 */


@Entity
@Table(name = "approof")
public class Approof {

    public Approof() {
    }

    public Approof(String approofName, String description, int totalTasks, Course course) {
        this.approofName = approofName;
        this.description = description;
        this.totalTasks = totalTasks;
        this.course = course;
    }

    @Id
    @Column(name = "approof_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true, nullable = false)
    private String approofName;

    @Column(length = 3000, nullable = false)
    private String description;

    @Column
    private int totalTasks;

    @ManyToOne
    @JoinColumn(name = "courceId")
    private Course course;

    public String getApproofName() {
        return approofName;
    }

    public void setApproofName(String name) {
        this.approofName = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotalTasks() {
        return totalTasks;
    }

    public void setTotalTasks(int totalTasks) {
        this.totalTasks = totalTasks;
    }
}
