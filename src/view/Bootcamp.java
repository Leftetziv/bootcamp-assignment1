/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.File;
import java.io.FileNotFoundException;
import view.dataentry.ManualDataEntry;
import view.dataentry.SyntheticDataEntry;
import java.util.ArrayList;
import java.util.Scanner;
import model.*;

/**
 *
 * @author Leyteris
 */
public class Bootcamp {

    private ArrayList<Course> courses;
    private ArrayList<Student> students;              
    private ArrayList<Trainer> trainers;              
    private ArrayList<Assignment> assignments;     //GENERAL DESCRIPTION OF ASSIGMENTS (not the objects assigment of each student!)
                                                   //TO GET EVERY STUDENT ASSIGNMENT WE MUST ITERATE FROM EACH COURSE->STUDENTS->ASSIGNMENTS
    public void DataEntry() {

        
        Scanner sc =new Scanner(System.in);   
         
        System.out.println("Manual data entry or synthetic data? (man/syn)");
        String answer;
        answer = "man";
//        answer = sc.nextLine();
        while (!answer.equalsIgnoreCase("man") && !answer.equalsIgnoreCase("syn")) {
            System.out.println("Select MAN or SYN data entry");
            answer = sc.nextLine();
        }
        if (answer.equalsIgnoreCase("syn")) {
            SyntheticDataEntry.createSynData();

            courses = SyntheticDataEntry.getALLCOURSES();
            students = SyntheticDataEntry.getALLSTUDENTS();
            trainers = SyntheticDataEntry.getALLTRAINERS();
            assignments = SyntheticDataEntry.getALLASSIGNMENTS();

            System.out.println("Created synthetic data");
        } else if (answer.equalsIgnoreCase("man")) {
            System.out.println("manual");
            ManualDataEntry.createManData();
            
            courses = ManualDataEntry.getALLCOURSES();
            students = ManualDataEntry.getALLSTUDENTS();
            trainers = ManualDataEntry.getALLTRAINERS();
            assignments = ManualDataEntry.getALLASSIGNMENTS();
            
        }
    }

    public void printAllCourses() {
        System.out.println("Showing all courses:");
        courses.stream().forEach(System.out::println);
        System.out.println("");
    }

    public void printAllStudents() {
        System.out.println("Showing students (duplicates shows only once):");
        students.stream().forEach(System.out::println);
        System.out.println("");
    }

    public void printAllTrainers() {
        System.out.println("Showing trainers(duplicates shows only once):");
        trainers.stream().forEach(System.out::println);
        System.out.println("");
    }

    public void printAllAssignments() {
        System.out.println("Showing general description of all assignments from all the courses:");
        assignments.stream().forEach(Assignment::printCourseDetails);
        System.out.println("");
    }

    public void printStudentsPerCourse() {
        DataCalculations.printStudentsPerCourse(courses);
    }

    public void printTrainersPerCourse() {
        DataCalculations.printTrainersPerCourse(courses);
    }

    public void printAssignmentsPerCourse() {
        DataCalculations.printAssignmentsPerCourse(courses);
    }

    public void printAssignmentsPerStudent() {
        DataCalculations.printAssignmentsPerStudent(students, courses);
    }

    public void printMultiCourseStudents() {
        System.out.println("Showing students who belong to multiple courses:");
        ArrayList<Student> duplicateStudents = DataCalculations.getMultiCourseStudents(courses);
        duplicateStudents.stream().forEach(System.out::println);
        System.out.println("");
    }

    public void printAssignmentsToSubmitPerWeek() {
        DataCalculations.printAssignmentsToSubmitPerWeek(courses);
    }

}
