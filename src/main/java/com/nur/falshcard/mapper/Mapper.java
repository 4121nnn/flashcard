package com.nur.falshcard.mapper;

import com.nur.falshcard.dto.FlashcardDTO;
import com.nur.falshcard.entiity.Flashcard;

public class Mapper {
    public static Flashcard toFlashcard(FlashcardDTO flashcardDTO){
        return new Flashcard(
                flashcardDTO.getId(),
                flashcardDTO.getQuestion(),
                flashcardDTO.getAnswer(),
                flashcardDTO.getCategory(),
                flashcardDTO.getDifficulty(),
                flashcardDTO.getMasteryLevel()
        );
    }

    public static FlashcardDTO toFlashcardDTO(Flashcard flashcard){
        return new FlashcardDTO(
                flashcard.getId(),
                flashcard.getQuestion(),
                flashcard.getAnswer(),
                flashcard.getCategory(),
                flashcard.getDifficulty(),
                flashcard.getMasteryLevel()
        );
    }

}
