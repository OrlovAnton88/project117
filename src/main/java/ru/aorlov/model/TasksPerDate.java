package ru.aorlov.model;

import java.util.Comparator;
import java.util.Date;

/**
 * Created by anton on 26.10.14.
 */
public class TasksPerDate {

    private Date date;

    private int taskSum;

    public TasksPerDate() {
    }


    public TasksPerDate(Date date, int taskSum) {
        this.date = date;
        this.taskSum = taskSum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTaskSum() {
        return taskSum;
    }

    public void setTaskSum(int taskSum) {
        this.taskSum = taskSum;
    }

    public static class DateComporator implements Comparator<TasksPerDate> {
        public int compare(TasksPerDate userApproofHistory1, TasksPerDate userApproofHistory2) {
            return userApproofHistory1.getDate().compareTo(userApproofHistory2.getDate());
        }
    }
}
