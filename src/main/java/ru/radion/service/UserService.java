package ru.radion.service;

import ru.radion.entity.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {
    List<User> getAll();
    Optional<User> getUserByName(String name);
    Optional<User> getUserById(Integer id);

    Optional<User> login(String name, String password);

    void add(User... users);

    Map<Integer, User> getUsersConvertedById();
}
