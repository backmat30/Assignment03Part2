package edu.cs2430.test.course;

import edu.cs2430.assignment3.Course;
import edu.cs2430.assignment3.Program;

// Prerequisites:
// Course Constructor1 tests

/**
 * This test adds on prerequisite course to an empty list. This will be true.
 * @author Christine Patterson
 */
public class CourseAddPrerequisiteCourseTest1
{
    public static void main(String[] args) throws IllegalAccessException
    {
        // Test input
        CourseCommons courseCommons = new CourseCommons();

        String preCourseName = "Introduction to Computer Programming";
        int preCourseNumber = 1430;
        Program preProgram = Program.COMPUTER_SCIENCE;
        int preCredits = 3;

        Course preCourse = new Course(preCourseName, preCourseNumber, preProgram, preCredits);

        String setCourseName = "Object-Oriented Programming";
        int setCourseNumber = 2430;
        Program setCourseProgram = Program.COMPUTER_SCIENCE;
        int setCourseCredits = 3;

        Course setCourse = new Course(setCourseName, setCourseNumber, setCourseProgram, setCourseCredits);

        // Test method with test input
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
