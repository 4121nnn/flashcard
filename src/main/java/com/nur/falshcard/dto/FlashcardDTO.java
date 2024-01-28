package com.nur.falshcard.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlashcardDTO {
    private Long Id;
    private String question;
    private String answer;
    private String category;
    private String difficulty;
    private int masteryLevel;
}
