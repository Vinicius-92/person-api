package com.viniciusaugusto.personapi.repository;

import com.viniciusaugusto.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
