package task12;

public class Main {
    public static void main(String[] args) {
        AuthenticatorAdapter authenticator = new AuthenticatorAdapter(new LegacyAuthService());
        System.out.println("admin/password -> " + authenticator.login("admin", "password"));
        System.out.println("admin/wrongpass -> " + authenticator.login("admin", "wrongpass"));
    }
}
