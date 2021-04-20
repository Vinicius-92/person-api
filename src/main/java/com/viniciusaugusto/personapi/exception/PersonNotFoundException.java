package com.viniciusaugusto.personapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PersonNotFoundException extends Exception{

    public PersonNotFoundException(Long id){
        super("Person not found with ID" + id);
    }
}
