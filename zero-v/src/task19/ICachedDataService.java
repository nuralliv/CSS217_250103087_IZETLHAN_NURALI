package task19;

public interface ICachedDataService {
    String read(int id);
    int getCacheHitCount();
}
