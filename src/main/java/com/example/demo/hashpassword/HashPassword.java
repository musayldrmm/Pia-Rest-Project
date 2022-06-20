package com.example.demo.hashpassword;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPassword {
    private String generatedPassword = "";

    public HashPassword(String passwordToHash) {
        // Create MessageDigest instance for MD5
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }

        // Add password bytes to digest
        md.update(passwordToHash.getBytes());

        // Get the hash's bytes
        byte[] bytes = md.digest();

        // This bytes[] has bytes in decimal format. Convert it to hexadecimal format
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        // Get complete hashed password in hex format
        generatedPassword = sb.toString();


    }
    public String getPasswordToHash()
    {
        return generatedPassword;
    }

}
