package tests;

import models.UserSimple;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;


public class LombokTest {

    public Logger logger = LogManager.getLogger();

    @Test
    public void lombokTest() {
        UserSimple user = UserSimple.builder()
                .login("Rudak")
                .password("QqtRK9elseEfAk6ilYcJ")
                .build();
        UserSimple user1 = UserSimple.builder()
                .login("Dzmitry")
                .password("Rudak")
                .build();
//        System.out.println(user.equals(user1));
//        System.out.println(user.getFirstname());
//        System.out.println(user.getLastname());
//        System.out.println(user);

        logger.info(user.toString());

//        System.err.println("ERROR!");
//
        logger.fatal("Fatal: all is bed");
        logger.error("Error: all is bed");
//        logger.info("INFO: just FYI");
//        logger.debug("Debug: for debug");
//        logger.trace("Trace: absolutely all");
    }

}
