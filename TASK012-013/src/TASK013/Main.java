package TASK013;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Elena.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("TASK013/spring-config.xml");
        Email email = ac.getBean(Email.class);
        email.setEmail("elena.com");
        email.setEmail("elena@com");
        email.setEmail("elena@elena.com");
    }
}
