package edu.cs2430.test.course;

import edu.cs2430.assignment3.Course;
import edu.cs2430.assignment3.Program;

// Prerequisites:
// Course Constructor1 tests

/**
 *
 * @author James G. Hickey
 */
public class CourseGetCourseNumberTest2
{
    public static void main(String[] args) throws IllegalAccessException
    {
        CourseCommons courseCommons = new CourseCommons();

        // create course object
        String setCourseName = "Seminar";
        int setCourseNumber = 4110;
        Program setCourseProgram = Program.SOFTWARE_ENGINEERING;
        int setCourseCredits = 1;

        // Test method with test input
        Course setCourse = new Course(setCourseName, setCourseNumber, setCourseProgram, setCourseCredits);

        // Test method with test input
        int courseNumber = setCourse.getNumber();

        // Verify the output -> Output the information to a file and compare string output
        String outputString = courseCommons.generateStateString(setCourse);

        System.out.println("Return value: " + courseNumber + "\n");

        System.out.println("Course:");
        System.out.println(outputString);
    }
}
