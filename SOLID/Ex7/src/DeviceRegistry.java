import java.util.*;

public class DeviceRegistry {
    private final java.util.List<Object> devices = new ArrayList<>();

    public void add(Object d) { devices.add(d); }

    public <T> T getFirstByCapabilities(Class<T> primaryCapability, Class<?>... requiredCapabilities) {
        for (Object d : devices) {
            if (!primaryCapability.isInstance(d)) continue;
            boolean matchesAll = true;
            for (Class<?> capability : requiredCapabilities) {
                if (!capability.isInstance(d)) {
                    matchesAll = false;
                    break;
                }
            }
            if (matchesAll) {
                return primaryCapability.cast(d);
            }
        }
        throw new IllegalStateException("Missing device for capability: " + primaryCapability.getSimpleName());
    }
}
