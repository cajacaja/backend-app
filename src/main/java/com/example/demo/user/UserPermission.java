package com.example.demo.user;

import javax.persistence.*;

@Entity
@Table
public class UserPermission {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    private Boolean code;
    private Boolean description;

    public UserPermission() {
    }

    public UserPermission(Boolean code, Boolean description) {
        this.code = code;
        this.description = description;
    }

    public UserPermission(Long id, Boolean code, Boolean description) {
        this.id = id;
        this.code = code;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "UserPermission{" +
                "id=" + id +
                ", code=" + code +
                ", description=" + description +
                '}';
    }
}
