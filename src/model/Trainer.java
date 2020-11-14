/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

/**
 *
 * @author Leyteris
 */
public class Trainer {          //Θεωρω οτι ονομα+επωνυμο ειναι identifier καθε trainer
    private String firstName;   //και οτι καθε trainer εχει μονο ενα κυριως μαθημα
    private String lastName;
    private String subject;

    public Trainer() {
    }

    public Trainer(String firstName, String lastName, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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
        Trainer t = (Trainer)obj;
        return firstName.equalsIgnoreCase(t.firstName) && lastName.equalsIgnoreCase(t.lastName) ;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.firstName);
        hash = 83 * hash + Objects.hashCode(this.lastName);
        return hash;
    }

    @Override
    public String toString() {
           return firstName+" "+lastName+": "+subject;
    }
    
}
