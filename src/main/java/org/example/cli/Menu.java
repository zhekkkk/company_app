package org.example.cli;

import java.util.Scanner;

public class Menu {

    private static Command[] commands = new Command[] {
            new AddEmployee(),
            new RemoveEmployee(),
            new AddDepartment(),
            new RemoveDepartment(),
            new UpdateDepartment(),
            new UpdateEmployee(),
            new ListOfDepartments(),
            new ListOfEmployees(),
            new ShowTotalSalary(),
            new ListOfDepartmentEmployees(),
    };

    public static void run() {
        while (true)
        {
            System.out.println("-----------------------------------");
            System.out.println("choose an action: ");
            for (int i = 0; i < commands.length; i++)
            {
                System.out.println(i + 1 + ". " + commands[i].getCommandName());
            }
            Scanner scanner = new Scanner(System.in);
            int k = scanner.nextInt();
            if (k == 0)
                break;
            commands[k - 1].execute();
            System.out.println("-----------------------------------");
        }
    }

}
