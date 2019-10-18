package com.app.service.impl;

import com.app.dao.PersonDao;
import com.app.model.Person;
import com.app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao personDao;

    @Override
    @Transactional
    public void addPerson(Person person)
    {
        personDao.addNewPerson(person);
    }
    @Override
    @Transactional
    public List<Person> getAllPersons() {
        return personDao.getAllPersons();
    }
    @Override
    @Transactional
    public void deletePerson(Integer personId) {
        personDao.deletePerson(personId);
    }

    @Override
    public Person getPersonByName(String name)
    {
       return personDao.getPersonByName(name);
    }
    @Override
    public Person getPersonByTypeDocument(String typeDocument)
    {
        return personDao.getByTypeOfDocument(typeDocument);
    }

    public Person updatePerson(Person person) {
        return personDao.updatePerson(person);
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }


}
