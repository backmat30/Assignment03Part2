package edu.cs2430.test.course;

import edu.cs2430.assignment3.Course;
import edu.cs2430.assignment3.Program;

// Prerequisites:
// Course Constructor1 tests

/**
 * This test adds a prerequisite course with the same name as the main course. This will be false.
 * @author Christine Patterson
 */
public class CourseAddPrerequisiteCourseTest4
{
    public static void main(String[] args) throws IllegalAccessException
    {
        //This test adds a prerequisite course with the same name as the main course. Will be false.
        CourseCommons courseCommons = new CourseCommons();

        //Create pre-course
        String preCourseName = "Object-Oriented Programming";
        int preCourseNumber = 2430;
        Program preProgram = Program.COMPUTER_SCIENCE;
        int preCredits = 3;

        Course preCourse = new Course(preCourseName, preCourseNumber, preProgram, preCredits);

        // Main course
        String setCourseName = "Object-Oriented Programming";
        int setCourseNumber = 2430;
        Program setCourseProgram = Program.COMPUTER_SCIENCE;
        int setCourseCredits = 3;

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
