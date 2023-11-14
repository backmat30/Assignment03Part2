package edu.cs2430.test.student;

import edu.cs2430.assignment3.Student;

// public Student(String name)

// Prerequisites:
// Course Constructor tests
// ScheduleEntry Constructor tests
// Schedule Constructor tests
public class StudentConstructor1Test1
{
    public static void main(String[] args) throws IllegalAccessException
    {
        StudentCommons studentCommons = new StudentCommons();

        // Test input
        String setStudentName = "Doog Sealant";

        // Test method with test input
        Student newStudent = new Student(setStudentName);

        // Verify the output -> Output the information to a file and compare string output
        String outputString = studentCommons.generateStateString(newStudent);

        System.out.println(outputString);
    }
}
