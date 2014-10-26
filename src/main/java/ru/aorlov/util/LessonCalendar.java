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

    private static final int WEDNESDAY = 3;
    private static final int SATURDAY = 7;

    private static final String START_DATE = "13-09-2014";
    private static final String END_DATE = "01-05-2015";

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

    private List<Lesson> getLessons() {
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
        c.set(Calendar.MILLISECOND, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.HOUR, 0);

        int num = 1;

        while (c.getTime().before(endDate)) {
            if (c.get(Calendar.DAY_OF_WEEK) == WEDNESDAY) {
                c.set(Calendar.HOUR, 18);
                c.set(Calendar.MINUTE, 30);
                lessons.add(new Lesson(c.getTime(), num));
                c.set(Calendar.HOUR, 0);
                c.set(Calendar.MINUTE, 0);
                num++;
            }

            if (c.get(Calendar.DAY_OF_WEEK) == SATURDAY) {
                c.set(Calendar.HOUR, 16);
                c.set(Calendar.MINUTE, 30);
                lessons.add(new Lesson(c.getTime(), num));
                c.set(Calendar.HOUR, 0);
                c.set(Calendar.MINUTE, 0);
                num++;
            }
            c.add(Calendar.DAY_OF_WEEK, 1);
        }


        return lessons;
    }


    private Date getDate(String dateSrt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy");

        return sdf.parse(dateSrt);

    }


}
