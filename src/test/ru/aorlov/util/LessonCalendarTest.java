package ru.aorlov.util;

import org.junit.Test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class LessonCalendarTest {

    @Test
    public void testGetLessonsAsJSON() throws Exception {
        LessonCalendar lc = new LessonCalendar();

        System.out.println("System date: " + new Date(System.currentTimeMillis()));

        //instantiates a calendar using the current time in the specified timezone
        Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));

        DateFormat format = DateFormat.getTimeInstance();
        format.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));


        System.out.println("Moscow time: " + format.format(c.getTime()));
        System.out.println("----------------------");

        lc.setLessons(lc.getLessons());
        System.out.println(lc.getLessons().get(15));
        System.out.println(lc.getNextLessonAsJson());

    }
}
