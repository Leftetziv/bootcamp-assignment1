/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.dataentry;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import model.Assignment;
import model.Course;
import model.Student;
import model.Trainer;

/**
 *
 * @author Leyteris
 */
public class SyntheticDataEntry {

    private static Random random = new Random();
    private static final ArrayList<Course> ALLCOURSES = new ArrayList<>();
    private static final ArrayList<Student> ALLSTUDENTS = new ArrayList<>();
    private static final ArrayList<Trainer> ALLTRAINERS = new ArrayList<>();
    private static final ArrayList<Assignment> ALLASSIGNMENTS = new ArrayList<>();

    public static void createSynData() {

        ArrayList<Course> courses;
        ArrayList<Trainer> trainers;
        ArrayList<Student> students;
        ArrayList<Assignment> assignments;
        ArrayList<Integer> assigns;

        courses = new ArrayList<>();
        courses.add(new Course("CB10", "Java", "Part Time", LocalDate.of(2020, 10, 5), LocalDate.of(2021, 03, 20)));
        courses.add(new Course("CB10", "Javascript", "Full Time", LocalDate.of(2020, 10, 5), LocalDate.of(2021, 03, 20)));
        courses.add(new Course("CB11", "Java", "Full Time", LocalDate.of(2020, 10, 5), LocalDate.of(2021, 03, 20)));
        ALLCOURSES.addAll(courses);

        trainers = new ArrayList<>();
        trainers.add(new Trainer("Kostas", "Kostou", "Java"));
        trainers.add(new Trainer("Nikos", "Nikou", "Html"));
        trainers.add(new Trainer("Giorgos", "Giorgou", "Java"));
        trainers.add(new Trainer("Aggelos", "Aggelou", "Spring Boot"));
        trainers.add(new Trainer("Takis", "Takou", "MySql"));
        trainers.add(new Trainer("Vaggelis", "Vaggelou", "Js"));
        trainers.add(new Trainer("Giannis", "Giannou", "Css"));
        trainers.add(new Trainer("Dimitris", "Dimitriou", "MS Sql"));
        ALLTRAINERS.addAll(trainers);

        assignments = new ArrayList<>();
        assignments.add(new Assignment("Classes", "Assignment in Classes", null, -1, -1, LocalDateTime.of(2020, 11, 10, 23, 59), 50, 100, false, -1));
        assignments.add(new Assignment("FrontEnd", "Assignment in FrontEnd", null, -1, -1, LocalDateTime.of(2021, 2, 10, 23, 59), 50, 100, true, -1));
        assignments.add(new Assignment("Functional", "Assignment in Functional Programming", null, -1, -1, LocalDateTime.of(2020, 11, 10, 23, 23, 59), 50, 100, false, -1));
        assignments.add(new Assignment("Node.js", "Assignment in BackEnd", null, -1, -1, LocalDateTime.of(2020, 12, 5, 23, 59), 50, 100, true, -1));
        assignments.add(new Assignment("JSP/Servlets", "Assignment in Servlets", null, -1, -1, LocalDateTime.of(2021, 2, 10, 23, 59), 50, 100, false, -1));
        assignments.add(new Assignment("Spring Boot", "Assignment in BackEnd", null, -1, -1, LocalDateTime.of(2021, 4, 10, 23, 59), 50, 100, true, -1));
        ALLASSIGNMENTS.addAll(assignments);

        
        students = new ArrayList<>();
        students.add(new Student("Aaaaa", "Bbbbb", LocalDate.of(2020, 11, 13), 2000));                  //FOR TESTING STUDENTS IN MULTIPLE COURSES
        for (int i = 0; i < 22; i++) {
            students.add(new Student(getRandomFirstName(), getRandomLastName(), getRandomBirthDate(), getRandomTuitionFees()));
        }
        ALLSTUDENTS.addAll(students);

   
        //*************************ASSIGNING TRAINERS TO COURSES*************************************
        assigns = new ArrayList<>();
        assigns.add(0);
        assigns.add(1);
        assigns.add(4);
        assigns.add(6);
        DataEntryUtilities.assignTrainersToCourse(ALLCOURSES.get(0), ALLTRAINERS, assigns);
        assigns.clear();
        assigns.add(1);
        assigns.add(6);
        assigns.add(5);
        assigns.add(7);
        DataEntryUtilities.assignTrainersToCourse(ALLCOURSES.get(1), ALLTRAINERS, assigns);
        assigns.clear();
        assigns.add(1);
        assigns.add(6);
        assigns.add(3);
        assigns.add(2);
        DataEntryUtilities.assignTrainersToCourse(ALLCOURSES.get(2), ALLTRAINERS, assigns);
        assigns.clear();

        //*************************************************ASSIGNING STUDENTS TO COURSES****************************************
        for (int i = 0; i < 8; i++) {
            assigns.add(i);
        }
        DataEntryUtilities.assignStudentsToCourse(ALLCOURSES.get(0), ALLSTUDENTS, assigns);
        assigns.clear();
        assigns.add(0);                                                                                     ////FOR TESTING STUDENTS IN MULTIPLE COURSES
        for (int i = 8; i < 15; i++) {
            assigns.add(i);
        }
        DataEntryUtilities.assignStudentsToCourse(ALLCOURSES.get(1), ALLSTUDENTS, assigns);
        assigns.clear();
        for (int i = 15; i < 23; i++) {
            assigns.add(i);
        }
        DataEntryUtilities.assignStudentsToCourse(ALLCOURSES.get(2), ALLSTUDENTS, assigns);
        assigns.clear();

        
        //**************************ASSIGNING INDIVIDUAL ASSIGMENTS TO THE STUDENTS OF THE COURSES*****************
        assigns.add(0);
        DataEntryUtilities.assignIndividualAssignmentsToCourseStudents(ALLCOURSES.get(0).getStudents(), ALLASSIGNMENTS, assigns, ALLCOURSES.get(0).getId());
        assigns.clear();
        assigns.add(2);
        DataEntryUtilities.assignIndividualAssignmentsToCourseStudents(ALLCOURSES.get(1).getStudents(), ALLASSIGNMENTS, assigns, ALLCOURSES.get(1).getId());
        assigns.clear();
        assigns.add(4);
        DataEntryUtilities.assignIndividualAssignmentsToCourseStudents(ALLCOURSES.get(2).getStudents(), ALLASSIGNMENTS, assigns, ALLCOURSES.get(2).getId());
        assigns.clear();

       
        // **************************ASSIGNING GROUP ASSIGMENTS TO THE STUDENTS OF THE COURSES*****************
        int courseNo = 0;
        ArrayList<Student> group = new ArrayList<>();
        group.add(ALLCOURSES.get(courseNo).getStudents().get(0));
        group.add(ALLCOURSES.get(courseNo).getStudents().get(1));
        group.add(ALLCOURSES.get(courseNo).getStudents().get(2));
        DataEntryUtilities.assignGroupAssignmentsToCourseStudents(group, ALLASSIGNMENTS.get(1), ALLCOURSES.get(0).getId());
        group = new ArrayList<>();
        group.add(ALLCOURSES.get(courseNo).getStudents().get(3));
        group.add(ALLCOURSES.get(courseNo).getStudents().get(4));
        group.add(ALLCOURSES.get(courseNo).getStudents().get(5));
        DataEntryUtilities.assignGroupAssignmentsToCourseStudents(group, ALLASSIGNMENTS.get(1), ALLCOURSES.get(0).getId());
        group = new ArrayList<>();
        group.add(ALLCOURSES.get(courseNo).getStudents().get(6));
        group.add(ALLCOURSES.get(courseNo).getStudents().get(7));
        DataEntryUtilities.assignGroupAssignmentsToCourseStudents(group, ALLASSIGNMENTS.get(1), ALLCOURSES.get(0).getId());
        

        
        courseNo = 1;
        group = new ArrayList<>();
        group.add(ALLCOURSES.get(courseNo).getStudents().get(0));
        group.add(ALLCOURSES.get(courseNo).getStudents().get(1));
        group.add(ALLCOURSES.get(courseNo).getStudents().get(2));
        DataEntryUtilities.assignGroupAssignmentsToCourseStudents(group, ALLASSIGNMENTS.get(3), ALLCOURSES.get(1).getId());
        group = new ArrayList<>();
        group.add(ALLCOURSES.get(courseNo).getStudents().get(3));
        group.add(ALLCOURSES.get(courseNo).getStudents().get(4));
        group.add(ALLCOURSES.get(courseNo).getStudents().get(5));
        DataEntryUtilities.assignGroupAssignmentsToCourseStudents(group, ALLASSIGNMENTS.get(3), ALLCOURSES.get(1).getId());
        group = new ArrayList<>();
        group.add(ALLCOURSES.get(courseNo).getStudents().get(6));
        group.add(ALLCOURSES.get(courseNo).getStudents().get(7));
        DataEntryUtilities.assignGroupAssignmentsToCourseStudents(group, ALLASSIGNMENTS.get(3), ALLCOURSES.get(1).getId());
        

        
        courseNo = 2;
        group = new ArrayList<>();
        group.add(ALLCOURSES.get(courseNo).getStudents().get(0));
        group.add(ALLCOURSES.get(courseNo).getStudents().get(1));
        group.add(ALLCOURSES.get(courseNo).getStudents().get(2));
        DataEntryUtilities.assignGroupAssignmentsToCourseStudents(group, ALLASSIGNMENTS.get(5), ALLCOURSES.get(2).getId());
        group = new ArrayList<>();
        group.add(ALLCOURSES.get(courseNo).getStudents().get(3));
        group.add(ALLCOURSES.get(courseNo).getStudents().get(4));
        group.add(ALLCOURSES.get(courseNo).getStudents().get(5));
        DataEntryUtilities.assignGroupAssignmentsToCourseStudents(group, ALLASSIGNMENTS.get(5), ALLCOURSES.get(2).getId());
        group = new ArrayList<>();
        group.add(ALLCOURSES.get(courseNo).getStudents().get(6));
        group.add(ALLCOURSES.get(courseNo).getStudents().get(7));
        DataEntryUtilities.assignGroupAssignmentsToCourseStudents(group, ALLASSIGNMENTS.get(5), ALLCOURSES.get(2).getId());
        

    }

    private static LocalDate getRandomBirthDate() {
        long startDate = LocalDate.of(1950, Month.JANUARY, 1).toEpochDay();
        long endDate = LocalDate.of(2000, Month.DECEMBER, 31).toEpochDay();
        long randomDate = ThreadLocalRandom.current().nextLong(endDate - startDate) + startDate;

        return LocalDate.ofEpochDay(randomDate);
    }

    private static int getRandomTuitionFees() {
        return random.nextInt(3001) + 1000;
    }

    private static String getRandomFirstName() {
        String[] firstNames = {
            "Dimitris",
            "Dimitra",
            "Nikos",
            "Nikoleta",
            "Leyteris",
            "Eleutheria",
            "Venia",
            "Eleni",
            "Kostas",
            "Fotis",
            "Hlias",
            "Iordanis",
            "Giorgos"
        };
        return firstNames[random.nextInt(firstNames.length)];
    }

    private static String getRandomLastName() {
        String[] lastNames = {
            "Galagher",
            "Cash",
            "Ozborn",
            "Gillan",
            "Plant",
            "Cobain",
            "Hetfield",
            "Smith",
            "De la Rocha",
            "Dio",
            "Waters",
            "Gilmour",
            "Kilmister",
            "Hendrix",
            "Bowie"
        };
        return lastNames[random.nextInt(lastNames.length)];
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
