package ru.aorlov;

import ru.aorlov.model.HtmlAcademyUser;

import java.util.Comparator;

/**
 * Created by anton on 05.10.14.
 */
public class ScoreComparatorDesc implements Comparator<HtmlAcademyUser> {

    @Override
    public int compare(HtmlAcademyUser o1, HtmlAcademyUser o2) {
        if (o1.getScores() > o2.getScores()) {
            return -1;
        } else if (o1.getScores() == o2.getScores()) {
            return 0;
        } else {
            return 1;
        }
    }


}
