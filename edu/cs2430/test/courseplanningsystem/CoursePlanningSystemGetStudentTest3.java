package edu.cs2430.test.courseplanningsystem;

import edu.cs2430.assignment3.CoursePlanningSystem;
import edu.cs2430.assignment3.Student;
import edu.cs2430.test.student.StudentCommons;

// public Student getStudent(int studentId)

// Prerequisites:
// Course Constructor tests
// ScheduleEntry Constructor tests
// Student Constructor tests
// CoursePlanningSystem Constructor tests
// CoursePlanningSystem AddStudent tests
public class CoursePlanningSystemGetStudentTest3
{
    public static void main(String[] args) throws IllegalAccessException
    {
        CoursePlanningSystemCommons coursePlanningSystemCommons = new CoursePlanningSystemCommons();
        StudentCommons studentCommons = new StudentCommons();

        CoursePlanningSystem setCoursePlanningSystem = new CoursePlanningSystem();

        String setStudent1Name = "Student 1";
        Student setStudent1 = new Student(setStudent1Name);
        setCoursePlanningSystem.addStudent(setStudent1);

        String setStudent2Name = "Student 2";
        Student setStudent2 = new Student(setStudent2Name);
        setCoursePlanningSystem.addStudent(setStudent2);

        // Test input
        int setStudentId = 3;

        // Test method with test input
        Student returnValue = setCoursePlanningSystem.getStudent(setStudentId);

        // Verify the output -> Output the information to a file and compare string output
        String returnValueString = studentCommons.generateStateString(returnValue);
        String outputString = coursePlanningSystemCommons.generateStateString(setCoursePlanningSystem);

        System.out.println("Return Value:\n");
        System.out.println(returnValueString);
        System.out.println("\n");
        System.out.println("Course Planning System:");
        System.out.println(outputString);
    }
}
