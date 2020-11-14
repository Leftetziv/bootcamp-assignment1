/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dataentry.ReadFromUserUtilities;
import datamanipulations.Bootcamp;
import java.util.Scanner;

/**
 *
 * @author Leyteris github.com/Leftetziv/bootcamp-assignment1
 */
public class RegistryOffice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choiceMenu = "";

        choiceMenu += "Enter the number of the procedure you want to do, or q to quit\n";
        choiceMenu += "1  - Show all Courses\n";
        choiceMenu += "2  - Show all Trainers\n";
        choiceMenu += "3  - Show all Students\n";
        choiceMenu += "4  - Show all Students who belong to multiple courses\n";
        choiceMenu += "5  - Show all courses Assignments\n";
        choiceMenu += "6  - Show all the Students per course\n";
        choiceMenu += "7  - Show all the Trainers per course\n";
        choiceMenu += "8  - Show all the Assignments per course\n";
        choiceMenu += "9  - Show all the Assignments per student\n";
        choiceMenu += "10 - Show all the Students with assignments on a specific week\n";
        choiceMenu += "11 - Modify existing data\n";

        int answerInt;

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.DataEntry();

        do {
            System.out.println(choiceMenu);
            answerInt = ReadFromUserUtilities.readNumberOrQuit(1, 11);

            if (answerInt != -1) {
                switch (answerInt) {
                    case 1:
                        bootcamp.printAllCourses();
                        System.out.println("Press enter to continue...");
                        sc.nextLine();
                        break;
                    case 2:
                        bootcamp.printAllTrainers();
                        System.out.println("Press enter to continue...");
                        sc.nextLine();
                        break;
                    case 3:
                        bootcamp.printAllStudents();
                        System.out.println("Press enter to continue...");
                        sc.nextLine();
                        break;
                    case 4:
                        bootcamp.printMultiCourseStudents();
                        System.out.println("Press enter to continue...");
                        sc.nextLine();
                        break;
                    case 5:
                        bootcamp.printAllAssignments();
                        System.out.println("Press enter to continue...");
                        sc.nextLine();
                        break;
                    case 6:
                        bootcamp.printStudentsPerCourse();
                        System.out.println("Press enter to continue...");
                        sc.nextLine();
                        break;
                    case 7:
                        bootcamp.printTrainersPerCourse();
                        System.out.println("Press enter to continue...");
                        sc.nextLine();
                        break;
                    case 8:
                        bootcamp.printAssignmentsPerCourse();
                        System.out.println("Press enter to continue...");
                        sc.nextLine();
                        break;
                    case 9:
                        bootcamp.printAssignmentsPerStudent();
                        System.out.println("Press enter to continue...");
                        sc.nextLine();
                        break;
                    case 10:
                        bootcamp.printAssignmentsToSubmitPerWeek();
                        System.out.println("Press enter to continue...");
                        sc.nextLine();
                        break;
                    case 11:
                        System.out.println("Coming soon...");                    //todo modify
                        System.out.println("Press enter to continue...");
                        sc.nextLine();
                        break;
                    default:
                        System.out.println("Enter on of the given numbers");

                }
            } else {
                break;
            }
        } while (true);

//        registry.printAllCourses();
//        registry.printAllTrainers();
//        registry.printAllStudents();
//        registry.printAllAssignments();
//        registry.printMultiCourseStudents();
//
//        registry.printStudentsPerCourse();
//        registry.printTrainersPerCourse();
//        registry.printAssignmentsPerCourse();
//        registry.printAssignmentsPerStudent();    
//        registry.printAssignmentsToSubmitPerWeek();
    }

}
