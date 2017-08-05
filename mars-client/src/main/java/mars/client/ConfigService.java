package mars.client;

import mars.client.model.AppInfo;

/**
 * @author Ricky Fung
 */
public abstract class ConfigService {

    public static Config getAppConfig() {
        AppInfo appInfo = new AppInfo();
        return getConfig(appInfo);
    }

    public static Config getConfig(AppInfo appInfo) {
        return null;
    }
}
