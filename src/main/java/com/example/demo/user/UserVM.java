package com.example.demo.user;

public class UserVM {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private UserStatus status;
    private String username;
    private String password;
    private Boolean code;
    private Boolean description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getCode() {
        return code;
    }

    public void setCode(Boolean code) {
        this.code = code;
    }

    public Boolean getDescription() {
        return description;
    }

    public void setDescription(Boolean description) {
        this.description = description;
    }
}
