package com.nur.falshcard.serivice.impl;

import com.nur.falshcard.dto.FlashcardDTO;
import com.nur.falshcard.entiity.Flashcard;
import com.nur.falshcard.excpetion.ResourceNotFoundException;
import com.nur.falshcard.mapper.Mapper;
import com.nur.falshcard.repository.FlashcardRepository;
import com.nur.falshcard.serivice.FlashcardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FlashcardServiceImpl implements FlashcardService {

    private FlashcardRepository flashcardRepository;
    @Override
    public FlashcardDTO createFlashcard(FlashcardDTO flashcardDTO) {
        Flashcard flashcard = Mapper.toFlashcard(flashcardDTO);
        Flashcard savedFlashcard = flashcardRepository.save(flashcard);

        return Mapper.toFlashcardDTO(savedFlashcard);
    }

    @Override
    public FlashcardDTO getFlashcardById(Long flashcardId){
        Flashcard flashcard = flashcardRepository.findById(flashcardId)
                .orElseThrow( () ->
                        new ResourceNotFoundException("Flashcard is not exists with given id :" + flashcardId));

        return Mapper.toFlashcardDTO(flashcard);
    }

    @Override
    public List<FlashcardDTO> getAllFlashcards() {
        List<Flashcard> flashcards = flashcardRepository.findAll();

        //sorting by mastery level
        flashcards.sort(Comparator.comparingInt(Flashcard::getMasteryLevel));
        return flashcards.stream().map(Mapper::toFlashcardDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FlashcardDTO updateFlashcard(Long id, FlashcardDTO dto) {
        Flashcard flashcard = flashcardRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Flashcard is not exists with given id: " + id)
        );
        flashcard.setQuestion(dto.getQuestion());
        flashcard.setAnswer(dto.getAnswer());
        flashcard.setDifficulty(dto.getDifficulty());
        flashcard.setCategory(dto.getCategory());

        flashcardRepository.save(flashcard);

        return Mapper.toFlashcardDTO(flashcard);
    }

    @Override
    public void deleteFlashcard(Long flashcardId) {
        Flashcard flashcard = flashcardRepository.findById(flashcardId).orElseThrow(
        () -> new ResourceNotFoundException("Flashcard is not exists with given id: " + flashcardId)
        );

        flashcardRepository.deleteById(flashcardId);

    }

    @Override
    public FlashcardDTO updateMasteryLevel(Long id, boolean increase) {
        Flashcard flashcard = flashcardRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(" Can not update flashcard mastery level with given id: \" + flashcardId")
        );
        int masteryLevel =  flashcard.getMasteryLevel();
        if(increase){
            if(masteryLevel < 100) masteryLevel += 10;
        }else{
            if(masteryLevel > 0) masteryLevel -= 10;
        }
        flashcard.setMasteryLevel(masteryLevel);
        Flashcard updatedFlashcard = flashcardRepository.save(flashcard);

        return Mapper.toFlashcardDTO(updatedFlashcard);


    }
}
