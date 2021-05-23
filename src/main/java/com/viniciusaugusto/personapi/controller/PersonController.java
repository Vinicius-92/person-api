package com.viniciusaugusto.personapi.controller;

import com.viniciusaugusto.personapi.dto.request.PersonDTO;
import com.viniciusaugusto.personapi.dto.response.MessageResponseDTO;
import com.viniciusaugusto.personapi.exception.PersonNotFoundException;
import com.viniciusaugusto.personapi.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private PersonService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO dto) {
        return service.createPerson(dto);
    }

    @GetMapping
    public List<PersonDTO> listAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PersonDTO dto) throws PersonNotFoundException {
        return service.updateById(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
        service.delete(id);
    }
}
