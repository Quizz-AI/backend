package com.quizzai.quizzai_api.users;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class UserEntity {
    
    
    @Id
    @SequenceGenerator(name = "userIdSeq", sequenceName = "user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "userIdSeq", strategy = GenerationType.SEQUENCE)
    @Column(name = "userId")
    private Long userId;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Email(message = "Email should be valid")
    @Column(name = "email")
    private String email;

    @NonNull
    @Column(name = "password")
    private String password;

    @NonNull
    @Column(name = "totalPoints")
    private Long totalPoints;

    @NonNull
    @Column(name = "quizCount")
    private Long quizCount;

    @NonNull
    @Column(name = "rightCount")
    private Long rightCount;

    @NonNull
    @Column(name = "country")
    private String country;

    // @OneToMany
    // @JoinColumn(name = "owned_room_id")
    // private RoomEntity roomsOwned;
    
}
