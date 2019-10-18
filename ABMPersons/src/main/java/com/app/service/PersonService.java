package com.app.service;

import com.app.model.Person;

import java.util.List;

public interface PersonService{
    public void addPerson(Person person);
    public List<Person> getAllPersons();
    public Person getPersonByName(String name);
    public Person getPersonByTypeDocument(String typeDocument);
    public void deletePerson(Integer personId);
    public Person updatePerson(Person person);
}
