package com.example.assesment2.service;

import com.example.assesment2.dao.PersonDAO;
import com.example.assesment2.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    PersonDAO personDAO;
    @Autowired
    public PersonService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }
    public void addPerson(Person person){
        personDAO.addPerson(person);
    }

    public Person getPersonById(int id){
        return personDAO.getPersonByIndex(id);
    }

    public String getRoleById(int id){
        return personDAO.getRoleByPersonIndex(id);
    }
    public Person getPersonUsername(String name){
        for(Person p : personDAO.getAllPersons()){
            if(p.getUsername().equals(name)){
                return p;
            }
        }
        return null;
    }
}
