package com.viniciusaugusto.personapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.viniciusaugusto.personapi.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PhoneType type;

    @Column(nullable = false)
    private String number;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "person_id")
    private Person person;
}
