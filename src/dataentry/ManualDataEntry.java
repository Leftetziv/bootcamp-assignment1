/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataentry;

import static dataentry.ReadFromUserUtilities.readString;
import java.util.ArrayList;
import java.util.Random;
import model.Assignment;
import model.Course;
import model.Student;
import model.Trainer;

/**
 *
 * @author Leyteris
 */
public class ManualDataEntry {

    private static final ArrayList<Course> ALLCOURSES = new ArrayList<>();
    private static final ArrayList<Student> ALLSTUDENTS = new ArrayList<>();
    private static final ArrayList<Trainer> ALLTRAINERS = new ArrayList<>();
    private static final ArrayList<Assignment> ALLASSIGNMENTS = new ArrayList<>();

    public static void createManData() {

        Course course;
        ArrayList<Trainer> trainers;
        ArrayList<Student> students;
        ArrayList<Assignment> assignments;
        boolean addMoreElement;

        //arxi tis loupas
        course = new Course();

        System.out.println("Enter the course title:");
        course.setTitle(ReadFromUserUtilities.readString());

        System.out.println("Enter the course stream:");
        course.setStream(ReadFromUserUtilities.readString());

        System.out.println("Enter the course type:");
        course.setType(ReadFromUserUtilities.readString());

        System.out.println("Enter the course start date:");
        course.setStartDate(ReadFromUserUtilities.readDate());

        System.out.println("Enter the course old date:");
        course.setEndDate(ReadFromUserUtilities.readDate());

        trainers = new ArrayList<>();
        do {
            Trainer trainer = new Trainer();
            System.out.println("\nCreating trainer for the course:");
            System.out.println("Enter the trainer first name:");
            trainer.setFirstName(ReadFromUserUtilities.readString());

            System.out.println("Enter the trainer last name:");
            trainer.setLastName(ReadFromUserUtilities.readString());

            System.out.println("Enter the trainer subject:");
            trainer.setSubject(ReadFromUserUtilities.readString());

            trainers.add(trainer);

            System.out.println("Do you want to create new trainer? (yes/no)");
            addMoreElement = ReadFromUserUtilities.readYesOrNo();
        } while (addMoreElement);
        course.setTrainers(trainers);
        ALLTRAINERS.addAll(trainers);

        students = new ArrayList<>();
        do {
            Student student = new Student();
            System.out.println("\nCreating student for the course:");
            System.out.println("Enter the student first name:");
            student.setFirstName(ReadFromUserUtilities.readString());

            System.out.println("Enter the student last name:");
            student.setLastName(ReadFromUserUtilities.readString());

            System.out.println("Enter the student date of birth:");
            student.setDateOfBirth(ReadFromUserUtilities.readDate());

            System.out.println("Enter the student tuition fees:");
            student.setTuitionFees(ReadFromUserUtilities.readInt());

            students.add(student);

            System.out.println("Do you want to create new student? (yes/no)");
            addMoreElement = ReadFromUserUtilities.readYesOrNo();
        } while (addMoreElement);
        course.setStudents(students);
        ALLSTUDENTS.addAll(students);
        
        assignments = new ArrayList<>();
        do {
            Assignment assignment = new Assignment();
            System.out.println("\nCreating assignment for the course:");
            System.out.println("Enter the assignment title:");
            assignment.setTitle(ReadFromUserUtilities.readString());

            System.out.println("Enter the assignment description:");
            assignment.setDescription(ReadFromUserUtilities.readString());

            System.out.println("Enter the assignment due to date:");
            assignment.setDueDateTime(ReadFromUserUtilities.readDateTime());

            System.out.println("Enter the assignment max oral mark:");
            assignment.setMaxOralMark(ReadFromUserUtilities.readInt());
            System.out.println("Enter the assignment max total mark:");
            assignment.setMaxTotalMark(ReadFromUserUtilities.readInt());

            System.out.println("Is this an individual asisgnment? (enter yes for individual, or no for team asisgnment)");
            assignment.setTeamAssignment(ReadFromUserUtilities.readYesOrNo());            
            
            assignments.add(assignment);

            System.out.println("Do you want to create new assignment? (yes/no)");
            addMoreElement = ReadFromUserUtilities.readYesOrNo();
        } while (addMoreElement);
        ALLASSIGNMENTS.addAll(assignments);
        
        
        

    }
}
