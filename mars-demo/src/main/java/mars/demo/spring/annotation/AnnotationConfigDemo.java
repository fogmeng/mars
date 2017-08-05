package mars.demo.spring.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Ricky Fung
 */
public class AnnotationConfigDemo {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:mars-annotation-demo.xml");

        LockSupport.park();
    }
}
