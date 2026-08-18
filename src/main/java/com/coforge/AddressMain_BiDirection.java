package com.coforge;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.coforge.model.Address;
import com.coforge.model.Gender;
import com.coforge.model.Person;

public class AddressMain_BiDirection {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure();

        SessionFactory sessionFactory =
                configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction =
                session.getTransaction();

        transaction.begin();

        Address address = new Address();
        address.setAddr_id(102);
        address.setCity("Jaipur");
        address.setState("Rajasthan");

        Person person = new Person();
        person.setName("Ajay Kumar");
        person.setGender(Gender.male);
        person.setAddress(address);

        address.setPerson(person);

        session.persist(address);

        transaction.commit();

        session.close();
        sessionFactory.close();
    }
}