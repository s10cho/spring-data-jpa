package com.spring.data.user.store.jpa.repository;

import com.spring.data.user.store.jpa.jpo.UserJpo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface UserRepository extends CrudRepository<UserJpo, String> {
}
