package ru.aorlov;

import ru.aorlov.model.User;

import java.util.Comparator;

/**
 * Created by anton on 05.10.14.
 */
public class ScoreComparatorDesc implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        if (o1.getScores() > o2.getScores()) {
            return -1;
        } else if (o1.getScores() == o2.getScores()) {
            return 0;
        } else {
            return 1;
        }
    }




}
