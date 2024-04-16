package org.example.cli;

import org.example.entity.Department;
import org.example.service.DepartmentServiceImpl;

import java.util.List;
import java.util.Scanner;

public class RemoveDepartment implements Command {

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
            System.out.println("choose a department to remove: ");
            Scanner sc = new Scanner(System.in);
            int index = sc.nextInt();
            if (index <= departments.size())
            {
                DepartmentServiceImpl.getInstance().removeById(departments.get(index - 1).getId());
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
        return "remove department";
    }
}
