package ru.aorlov.dto;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by anton on 11.10.14.
 */
public class ApproofDTO {

    private Long id;

    @NotEmpty
    private String name;

    private int totalTasks;

    private int passedTasks;

    boolean isPassed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean isPassed) {
        this.isPassed = isPassed;
    }

    public int getPassedTasks() {
        return passedTasks;
    }

    public void setPassedTasks(int passedTasks) {
        this.passedTasks = passedTasks;
    }

    public int getTotalTasks() {
        return totalTasks;
    }

    public void setTotalTasks(int totalTasks) {
        this.totalTasks = totalTasks;
    }
}
