package edu.cs2430.test.courseplanningsystem;

import edu.cs2430.assignment3.CoursePlanningSystem;
import edu.cs2430.assignment3.Student;

// public boolean addStudent(Student student)

// Prerequisites:
// Course Constructor tests
// ScheduleEntry Constructor tests
// Student Constructor tests
// CoursePlanningSystem Constructor tests
public class CoursePlanningSystemAddStudentTest1
{
    public static void main(String[] args) throws IllegalAccessException
    {
        CoursePlanningSystemCommons coursePlanningSystemCommons = new CoursePlanningSystemCommons();

        CoursePlanningSystem setCoursePlanningSystem = new CoursePlanningSystem();

        // Test input
        String setStudentName = "Doog Sealant";
        Student setStudent = new Student(setStudentName);

        // Test method with test input
        boolean returnValue = setCoursePlanningSystem.addStudent(setStudent);

        // Verify the output -> Output the information to a file and compare string output
        String outputString = coursePlanningSystemCommons.generateStateString(setCoursePlanningSystem);

        System.out.println("Return Value:  " + returnValue + "\n");
        System.out.println("Course Planning System:");
        System.out.println(outputString);
    }
}
