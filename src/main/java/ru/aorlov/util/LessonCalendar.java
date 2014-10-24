package ru.aorlov.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Author:      oav <br>
 * Date:        24.10.14, 21:54 <br>
 * Company:     SofIT labs <br>
 * Revision:    $Id$ <br>
 * Description: <br>
 */
public class LessonCalendar {

    private static final int WEDNESDAY = 2;
    private static final int SATURDAY = 5;

    private static String[] studyTime = new String[]{"18:30", "16:30"};

    public String getDateOfNextLesson(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());

//        if(c.getTime().after())
//        while (c.get(Calendar.DAY_OF_WEEK) != WEDNESDAY){
//            c.add(Calendar.DAY_OF_MONTH, 1);
//        }



        return "";
    }




}
