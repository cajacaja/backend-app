package com.example.demo.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Page<AppUser> getUsers(Optional<Integer> page, Optional<Integer>  pageSize, Optional<String>  property) {
        return userRepository.findAll(
                PageRequest.of(
                        page.orElse(0),
                        pageSize.orElse(10),
                        Sort.Direction.ASC,
                        property.orElse("id")
                )
        );
    }

    public AppUser getUser(Long id) throws IllegalAccessException {
        if (!userRepository.existsById(id)) {
            throw new IllegalAccessException("User doesn't exist");
        }

        return userRepository.getReferenceById(id);
    }

    public AppUser addUser(UserVM user) throws IllegalAccessException, NoSuchAlgorithmException {
        checkEmail(user.getEmail());
        checkUsername(user.getUsername());

        AppUser newUser = new AppUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getUsername(), user.getStatus());
        newUser.setUserPermission(new UserPermission(user.getCode(), user.getDescription()));
        newUser.setUserAuthInformation(new UserAuthInformation(user.getPassword()));

        userRepository.save(newUser);

        return newUser;
    }

    public AppUser updateUser(Long id,UserVM user) throws IllegalAccessException {
        if (!userRepository.existsById(id)) {
            throw new IllegalAccessException("User doesn't exist");
        }
        AppUser existingUser = userRepository.getReferenceById(id);

        if(!Objects.equals(user.getEmail(), existingUser.getEmail())) {
            checkEmail(user.getEmail());
        }

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setStatus(user.getStatus());

       return userRepository.saveAndFlush(existingUser);
    }

    public UserPermission updateUserPermissions(Long id, UserPermission permission) throws IllegalAccessException {
        if (!userRepository.existsById(id)) {
            throw new IllegalAccessException("User doesn't exist");
        }
        AppUser existingUser = userRepository.getReferenceById(id);
        existingUser.setUserPermission(permission);
        userRepository.saveAndFlush(existingUser);

        return existingUser.getUserPermission();

    }

    public void deleteUser(Long id) throws IllegalAccessException {
        if (!userRepository.existsById(id)) {
            throw new IllegalAccessException("User doesn't exist");
        }

        userRepository.deleteById(id);
    }

    private void checkEmail (String email) throws IllegalAccessException {
        Optional<AppUser> userByEmail = userRepository.findUserByEmail(email);
        if(userByEmail.isPresent()) {
            throw new IllegalAccessException("Email is already taken");
        }
    }

    private void checkUsername(String username) throws IllegalAccessException {
        Optional<AppUser> userByUsername = userRepository.findUserByUsername(username);
        if(userByUsername.isPresent()) {
            throw new IllegalAccessException("Username is already taken");
        }
    }


}
