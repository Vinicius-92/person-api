package com.viniciusaugusto.personapi.repository;

import com.viniciusaugusto.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT person FROM Person person JOIN FETCH person.phones WHERE person IN :personsList")
    List<Person> listAll(List<Person> personsList);
}
