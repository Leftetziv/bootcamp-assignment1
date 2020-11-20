/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.dataentry;

import model.Assignment;
import model.Course;
import model.Student;
import model.Trainer;

/**
 *
 * @author Leyteris
 */
public class ReadModelsFromUser {

    public static Course getCourseFromUser() {
        Course course = new Course();

        System.out.println("Enter the course title:");
        course.setTitle(ReadFromUserUtilities.readString());
        System.out.println("Enter the course stream:");
        course.setStream(ReadFromUserUtilities.readString());
        System.out.println("Enter the course type:");
        course.setType(ReadFromUserUtilities.readString());
        System.out.println("Enter the course start date:");
        course.setStartDate(ReadFromUserUtilities.readDate());
        System.out.println("Enter the course end date:");
        course.setEndDate(ReadFromUserUtilities.readDate());

        return course;
    }

    public static Trainer getTrainerFromUser() {
        Trainer trainer = new Trainer();
        System.out.println("\nCreating trainer for the course:");
        System.out.println("Enter the trainer first name:");
        trainer.setFirstName(ReadFromUserUtilities.readString());
        System.out.println("Enter the trainer last name:");
        trainer.setLastName(ReadFromUserUtilities.readString());
        System.out.println("Enter the trainer subject:");
        trainer.setSubject(ReadFromUserUtilities.readString());
        
        return trainer;
    }

    public static Student getStudentFromUser() {
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
        
        return student;
    }

    public static Assignment getAssignment(boolean isGroupAssignment) {
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
        System.out.println("Enter the assignment max total mark:");     //TODO MAKING SURE TOTAL MARK IS BIGGER THAN ORAL MARK
        assignment.setMaxTotalMark(ReadFromUserUtilities.readInt());
        assignment.setTeamAssignment(isGroupAssignment);
        
        return assignment;
    }

}
