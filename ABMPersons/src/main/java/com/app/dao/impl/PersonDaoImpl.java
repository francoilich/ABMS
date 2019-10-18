package com.app.dao.impl;

import com.app.dao.PersonDao;
import com.app.model.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class PersonDaoImpl implements PersonDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addNewPerson(Person person) {
        sessionFactory.getCurrentSession().saveOrUpdate(person);
    }
    @Override
    public List<Person> getAllPersons() {
        return sessionFactory.getCurrentSession().createQuery("from com.app.model.Person").list();

    }

    @Override
    public Person getPersonByName(String name) {
        return sessionFactory.getCurrentSession().get(Person.class, name);
    }
    @Override
    public Person getByTypeOfDocument(String typeDocument)
    {
        return sessionFactory.getCurrentSession().get(Person.class,typeDocument);
    }
    @Override
    public void deletePerson(Integer personId) {
        Optional<Person> person = Optional.of(sessionFactory.getCurrentSession().load(Person.class, personId));
        if(person.isPresent())
        {
            this.sessionFactory.getCurrentSession().delete(person);
        }
    }
    @Override
    public Person updatePerson(Person person) {
        sessionFactory.getCurrentSession().update(person);
        return person;
    }
}
