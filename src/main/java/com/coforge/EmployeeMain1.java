package com.coforge;

import java.time.LocalDate;
import java.util.Scanner;

import com.coforge.dao.EmployeeDao;
import com.coforge.model.Employee;

public class EmployeeMain1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EmployeeDao dao = new EmployeeDao();

        String ch = "y";

        while (ch.equalsIgnoreCase("y")) {

            System.out.println("\n******** Employee Management ********");
            System.out.println("1. Add Employee");
            System.out.println("2. Show All Employees");
            System.out.println("3. Search Employee By Id");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int operation = scanner.nextInt();

            switch (operation) {

            case 1:

                Employee emp = new Employee();

                System.out.print("Enter Employee Id: ");
                emp.setId(scanner.nextInt());
                scanner.nextLine();

                System.out.print("Enter Employee Name: ");
                emp.setName(scanner.nextLine());

                System.out.print("Enter DOB (yyyy-MM-dd): ");
                LocalDate dob = LocalDate.parse(scanner.next());

                emp.setDob(dob);
                scanner.nextLine();

                System.out.print("Enter Location: ");
                emp.setLocation(scanner.nextLine());

                dao.addEmployee(emp);

                System.out.println("Employee Added Successfully.");

                break;

            case 2:

                System.out.println("\n-----------Employee List-----------");

                dao.showAllEmployee().forEach(a ->

                System.out.println(
                        "Id : " + a.getId()
                                + "  Name : " + a.getName()
                                + "  DOB : " + a.getDob()
                                + "  Location : " + a.getLocation()));

                break;

            case 3:

                System.out.print("Enter Employee Id : ");

                Employee e = dao.searchEmployeeById(scanner.nextInt());

                if (e != null) {

                    System.out.println("\nEmployee Found");

                    System.out.println("Id       : " + e.getId());
                    System.out.println("Name     : " + e.getName());
                    System.out.println("DOB      : " + e.getDob());
                    System.out.println("Location : " + e.getLocation());

                } else {

                    System.out.println("Employee Not Found.");
                }

                break;

            case 4:

                System.out.println("Thank You...");
                scanner.close();
                System.exit(0);

                break;

            default:

                System.out.println("Invalid Choice.");

            }

            System.out.print("\nDo you want to continue (y/n): ");
            ch = scanner.next();
        }

        scanner.close();
    }
}