package com.taxisharing.server.user.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    private static final String DEFAULT_PROFILE = "/default-profile";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 16, nullable = false)
    private String nickname;

    private String profileImage = DEFAULT_PROFILE;

    @Column(nullable = false)
    private String username;

    @Column(length = 64, nullable = false)
    private String hash;


    @Column(length = 32, nullable = false)
    private String email;

    private Integer manner;

    public User(String nickname, String username, String hash, String email, String profileImage, int manner)
    {
        this.email = email;
        this.hash = hash;
        this.nickname = nickname;
        this.username = username;
        this.profileImage = profileImage;
        this.manner = manner;
    }

    public User(String nickname, String username, String hash, String email, String profileImage)
    {
        this(nickname, username, hash, email, profileImage, 0);
    }

    public User(String nickname, String username, String hash, String email)
    {
        this(nickname, username, hash,  email, null);
    }
}
