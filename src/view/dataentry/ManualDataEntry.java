/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.dataentry;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
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
        int courseCounter = 0;
        do {
            course = ReadModelsFromUser.getCourseFromUser();          
            ALLCOURSES.add(course);

            //***************************TRAINERS ASSIGNMENTS TO THE COURSES *************************************************************************
            ArrayList<Integer> trainersToAssign = new ArrayList<>();

            if (ALLTRAINERS.size() != 0) {                             //ASKING USER IF WANT TO ADD ALREADY EXISTING TRAINERS
                System.out.println("Do you want to assign some already existing trainers to the course? (yes/no)");
                if (ReadFromUserUtilities.readYesOrNo()) {
                    System.out.println("Enter the numbers of the Trainers below to assign them. Seperate the values by commas, like in the following example: 5,8,9,11");
                    System.out.println("Or enter q to quit");
                    int trainerCounter = 1;
                    for (Trainer t : ALLTRAINERS) {
                        System.out.println(trainerCounter + " - " + t);
                        trainerCounter++;
                    }

                    List<Integer> existingTrainersToAssign = ReadFromUserUtilities.readListOfNumbersOrQuit(1, trainerCounter - 1);
                    existingTrainersToAssign = existingTrainersToAssign.stream().map(i -> i - 1).collect(Collectors.toList());
                    if (existingTrainersToAssign.get(0) != -2) {
                        trainersToAssign.addAll(existingTrainersToAssign);
                    }
                }
            }

            System.out.println("Do you want to add new trainer for the course? (yes/no)");
            while (ReadFromUserUtilities.readYesOrNo()) {
                Trainer trainer = ReadModelsFromUser.getTrainerFromUser();
                ALLTRAINERS.add(trainer);
                trainersToAssign.add(ALLTRAINERS.indexOf(trainer));
                System.out.println("Do you want to add new trainer for the course? (yes/no)");
            }

            if (trainersToAssign.size() > 0) {
                DataEntryUtilities.assignTrainersToCourse(ALLCOURSES.get(courseCounter), ALLTRAINERS, trainersToAssign);
            }

            //***************************STUDENTS ASSIGNMENTS TO THE COURSES*********************************************************************************
            ArrayList<Integer> studentsToAssign = new ArrayList<>();

            if (ALLSTUDENTS.size() != 0) {                             //ASKING USER IF WANT TO ADD ALREADY EXISTING STUDENTS
                System.out.println("Do you want to assign some already existing students to the course? (yes/no)");
                if (ReadFromUserUtilities.readYesOrNo()) {
                    System.out.println("Enter the numbers of the Students below to assign them. Seperate the values by commas, like in the following example: 5,8,9,11");
                    System.out.println("Or enter q to quit");
                    int studentCounter = 1;
                    for (Student t : ALLSTUDENTS) {
                        System.out.println(studentCounter + " - " + t);
                        studentCounter++;
                    }

                    List<Integer> existingStudentsToAssign = ReadFromUserUtilities.readListOfNumbersOrQuit(1, studentCounter - 1);
                    existingStudentsToAssign = existingStudentsToAssign.stream().map(i -> i - 1).collect(Collectors.toList());
                    
                    if (existingStudentsToAssign.get(0) != -2) {
                        studentsToAssign.addAll(existingStudentsToAssign);
                    }
                }
            }

            System.out.println("Do you want to add new students for the course? (yes/no)");
            while (ReadFromUserUtilities.readYesOrNo()) {
                Student student = ReadModelsFromUser.getStudentFromUser();
                ALLSTUDENTS.add(student);
                studentsToAssign.add(ALLSTUDENTS.indexOf(student));
                System.out.println("Do you want to add new Student for the course? (yes/no)");
            }

            if (studentsToAssign.size() > 0) {
                DataEntryUtilities.assignStudentsToCourse(ALLCOURSES.get(courseCounter), ALLSTUDENTS, studentsToAssign);
            }

            //*************************** INDIVIDUAL ASSIGNMENTS ASSIGNS TO THE STUDENTS OF THE COURSE*********************************************************************************
            ArrayList<Integer> individualAssignmentsToAssignToStudents = new ArrayList<>();

            if (ALLASSIGNMENTS.stream().anyMatch(i -> i.isTeamAssignment() == false)) {     //ASKING USER IF WANT TO ASSIGN ALREADY EXISTING INDIVIDUAL ASSIGNMENTS TO THE STUDENTS OF THE COURSE
                System.out.println("Do you want to assign some already existing individual assignments to the students of the course? (yes/no)");
                if (ReadFromUserUtilities.readYesOrNo()) {
                    System.out.println("Enter the numbers of the assignments below to assign them to every student of the course. Seperate the values by commas, like in the following example: 5,8,9,11");
                    System.out.println("Or enter q to quit");

                    int assignmentCounter = 1;
                    List<Assignment> individualAssignmentsOnly = ALLASSIGNMENTS.stream().filter(i -> !i.isTeamAssignment()).collect(Collectors.toList());
                    for (Assignment as : individualAssignmentsOnly) {
                        System.out.println(assignmentCounter + " - " + as);
                        assignmentCounter++;
                    }

                    List<Integer> reducedExistingAssignmentsToAssign = ReadFromUserUtilities.readListOfNumbersOrQuit(1, assignmentCounter - 1);
                    reducedExistingAssignmentsToAssign = reducedExistingAssignmentsToAssign.stream().map(i -> i - 1).collect(Collectors.toList());

                    ArrayList<Integer> ExistingAssignmentsToAssign = new ArrayList<>();
                    for (Integer i : reducedExistingAssignmentsToAssign) {
                        Assignment as = individualAssignmentsOnly.get(i);
                        ExistingAssignmentsToAssign.add(ALLASSIGNMENTS.indexOf(as));
                    }

                    if (ExistingAssignmentsToAssign.get(0) != -1) {
                        individualAssignmentsToAssignToStudents.addAll(ExistingAssignmentsToAssign);
                    }
                }
            }

            System.out.println("Do you want to add new individual assignment for the course? (yes/no)");
            while (ReadFromUserUtilities.readYesOrNo()) {
                Assignment assignment = ReadModelsFromUser.getAssignment(false);
                ALLASSIGNMENTS.add(assignment);
                individualAssignmentsToAssignToStudents.add(ALLASSIGNMENTS.indexOf(assignment));
                System.out.println("Do you want to add new individual assignment for the course? (yes/no)");
            }

            if (individualAssignmentsToAssignToStudents.size() > 0) {
                DataEntryUtilities.assignIndividualAssignmentsToCourseStudents(
                        ALLCOURSES.get(courseCounter).getStudents(), 
                        ALLASSIGNMENTS, 
                        individualAssignmentsToAssignToStudents,
                        ALLCOURSES.get(courseCounter).getId(),
                        false);
            }

            //*************************** GROUP ASSIGNMENTS ASSIGNS TO THE STUDENTS OF THE COURSE*********************************************************************************
            ArrayList<Integer> groupAssignmentsToAssignToStudents = new ArrayList<>();

            System.out.println("Do you want to add new group assignment for the course? (yes/no)");
            while (ReadFromUserUtilities.readYesOrNo()) {
                Assignment assignment = ReadModelsFromUser.getAssignment(true);
                ALLASSIGNMENTS.add(assignment);
                groupAssignmentsToAssignToStudents.add(ALLASSIGNMENTS.indexOf(assignment));
                System.out.println("Do you want to add new group assignment for the course? (yes/no)");
            }

            ArrayList<Student> courseStudents = ALLCOURSES.get(courseCounter).getStudents();
            System.out.println("Groups assignments:");
            for (Integer i : groupAssignmentsToAssignToStudents) {
                Assignment assignment = ALLASSIGNMENTS.get(i);
                ArrayList<Student> studentsAllreadyAssigned = new ArrayList<>();
                while (studentsAllreadyAssigned.size() != courseStudents.size()) {
                    System.out.println("Assignment: " + assignment.getTitle());
                    System.out.println("Enter the numbers of the students below, to assign them all to a group assignment as a team. "
                            + "Seperate the values by commas, like in the following example: 5,8,9,11");

                    int studentCounter = 1;
                    for (Student t : courseStudents) {
                        if (!studentsAllreadyAssigned.contains(t)) {
                            System.out.println(studentCounter + " - " + t);
                        }
                        studentCounter++;
                    }

                    List<Integer> group = ReadFromUserUtilities.readListOfNumbersOrQuit(1, studentCounter - 1);
                    group = group.stream().map(k -> k - 1).collect(Collectors.toList());

                    if (group.get(0) == -2) {
                        System.out.println("You have to declare the groups");
                        continue;
                    }

                    ArrayList<Student> studentGrouping = new ArrayList<>();
                    for (int k = 0; k < group.size(); k++) {
                        studentsAllreadyAssigned.add(courseStudents.get(group.get(k)));
                        studentGrouping.add(courseStudents.get(group.get(k)));
                    }

                    DataEntryUtilities.assignGroupAssignmentsToCourseStudents(
                            studentGrouping, 
                            assignment, 
                            ALLCOURSES.get(courseCounter).getId(), 
                            false);
                }
            }

            System.out.println("Add more course?( yes/no)");
            courseCounter++;
        } while (ReadFromUserUtilities.readYesOrNo());
    }

    public static ArrayList<Course> getALLCOURSES() {
        return ALLCOURSES;
    }

    public static ArrayList<Student> getALLSTUDENTS() {
        return ALLSTUDENTS;
    }

    public static ArrayList<Trainer> getALLTRAINERS() {
        return ALLTRAINERS;
    }

    public static ArrayList<Assignment> getALLASSIGNMENTS() {
        return ALLASSIGNMENTS;
    }

}
