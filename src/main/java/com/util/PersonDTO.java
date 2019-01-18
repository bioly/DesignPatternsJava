package com.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class PersonDTO {

    private String name;
    private String surname;
    private int age;

    public static PersonDTO map(Person person){
        return new PersonDTO(person.getFirstname(), person.getLastname(), person.getAge());
    }
}
