package com.spring.data.user.service;

import com.spring.data.user.domain.User;
import com.spring.data.user.sdo.UserCdo;
import com.spring.data.user.sdo.UserUdo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void crudTest() {
        UserCdo userCdo = new UserCdo("hong", "홍길동", "basic", "http://profile/24/24");
        userService.register(userCdo);

        //        TestTransaction.flagForCommit();

        UserUdo userUdo = new UserUdo("김길동", "vip", null);
        userService.modify(userCdo.getId(), userUdo);

        User findUser = userService.find(userCdo.getId());
        log.debug("findUser: {}", findUser);
    }
}
