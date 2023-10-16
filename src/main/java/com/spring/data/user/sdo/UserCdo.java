package com.spring.data.user.sdo;

import com.spring.data.user.domain.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserCdo {

    private String id;

    private String name;

    private String role;

    private String profileUrl;

    public User toDomain() {
        return new User(
            id,
            name,
            role,
            profileUrl
        );
    }
}
