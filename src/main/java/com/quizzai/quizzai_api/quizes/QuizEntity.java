package com.quizzai.quizzai_api.quizes;


import java.util.List;

import com.quizzai.quizzai_api.rooms.RoomEntity;
import com.quizzai.quizzai_api.users.UserEntity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
@Table(name = "quizes")
public class QuizEntity {
    

    @Id
    @SequenceGenerator(name = "quizIdSeq", sequenceName = "quiz_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "quizIdSeq", strategy = GenerationType.SEQUENCE)
    @Column(name = "quizId")
    private Long quizId;


    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private UserEntity owner;

    // Um quiz pode estar em várias salas
    @OneToMany(mappedBy = "quiz")
    private List<RoomEntity> rooms;
}
