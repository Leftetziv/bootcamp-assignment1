/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataentry;

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

        Course course;
        ArrayList<Trainer> trainers;
        ArrayList<Student> students;
        ArrayList<Assignment> assignments;

        /**
         * *************************************** setting course details 1 ***************************************************
         */
        course = new Course();
        course.setTitle("CB10");
        course.setStream("Java");
        course.setType("Part Time");
        course.setStartDate(LocalDate.of(2020, 10, 5));
        course.setEndDate(LocalDate.of(2021, 03, 20));

        trainers = new ArrayList<>();
        trainers.add(new Trainer("Kostas", "Kostou", "Java"));
        trainers.add(new Trainer("Nikos", "Nikou", "Html"));
        trainers.add(new Trainer("Giannis", "Giannou", "Css"));
        trainers.add(new Trainer("Takis", "Takou", "MySql"));
        course.setTrainers(trainers);
        ALLTRAINERS.addAll(trainers);

        assignments = new ArrayList<>();
        assignments.add(new Assignment("Classes", "Assignment in Classes", null, -1, -1, LocalDateTime.of(2020, 11, 10, 23, 59), 50, 100, false));
        assignments.add(new Assignment("FrontEnd", "Assignment in FrontEnd", null, -1, -1, LocalDateTime.of(2021, 2, 10, 23, 59), 50, 100, true));
        ALLASSIGNMENTS.addAll(assignments);

        students = new ArrayList<>();
        students.add(new Student("Aaaaa", "Bbbbb", LocalDate.of(2020, 11, 13), 2000)); //for testing students on duplicate courses
        for (int i = 0; i < 10; i++) {
            students.add(new Student(getRandomFirstName(), getRandomLastName(), getRandomBirthDate(), getRandomTuitionFees()));
        }
        individualAssignment(students, assignments.get(0));
        teamAssignment(students, assignments.get(1), 3);
        course.setStudents(students);
        ALLSTUDENTS.addAll(students);

        ALLCOURSES.add(course);

        /**
         * *************************************** setting course details 2 ***************************************************
         */
        course = new Course();
        course.setTitle("CB10");
        course.setStream("Javascript");
        course.setType("Full Time");
        course.setStartDate(LocalDate.of(2020, 10, 5));
        course.setEndDate(LocalDate.of(2020, 12, 25));

        trainers = new ArrayList<>();
        trainers.add(new Trainer("Giorgos", "Giorgou", "Java"));
        trainers.add(new Trainer("Nikos", "Nikou", "Html"));
        trainers.add(new Trainer("Aggelos", "Aggelou", "Spring Boot"));
        trainers.add(new Trainer("Takis", "Takou", "MySql"));
        course.setTrainers(trainers);
        ALLTRAINERS.addAll(trainers);

        assignments = new ArrayList<>();
        assignments.add(new Assignment("Functional", "Assignment in Functional Programming", null, -1, -1, LocalDateTime.of(2020, 11, 10, 23, 23, 59), 50, 100, false));
        assignments.add(new Assignment("Node.js", "Assignment in BackEnd", null, -1, -1, LocalDateTime.of(2020, 12, 5, 23, 59), 50, 100, true));
        ALLASSIGNMENTS.addAll(assignments);

        students = new ArrayList<>();
        students.add(new Student("Aaaaa", "Bbbbb", LocalDate.of(2020, 11, 13), 2000)); //for testing students on duplicate courses
        for (int i = 0; i < 10; i++) {
            students.add(new Student(getRandomFirstName(), getRandomLastName(), getRandomBirthDate(), getRandomTuitionFees()));
        }
        individualAssignment(students, assignments.get(0));
        teamAssignment(students, assignments.get(1), 2);
        course.setStudents(students);
        ALLSTUDENTS.addAll(students);

        ALLCOURSES.add(course);

        /**
         * *************************************** setting course details 3 ***************************************************
         */
        course = new Course();
        course.setTitle("CB11");
        course.setStream("Java");
        course.setType("Full Time");
        course.setStartDate(LocalDate.of(2021, 1, 10));
        course.setEndDate(LocalDate.of(2021, 4, 25));

        trainers = new ArrayList<>();
        trainers.add(new Trainer("Vaggelis", "Vaggelou", "Js"));
        trainers.add(new Trainer("Nikos", "Nikou", "Html"));
        trainers.add(new Trainer("Giannis", "Giannou", "Css"));
        trainers.add(new Trainer("Dimitris", "Dimitriou", "MS Sql"));
        course.setTrainers(trainers);
        ALLTRAINERS.addAll(trainers);

        assignments = new ArrayList<>();
        assignments.add(new Assignment("JSP/Servlets", "Assignment in Servlets", null, -1, -1, LocalDateTime.of(2021, 2, 10, 23, 59), 50, 100, false));
        assignments.add(new Assignment("Spring Boot", "Assignment in BackEnd", null, -1, -1, LocalDateTime.of(2021, 4, 10, 23, 59), 50, 100, true));
        ALLASSIGNMENTS.addAll(assignments);

        students = new ArrayList<>();
//        students.add(new Student("Aaaaa", "Bbbbb", LocalDate.of(1989, 2, 13), 2000)); //for testing students on duplicate courses
        for (int i = 0; i < 10; i++) {
            students.add(new Student(getRandomFirstName(), getRandomLastName(), getRandomBirthDate(), getRandomTuitionFees()));
        }

        individualAssignment(students, assignments.get(0));
        teamAssignment(students, assignments.get(1), 3);
        course.setStudents(students);
        ALLSTUDENTS.addAll(students);

        ALLCOURSES.add(course);
    }

    private static LocalDate getRandomBirthDate() {
        long startDate = LocalDate.of(1950, Month.JANUARY, 1).toEpochDay();
        long endDate = LocalDate.of(2000, Month.DECEMBER, 31).toEpochDay();
        long randomDate = ThreadLocalRandom.current().nextLong(endDate - startDate) + startDate;

        return LocalDate.ofEpochDay(randomDate);
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

    private static void individualAssignment(ArrayList<Student> students, Assignment ass) {
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

    private static void teamAssignment(ArrayList<Student> students, Assignment ass, int group) {
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

    public static ArrayList<Course> getALLCOURSES() {
        return ALLCOURSES;
    }

    public static ArrayList<Student> getALLSTUDENTS() {
        return RemoveDuplicates.removeDuplicates(ALLSTUDENTS);
    }

    public static ArrayList<Trainer> getALLTRAINERS() {
        return RemoveDuplicates.removeDuplicates(ALLTRAINERS);
    }

    public static ArrayList<Assignment> getALLASSIGNMENTS() {
        return ALLASSIGNMENTS;
    }

}
