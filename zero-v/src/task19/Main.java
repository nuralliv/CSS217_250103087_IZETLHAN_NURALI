package task19;

public class Main {
    public static void main(String[] args) {
        CachedDatabaseAdapter cache = new CachedDatabaseAdapter(new ExpensiveRemoteDatabase());
        System.out.println(cache.read(1));
        System.out.println(cache.read(1));
        System.out.println(cache.read(2));
        System.out.println("Cache hits: " + cache.getCacheHitCount());
    }
}
