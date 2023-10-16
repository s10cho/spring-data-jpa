package com.spring.data.user.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.spring.data.user.domain.User;
import com.spring.data.user.sdo.UserCdo;
import com.spring.data.user.sdo.UserUdo;
import com.spring.data.user.store.UserStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserStore userStore;

    public List<User> findAll() {
        return userStore.findAll();
    }

    public User find(String id) {
        return userStore.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Not fount user"));
    }

    public void register(UserCdo userCdo) {
        User user = userCdo.toDomain();
        userStore.save(user);
    }

    public void modify(String id, UserUdo userUdo) {
        User findUser = find(id);
        User user = userUdo.toDomain(findUser);
        userStore.update(user);
    }

    public void remove(String id) {
        userStore.delete(id);
    }
}
