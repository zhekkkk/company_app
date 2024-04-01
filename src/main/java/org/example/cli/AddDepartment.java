package org.example.cli;

import org.example.entity.Department;
import org.example.service.DepartmentServiceImpl;

import java.util.Scanner;

public class AddDepartment implements Command {

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter department name: ");
        String name = sc.nextLine();
        DepartmentServiceImpl.getInstance().add(new Department(name));
    }

    @Override
    public String getCommandName() {
        return "add department";
    }
}
