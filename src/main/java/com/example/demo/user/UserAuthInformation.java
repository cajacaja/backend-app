package com.example.demo.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

@Entity
@Table
public class UserAuthInformation {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    @JsonIgnore
    private byte[] salt;
    @JsonIgnore
    private byte[] hash;

    public UserAuthInformation() {
    }

    public UserAuthInformation(String password) throws NoSuchAlgorithmException {

        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        this.salt = salt;

        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(salt);
        this.hash = md.digest(password.getBytes(StandardCharsets.UTF_8));

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getSalt() {
        return salt;
    }

    public byte[] getHash() {
        return hash;
    }

    @Override
    public String toString() {
        return "UserAuthInformation{" +
                "id=" + id +
                ", salt=" + Arrays.toString(salt) +
                ", hash=" + Arrays.toString(hash) +
                '}';
    }
}
