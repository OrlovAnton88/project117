package ru.aorlov.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Author:      oav <br>
 * Date:        24.10.14, 21:54 <br>
 * Company:     SofIT labs <br>
 * Revision:    $Id$ <br>
 * Description: <br>
 */
@Component
public class LessonCalendar {

    private final static Logger LOGGER = LoggerFactory.getLogger(LessonCalendar.class);

    private static final int WEDNESDAY = 4;
    private static final int SATURDAY = 7;

    private static final String START_DATE = "13-09-2014 16:30";
    private static final String END_DATE = "06-05-2015 18:30";

    private List<Lesson> lessons;

    @PostConstruct
    public void init() {
        lessons = getLessons();
        Collections.sort(lessons, new Lesson.DateComparator());
    }

    public String getLessonsAsJSON() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
        Gson gson = gsonBuilder.create();
        return gson.toJson(lessons);
    }

    public String getNextLessonAsJson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
        Gson gson = gsonBuilder.create();

        for (Lesson lesson : lessons) {
            if (lesson.getDate().after(new Date())) {
                return gson.toJson(lesson);
            }
        }
        return null;
    }

    public List<Lesson> getLessons() {
        List<Lesson> lessons = new ArrayList<Lesson>();

        Date startDate = null;
        Date endDate = null;
        try {
            startDate = getDate(START_DATE);
            endDate = getDate(END_DATE);
        } catch (ParseException ex) {
            LOGGER.error("Error parsing start date", ex);
        }

        Calendar c = Calendar.getInstance();
        c.setTime(startDate);
        c.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));

        int num = 1;

        while (c.getTime().before(endDate)) {
            if (c.get(Calendar.DAY_OF_WEEK) == WEDNESDAY) {
                c.add(Calendar.HOUR_OF_DAY, 2);
                lessons.add(new Lesson(c.getTime(), num));
                c.add(Calendar.HOUR_OF_DAY, -2);
                num++;
            }

            if (c.get(Calendar.DAY_OF_WEEK) == SATURDAY) {
                lessons.add(new Lesson(c.getTime(), num));
                num++;
            }
            c.add(Calendar.HOUR_OF_DAY, 24);
        }


        return lessons;
    }


    private Date getDate(String dateSrt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy HH:mm");
        sdf.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));
        return sdf.parse(dateSrt);

    }

    /**
     * For test
     *
     * @param lessons
     */
    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
