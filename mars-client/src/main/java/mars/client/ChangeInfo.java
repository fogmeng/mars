package mars.client;

/**
 * @author Ricky Fung
 */
public class ConfigChange {
    private String propertyName;
    private String oldValue;
    private String newValue;
    private PropertyChangeType changeType;

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public PropertyChangeType getChangeType() {
        return changeType;
    }

    public void setChangeType(PropertyChangeType changeType) {
        this.changeType = changeType;
    }
}
