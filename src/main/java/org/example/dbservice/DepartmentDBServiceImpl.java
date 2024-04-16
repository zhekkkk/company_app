package org.example.dbservice;

import org.example.entity.Department;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DepartmentDBServiceImpl implements DepartmentDBService {

    private DBConnectionService dbConnectionService;
    private Statement statement;
    private ResultSet resultSet;

    private static DepartmentDBServiceImpl instance;

    private DepartmentDBServiceImpl() {
        dbConnectionService = DBConnectionService.getInstance();
    }

    public static DepartmentDBServiceImpl getInstance() {
        if (instance == null)
            instance = new DepartmentDBServiceImpl();
        return instance;
    }

    @Override
    public void addEmployee(UUID uuid) {
        String sql = "UPDATE departments SET num_of_employees = num_of_employees + 1 WHERE id = '" + uuid + "';";
        try {
            createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeEmployee(UUID uuid) {
        String sql = "UPDATE departments SET num_of_employees = num_of_employees - 1 WHERE id = '" + uuid + "';";
        try {
            createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void add(Department obj) {
        String sql = "INSERT INTO departments (id, name, num_of_employees) VALUES ('" + obj.getId() + "', '" + obj.getName() + "', " + obj.getNumberOfEmployees() + ");";
        try {
            createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Department getById(UUID uuid) {
        String sql = "SELECT * FROM departments WHERE id = '" + uuid + "';";
        Department department = null;
        try {
            createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                UUID id = (UUID)resultSet.getObject("id");
                String name = resultSet.getString("name");
                int numberOfEmployees = resultSet.getInt("num_of_employees");
                department = new Department(id, name, numberOfEmployees);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return department;
    }

    @Override
    public void removeById(UUID uuid) {
        String sql = "DELETE FROM departments WHERE id = '" + uuid + "';";
        try {
            createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Department obj) {
        String sql = "UPDATE departments SET name = '" + obj.getName() + "' WHERE id = '" + obj.getId() + "';";
        try {
            createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Department> getAll() {
        String sql = "SELECT * FROM departments;";
        List<Department> departments = new ArrayList<>();
        try {
            createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                UUID id = (UUID)resultSet.getObject("id");
                String name = resultSet.getString("name");
                int numberOfEmployees = resultSet.getInt("num_of_employees");
                departments.add(new Department(id, name, numberOfEmployees));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return departments;
    }

    private void createStatement() {
        statement = dbConnectionService.createStatement();
    }

}
