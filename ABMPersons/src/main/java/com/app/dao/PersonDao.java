package com.app.dao;

import com.app.model.Person;

import java.util.List;

public interface PersonDao {
    public void addNewPerson(Person person);
    public List getAllPersons();
    Person getPersonByName(String name);
    Person getByTypeOfDocument(String typeDocument);
    public void deletePerson(Integer personId);
    public Person updatePerson(Person person);


}
