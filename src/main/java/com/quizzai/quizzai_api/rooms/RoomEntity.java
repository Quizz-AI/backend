package com.quizzai.quizzai_api.rooms;


import com.quizzai.quizzai_api.quizes.QuizEntity;
import com.quizzai.quizzai_api.users.UserEntity;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
@Table(name = "rooms")
public class RoomEntity {
    

    @Id
    @SequenceGenerator(name = "roomIdSeq", sequenceName = "room_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "roomIdSeq", strategy = GenerationType.SEQUENCE)
    @Column(name = "roomId")
    private Long roomId;

    @NonNull
    @Column(name = "joinCode")
    private String joinCode;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private UserEntity owner;

    // Cada sala tem vários jogadores, e um jogador pode estar em uma sala por vez
    @ManyToMany
    @JoinTable(
        name = "room_players",
        joinColumns = @JoinColumn(name = "room_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<UserEntity> players;

    // Cada sala tem um quiz
    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    private QuizEntity quiz;
}
