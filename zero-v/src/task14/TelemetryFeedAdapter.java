package task14;

import java.util.LinkedHashMap;
import java.util.Map;

public class TelemetryFeedAdapter implements ITelemetryService {

    private final LegacySensorFeed legacySensorFeed;

    public TelemetryFeedAdapter(LegacySensorFeed legacySensorFeed) {
        this.legacySensorFeed = legacySensorFeed;
    }

    @Override
    public Map<String, String> getCleanTelemetry() {
        Map<String, String> result = new LinkedHashMap<>();
        String raw = legacySensorFeed.getRawTelemetry();
        if (raw == null || raw.isBlank()) {
            return result;
        }

        String[] tokens = raw.split(";");
        for (String token : tokens) {
            String trimmed = token.trim();
            if (trimmed.isEmpty() || !trimmed.contains("=")) {
                continue;
            }
            int eqIndex = trimmed.indexOf('=');
            String key = trimmed.substring(0, eqIndex).trim();
            String value = trimmed.substring(eqIndex + 1).trim();
            if (key.isEmpty()) {
                continue;
            }
            result.put(key, value);
        }

        return result;
    }
}
