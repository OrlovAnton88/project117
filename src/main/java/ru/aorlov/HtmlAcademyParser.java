package ru.aorlov;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.aorlov.model.*;
import ru.aorlov.service.*;
import ru.aorlov.util.ParsingException;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by anton on 05.10.14.
 */

@Component
public class HtmlAcademyParser {

    @Resource
    ApproofService approofService;
    @Resource
    UserApproofService userApproofService;
    @Resource
    UserService userService;
    @Resource
    CourseService courseService;
    @Resource
    UserApproofHistoryService userApproofHistoryService;


    public HtmlAcademyParser() {
        // Exists only to defeat instantiation.
    }

    private final static Logger LOGGER = LoggerFactory.getLogger(HtmlAcademyParser.class);

    public static final String NAME_PATH = "body > div.container.ha-page-min-height > div:nth-child(1) > div > ul > li.active";
    public static final String COURSES_OK_NUM = "body > div.container.ha-page-min-height > div:nth-child(2) > div.span9 > table:nth-child(4) > tbody > tr:nth-child(1) > td:nth-child(3) > b";
    public static final String SCORES_SUM = "body > div.container.ha-page-min-height > div:nth-child(2) > div.span9 > table:nth-child(4) > tbody > tr:nth-child(1) > td:nth-child(6) > b";
    public static final String DETAILED_TABLE = "body > div.container.ha-page-min-height > div:nth-child(2) > div.span9 > table.table.table-bordered.table-striped";
    public static final String BASIC_COURSES = "Базовые курсы";

    private List<User> cachedUsers;

    @Scheduled(cron = "0 0 0 * * *")
//    @Scheduled(fixedDelay = 1000L)
    public void cronRun() {
        LOGGER.debug("Cron run starting...");
        parseSite(true);
    }

    public void manualRun() {
        parseSite(false);
    }


    private void parseSite(boolean isCron) {
        if (isCron) {
            LOGGER.info("Cron run. Rescanning HTML academy web-site...");
        } else {
            LOGGER.info("Manual run. Rescanning HTML academy web-site...");
        }

        List<User> users = userService.findAll();

        Document doc = null;

        for (User user : users) {

            String link = user.getHtmlAcademyLink();
            LOGGER.debug("Scanning data from user " + user.getUserName() + "link [" + link + ']');

            try {
                sleep(1000L);
                doc = Jsoup.connect(link).timeout(3000).get();
            } catch (IOException ex) {
                LOGGER.error("Error getting link [" + link + ']', ex);
            }


            sleep(1000L);

            Elements scoreSum = doc.select(SCORES_SUM);
            Elements coursesOkNum = doc.select(COURSES_OK_NUM);
            Elements detailedTable = doc.select(DETAILED_TABLE);

            int scoresSumInt = 0;
            int coursesOkNumInt = 0;

            try {
                validate(scoreSum, "scoreSum");
                validate(coursesOkNum, "coursesOkNum");
            } catch (ParsingException ex) {
                LOGGER.error("Error validating. Skip user..." + ex.getMessage());
                LOGGER.error("Set score to 0");
                user.setScores(scoresSumInt);
                LOGGER.error("Set passed cources to 0");
                user.setCoursesFinished(coursesOkNumInt);
                LOGGER.error("Clearing cources info");
                userApproofService.deleteAll(user);

                continue;
            }

            scoresSumInt = Integer.valueOf(scoreSum.get(0).text().replace(" ", ""));

            coursesOkNumInt = Integer.valueOf(coursesOkNum.get(0).text().trim());

            user.setScores(scoresSumInt);

            user.setCoursesFinished(coursesOkNumInt);

            parseAndSaveApproofs(user, detailedTable, isCron);
        }

        LOGGER.info("Rescanning finished.");
    }

    /**
     * Parse and save approof for given user
     *
     * @param user
     * @param table
     * @param isCron
     */
    private void parseAndSaveApproofs(User user, Elements table, boolean isCron) {
        if (table.size() != 1) {
            throw new IllegalArgumentException("fail to scrap single table");
        }

        List<UserApproof> approofs = new ArrayList();

        Elements rows = table.get(0).select("tr");

        for (org.jsoup.nodes.Element row : rows) {


            Elements courseName = row.select("td:nth-child(1)");
            Elements scores = row.select("td:nth-child(3)");

            if (courseName.size() == 0 || scores.size() == 0) {
                continue;
            }

            String[] totalPased = scores.get(0).text().split("/");
            int passed = Integer.valueOf(totalPased[0].trim());
            int total = Integer.valueOf(totalPased[1].trim());
            String name = courseName.get(0).text();

            if (passed == 0) {
                //do not need non-started courses
                continue;
            }

            Approof approof = approofService.findByName(name);

            UserApproof userApproof = new UserApproof(passed, user, name);

            userApproof.setApproof(approof);

            userApproofService.save(userApproof);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(Calendar.MILLISECOND, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MINUTE, 0);

            if (isCron) {
                UserApproofHistory userApproofHistory = new UserApproofHistory(
                        passed,
                        user,
                        approof,
                        calendar.getTime());
                userApproofHistoryService.create(userApproofHistory);
            }
        }
    }

    public void loadUsers(List<String> links) throws IOException {
        List<User> users = new ArrayList<User>();
        Document doc;
        for (String link : links) {
            try {
                doc = Jsoup.connect(link).timeout(3000).get();
            } catch (IOException ex) {
                throw new IOException("Error getting page by link [" + link + ']', ex);
            }

            Elements name = doc.select(NAME_PATH);
            Elements scoreSum = doc.select(SCORES_SUM);
            Elements coursesOkNum = doc.select(COURSES_OK_NUM);

            try {
                validate(name, "name");
                validate(scoreSum, "scoreSum");
                validate(coursesOkNum, "coursesOkNum");
            } catch (ParsingException ex) {
                LOGGER.error("Error validating. Skip user..." + ex.getMessage());
                continue;
            }

            int scoresSumInt = Integer.valueOf(scoreSum.get(0).text().replace(" ", ""));
            int coursesOkNumInt = Integer.valueOf(coursesOkNum.get(0).text().trim());
            String nameClean = name.get(0).text();

            User user = new User(nameClean, link, scoresSumInt, coursesOkNumInt);

            users.add(user);

        }
        userService.save(users);
    }

    private void validate(Elements elements, String name) throws ParsingException {
        if (elements.size() > 1) {
            throw new ParsingException("More than one " + name + "for one user");
        } else if (elements.size() == 0) {
            throw new ParsingException("No " + name + "for one user");
        }
    }


    public void loadApproofs() {

        String link = Links.getLinks().get(0);
        Document doc = null;
        try {
            doc = Jsoup.connect(link).timeout(3000).get();
        } catch (IOException ex) {
            LOGGER.error("Error getting link [" + link + ']', ex);
        }

        Elements table = doc.select(DETAILED_TABLE);

        Elements rows = table.get(0).select("tr");

        for (org.jsoup.nodes.Element row : rows) {


            Elements courseName = row.select("td:nth-child(1)");
            Elements scores = row.select("td:nth-child(3)");

            if (courseName.size() == 0 || scores.size() == 0) {
                continue;
            }

            String[] totalPased = scores.get(0).text().split("/");
            int passed = Integer.valueOf(totalPased[0].trim());
            int total = Integer.valueOf(totalPased[1].trim());
            String name = courseName.get(0).text();

            Course course = courseService.find(Course.HTML_ACADEMY);
            if (course == null) {
                course = courseService.create(new Course(Course.HTML_ACADEMY, "N/A"));
            }
            Approof approof = new Approof(name, "N/A", total, course);
            approofService.create(approof);
        }

    }

    /**
     * Wait to avoid beeng bunned
     *
     * @param time
     */
    private void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            LOGGER.error("Error waiting 1 sec. ", ex);
        }
    }

}
