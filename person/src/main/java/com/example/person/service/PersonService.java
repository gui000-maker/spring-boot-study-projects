package com.example.person.service;

import com.example.person.model.Person;
import com.example.person.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
        private final PersonRepository personRepository;

        public PersonService(PersonRepository personRepository) {
                this.personRepository = personRepository;
        }

        public Person create(Person person) {
                return personRepository.save(person);
        }

        public List<Person> getAll() {
                return personRepository.findAll();
        }


        public Person getById(Long id) {
                return personRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Person not found"));
        }

        public Person update(Long id, Person updatedPerson) {
                Person person = getById(id);
                person.setName(updatedPerson.getName());
                return personRepository.save(person);
        }

        public void delete(Long id) {
                if (!personRepository.existsById(id)) {
                        throw new RuntimeException("Person not found");
                }
                personRepository.deleteById(id);
        }
}
