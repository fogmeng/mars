package mars.client;

import java.util.Set;

/**
 * @author Ricky Fung
 */
public interface ChangeEvent {

    Set<String> getChangedKeys();

    ChangeInfo getChangeInfo(String key);

    boolean isChanged(String key);
}
