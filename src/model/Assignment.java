/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Leyteris
 */
public class Assignment {

    private long id;
    private static long count = 0;
    private String title;
    private String description;
    private LocalDateTime subDateTime;
    private int oralMark;
    private int totalMark;
    private LocalDateTime dueDateTime;
    private int maxOralMark;
    private int maxTotalMark;
    private boolean teamAssignment;
    private long courseId;

    ArrayList<Student> assignedStudents;

    public Assignment() {
        this.assignedStudents = new ArrayList<>();
        count++;
        this.id = count;
    }

    public Assignment(String title, String description, LocalDateTime subDateTime, int oralMark, int totalMark, LocalDateTime dueDateTime, int maxOralMark, int maxTotalMark, boolean teamAssignment, long courseId) {
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.oralMark = oralMark;
        this.totalMark = totalMark;
        this.dueDateTime = dueDateTime;
        this.maxOralMark = maxOralMark;
        this.maxTotalMark = maxTotalMark;
        this.teamAssignment = teamAssignment;
        this.courseId = courseId;
        this.assignedStudents = new ArrayList<>();
        count++;
        this.id = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getSubDateTime() {
        return subDateTime;
    }

    public void setSubDateTime(LocalDateTime subDateTime) {
        this.subDateTime = subDateTime;
    }

    public int getOralMark() {
        return oralMark;
    }

    public void setOralMark(int oralMark) {
        this.oralMark = oralMark;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    public LocalDateTime getDueDateTime() {
        return dueDateTime;
    }

    public void setDueDateTime(LocalDateTime dueDateTime) {
        this.dueDateTime = dueDateTime;
    }

    public int getMaxOralMark() {
        return maxOralMark;
    }

    public void setMaxOralMark(int maxOralMark) {
        this.maxOralMark = maxOralMark;
    }

    public int getMaxTotalMark() {
        return maxTotalMark;
    }

    public void setMaxTotalMark(int maxTotalMark) {
        this.maxTotalMark = maxTotalMark;
    }

    public boolean isTeamAssignment() {
        return teamAssignment;
    }

    public void setTeamAssignment(boolean teamAssignment) {
        this.teamAssignment = teamAssignment;
    }

    public ArrayList<Student> getAssignedStudents() {
        return assignedStudents;
    }

    public void setAssignedStudents(ArrayList<Student> assignedStudents) {
        this.assignedStudents = assignedStudents;
    }

    public long getId() {
        return id;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }
    
    

    @Override
    public String toString() {
        String answer = "";
        answer += title + ": " + description;
        if (subDateTime != null) {
            answer += ", submitted on " + subDateTime + ", Oral mark: " + oralMark + " Total Mark: " + totalMark;
            if (subDateTime.isAfter(dueDateTime)) {
                answer += ". Overdue!";
            }
        } else {
            answer += ", not submitted yet";
        }

        for (Student s : assignedStudents) {
            answer += " (" + s.getFirstName() + " " + s.getLastName() + ")";
        }
        return answer;
    }

    public void printStudentDetails() {
        String answer = "";
        answer += title + ": " + description;
        if (subDateTime != null) {
            answer += ", submitted on " + subDateTime + ", Oral mark: " + oralMark + " Total Mark: " + totalMark;
            if (subDateTime.isAfter(dueDateTime)) {
                answer += ". Overdue!";
            }
        } else {
            answer += ", not submitted yet";
        }
        System.out.print(answer);

        for (Student s : assignedStudents) {
            System.out.print(" (" + s.getFirstName() + " " + s.getLastName() + ")");
        }

        System.out.println();
    }

    public void printCourseDetails() {
        System.out.println(title + ": " + description + ", due to " + dueDateTime.toString()
                + ". Max Oral mark: " + maxOralMark + ", max Total Mark: " + maxTotalMark);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Assignment ass = (Assignment) obj;
        return this.id == ass.getId();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

}
