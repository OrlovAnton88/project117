package ru.aorlov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import ru.aorlov.service.ApproofService;

/**
 * Created by anton on 05.10.14.
 */
public class Main {
    private final static Logger logger = LoggerFactory.getLogger(Main.class);
//todo:  https://www.openshift.com/products/online

    ApplicationContext ctx = new FileSystemXmlApplicationContext("//home/anton/117/src/main/resources/META-INF/applicationContext.xml");
    ApproofService service =   ctx.getBean(ApproofService.class);
    public static void main(String[] args) {



        logger.info("Entering application.");
        logger.warn("Entering application.");
        logger.debug("Entering application.");
        logger.error("Entering application.");

    }
}