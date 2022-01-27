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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="target_id")
    private User target;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;

    public MannerRecord(int score)
    {
        this.score = score;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTarget(User target) {
        this.target = target;
    }
}
