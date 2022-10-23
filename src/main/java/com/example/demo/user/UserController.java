package com.example.demo.user;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(path = "api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Page<AppUser> getUsers(
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<Integer> pageSize,
            @RequestParam Optional<String> sortBy
            ) {
        return userService.getUsers(page, pageSize, sortBy);
    }

    @GetMapping(path="{id}")
    public AppUser getUserById(@PathVariable("id") Long id) throws IllegalAccessException {
        return userService.getUser(id);
    }

    @PostMapping
    public AppUser addUser(@RequestBody UserVM user) throws IllegalAccessException, NoSuchAlgorithmException {
      return  userService.addUser(user);
    }

    @PutMapping(path="{id}")
    public AppUser updateUserInformation(@PathVariable("id") Long id,  @RequestBody UserVM user) throws IllegalAccessException {
        return userService.updateUser(id, user);
    }

    @PutMapping(path = "{id}/permissions")
    public UserPermission updateUserPermissions(@PathVariable("id") Long id, @RequestBody UserPermission permission) throws IllegalAccessException {
        return userService.updateUserPermissions(id, permission);
    }

    @DeleteMapping(path="{id}")
    public void deleteUser(@PathVariable("id") Long id) throws IllegalAccessException {
        userService.deleteUser(id);
    }
}
