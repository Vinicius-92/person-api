package com.viniciusaugusto.personapi.service;

import com.viniciusaugusto.personapi.dto.request.PersonDTO;
import com.viniciusaugusto.personapi.dto.response.MessageResponseDTO;
import com.viniciusaugusto.personapi.entity.Person;
import com.viniciusaugusto.personapi.exception.PersonNotFoundException;
import com.viniciusaugusto.personapi.mapper.PersonMapper;
import com.viniciusaugusto.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private PersonRepository repository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = repository.save(personToSave);
        return createMessageResponse(savedPerson.getId(), "Created person with ID ");
    }

    @Transactional(readOnly = true)
    public Page<PersonDTO> listAll(PageRequest pageRequest) {
        Page<Person> person = repository.findAll(pageRequest);
        repository.listAll(person.stream().collect(Collectors.toList()));
        return person.map(personMapper::toDTO);
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);
        return personMapper.toDTO(person);
    }

    public void delete(Long id) throws PersonNotFoundException {
        verifyIfExists(id);
        repository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);
        Person personToUpdate = personMapper.toModel(personDTO);
        Person updatedPerson = repository.save(personToUpdate);
        return createMessageResponse(updatedPerson.getId(), "Updated person with ID ");
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO.builder().message(message + id).build();
    }
}
