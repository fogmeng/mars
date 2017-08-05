package mars.client;

import java.util.Set;

/**
 * @author Ricky Fung
 */
public interface ConfigChangeEvent {

    Set<String> getChangedKeys();

    ConfigChange getChange(String key);
}
