package com.example.demo.controller;

import com.example.demo.entity.Note;
import com.example.demo.service.PersonalNotesService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons/{personId}/notes")
public class PersonalNotesController {
    private final PersonalNotesService personalNotesService;

    public PersonalNotesController(PersonalNotesService personalNotesService) {
        this.personalNotesService = personalNotesService;
    }

    @PostMapping
    public void addNote(@PathVariable Long personId, @RequestBody Note note){
        personalNotesService.addNote(personId, note);
    }
}
