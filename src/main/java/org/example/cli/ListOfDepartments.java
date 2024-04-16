package org.example.cli;

import org.example.entity.Department;
import org.example.service.DepartmentServiceImpl;

import java.util.List;
import java.util.Scanner;

public class ListOfDepartments implements Command {

    @Override
    public void execute() {
        List<Department> departments = DepartmentServiceImpl.getInstance().getAll();
        if (!departments.isEmpty())
        {
            for (int i = 0; i < departments.size(); i++)
            {
                Department dep = departments.get(i);
                System.out.println((i + 1) + ". " + dep.getName() + ", number of employees: " + dep.getNumberOfEmployees());
            }
        }
        else
        {
            System.out.println("there is no departments");
        }
    }

    @Override
    public String getCommandName() {
        return "list of departments";
    }
}
