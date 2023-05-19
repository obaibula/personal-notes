package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

import static org.springframework.http.ResponseEntity.created;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonsRepository personsRepository;

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        // save person to the db
        // create new location based on generated id
        // return teh response with the new location
        personsRepository.save(person);

        var location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(person.getId())
                .toUri();

        return created(location)
                .body(person);
    }

    @GetMapping
    public List<Person> getALl() {
        return personsRepository.findAll();
    }
}
