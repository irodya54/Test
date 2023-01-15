package ru.radion.service;

import ru.radion.entity.User;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class UserServiceImpl implements UserService{

    private List<User> userList = new ArrayList<>();

    @Override
    public List<User> getAll() {
        return userList;
    }

    @Override
    public Optional<User> getUserByName(String name) {
        return userList.stream().filter(user -> name.equals(user.getName())).findFirst();
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return userList.stream().filter(user -> id.equals(user.getId())).findFirst();
    }

    @Override
    public Optional<User> login(String name, String password) {
        if (name == null || password == null) throw new IllegalArgumentException("name or password is null");
        return userList.stream()
                .filter(user -> name.equals(user.getName()))
                .filter(user -> password.equals(user.getPassword()))
                .findFirst();
    }

    @Override
    public void add(User... users) {
        userList.addAll(Arrays.asList(users));
    }

    @Override
    public Map<Integer, User> getUsersConvertedById() {
        return userList.stream()
                .collect(toMap(User::getId, Function.identity()));
    }
}
