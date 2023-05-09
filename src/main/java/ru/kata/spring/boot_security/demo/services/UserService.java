package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.entities.Role;
import ru.kata.spring.boot_security.demo.entities.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    List<User> getUserList();

    User getUserById(Long id);

    User deleteUserById(Long id);

    void deleteAllUsers();

    User changeUser(User user);

    boolean saveUser(User user);
}
