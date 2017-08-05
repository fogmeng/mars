package mars.demo;

import mars.client.ChangeEvent;
import mars.client.ChangeInfo;
import mars.client.Config;
import mars.client.ConfigService;

/**
 * @author Ricky Fung
 */
public class MarConfigDemo {

    public static void main(String[] args) {

        Config config = ConfigService.getAppConfig();
        config.addOnChangeListener(new Config.OnChangeListener() {
            @Override
            public void onChange(ChangeEvent changeEvent) {

                for (String key : changeEvent.getChangedKeys()) {
                    ChangeInfo change = changeEvent.getChangeInfo(key);
                    System.out.println(String.format(
                            "Found change - key: %s, oldValue: %s, newValue: %s, changeType: %s",
                            change.getPropertyName(), change.getOldValue(),
                            change.getNewValue(), change.getChangeType()));
                }
            }
        });

        System.out.println(config.getProperty("jdbc.url"));
        System.out.println(config.getProperty("jdbc.username"));
        System.out.println(config.getProperty("jdbc.password"));

        System.out.println(config.getIntProperty("jdbc.maxActive", 50));
        System.out.println(config.getIntProperty("jdbc.initialSize", 10));

        System.out.println(config.getIntProperty("jdbc.maxWait", 60000));
        System.out.println(config.getIntProperty("jdbc.minIdle", 1));

        System.out.println(config.getLongProperty("jdbc.timeBetweenEvictionRunsMillis", 60000L));
        System.out.println(config.getLongProperty("jdbc.minEvictableIdleTimeMillis", 300000L));

        System.out.println(config.getProperty("validationQuery", "SELECT 'x'"));
        System.out.println(config.getBooleanProperty("jdbc.testWhileIdle", true));
        System.out.println(config.getBooleanProperty("jdbc.testOnBorrow", false));
        System.out.println(config.getBooleanProperty("jdbc.testOnReturn", false));
        System.out.println(config.getBooleanProperty("jdbc.poolPreparedStatements", true));

        System.out.println(config.getIntProperty("jdbc.maxPoolPreparedStatementPerConnectionSize", 20));

    }
}
