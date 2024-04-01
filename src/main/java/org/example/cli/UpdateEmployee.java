package org.example.cli;

import org.example.entity.Department;
import org.example.entity.Employee;
import org.example.service.DepartmentServiceImpl;
import org.example.service.EmployeeServiceImpl;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class UpdateEmployee implements Command {
    @Override
    public void execute() {
        List<Employee> employees = EmployeeServiceImpl.getInstance().getAll();
        if (employees.size() != 0) {
            for (int i = 0; i < employees.size(); i++) {
                Employee emp = employees.get(i);
                System.out.println((i + 1) + ". " + emp.getName() + " " + emp.getSurname() + " " + emp.getPatronymic() + ", age: " + emp.getAge() + ", department: " + DepartmentServiceImpl.getInstance().getById(emp.getDepartmentId()).getName());
            }
            System.out.println("choose department to update");
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                int index = sc.nextInt();
                Employee emp = EmployeeServiceImpl.getInstance().getById(employees.get(index - 1).getId());

                System.out.println("old name: " + emp.getName());
                System.out.print("new name (press enter to pass): ");
                String newName;
                if (sc.hasNext()) {
                    newName = sc.next();
                } else {
                    newName = emp.getName();
                }

                System.out.println("old surname: " + emp.getSurname());
                System.out.print("new surname (press enter to pass): ");
                String newSurname;
                if (sc.hasNext()) {
                    newSurname = sc.next();
                } else {
                    newSurname = emp.getSurname();
                }

                System.out.println("old patronymic: " + emp.getPatronymic());
                System.out.print("new patronymic (press enter to pass): ");
                String newPatronymic;
                if (sc.hasNext()) {
                    newPatronymic = sc.next();
                } else {
                    newPatronymic = emp.getPatronymic();
                }

                System.out.println("old age: " + emp.getAge());
                System.out.print("new age (press enter to pass): ");
                int newAge;
                if (sc.hasNext()) {
                    try {
                        newAge = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("age should be integer");
                        return;
                    }
                } else {
                    newAge = emp.getAge();
                }

                System.out.println("old salary: " + emp.getSalary());
                System.out.print("new salary (press enter to pass): ");
                double newSalary;
                if (sc.hasNext()) {
                    try {
                        newSalary = sc.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("salary should be double");
                        return;
                    }
                } else {
                    newSalary = emp.getSalary();
                }

                System.out.println("old department: " + DepartmentServiceImpl.getInstance().getById(emp.getDepartmentId()).getName());
                System.out.println("list of departments: ");
                List<Department> departments = DepartmentServiceImpl.getInstance().getAll();
                for (int i = 0; i < departments.size(); i++) {
                    Department dep = departments.get(i);
                    System.out.println((i + 1) + ". " + dep.getName() + ", number of employees: " + dep.getNumberOfEmployees());
                }
                System.out.print("new department (press enter to pass): ");
                int newIndex;
                UUID newDepartmentId;
                if (sc.hasNext()) {
                    try {
                        newIndex = sc.nextInt();
                        newDepartmentId = departments.get(newIndex - 1).getId();
                    } catch (InputMismatchException e) {
                        System.out.println("choose one of existing departments");
                        return;
                    }
                } else {
                    newDepartmentId = emp.getDepartmentId();
                }

                Employee newEmp = new Employee(newDepartmentId, newName, newSurname, newPatronymic, newAge, newSalary);
                newEmp.setId(emp.getId());
                EmployeeServiceImpl.getInstance().update(newEmp);
            }
        }
    }

    @Override
    public String getCommandName() {
        return "update employee";
    }
}
