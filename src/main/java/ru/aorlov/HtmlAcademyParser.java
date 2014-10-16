package ru.aorlov;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.aorlov.model.Approof;
import ru.aorlov.model.Course;
import ru.aorlov.model.User;
import ru.aorlov.model.UserApproof;
import ru.aorlov.service.ApproofService;
import ru.aorlov.service.CourseService;
import ru.aorlov.service.UserApproofService;
import ru.aorlov.service.UserService;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
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

    private static HtmlAcademyParser instance = null;

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


    @Scheduled(fixedDelay = 3600000)
    public void parseSite() {

        LOGGER.info("Rescanning HTML academy web-site...");
        List<User> users = userService.findAll();
        Document doc = null;
        for (User user : users) {
            String link = user.getHtmlAcademyLink();
            try {
               try{
                   Thread.sleep(1000);
               } catch (InterruptedException ex){
                   LOGGER.error("Error waiting 1 sec. ", ex);
               }
                doc = Jsoup.connect(link).timeout(3000).get();
            } catch (IOException ex) {
              LOGGER.error("Error getting link [" + link + ']', ex);
            }
            Elements scoressSum = doc.select(SCORES_SUM);
            Elements coursesOkNum = doc.select(COURSES_OK_NUM);
            Elements detailedTable = doc.select(DETAILED_TABLE);

            if (scoressSum.size() != 1) {
                throw new IllegalArgumentException("Not 1  score sum for one user. Link: " + link);
            }

            if (coursesOkNum.size() != 1) {
                throw new IllegalArgumentException("Not 1 coursesOkNum for one user. Link: " + link);
            }

            int scoresSumInt = Integer.valueOf(scoressSum.get(0).text().replace(" ", ""));
            int coursesOkNumInt = Integer.valueOf(coursesOkNum.get(0).text().trim());


            user.setScores(scoresSumInt);
            user.setCoursesFinished(coursesOkNumInt);

            saveApproofs(user, detailedTable);

        }
        LOGGER.info("Rescanning finished.");
    }

    private void saveApproofs(User user, Elements table) {
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

            UserApproof userApproof = new UserApproof(passed, user,name);

            userApproof.setApproof(approof);

            userApproofService.save(userApproof);
        }
    }

    public void loadUsers(List<String> links) throws IOException {
        List<User> users = new ArrayList<User>();
        Document doc = null;
        for (String link : links) {
            try {
                doc = Jsoup.connect(link).timeout(3000).get();
            } catch (IOException ex) {
                throw new IOException("Error getting page by link [" + link + ']', ex);
            }

            Elements name = doc.select(NAME_PATH);
            Elements scoressSum = doc.select(SCORES_SUM);
            Elements coursesOkNum = doc.select(COURSES_OK_NUM);

            if (name.size() != 1) {
                throw new IllegalArgumentException("Not 1  name for one user. Link: " + link);
            }

            if (scoressSum.size() != 1) {
                throw new IllegalArgumentException("Not 1  score sum for one user. Link: " + link);
            }

            if (coursesOkNum.size() != 1) {
                throw new IllegalArgumentException("Not 1 coursesOkNum for one user. Link: " + link);
            }

            int scoresSumInt = Integer.valueOf(scoressSum.get(0).text().replace(" ", ""));
            int coursesOkNumInt = Integer.valueOf(coursesOkNum.get(0).text().trim());
            String nameClean = name.get(0).text();

            User user = new User(nameClean, link, scoresSumInt, coursesOkNumInt);

            users.add(user);

        }
        userService.save(users);
    }


    public void loadApproofs(){
      String link =   Links.getLinks().get(0);
        Document doc= null;
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
            if(course == null){
                course =  courseService.create(new Course(Course.HTML_ACADEMY, "N/A"));
            }
            Approof approof = new Approof(name, "N/A", total, course);
            approofService.create(approof);
        }

    }


//    @Scheduled(cron = "0 0/1 * * * *")
//    public void scanUsers() throws IOException {
//        LOGGER.info("Scanning users...");
//        createUsers();
//    }


}
