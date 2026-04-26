package com.example.person.controller;

import com.example.person.service.PersonService;
import com.example.person.model.Person;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/people")
public class PersonController {
        private final PersonService personService;

        public PersonController(PersonService personService) {
                this.personService = personService;
        }

        @PostMapping
        public Person createPerson(@RequestBody Person person) {
                return personService.create(person);
        }

        @GetMapping
        public List<Person> getAllPersons() {
                return personService.getAll();
        }

        @GetMapping("/{id}")
        public Person person(@PathVariable Long id) {
                return personService.getById(id);
        }

        @PutMapping("/{id}")
        public Person updatePerson(@PathVariable Long id, @RequestBody Person person) {
                return personService.update(id, person);
        }

        @DeleteMapping("/{id}")
        public void deletePerson(@PathVariable Long id) {
                personService.delete(id);
        }
}
