package org.example.cli;

import org.example.entity.Department;
import org.example.service.DepartmentServiceImpl;

import java.util.List;
import java.util.Scanner;

public class UpdateDepartment implements Command {

    @Override
    public void execute() {
        List<Department> departments = DepartmentServiceImpl.getInstance().getAll();
        if (departments.size() != 0) {
            for (int i = 0; i < departments.size(); i++) {
                Department dep = departments.get(i);
                System.out.println((i + 1) + ". " + dep.getName() + ", number of employees: " + dep.getNumberOfEmployees());
            }
            System.out.println("choose a department to update: ");
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt())
            {
                int index = sc.nextInt();
                Department dep = DepartmentServiceImpl.getInstance().getById(departments.get(index - 1).getId());

                System.out.println("old name: " + dep.getName());
                System.out.print("new name: ");
                String newName;
                if (sc.hasNext())
                {
                    newName = sc.next();
                }
                else
                {
                    newName = dep.getName();
                }

                Department newDep = new Department(newName);
                newDep.setId(dep.getId());
                DepartmentServiceImpl.getInstance().update(newDep);
            }
            else
            {
                System.out.println("wrong input");
            }

        } else {
            System.out.println("there is no departments");
        }
    }

    @Override
    public String getCommandName() {
        return "update department";
    }
}
