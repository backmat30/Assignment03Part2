package edu.cs2430.test.course;

import edu.cs2430.assignment3.Course;
import edu.cs2430.assignment3.Program;

// Prerequisites:
// Course Constructor1 tests
// Course Constructor2 tests

/**
 * This test retrieves the prerequisite course list.
 * @author Christine Patterson
 */
public class CourseGetPrerequisiteCoursesTest2
{
    public static void main(String[] args) throws IllegalAccessException
    {
        CourseCommons courseCommons = new CourseCommons();

        // Test input

        String preCourseName = "Object-Oriented Programming";
        int preCourseNumber = 2430;
        Program preProgram = Program.COMPUTER_SCIENCE;
        int preCredits = 3;

        Course preCourse = new Course(preCourseName, preCourseNumber, preProgram, preCredits);

        String setCourseName = "Data Structures";
        int setCourseNumber = 2630;
        Program setProgram = Program.COMPUTER_SCIENCE;
        int setCredits = 3;

        Course[] prerequisiteCourses = {preCourse};
        Course setCourse = new Course(setCourseName, setCourseNumber, setProgram, setCredits, prerequisiteCourses);

        // Test method with test input
        Course[] myCourses = setCourse.getPrerequisiteCourses();

        // Verify the output -> Output the information to a file and compare string output
        String outputString1 = courseCommons.generateStateString(preCourse);
        String outputString2 = courseCommons.generateStateString(setCourse);

        System.out.println("Return Value:");

        for(Course myCourse : myCourses)
        {
            System.out.println(courseCommons.generateStateString(myCourse));
        }

        System.out.println("\n");
        System.out.println("Course:");
        System.out.println(outputString1);
        System.out.println("\n");
        System.out.println("Prerequisite Course:");
        System.out.println(outputString2);

    }
}
