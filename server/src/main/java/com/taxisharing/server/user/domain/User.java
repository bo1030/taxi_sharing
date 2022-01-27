package com.taxisharing.server.user.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "user")
    private final List<MannerRecord> targetRecordList = new ArrayList<>();

    @OneToMany(mappedBy = "target")
    private final List<MannerRecord> evaluatedRecordList = new ArrayList<>();

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
        this(nickname, username, hash,  email, DEFAULT_PROFILE);
    }

    public void setManner(Integer manner) {
        this.manner = manner;
    }

    public void addTargetRecord(MannerRecord mannerRecord)
    {
        this.targetRecordList.add(mannerRecord);
        mannerRecord.setUser(this);
    }

    public void addEvaluateRecord(MannerRecord mannerRecord)
    {
        this.evaluatedRecordList.add(mannerRecord);
        mannerRecord.setTarget(this);
    }

    public void setMeanScore()
    {
        int size = evaluatedRecordList.size();
        int sum = 0;
        for(MannerRecord mannerRecord:evaluatedRecordList)
        {
            sum += mannerRecord.getScore();
        }
        this.manner = sum/size;
    }
}
