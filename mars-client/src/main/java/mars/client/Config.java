package mars.client;

/**
 * @author Ricky Fung
 */
public interface Config {

    /**
     * Return the property value with the given key.
     * @param key
     * @return
     */
    String getProperty(String key);

    /**
     * Return the property value with the given key, or {@code defaultValue} if the key doesn't exist.
     * @param key
     * @param defaultValue
     * @return
     */
    String getProperty(String key, String defaultValue);

    /**
     * Return the short property value with the given key.
     * @param key
     * @return
     */
    Short getShortProperty(String key);

    Short getShortProperty(String key, Short defaultValue);


    /**
     * Return the integer property value with the given key.
     * @param key
     * @return
     */
    Integer getIntProperty(String key);

    /**
     * Return the integer property value with the given key, or {@code defaultValue} if the key doesn't exist.
     * @param key
     * @param defaultValue
     * @return
     */
    Integer getIntProperty(String key, Integer defaultValue);


    Long getLongProperty(String key);

    Long getLongProperty(String key, Long defaultValue);


    Float getFloatProperty(String key);

    /**
     * Return the float property value with the given key, or {@code defaultValue} if the key doesn't
     * exist.
     * @param key
     * @param defaultValue
     * @return
     */
    Float getFloatProperty(String key, Float defaultValue);

    /**
     * Return the double property value with the given key.
     * @param key
     * @return
     */
    Double getDoubleProperty(String key);

    Double getDoubleProperty(String key, Double defaultValue);

    /**
     * Return the boolean property value with the given key.
     * @param key
     * @return
     */
    Boolean getBooleanProperty(String key);

    Boolean getBooleanProperty(String key, Boolean defaultValue);

    void addOnChangeListener(OnChangeListener listener);

    interface OnChangeListener {
        void onChange(ChangeEvent changeEvent);
    }
}
