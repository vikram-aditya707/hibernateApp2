package com.coforge.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.coforge.model.Employee;

public class EmployeeDao {

    SessionFactory factory;
    Session session;
    Transaction transaction;

    public EmployeeDao() {

        Configuration configuration = new Configuration();
        configuration.configure();

        factory = configuration.buildSessionFactory();
        session = factory.openSession();
    }

    public void addEmployee(Employee employee) {

        transaction = session.beginTransaction();

        session.persist(employee);

        transaction.commit();
    }

    public List<Employee> showAllEmployee() {

        return session.createQuery("from Employee", Employee.class).list();
    }

    public Employee searchEmployeeById(int id) {

        Employee e = session.find(Employee.class, id);

        return e;
    }
}