package edu.cs2430.test.student;

import edu.cs2430.assignment3.Student;

// Prerequisites:
// Student Constructor tests

public class StudentGetNameTest1
{
    public static void main(String[] args) throws IllegalAccessException
    {
        //This test will retrieve the semester of a schedule entry.
        StudentCommons studentCommons = new StudentCommons();

        // Test input
        String setStudentName = "Doug Selent";
        Student setStudent = new Student(setStudentName);

        // Test method
        String returnValue = setStudent.getName();

        // Verify the output -> Output the information to a file and compare string output
        String outputString = studentCommons.generateStateString(setStudent);

        System.out.println("Return Value:  " + returnValue + "\n");
        System.out.println("Student:");
        System.out.println(outputString);
    }
}
