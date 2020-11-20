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
            trainers.add(ALLTRAINERS.get(i));
        }

        course.setTrainers(trainers);
    }

    static void assignStudentsToCourse(Course course, ArrayList<Student> ALLSTUDENTS, ArrayList<Integer> studentsAssigns) {
        ArrayList<Student> students = new ArrayList<>();

        for (int i : studentsAssigns) {
            students.add(ALLSTUDENTS.get(i));
        }

        course.setStudents(students);
    }

    static void assignIndividualAssignmentsToCourseStudents(ArrayList<Student> students, ArrayList<Assignment> ALLASSIGNMENTS, ArrayList<Integer> assignmentsAssigns, long courseId, boolean randomize) {
        int assignmentsCount;

        for (int i : assignmentsAssigns) {
            Assignment courseAssignment = ALLASSIGNMENTS.get(i);

            for (int k = 0; k < students.size(); k++) {
                Assignment assigment = new Assignment(courseAssignment.getTitle(), courseAssignment.getDescription(),
                        null, -1, -1,
                        courseAssignment.getDueDateTime(), courseAssignment.getMaxOralMark(), courseAssignment.getMaxTotalMark(),
                        false, courseId);

                if (randomize) {
                    assigment.setSubDateTime(getRandomSubmissionDate(courseAssignment.getDueDateTime()));
                    assigment.setOralMark(random.nextInt(courseAssignment.getMaxOralMark()));
                    assigment.setTotalMark(random.nextInt(courseAssignment.getMaxTotalMark()));
                }
                
                students.get(k).getAssignments().add(assigment);

                assignmentsCount = students.get(k).getAssignments().size();
                students.get(k).getAssignments().get(assignmentsCount - 1).getAssignedStudents().add(students.get(k));
            }
        }
    }

    static void assignGroupAssignmentsToCourseStudents(ArrayList<Student> students, Assignment assignmentOriginal, long courseId, boolean randomize) {
        int assignmentsCount;

            Assignment assigment = new Assignment(assignmentOriginal.getTitle(), assignmentOriginal.getDescription(),
                        null, -1, -1,
                        assignmentOriginal.getDueDateTime(), assignmentOriginal.getMaxOralMark(), assignmentOriginal.getMaxTotalMark(),
                        true, courseId);
            
            if (randomize) {
                    assigment.setSubDateTime(getRandomSubmissionDate(assignmentOriginal.getDueDateTime()));
                    assigment.setOralMark(random.nextInt(assignmentOriginal.getMaxOralMark()));
                    assigment.setTotalMark(random.nextInt(assignmentOriginal.getMaxTotalMark()));
                }
            
            
            for (int k = 0; k < students.size(); k++) {
                students.get(k).getAssignments().add(assigment);

                assignmentsCount = students.get(k).getAssignments().size();
                students.get(k).getAssignments().get(assignmentsCount - 1).getAssignedStudents().add(students.get(k));
            }
        
    }
}
