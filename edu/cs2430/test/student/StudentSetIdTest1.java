package edu.cs2430.test.student;

import edu.cs2430.assignment3.Student;

// Prerequisites:
// Student Constructor tests

public class StudentSetIdTest1
{
    public static void main(String[] args) throws IllegalAccessException
    {
        //This test will retrieve the semester of a schedule entry.
        StudentCommons studentCommons = new StudentCommons();

        // Test input
        String setStudentName = "Doug Selent";

        Student setStudent = new Student(setStudentName);
        int newStudentId = 9;

        // Test method
        setStudent.setId(newStudentId);

        // Verify the output -> Output the information to a file and compare string output
        String outputString = studentCommons.generateStateString(setStudent);

        System.out.println("Student:");
        System.out.println(outputString);
    }
}
