/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import utilities.DataCalculations;
import java.io.File;
import java.io.FileNotFoundException;
import dataentry.ManualDataEntry;
import dataentry.SyntheticDataEntry;
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
    
    //GENERAL DESCRIPTION OF ASSIGMENTS (not the objects assigment of each student!)   
    //TO GET EVERY STUDENT ASSIGNMENT WE MUST ITERATE FROM EACH COURSE->STUDENTS->ASSIGNMENTS
    private ArrayList<Assignment> assignments;     
                                                   
    public void DataEntry() {

        
        Scanner sc =new Scanner(System.in);   
         
        System.out.println("Manual data entry or synthetic data? (manual/synthetic)");
        String answer;
        answer = sc.nextLine();
        while (!answer.equalsIgnoreCase("manual") && !answer.equalsIgnoreCase("synthetic")) {
            System.out.println("Select MANUAL or SYNTHETIC data entry");
            answer = sc.nextLine();
        }
        if (answer.equalsIgnoreCase("synthetic")) {
            SyntheticDataEntry.createSynData();

            courses = SyntheticDataEntry.getALLCOURSES();
            students = SyntheticDataEntry.getALLSTUDENTS();
            trainers = SyntheticDataEntry.getALLTRAINERS();
            assignments = SyntheticDataEntry.getALLASSIGNMENTS();

            System.out.println("Created synthetic data");
        } else if (answer.equalsIgnoreCase("manual")) {
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
        System.out.println();
    }

    public void printAllStudents() {
        System.out.println("Showing students (duplicates shows only once):");
        students.stream().forEach(System.out::println);
        System.out.println();
    }

    public void printAllTrainers() {
        System.out.println("Showing trainers(duplicates shows only once):");
        trainers.stream().forEach(System.out::println);
        System.out.println();
    }

    public void printAllAssignments() {
        System.out.println("Showing general description of all assignments from all the courses:");
        assignments.stream().forEach(i ->  System.out.println(i.toStringBrief()));
        System.out.println();
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
        System.out.println();
    }

    public void printAssignmentsToSubmitPerWeek() {
        DataCalculations.printAssignmentsToSubmitPerWeek(courses);
    }    
   
}
