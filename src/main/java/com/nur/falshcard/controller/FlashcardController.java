package com.nur.falshcard.controller;

import com.nur.falshcard.dto.FlashcardDTO;
import com.nur.falshcard.serivice.FlashcardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flashcards")
@AllArgsConstructor
@CrossOrigin("*")
public class FlashcardController {
    private FlashcardService flashcardService;

    // add flashcard REST API
    @PostMapping
    public ResponseEntity<FlashcardDTO> createFlashcard(@RequestBody FlashcardDTO flashcardDTO){
        FlashcardDTO savedFlashcard = flashcardService.createFlashcard(flashcardDTO);

        return new ResponseEntity<>(savedFlashcard, HttpStatus.CREATED);
    }

    // gel all flashcards REST API
    @GetMapping
    public ResponseEntity<List<FlashcardDTO>> getAllFlashcards(){
        List<FlashcardDTO> flashcardDTOs = flashcardService.getAllFlashcards();
        return ResponseEntity.ok(flashcardDTOs);
    }

    // get flashcard by id REST API
    @GetMapping("{id}")
    public ResponseEntity<FlashcardDTO> getFlashcardById(@PathVariable("id") Long id){
        FlashcardDTO flashcardDTO = flashcardService.getFlashcardById(id);
        return ResponseEntity.ok(flashcardDTO);
    }

    // update flashcard REST API
    @PostMapping("/update/{id}")
    public ResponseEntity<FlashcardDTO> updateFlashcard(@PathVariable("id") Long id, @RequestBody FlashcardDTO flashcardDTO){
        FlashcardDTO savedFlashcard = flashcardService.updateFlashcard(id, flashcardDTO);
        return ResponseEntity.ok(flashcardDTO);
    }

    // delete flashcard REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFlashcard(@PathVariable("id") Long id){
        flashcardService.deleteFlashcard(id);
        return ResponseEntity.ok("Flashcard deleted successfully.");
    }

    // update flashcard mastery level REST API
    @PostMapping("{id}")
    public ResponseEntity<FlashcardDTO> updateMasteryLevel(@PathVariable("id") Long id,
                                                           @RequestParam(value = "increase", defaultValue = "true") boolean increase){
        FlashcardDTO flashcardDTO = flashcardService.updateMasteryLevel(id, increase);
        return ResponseEntity.ok(flashcardDTO);
    }

}
