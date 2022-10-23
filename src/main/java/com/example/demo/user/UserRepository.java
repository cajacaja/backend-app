package com.example.demo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

    @Query("SELECT au FROM AppUser au WHERE au.email = :email")
    Optional<AppUser> findUserByEmail(@Param("email") String email);

    @Query("SELECT au FROM AppUser au WHERE au.username = :username")
    Optional<AppUser> findUserByUsername(@Param("username") String username);
}
