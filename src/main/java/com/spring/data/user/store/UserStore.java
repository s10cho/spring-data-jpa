package com.spring.data.user.store;

import java.util.List;
import java.util.Optional;

import com.spring.data.user.domain.User;

public interface UserStore {

    List<User> findAll();

    Optional<User> findById(String id);

    void save(User user);

    void update(User user);

    void delete(String id);
}
