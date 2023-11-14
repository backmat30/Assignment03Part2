package edu.cs2430.test.course;

import edu.cs2430.assignment3.Course;
import edu.cs2430.assignment3.Program;

// Prerequisites:
// Course Constructor1 tests

/**
 * This test will add a null course object. This will be false.
 * @author Christine Patterson
 */
public class CourseAddPrerequisiteCourseTest6
{

    public static void main(String[] args) throws IllegalAccessException
    {
        CourseCommons courseCommons = new CourseCommons();

        // Create pre-course
        Course preCourse = null;

        // Test input
        String setCourseName = "Object-Oriented Programming";
        int setCourseNumber = 2430;
        Program setCourseProgram = Program.COMPUTER_SCIENCE;
        int setCourseCredits = 3;

        // Test method with test input
        Course setCourse = new Course(setCourseName, setCourseNumber, setCourseProgram, setCourseCredits);

        // Test method
        boolean courseAdded = setCourse.addPrerequisiteCourse(preCourse);

        // Verify the output -> Output the information to a file and compare string output
        String outputString1 = courseCommons.generateStateString(preCourse);
        String outputString2 = courseCommons.generateStateString(setCourse);

        System.out.println("Return Value: " + courseAdded + "\n");

        System.out.println("Prerequisite Course:");
        System.out.println(outputString1);
        System.out.println("\n");

        System.out.println("Current Course:");
        System.out.println(outputString2);
    }
}
