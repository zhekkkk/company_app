package org.example.cli;

import org.example.entity.Employee;
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
            
        }
    }

    @Override
    public String getCommandName() {
        return "remove employee";
    }
}
