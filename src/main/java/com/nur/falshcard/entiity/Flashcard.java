package com.nur.falshcard.entiity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="flashcards")
public class Flashcard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String question;
    private String answer;
    private String category;
    private String difficulty;
    @Column(name = "mastery_level")
    private int masteryLevel;

}
