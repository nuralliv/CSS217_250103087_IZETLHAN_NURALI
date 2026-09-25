package task19;

import java.util.HashMap;
import java.util.Map;

public class CachedDatabaseAdapter implements ICachedDataService {

    private final ExpensiveRemoteDatabase expensiveRemoteDatabase;
    private final Map<Integer, String> cache = new HashMap<>();
    private int hitCounter = 0;

    public CachedDatabaseAdapter(ExpensiveRemoteDatabase expensiveRemoteDatabase) {
        this.expensiveRemoteDatabase = expensiveRemoteDatabase;
    }

    @Override
    public String read(int id) {
        if (cache.containsKey(id)) {
            hitCounter++;
            return cache.get(id);
        }
        String value = expensiveRemoteDatabase.queryById(id);
        cache.put(id, value);
        return value;
    }

    @Override
    public int getCacheHitCount() {
        return hitCounter;
    }
}
