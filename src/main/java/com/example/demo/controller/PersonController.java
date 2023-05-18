package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonsRepository personsRepository;

    @PostMapping
    public void createPerson(@RequestBody Person person) {
        // save person to the db
        personsRepository.save(person);
    }
}
