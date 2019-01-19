package com.designpatterns.builder.fluentbuilder;

class Person{
    // address
    public String streetAddress, postcode, city;

    // employment
    public String companyName, position;
    public int annualIncome;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("streetAddress='").append(streetAddress).append('\'');
        sb.append(", postcode='").append(postcode).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", companyName='").append(companyName).append('\'');
        sb.append(", position='").append(position).append('\'');
        sb.append(", annualIncome=").append(annualIncome);
        sb.append('}');
        return sb.toString();
    }
}

// builder facade
class PersonBuilder{
    protected Person person = new Person();

    public PersonAddressBuilder lives(){
        return new PersonAddressBuilder(person);
    }

    public JobBuilder works(){
        return new JobBuilder(person);
    }

    public Person build(){
        return person;
    }
}

class PersonAddressBuilder extends PersonBuilder{

    public PersonAddressBuilder(Person person) {
        this.person = person;
    }

    public PersonAddressBuilder at(String streetAddress){
        person.streetAddress = streetAddress;
        return this;
    }

    public PersonAddressBuilder in(String city){
        person.city = city;
        return this;
    }

    public PersonAddressBuilder withPostCode(String postCode){
        person.postcode = postCode;
        return this;
    }
}

class JobBuilder extends PersonBuilder{

    public JobBuilder(Person person) {
        this.person = person;
    }

    public JobBuilder inCompany(String company){
        this.person.companyName = company;
        return this;
    }

    public JobBuilder asA(String position){
        this.person.position = position;
        return this;
    }

    public JobBuilder earnings(int annualIncome){
        this.person.annualIncome = annualIncome;
        return this;
    }
}

public class FluentBuilderDemo {
    public static void main(String[] args) {
        PersonBuilder pb = new PersonBuilder();
        Person p = pb
                .lives()
                  .at("100 Welton Road")
                  .in("Amsterdam")
                  .withPostCode("23DF33")
                .works()
                  .inCompany("Motorola")
                  .asA("Engineer")
                  .earnings(12000)
                .build();
        System.out.println(p);
    }
}
