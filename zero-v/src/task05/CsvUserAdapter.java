package task05;

public class CsvUserAdapter implements IUserSource {

    private final LegacyCsvUserStore legacyCsvUserStore;

    public CsvUserAdapter(LegacyCsvUserStore legacyCsvUserStore) {
        this.legacyCsvUserStore = legacyCsvUserStore;
    }

    @Override
    public UserProfile getNextUser() {
        String row = legacyCsvUserStore.fetchNextRow();
        if (row == null) {
            throw new IllegalStateException("Legacy user store returned null row");
        }
        String[] tokens = row.split(",", -1);
        if (tokens.length != 3) {
            throw new IllegalStateException("Invalid CSV row: " + row);
        }
        try {
            int id = Integer.parseInt(tokens[0].trim());
            String fullName = tokens[1].trim();
            String role = tokens[2].trim();
            return new UserProfile(id, fullName, role);
        } catch (NumberFormatException e) {
            throw new IllegalStateException("Invalid CSV row: " + row, e);
        }
    }
}
