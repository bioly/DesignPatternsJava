package com.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

    private String firstname;
    private String lastname;
    private String address;
    private String title;
    private int age;
    private int salary;

    public Person(String firstname, String lastname, String address, String title, int age, int salary) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.title = title;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("firstname='").append(firstname).append('\'');
        sb.append(", lastname='").append(lastname).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", age=").append(age);
        sb.append(", salary=").append(salary);
        sb.append('}');
        return sb.toString();
    }
}
