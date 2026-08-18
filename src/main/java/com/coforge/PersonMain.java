package com.coforge;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.coforge.model.Address;
import com.coforge.model.Gender;
import com.coforge.model.Person;

public class PersonMain {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.getTransaction();

        Person person = new Person();
        person.setName("Ram Kumar");
        person.setGender(Gender.male);

        Address address = new Address();
        address.setAddr_id(103);
        address.setCity("noida");
        address.setState("up");
        
        person.setAddress(address);

        transaction.begin();

        session.persist(address);
        session.persist(person);

        transaction.commit();

        session.close();
        sessionFactory.close();

        System.out.println("Person and Address Saved Successfully.");
    }
}