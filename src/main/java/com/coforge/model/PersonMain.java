package com.coforge.model;

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

        SessionFactory factory = configuration.buildSessionFactory();

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        Address address = new Address();
        address.setAddr_id(101);
        address.setCity("Noida");
        address.setState("Uttar Pradesh");

        Person person = new Person();
        person.setName("Aditya");
        person.setGender(Gender.MALE);
        person.setAddress(address);

        session.persist(person);

        transaction.commit();

        session.close();

        factory.close();

        System.out.println("Person Saved Successfully");

    }
}