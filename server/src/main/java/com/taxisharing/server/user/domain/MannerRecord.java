package com.taxisharing.server.user.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "manner_record")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MannerRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="target_id")
    private User target;

    public MannerRecord(int score)
    {
        this.score = score;
    }
}
