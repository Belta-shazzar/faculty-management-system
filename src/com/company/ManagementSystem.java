package com.company;

import java.util.Scanner;

public class ManagementSystem {
    public static void main(String[] args) {
        Faculty operation = new Faculty();

        Scanner sc = new Scanner(System.in);

        int i = 0;
        while (!(i == 7)) {
            System.out.print("1. Create Department\n2. Add Student\n3. View list of departments\n" +
                    "4. Remove department\n5. View list of students\n6. Remove student\n7. Exit" +
                    "\nWhat action will you like to perform: ");
            int action = sc.nextInt();
            i = action;

            switch (action) {
                case 1:
                    operation.createDepartment();
                    break;
                case 2:
                    operation.addStudent();
                    break;
                case 3:
                    operation.listOfDepartment();
                    break;
                case 4:
                    operation.removeDept();
                    break;
                case 5:
                    operation.listOfStudent();
                    break;
                case 6:
                    operation.removeStudent();
                    break;
                case 7:
                    System.out.println("Goodbye.");
                    break;
                default:
                    System.out.println("\nInvalid number entered!");
            }
        }

    }
}
