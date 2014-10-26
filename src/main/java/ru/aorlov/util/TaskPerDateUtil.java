package ru.aorlov.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.aorlov.model.TasksPerDate;
import ru.aorlov.model.UserApproofHistory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by anton on 26.10.14.
 */
public class TaskPerDateUtil {

    private final static Logger LOGGER = LoggerFactory.getLogger(TaskPerDateUtil.class);

    private static Map<String, Integer> getMap(final List<UserApproofHistory> list) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        Collections.sort(list, new UserApproofHistory.DateComporator());
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH");
        for (UserApproofHistory uh : list) {
            Calendar c = Calendar.getInstance();
            c.setTime(uh.getDate());
            c.set(Calendar.MILLISECOND, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MINUTE, 0);

            String key = sdf.format(c.getTime());
            if (map.get(key) == null) {
                map.put(key, uh.getPassedTasks());
            } else {
                Integer sum = map.get(key);
                sum += uh.getPassedTasks();
                map.put(key, sum);
            }
        }
        return map;
    }

    public static List<TasksPerDate> getHistory(final List<UserApproofHistory> list) {

        List<TasksPerDate> toReturn = new ArrayList<TasksPerDate>();
        Map<String, Integer> map = getMap(list);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH");

        for (String s : map.keySet()) {
            TasksPerDate tasksPerDate = null;
            try {
                tasksPerDate = new TasksPerDate(sdf.parse(s), map.get(s));
            } catch (ParseException ex) {
                LOGGER.error("Error pasing date " + s);
            }
            toReturn.add(tasksPerDate);
        }

        return toReturn;

    }


}
