package com.example.demo.service;

import com.example.demo.entity.Note;
import com.example.demo.repository.PersonsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PersonalNotesService {
    private final PersonsRepository personsRepository;

    @Transactional
    public void addNote(Long personId, Note note) {
        var person = personsRepository.findById(personId)
                .orElseThrow();
        person.addNote(note);
    }
}
