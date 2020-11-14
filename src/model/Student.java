/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Leyteris
 */
public class Student {                  //Θεωρω οτι ονομα+επωνυμο+dateOfBirth+tuitionFees ειναι identifier καθε student

    private String firstName; 
    private String lastName;
    private LocalDate dateOfBirth;
    private float tuitionFees;

    private ArrayList<Assignment> assignments;

    public Student() {
    }

    public Student(String firstName, String lastName, LocalDate dateOfBirth, float tuitionFees) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.tuitionFees = tuitionFees;
        assignments = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public float getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(float tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(ArrayList<Assignment> assignments) {
        this.assignments = assignments;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + dateOfBirth.toString() + ") : " + tuitionFees + "€";
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() !=  obj.getClass()) {
            return false;
        }  
        Student s = (Student) obj;
        return firstName.equalsIgnoreCase(s.firstName)
                && lastName.equalsIgnoreCase(s.lastName)
                && dateOfBirth.equals(s.dateOfBirth)
                && tuitionFees==s.tuitionFees;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.firstName);
        hash = 17 * hash + Objects.hashCode(this.lastName);
        hash = 17 * hash + Objects.hashCode(this.dateOfBirth);
        hash = 17 * hash + Float.floatToIntBits(this.tuitionFees);
        return hash;
    }

}
