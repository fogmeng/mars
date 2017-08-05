package mars.client;

/**
 * @author Ricky Fung
 */
public class AppInfo {
    private String appId;   //应用id标识
    private String cluster; //集群
    private Environment env; //应用部署环境

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    public Environment getEnv() {
        return env;
    }

    public void setEnv(Environment env) {
        this.env = env;
    }
}
