package com.spring.data.user.store.jpa;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.spring.data.user.domain.User;
import com.spring.data.user.store.UserStore;
import com.spring.data.user.store.jpa.jpo.UserJpo;
import com.spring.data.user.store.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class UserJpaStore implements UserStore {

    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
            .map(UserJpo::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id)
            .map(UserJpo::toDomain);
    }

    @Transactional
    @Override
    public void save(User user) {
        userRepository.save(new UserJpo(user));
    }

    @Transactional
    @Override
    public void update(User user) {
        UserJpo userJpo = userRepository.findById(user.getId())
            .orElseThrow(() -> new NoSuchElementException("Not found user."));
        userJpo.update(user);
    }

    @Transactional
    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }
}
