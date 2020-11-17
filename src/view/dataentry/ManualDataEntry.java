/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.dataentry;

import java.util.ArrayList;
import java.util.List;
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
        ArrayList<Trainer> trainers = new ArrayList<>();
        ArrayList<Student> students;
        ArrayList<Assignment> assignments;
        boolean addMoreElement;

        //arxi tis loupas ***************************************
        course = new Course();
        int courseCounter = 0;

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
        System.out.println("Course created");

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

                ArrayList<Integer> existingTrainersToAssign = ReadFromUserUtilities.readListOfNumbersOrQuit(1, trainerCounter - 1);
                if (existingTrainersToAssign.get(0) != -1) {
                    trainersToAssign.addAll(existingTrainersToAssign);
                }
            }
        }

        System.out.println("Do you want to add new trainer for the course? (yes/no)");
        while (ReadFromUserUtilities.readYesOrNo()) {
            Trainer trainer = new Trainer();
            System.out.println("\nCreating trainer for the course:");
            System.out.println("Enter the trainer first name:");
            trainer.setFirstName(ReadFromUserUtilities.readString());
            System.out.println("Enter the trainer last name:");
            trainer.setLastName(ReadFromUserUtilities.readString());
            System.out.println("Enter the trainer subject:");
            trainer.setSubject(ReadFromUserUtilities.readString());

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

                ArrayList<Integer> existingStudentsToAssign = ReadFromUserUtilities.readListOfNumbersOrQuit(1, studentCounter - 1);
                if (existingStudentsToAssign.get(0) != -1) {
                    studentsToAssign.addAll(existingStudentsToAssign);
                }
            }
        }

        System.out.println("Do you want to add new students for the course? (yes/no)");
        while (ReadFromUserUtilities.readYesOrNo()) {
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

            ALLSTUDENTS.add(student);
            studentsToAssign.add(ALLSTUDENTS.indexOf(student));
            System.out.println("Do you want to add new Student for the course? (yes/no)");
        }

        if (studentsToAssign.size() > 0) {
            DataEntryUtilities.assignStudentsToCourse(ALLCOURSES.get(courseCounter), ALLSTUDENTS, studentsToAssign);
        }

        //*************************** INDIVIDUAL ASSIGNMENTS ASSIGNS TO THE STUDENTS OF THE COURSE*********************************************************************************
        ArrayList<Integer> individualAssignmentsToAssignToStudents = new ArrayList<>();

        if (ALLASSIGNMENTS.size() != 0 && ALLASSIGNMENTS.stream().anyMatch(i -> i.isTeamAssignment() == false)) {     //ASKING USER IF WANT TO ASSIGN ALREADY EXISTING INDIVIDUAL ASSIGNMENTS TO THE STUDENTS OF THE COURSE
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

                ArrayList<Integer> reducedExistingAssignmentsToAssign = ReadFromUserUtilities.readListOfNumbersOrQuit(1, assignmentCounter - 1);

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
            assignment.setTeamAssignment(false);

            ALLASSIGNMENTS.add(assignment);
            individualAssignmentsToAssignToStudents.add(ALLASSIGNMENTS.indexOf(assignment));
            System.out.println("Do you want to add new individual assignment for the course? (yes/no)");
        }

        if (individualAssignmentsToAssignToStudents.size() > 0) {
            DataEntryUtilities.assignIndividualAssignmentsToCourseStudents(ALLCOURSES.get(courseCounter).getStudents(), ALLASSIGNMENTS, individualAssignmentsToAssignToStudents);
        }

        //*************************** GROUP ASSIGNMENTS ASSIGNS TO THE STUDENTS OF THE COURSE*********************************************************************************
        ArrayList<Integer> groupAssignmentsToAssignToStudents = new ArrayList<>();

        System.out.println("Do you want to add new group assignment for the course? (yes/no)");
        while (ReadFromUserUtilities.readYesOrNo()) {
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
            assignment.setTeamAssignment(true);

            ALLASSIGNMENTS.add(assignment);
            groupAssignmentsToAssignToStudents.add(ALLASSIGNMENTS.indexOf(assignment));
            System.out.println("Do you want to add new group assignment for the course? (yes/no)");
        }
        
        //select the students of the each group
        

        
    }
}
