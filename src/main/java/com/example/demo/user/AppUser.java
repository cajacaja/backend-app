package com.example.demo.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AppUser {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    private String username;

    private UserStatus status;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_auth_information_id")
    private UserAuthInformation userAuthInformation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_permission_id")
    private UserPermission userPermission;

    public AppUser() {
    }

    public AppUser(String firstName, String lastName, String email, String username, UserStatus status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.status = status;
    }

    public AppUser(Long id, String firstName, String lastName, String email, String username, UserStatus status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserPermission getUserPermission() {
        return userPermission;
    }

    public void setUserPermission(UserPermission userPermission) {
        this.userPermission = userPermission;
    }

    public UserAuthInformation getUserAuthInformation() {
        return userAuthInformation;
    }

    public void setUserAuthInformation(UserAuthInformation userAuthInformation) {
        this.userAuthInformation = userAuthInformation;
    }



    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

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

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", status=" + status +
                ", userAuthInformation=" + userAuthInformation +
                ", userPermission=" + userPermission +
                '}';
    }
}
