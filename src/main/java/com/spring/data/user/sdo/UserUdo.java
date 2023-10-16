package com.spring.data.user.sdo;

import static org.apache.commons.lang3.StringUtils.defaultString;

import com.spring.data.user.domain.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserUdo {

    private String name;

    private String role;

    private String profileUrl;

    public User toDomain(User originUser) {
        return new User(
            originUser.getId(),
            defaultString(name, originUser.getName()),
            defaultString(role, originUser.getRole()),
            defaultString(profileUrl, originUser.getProfileUrl())
        );
    }
}
