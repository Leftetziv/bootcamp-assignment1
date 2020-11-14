/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataentry;

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
    private static Random random = new Random();
    private static final ArrayList<Course> ALLCOURSES = new ArrayList<>();
    private static final ArrayList<Student> ALLSTUDENTS = new ArrayList<>();
    private static final ArrayList<Trainer> ALLTRAINERS = new ArrayList<>();
    private static final ArrayList<Assignment> ALLASSIGNMENTS = new ArrayList<>();
    
    public static void createManData() {
        
    }
}
