/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.dataentry;

import java.time.LocalDateTime;
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
public class DataEntryUtilities {

    private static Random random = new Random();

    private static LocalDateTime getRandomSubmissionDate(LocalDateTime due) {
        float dice = random.nextFloat();

        if (dice < 0.33) {
            return due.minusDays(5);
        } else if (dice < 0.66) {
            return due.plusDays(5);
        } else {
            return null;
        }
    }

    static void assignTrainersToCourse(Course course, ArrayList<Trainer> ALLTRAINERS, ArrayList<Integer> trainersAssigns) {
        ArrayList<Trainer> trainers = new ArrayList<>();

        for (int i : trainersAssigns) {
            trainers.add(ALLTRAINERS.get(i - 1));
        }

        course.setTrainers(trainers);
    }

    static void assignStudentsToCourse(Course course, ArrayList<Student> ALLSTUDENTS, ArrayList<Integer> studentsAssigns) {
        ArrayList<Student> students = new ArrayList<>();

        for (int i : studentsAssigns) {
            students.add(ALLSTUDENTS.get(i - 1));
        }

        course.setStudents(students);
    }

    static void assignIndividualAssignmentsToCourseStudents(ArrayList<Student> students, ArrayList<Assignment> ALLASSIGNMENTS, ArrayList<Integer> assignmentsAssigns) {
        int assignmentsCount;

        for (int i : assignmentsAssigns) {
            Assignment courseAssignment = ALLASSIGNMENTS.get(i-1);

            for (int k = 0; k < students.size(); k++) {
                Assignment assigment = new Assignment(courseAssignment.getTitle(), courseAssignment.getDescription(),
                        getRandomSubmissionDate(courseAssignment.getDueDateTime()), random.nextInt(courseAssignment.getMaxOralMark()), random.nextInt(courseAssignment.getMaxTotalMark()),
                        courseAssignment.getDueDateTime(), courseAssignment.getMaxOralMark(), courseAssignment.getMaxTotalMark(), false);

                students.get(k).getAssignments().add(assigment);

                assignmentsCount = students.get(k).getAssignments().size();
                students.get(k).getAssignments().get(assignmentsCount - 1).getAssignedStudents().add(students.get(k));
            }
        }
    }

    static void assignGroupAssignmentsToCourseStudents(ArrayList<Student> students, ArrayList<Assignment> ALLASSIGNMENTS, ArrayList<Integer> assignmentsAssigns) {
        int assignmentsCount;

        for (int i : assignmentsAssigns) {
            Assignment courseAssignment = ALLASSIGNMENTS.get(i-1);

            Assignment assigment = new Assignment(courseAssignment.getTitle(), courseAssignment.getDescription(),
                        getRandomSubmissionDate(courseAssignment.getDueDateTime()), random.nextInt(courseAssignment.getMaxOralMark()), random.nextInt(courseAssignment.getMaxTotalMark()),
                        courseAssignment.getDueDateTime(), courseAssignment.getMaxOralMark(), courseAssignment.getMaxTotalMark(), true);
            
            for (int k = 0; k < students.size(); k++) {
                students.get(k).getAssignments().add(assigment);

                assignmentsCount = students.get(k).getAssignments().size();
                students.get(k).getAssignments().get(assignmentsCount - 1).getAssignedStudents().add(students.get(k));
            }
        }
    }
}
