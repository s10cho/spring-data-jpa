package com.spring.data.user.store.jpa.jpo;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.spring.data.user.domain.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Entity
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserJpo {

    @Id
    private String id;

    private String name;

    private String role;

    private String profileUrl;

    public UserJpo(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.role = user.getRole();
        this.profileUrl = user.getProfileUrl();
    }

    public void update(User user) {
        this.name = user.getName();
        this.role = user.getRole();
        this.profileUrl = user.getProfileUrl();
    }

    public User toDomain() {
        return new User(
            id,
            name,
            role,
            profileUrl
        );
    }
}
