package ru.aorlov.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.aorlov.model.HtmlAcademyUser;
import ru.aorlov.model.TasksPerDate;
import ru.aorlov.model.UserApproofHistory;
import ru.aorlov.service.UserApproofHistoryService;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by anton on 26.10.14.
 */
@Component
public class TaskPerDateUtil {
    @Resource
    UserApproofHistoryService userApproofHistoryService;


    @PostConstruct
    protected void init() {
//        cacheApproofHistory();
    }

    public void cacheApproofHistory() {
        //todo: cache map and etc...
//       List list =  userApproofHistoryService.findAll();


    }


    private final static Logger LOGGER = LoggerFactory.getLogger(TaskPerDateUtil.class);

    private Map<String, Integer> getMap(final List<UserApproofHistory> list) {
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

    public List<TasksPerDate> getSortedHistory(final HtmlAcademyUser user) {

        List<UserApproofHistory> list = userApproofHistoryService.findAllByUser(user);

        return getTaskPerDateList(list);
    }

    private List<TasksPerDate> getTaskPerDateList(final List<UserApproofHistory> list) {

        Map<String, Integer> map = getMap(list);

        List<TasksPerDate> toReturn = new ArrayList<TasksPerDate>();

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
        Collections.sort(toReturn, new TasksPerDate.DateComporator());

        return toReturn;

    }

    public int getApproofHistoryDuringLastWeek(HtmlAcademyUser user) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_WEEK, -7);

        List<UserApproofHistory> list = userApproofHistoryService.getApproofHistorySince(user, calendar.getTime());

        List<TasksPerDate> sumList = getTaskPerDateList(list);
        if (sumList.isEmpty()) {
            return 0;
        }
        TasksPerDate first = sumList.get(0);
        TasksPerDate last = sumList.get(sumList.size() - 1);

        return last.getTaskSum() - first.getTaskSum();
    }

}
