package org.example;

import org.example.cli.Menu;
import org.example.entity.Department;
import org.example.entity.Employee;
import org.example.service.DepartmentServiceImpl;
import org.example.service.EmployeeServiceImpl;

import java.util.List;

public class App {

    public static void main(String[] args) {
        /*DepartmentServiceImpl.getInstance().add(new Department("accounting"));
        DepartmentServiceImpl.getInstance().add(new Department("sales"));
        DepartmentServiceImpl.getInstance().add(new Department("human resources"));
        List<Department> deps = DepartmentServiceImpl.getInstance().getAll();
        EmployeeServiceImpl.getInstance().add(new Employee(deps.get(0).getId(), "kuznetsov", "roman", "egorovich", 34, 15000));
        EmployeeServiceImpl.getInstance().add(new Employee(deps.get(0).getId(), "pugacheva", "kira", "georgievna", 55, 22222));
        EmployeeServiceImpl.getInstance().add(new Employee(deps.get(0).getId(), "kovaleva", "milana", "kirillovna", 25, 1509));
        EmployeeServiceImpl.getInstance().add(new Employee(deps.get(1).getId(), "samoylova", "kseniya", "maksimovna", 52, 87000));
        EmployeeServiceImpl.getInstance().add(new Employee(deps.get(1).getId(), "maslova", "arina", "andreevna", 22, 8700));
        EmployeeServiceImpl.getInstance().add(new Employee(deps.get(2).getId(), "demin", "mikhail", "maratovich", 44, 28974));
        EmployeeServiceImpl.getInstance().add(new Employee(deps.get(2).getId(), "larionov", "artem", "fyodorovich", 33, 56453));
        */Menu.run();
    }

}
