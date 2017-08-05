package mars.demo.spring.annotation.bean;

import mars.client.ChangeEvent;
import mars.client.Config;
import mars.client.springsupport.annotation.MarsConfigChangeListener;
import mars.client.springsupport.annotation.MarsConfig;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author Ricky Fung
 */
public class SampleAnnotationBean {
    @MarsConfig
    private Config config;

    @Value("${batch:100}")
    private int batch;

    @MarsConfigChangeListener
    private void someOnChange(ChangeEvent changeEvent) {
        //update injected value of batch if it is changed in Apollo
        if (changeEvent.isChanged("batch")) {
            batch = config.getIntProperty("batch", 100);
        }
    }
}
