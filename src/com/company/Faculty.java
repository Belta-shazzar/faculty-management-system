package com.company;

import java.util.*;

public class Faculty {
//    Department variables
    private static int deptIdSource = 100;
    private String deptId;
    private String deptName;
    private Date deptDateCreated;

//    Student variables
    private static int studentIdSource = 100;
    private String studentId;
    private String studentFirstName;
    private String studentLastName;
    private String studentDepartment;
    private String studentLevel;
    private Date studentDateCreated;

//    Array for action 3.
    ArrayList<String> deptList = new ArrayList<String>();

//  Array for student department option.
    ArrayList<String> deptListDisplay = new ArrayList<String>();

//    Array for action 5.
    ArrayList<String> studentList = new ArrayList<String>();

    Scanner sc = new Scanner(System.in);

//    Method for operation no.1
    public void createDepartment() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of departments to be created: ");
        int numb = sc.nextInt();
        int i = 0;
        while (i < numb) {
            System.out.print("Department name: ");
            this.deptName = sc.next();
            sc.nextLine();
            this.deptId = Integer.toString(deptIdSource++);
            this.deptDateCreated = new Date();

//            Operation 3 display.
            String newDept = "Department id: " + deptId + ", Department name: " +
                    deptName + ", Date created: " + deptDateCreated + "\n";
            deptList.add(newDept);

//            Student department option.
            deptListDisplay.add(deptId + " " + deptName);
            i++;
        }
        System.out.println(i + " Department created\n");
    }

//    Method for operation no. 3
    public void listOfDepartment() {
        System.out.println(deptList);
    }

//    Method for operation 4
    public void removeDept() {
        System.out.print("Number of departments to be removed: ");
        int number = sc.nextInt();
        int i = 0;
        while (i < number) {
            System.out.println(deptList);
            System.out.print("Enter department ID: ");
            String selectedId = sc.next();
            String check = "Department id: " + selectedId;


            Iterator<String> iterator = deptList.iterator();

            while (iterator.hasNext()) {
                if (iterator.next().contains(check)) {
                    iterator.remove();
                }
            }

            Iterator<String> iterator2 = deptListDisplay.iterator();

            while (iterator2.hasNext()) {
                if (iterator2.next().contains(selectedId)) {
                    iterator2.remove();
                }
            }

            studentList.removeIf(student -> student.contains(studentDepartment) && !(deptList.contains(studentDepartment)));

            i++;
        }
        if (i > 1) {
            System.out.println(i + " departments removed.\n");
        } else {
            System.out.println(i + " department removed.\n");
        }
    }

    public void addStudent() {
        System.out.print("Number of students to be added: ");
        int number = sc.nextInt();
        int person = 0;
        while (person < number) {
            System.out.println("1 - Freshman \n2 - Sophomore \n3 - Penultimate \n4 - Finals");
            for (int i = 0; i < 2; i++) {
                System.out.print("*pick number allocated to level\nEnter student level: ");
                int levelPicked = sc.nextInt();
                if (levelPicked > 0 && levelPicked < 5) {
                    this.studentLevel = Integer.toString(levelPicked);
                    break;
                } else {
                    System.out.println("Invalid level entered!");
                }
            }
            if (studentLevel == null) {
                System.out.println("\nLevel was not entered");
            } else {
                System.out.println("Level " + studentLevel);
                System.out.print("Enter first name: ");
                this.studentFirstName = sc.next();
                System.out.print("Enter last name: ");
                this.studentLastName = sc.next();
                this.studentId = studentLevel + Integer.toString(studentIdSource++);

//                Option display for student to pick from.
                System.out.println("Available departments: \n" + deptListDisplay);
                System.out.print("*enter department by name \nDesired department: ");
                String selectedDept = sc.next();
                sc.nextLine();
                for (String dept : deptList) {
                    if (dept.contains(selectedDept)) {
                        this.studentDepartment = selectedDept;
                    }
                }


                this.studentDateCreated = new Date();

                String studentDetail = "Student id: " + studentId + ", First Name: " + studentFirstName
                        + ", Last Name: " + studentLastName + ", Level: " + studentLevel +
                        ", Department: " + studentDepartment + ", Date added: " + studentDateCreated + "\n";

                studentList.add(studentDetail);


                person++;
            }
        }
            System.out.println(person + " Student added.\n");
    }
//  Method for operation 5
    public void listOfStudent() {
        System.out.println(studentList);
    }

//    Method for operation 6
    public void removeStudent() {
        System.out.print("Number of students to be removed: ");
        int number = sc.nextInt();
        int i = 0;
        while (i < number) {
            System.out.println(studentList);
            System.out.print("Enter student ID: ");
            String selectedId = sc.next();
            String check = "Student id: " + selectedId;

            Iterator<String> itr = studentList.iterator();
            while (itr.hasNext()) {
                if (itr.next().contains(check)) {
                    itr.remove();
                }
            }

            i++;
        }
        if (i > 1) {
            System.out.println(i + " students removed.\n");
        } else {
            System.out.println(i + " student removed.\n");
        }
    }
}
