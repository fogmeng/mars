package mars.client.springsupport.annotation;

import java.lang.annotation.*;

/**
 * @author Ricky Fung
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface MarsConfigChangeListener {

    String[] value() default {};
}
