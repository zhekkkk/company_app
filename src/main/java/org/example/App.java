package org.example;

import org.example.cli.Menu;
import org.example.entity.Department;
import org.example.entity.Employee;
import org.example.service.DepartmentServiceImpl;
import org.example.service.EmployeeServiceImpl;

import java.util.List;

public class App {

    public static void main(String[] args) {
        DepartmentServiceImpl.getInstance().add(new Department("abracadabra"));
        DepartmentServiceImpl.getInstance().add(new Department("woopytyscoop"));
        DepartmentServiceImpl.getInstance().add(new Department("scoobydoobydoo"));
        List<Department> deps = DepartmentServiceImpl.getInstance().getAll();
        EmployeeServiceImpl.getInstance().add(new Employee(deps.get(0).getId(), "kanye", "west", "shiz", 34, 15000));
        EmployeeServiceImpl.getInstance().add(new Employee(deps.get(0).getId(), "marshall", "mathers", "shiz", 55, 22222));
        EmployeeServiceImpl.getInstance().add(new Employee(deps.get(0).getId(), "snoop", "dogg", "shiz", 12, 150));
        EmployeeServiceImpl.getInstance().add(new Employee(deps.get(0).getId(), "colson", "baker", "shiz", 99, 87000));
        Menu.run();
    }

}
