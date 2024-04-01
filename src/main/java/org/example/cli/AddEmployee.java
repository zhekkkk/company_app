package org.example.cli;

import org.example.entity.Department;
import org.example.entity.Employee;
import org.example.service.DepartmentServiceImpl;
import org.example.service.EmployeeServiceImpl;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class AddEmployee implements Command {

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("name: ");
        String name = sc.nextLine();
        System.out.println("surname: ");
        String surname = sc.nextLine();
        System.out.println("patronymic: ");
        String patronymic = sc.nextLine();
        System.out.println("age: ");
        try
        {
            int age = sc.nextInt();
            System.out.println("salary: ");
            try
            {
                double salary = sc.nextDouble();
                System.out.println("department: ");
                List<Department> departments = DepartmentServiceImpl.getInstance().getAll();
                for (int i = 0; i < departments.size(); i++)
                {
                    System.out.println((i+1) + ". " + departments.get(i).getName() + ", " + departments.get(i).getNumberOfEmployees() + " employees");
                }
                int choice = sc.nextInt();
                UUID department = departments.get(choice - 1).getId();
                Employee employee = new Employee(department, name, surname, patronymic,age, salary);
                EmployeeServiceImpl.getInstance().add(employee);
            }
            catch (InputMismatchException e)
            {
                System.out.println("salary should be double");
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println("age should be an integer");
        }

    }

    @Override
    public String getCommandName() {
        return "add employee";
    }
}
