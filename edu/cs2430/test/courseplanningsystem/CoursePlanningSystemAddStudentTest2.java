package edu.cs2430.test.courseplanningsystem;

import edu.cs2430.assignment3.CoursePlanningSystem;
import edu.cs2430.assignment3.Student;

// public boolean addStudent(Student student)

// Prerequisites:
// Course Constructor tests
// ScheduleEntry Constructor tests
// Student Constructor tests
// CoursePlanningSystem Constructor tests
// CoursePlanningSystemAddStudentTest1
public class CoursePlanningSystemAddStudentTest2
{
    public static void main(String[] args) throws IllegalAccessException
    {
        CoursePlanningSystemCommons coursePlanningSystemCommons = new CoursePlanningSystemCommons();

        CoursePlanningSystem setCoursePlanningSystem = new CoursePlanningSystem();
        int maxArraySize = 1000;
        // Test input

        for(int i=0; i<maxArraySize; i++)
        {
            String setStudentName = "Student " + (i+1);
            Student setStudent = new Student(setStudentName);
            setCoursePlanningSystem.addStudent(setStudent);
        }

        String setStudentName = "Student " + (maxArraySize);
        Student setStudent = new Student(setStudentName);

        // Test method with test input
        boolean returnValue = setCoursePlanningSystem.addStudent(setStudent);

        // Verify the output -> Output the information to a file and compare string output
        String outputString = coursePlanningSystemCommons.generateStateString(setCoursePlanningSystem);

        System.out.println("Return Value:  " + returnValue);
    }
}
