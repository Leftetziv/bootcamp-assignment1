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
import model.Student;

/**
 *
 * @author Leyteris
 */
public class DataEntryUtilities<T> {

    private static Random random = new Random();

    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> mixed) {
        ArrayList<T> distinct = new ArrayList<>();

        for (T t : mixed) {
            if (!distinct.contains(t)) {
                distinct.add(t);
            }
        }

        return distinct;
    }

    public static void individualAssignment(ArrayList<Student> students, Assignment ass) {
        int assignmentsCount;

        for (int i = 0; i < students.size(); i++) {                                          //individual assignment

            Assignment assigment = new Assignment(ass.getTitle(), ass.getDescription(),
                    getRandomSubmissionDate(ass.getDueDateTime()), random.nextInt(ass.getMaxOralMark()), random.nextInt(ass.getMaxTotalMark()),
                    ass.getDueDateTime(), ass.getMaxOralMark(), ass.getMaxTotalMark(), false);

            students.get(i).getAssignments().add(assigment);

            assignmentsCount = students.get(i).getAssignments().size();
            students.get(i).getAssignments().get(assignmentsCount - 1).getAssignedStudents().add(students.get(i));
        }
    }

    public static void teamAssignment(ArrayList<Student> students, Assignment ass, int group) {
        int assignmentsCount = 0;

        for (int i = 0; i < students.size() - group; i = i + group) {

            Assignment assigment = new Assignment(ass.getTitle(), ass.getDescription(),
                    getRandomSubmissionDate(ass.getDueDateTime()), random.nextInt(ass.getMaxOralMark()), random.nextInt(ass.getMaxTotalMark()),
                    ass.getDueDateTime(), ass.getMaxOralMark(), ass.getMaxTotalMark(), true);

            for (int k = i; k < (i + group); k++) {
                students.get(k).getAssignments().add(assigment);

                assignmentsCount = students.get(k).getAssignments().size();
                students.get(k).getAssignments().get(assignmentsCount - 1).getAssignedStudents().add(students.get(k));
            }
        }

        Assignment assigment = new Assignment(ass.getTitle(), ass.getDescription(),
                getRandomSubmissionDate(ass.getDueDateTime()), random.nextInt(ass.getMaxOralMark()), random.nextInt(ass.getMaxTotalMark()),
                ass.getDueDateTime(), ass.getMaxOralMark(), ass.getMaxTotalMark(), true);

        for (int i = students.size() - 1; i >= 0; i--) {
            if (students.get(i).getAssignments().size() != assignmentsCount) {
                students.get(i).getAssignments().add(assigment);

                assignmentsCount = students.get(i).getAssignments().size();
                students.get(i).getAssignments().get(assignmentsCount - 1).getAssignedStudents().add(students.get(i));
            } else {
                break;
            }
        }
    }
    
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
}
