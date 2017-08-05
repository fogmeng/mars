package mars.client.springsupport;

import mars.client.ChangeEvent;
import mars.client.Config;
import mars.client.ConfigService;
import mars.client.springsupport.annotation.MarsConfig;
import mars.client.springsupport.annotation.MarsConfigChangeListener;
import mars.util.Asserts;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Mars Annotation Processor for springframework application
 * @author Ricky Fung
 */
public class MarsAnnotationProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class clazz = bean.getClass();
        processBeanFields(bean, clazz.getDeclaredFields());
        processBeanMethods(bean, clazz.getDeclaredMethods());
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    private void processBeanFields(Object bean, Field[] declaredFields) {
        for (Field field : declaredFields) {
            MarsConfig annotation = AnnotationUtils.getAnnotation(field, MarsConfig.class);
            if (annotation == null) {
                continue;
            }

            Asserts.isTrue(Config.class.isAssignableFrom(field.getType()),
                    "Invalid type: %s for field: %s, should be Config", field.getType(), field);

            String namespace = annotation.value();
            Config config = ConfigService.getAppConfig();

            ReflectionUtils.makeAccessible(field);
            ReflectionUtils.setField(field, bean, config);
        }
    }

    private void processBeanMethods(final Object bean, Method[] declaredMethods) {
        for (final Method method : declaredMethods) {
            MarsConfigChangeListener annotation = AnnotationUtils.findAnnotation(method, MarsConfigChangeListener.class);
            if (annotation == null) {
                continue;
            }

            Class<?>[] parameterTypes = method.getParameterTypes();
            Asserts.isTrue(parameterTypes.length == 1,
                    "Invalid number of parameters: %s for method: %s, should be 1", parameterTypes.length, method);
            Asserts.isTrue(ChangeEvent.class.isAssignableFrom(parameterTypes[0]),
                    "Invalid parameter type: %s for method: %s, should be ConfigChangeEvent", parameterTypes[0], method);

            ReflectionUtils.makeAccessible(method);
            String[] namespaces = annotation.value();
            for (String namespace : namespaces) {
                Config config = ConfigService.getAppConfig();

                config.addOnChangeListener(new Config.OnChangeListener() {

                    @Override
                    public void onChange(ChangeEvent changeEvent) {
                        ReflectionUtils.invokeMethod(method, bean, changeEvent);
                    }
                });
            }
        }
    }
}
