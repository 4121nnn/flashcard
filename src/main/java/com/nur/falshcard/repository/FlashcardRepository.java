package com.nur.falshcard.repository;

import com.nur.falshcard.entiity.Flashcard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlashcardRepository extends JpaRepository<Flashcard, Long> {

}
