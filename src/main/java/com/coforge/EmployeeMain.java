package com.coforge;

import java.time.LocalDate;
import java.util.List;

import com.coforge.dao.EmployeeDao;
import com.coforge.model.Employee;

public class EmployeeMain {

    public static void main(String[] args) {

        EmployeeDao dao = new EmployeeDao();

        Employee emp = new Employee();

        emp.setName("Naman");
        emp.setDob(LocalDate.of(2004, 5, 20));
        emp.setLocation("Noida");

        dao.addEmployee(emp);

        Employee e = dao.searchEmployeeById(1);

        System.out.println(e);

        List<Employee> list = dao.showAllEmployee();

        for (Employee employee : list) {
            System.out.println(employee);
        }
    }
}