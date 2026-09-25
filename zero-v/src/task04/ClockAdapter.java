package task04;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

public class ClockAdapter implements IModernCalendar {

    private final LegacyClock legacyClock;

    public ClockAdapter(LegacyClock legacyClock) {
        this.legacyClock = legacyClock;
    }

    @Override
    public LocalDate getCurrentDate() {
        Instant instant = Instant.ofEpochSecond(legacyClock.getEpochSeconds());
        return instant.atZone(ZoneOffset.UTC).toLocalDate();
    }
}
