package edu.cs2430.test.course;

import edu.cs2430.assignment3.Course;
import edu.cs2430.assignment3.Program;

// Prerequisites:
// None

public class CourseConstructor1Test1
{
    public static void main(String[] args) throws IllegalAccessException
    {
        CourseCommons courseCommons = new CourseCommons();

        // Test input
        String setCourseName = "Object-Oriented Programming";
        int setCourseNumber = 2430;
        Program setCourseProgram = Program.COMPUTER_SCIENCE;
        int setCourseCredits = 3;

        // Test method with test input
        Course newCourse = new Course(setCourseName, setCourseNumber, setCourseProgram, setCourseCredits);

        // Verify the output -> Output the information to a file and compare string output
        String outputString = courseCommons.generateStateString(newCourse);

        System.out.println(outputString);
    }
}
