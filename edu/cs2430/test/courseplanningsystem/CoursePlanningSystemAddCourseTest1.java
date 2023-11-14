package edu.cs2430.test.courseplanningsystem;

import edu.cs2430.assignment3.Course;
import edu.cs2430.assignment3.CoursePlanningSystem;
import edu.cs2430.assignment3.Program;

// public boolean addCourse(Course course)

// Prerequisites:
// Course Constructor tests
// ScheduleEntry Constructor tests
// Student Constructor tests
// CoursePlanningSystem Constructor tests
public class CoursePlanningSystemAddCourseTest1
{
    public static void main(String[] args) throws IllegalAccessException
    {
        CoursePlanningSystemCommons coursePlanningSystemCommons = new CoursePlanningSystemCommons();

        CoursePlanningSystem setCoursePlanningSystem = new CoursePlanningSystem();

        // Test input
        String setCourseName = "Object-Oriented Programming";
        int setCourseNumber = 2430;
        Program setProgram = Program.COMPUTER_SCIENCE;
        int setCredits = 3;

        Course setCourse = new Course(setCourseName, setCourseNumber, setProgram, setCredits);

        // Test method with test input
        boolean returnValue = setCoursePlanningSystem.addCourse(setCourse);

        // Verify the output -> Output the information to a file and compare string output
        String outputString = coursePlanningSystemCommons.generateStateString(setCoursePlanningSystem);

        System.out.println("Return Value:  " + returnValue + "\n");
        System.out.println("Course Planning System:");
        System.out.println(outputString);
    }
}
