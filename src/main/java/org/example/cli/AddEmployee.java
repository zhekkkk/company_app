package org.example.cli;

import org.example.entity.Employee;
import org.example.service.EmployeeServiceImpl;

public class AddEmployee implements Command {

    @Override
    public void execute() {
        Employee employee = new Employee(null, null, null, null,-1, -1);
        EmployeeServiceImpl.getInstance().add(employee);
    }

    @Override
    public String getCommandName() {
        return "add employee";
    }
}
