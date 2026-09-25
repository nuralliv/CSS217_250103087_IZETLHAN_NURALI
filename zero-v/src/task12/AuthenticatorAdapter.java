package task12;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AuthenticatorAdapter implements IModernAuthenticator {

    private final LegacyAuthService legacyAuthService;

    public AuthenticatorAdapter(LegacyAuthService legacyAuthService) {
        this.legacyAuthService = legacyAuthService;
    }

    @Override
    public boolean login(String username, String plainTextPassword) {
        String hexHash = toMd5Hex(plainTextPassword);
        return legacyAuthService.authenticateUserHex(username, hexHash);
    }

    private String toMd5Hex(String plainTextPassword) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] hashBytes = digest.digest(plainTextPassword.getBytes(StandardCharsets.UTF_8));
            StringBuilder hex = new StringBuilder(hashBytes.length * 2);
            for (byte b : hashBytes) {
                hex.append(String.format("%02x", b));
            }
            return hex.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("MD5 algorithm not available", e);
        }
    }
}
