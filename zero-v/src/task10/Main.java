package task10;

public class Main {
    public static void main(String[] args) {
        FlattenedConfigAdapter config = new FlattenedConfigAdapter(new NestedConfigStore());
        System.out.println("database.host = " + config.getString("database.host"));
        System.out.println("database.port = " + config.getString("database.port"));
        System.out.println("server.name = " + config.getString("server.name"));
        System.out.println("missing.key = " + config.getString("missing.key"));
    }
}
