package task05;

public class Main {
    public static void main(String[] args) {
        CsvUserAdapter userSource = new CsvUserAdapter(new LegacyCsvUserStore());
        UserProfile user = userSource.getNextUser();
        System.out.println("User: " + user);
    }
}
