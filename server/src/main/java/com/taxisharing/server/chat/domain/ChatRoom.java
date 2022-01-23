package  com.taxisharing.server.chat.domain;

import com.taxisharing.server.user.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "chat_room")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45, nullable = false)
    private String hostName;

    private Date generateTime;

    private Date departureTime;

    @Column(length = 64, nullable = false)
    private String departureAddress;

    private float departureLatitude;

    private float departureLongitude;

    @Column(length = 64, nullable = false)
    private String destinationAddress;

    private float destinationLatitude;

    private float destinationLongitude;

    private Integer maximumNumber;
    private Integer currentNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User host;

    @OneToMany(mappedBy = "chat_room")
    private final List<ChatRoomParticipant> participants = new ArrayList<>();

    public ChatRoom(String hostName, Date generateTime, Date departureTime, String departureAddress, float departureLatitude, float departureLongitude, String destinationAddress, float destinationLatitude, float destinationLongitude, Integer maximumNumber, Integer currentNumber, User host){
        this.hostName = hostName;
        this.generateTime = generateTime;
        this.departureTime = departureTime;
        this.departureAddress = departureAddress;
        this.departureLatitude = departureLatitude;
        this.departureLongitude = departureLongitude;
        this.destinationAddress = destinationAddress;
        this.destinationLatitude = destinationLatitude;
        this.destinationLongitude = destinationLongitude;
        this.maximumNumber = maximumNumber;
        this.currentNumber = currentNumber;
        this.host = host;
    }
    public ChatRoom(String hostName, Date generateTime, Date departureTime, String departureAddress, float departureLatitude, float departureLongitude, String destinationAddress, float destinationLatitude, float destinationLongitude, Integer maximumNumber, User host){
        this(hostName,generateTime,departureTime,departureAddress,departureLatitude,departureLongitude,destinationAddress,destinationLatitude,destinationLongitude,maximumNumber,1, host);
    }
}