package edu.cs2430.test.course;

import edu.cs2430.assignment3.Course;
import edu.cs2430.assignment3.Program;

// Prerequisites:
// Course Constructor1 tests

/**
 * This tests the setter method for course name.
 * @author Christine Patterson
 */

public class CourseSetNameTest1
{
    public static void main(String[] args) throws IllegalAccessException
    {
        CourseCommons courseCommons = new CourseCommons();

        // Test input
        String setCourseName = "Seminar";
        int setCourseNumber = 4110;
        Program setCourseProgram = Program.SOFTWARE_ENGINEERING;
        int setCourseCredits = 1;

        // Test method with test input
        Course setCourse = new Course(setCourseName, setCourseNumber, setCourseProgram, setCourseCredits);

        //Test method for setName using constructed course above
        setCourse.setName("Senior Seminar");

        // Verify the output -> Output the information to a file and compare string output
        String outputString = courseCommons.generateStateString(setCourse);

        System.out.println("Course: ");
        System.out.println(outputString);
    }
}
