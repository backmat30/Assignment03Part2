package edu.cs2430.test.course;

import edu.cs2430.assignment3.Course;
import edu.cs2430.assignment3.Program;


// Prerequisites:
// Course Constructor1 tests

/**
 *
 * @author James G. Hickey
 */
public class CourseGetNumberOfCreditsTest2
{
    public static void main(String[] args) throws IllegalAccessException
    {
        CourseCommons courseCommons = new CourseCommons();

        // Test input
        String setCourseName = "Object-Oriented Programming";
        int setCourseNumber = 2430;
        Program setCourseProgram = Program.COMPUTER_SCIENCE;
        int setCourseCredits = 3;

        Course setCourse = new Course(setCourseName, setCourseNumber, setCourseProgram, setCourseCredits);

        //Test method for getNumberOfCredits using constructed course above
        int courseCredits = setCourse.getNumberOfCredits();

        // Verify the output -> Output the information to a file and compare string output
        String outputString = courseCommons.generateStateString(setCourse);

        System.out.println("Return value: " + courseCredits + "\n");

        System.out.println("Course:");
        System.out.println(outputString);
    }
}
