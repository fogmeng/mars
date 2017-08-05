package mars.demo.spring.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Ricky Fung
 */
public class XmlConfigDemo {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:mars-xml-demo.xml");

        LockSupport.park();
    }
}
