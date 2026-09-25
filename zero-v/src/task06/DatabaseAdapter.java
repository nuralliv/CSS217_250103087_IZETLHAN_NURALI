package task06;

public class DatabaseAdapter implements IRepository {

    private final LegacyDatabaseConnection legacyDatabaseConnection;

    public DatabaseAdapter(LegacyDatabaseConnection legacyDatabaseConnection) {
        this.legacyDatabaseConnection = legacyDatabaseConnection;
    }

    @Override
    public String findById(int id) throws RecordNotFoundException, DatabaseLockedException {
        String[] outBuffer = new String[1];
        int code = legacyDatabaseConnection.executeFetch(id, outBuffer);
        if (code == -1) {
            throw new RecordNotFoundException("Record not found for id: " + id);
        }
        if (code == -2) {
            throw new DatabaseLockedException("Database locked while fetching id: " + id);
        }
        return outBuffer[0];
    }
}
