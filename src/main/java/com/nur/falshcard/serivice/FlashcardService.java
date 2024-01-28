package com.nur.falshcard.serivice;

import com.nur.falshcard.dto.FlashcardDTO;
import com.nur.falshcard.excpetion.ResourceNotFoundException;

import java.util.List;

public interface FlashcardService {

    FlashcardDTO createFlashcard(FlashcardDTO flashcardDTO);

    FlashcardDTO getFlashcardById(Long flashcardId) throws ResourceNotFoundException;

    List<FlashcardDTO> getAllFlashcards();

    FlashcardDTO updateFlashcard(Long id, FlashcardDTO dto);

    void deleteFlashcard(Long flashcardId);

    FlashcardDTO updateMasteryLevel(Long id, boolean increase);
}
