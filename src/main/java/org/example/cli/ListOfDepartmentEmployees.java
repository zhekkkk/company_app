package org.example.cli;

import org.example.dbservice.EmployeeDBService;
import org.example.entity.Department;
import org.example.entity.Employee;
import org.example.service.DepartmentServiceImpl;
import org.example.service.EmployeeService;
import org.example.service.EmployeeServiceImpl;

import java.util.List;
import java.util.Scanner;

public class ListOfDepartmentEmployees implements Command {
    @Override
    public void execute() {
        List<Department> departments = DepartmentServiceImpl.getInstance().getAll();
        if (departments.size() != 0)
        {
            for (int i = 0; i < departments.size(); i++)
            {
                Department dep = departments.get(i);
                System.out.println((i + 1) + ". " + dep.getName() + ", number of employees: " + dep.getNumberOfEmployees());
            }
            System.out.println("choose department: ");
            Scanner sc = new Scanner(System.in);
            int index = sc.nextInt();
            if (index <= departments.size())
            {
                //DepartmentServiceImpl.getInstance().removeById(departments.get(index - 1).getId());
                List<Employee> employees = EmployeeServiceImpl.getInstance().getByDepartmentId(departments.get(index - 1).getId());
                if (employees.size() != 0)
                {
                    for (int i = 0; i < employees.size(); i++) {
                        Employee emp = employees.get(i);
                        System.out.println((i + 1) + ". " + emp.getName() + " " + emp.getSurname() + " " + emp.getPatronymic() + ", age: " + emp.getAge() + ", department: " + DepartmentServiceImpl.getInstance().getById(emp.getDepartmentId()).getName());
                    }
                }
                else
                {
                    System.out.println("there is no employees");
                }
            }
            else
            {
                System.out.println("wrong number of department");
            }
        }
        else
        {
            System.out.println("there is no departments");
        }
    }

    @Override
    public String getCommandName() {
        return "list of employees of department";
    }
}
