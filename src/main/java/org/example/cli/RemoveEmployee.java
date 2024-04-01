package org.example.cli;

import org.example.entity.Employee;
import org.example.service.DepartmentServiceImpl;
import org.example.service.EmployeeServiceImpl;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class RemoveEmployee implements Command {

    @Override
    public void execute() {
        List<Employee> employees = EmployeeServiceImpl.getInstance().getAll();
        for (int i = 0; i < employees.size(); i++)
        {
            Employee emp = employees.get(i);
            System.out.println((i + 1) + ". " + emp.getName() + " " + emp.getSurname() + " " + emp.getPatronymic() + ", " + emp.getAge() + " лет, отдел: " + DepartmentServiceImpl.getInstance().getById(emp.getDepartmentId()).getName());
        }
        System.out.println("Введите номер работника для удаления: ");
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        EmployeeServiceImpl.getInstance().removeById(employees.get(index - 1).getId());
    }

    @Override
    public String getCommandName() {
        return "remove employee";
    }
}
