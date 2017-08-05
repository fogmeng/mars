package mars.demo.spring.xml.bean;

/**
 * @author Ricky Fung
 */
public class SampleBean {
    private int connectTimeout;
    private int readTimeout;
    private int writeTimeout;

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    public void setWriteTimeout(int writeTimeout) {
        this.writeTimeout = writeTimeout;
    }
}
