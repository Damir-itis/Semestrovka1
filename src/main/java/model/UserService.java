package model;

import model.User;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserService {

    private static final String SALT = "DAMIR%KASIMOV-BEST+CODERS[]EVER-TRUE-100%";

    public User enrollUser(String username, String password) {

        if (username == null || password == null) {
           return null;
        }

        User user = new User();
        user.setUsername(username);
        String passwordSecure = generateSecurePassword(password);
        user.setPassword(passwordSecure);

        return user;
    }

    private String generateSecurePassword(String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-512");
            md.update(SALT.getBytes());
            byte[] newValue = md.digest(password.getBytes(StandardCharsets.UTF_8));
            return java.util.Base64.getEncoder().encodeToString(newValue);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return password;
    }
}
