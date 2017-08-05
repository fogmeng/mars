package mars.client;

/**
 * @author Ricky Fung
 */
public interface ChangeInfo {

    String getPropertyName();

    String getOldValue();

    String getNewValue();

    ChangeType getChangeType();

}
