package org.example.cli;

import org.example.entity.Employee;
import org.example.service.EmployeeServiceImpl;

import java.util.Scanner;

public class AddEmployee implements Command {

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Имя: ");
        String name = sc.nextLine();
        System.out.println("Фамилия: ");
        String surname = sc.nextLine();
        System.out.println("Отчества: ");
        String patronymic = sc.nextLine();
        System.out.println("Возраст: ");
        int age = sc.nextInt();
        System.out.println("Зарплата: ");
        double salary = sc.nextDouble();
        Employee employee = new Employee(null, name, surname, patronymic,age, salary);
        EmployeeServiceImpl.getInstance().add(employee);
    }

    @Override
    public String getCommandName() {
        return "add employee";
    }
}
