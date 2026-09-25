package task06;

public class Main {
    public static void main(String[] args) throws Exception {
        DatabaseAdapter repo = new DatabaseAdapter(new LegacyDatabaseConnection());

        System.out.println("Record: " + repo.findById(1));

        try {
            repo.findById(404);
        } catch (RecordNotFoundException e) {
            System.out.println("Correctly threw RecordNotFoundException: " + e.getMessage());
        }

        try {
            repo.findById(500);
        } catch (DatabaseLockedException e) {
            System.out.println("Correctly threw DatabaseLockedException: " + e.getMessage());
        }
    }
}
