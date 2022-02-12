package com.taxisharing.server.user.domain;


import com.taxisharing.server.common.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "manner_record")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MannerRecord extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="target_id")
    private User target;

    @ManyToOne(fetch = FetchType.LAZY)
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
