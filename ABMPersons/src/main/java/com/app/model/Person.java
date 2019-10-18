package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "per_tbl")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "document")
    private long numberOfDocument;
    @Column(name = "typeOfDocument")
    private String typeOfDocument;
    @Column(name = "birthDate")
    private String birthDate;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumberOfDocument() {
        return numberOfDocument;
    }

    public void setNumberOfDocument(long numberOfDocument) {
        this.numberOfDocument = numberOfDocument;
    }

    public String getTypeOfDocument() {
        return typeOfDocument;
    }

    public void setTypeOfDocument(String typeOfDocument) {
        this.typeOfDocument = typeOfDocument;
    }
}
