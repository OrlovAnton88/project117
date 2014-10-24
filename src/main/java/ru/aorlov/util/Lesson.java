package ru.aorlov.util;

import java.util.Comparator;
import java.util.Date;

/**
 * Created by anton on 25.10.14.
 */
public class Lesson {
    private Date date;
    private int number;

    public Lesson(Date date, int number) {
        this.date = date;
        this.number = number;
    }

    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    static class DateComparator implements Comparator<Lesson> {
        public int compare(Lesson l1, Lesson l2) {
            Date one = l1.getDate();
            Date two = l2.getDate();
            return one.compareTo(two);
        }
    }

}
