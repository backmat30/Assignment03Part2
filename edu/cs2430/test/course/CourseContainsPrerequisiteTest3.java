package edu.cs2430.test.course;

import edu.cs2430.assignment3.Course;
import edu.cs2430.assignment3.Program;

// Prerequisites:
// Course Constructor1 tests
// Course Constructor2 tests
// Course SetCourseNumber tests
// Course SetProgram tests

/**
 *
 * @author James G. Hickey
 */
public class CourseContainsPrerequisiteTest3
{

    public static void main(String[] args) throws IllegalAccessException
    {
        CourseCommons courseCommons = new CourseCommons();

        // Prerequisite course
        String setCourseName = "Introduction to Software Engineering";
        int setCourseNumber = 2730;
        Program setCourseProgram = Program.SOFTWARE_ENGINEERING;
        int setCourseCredits = 3;

        // Prerequisite courses to be added
        String setCourse2Name = "Introduction to Software Engineering";
        int setCourse2Number = 2730;
        Program setCourse2Program = Program.SOFTWARE_ENGINEERING;
        int setCourse2Credits = 3;

        Course firstCourse = new Course(setCourseName, setCourseNumber, setCourseProgram, setCourseCredits);
        Course secondCourse = new Course(setCourse2Name, setCourse2Number, setCourse2Program, setCourse2Credits);

        //adding the prerequisite courses
        Course[] preReqs = new Course[5];
        //preReqs[0] = firstCourse;
        preReqs[4] = firstCourse;

        // Creating the base class with prerequisites
        String setCourseThreeName = "Intermediate Software Engineering";
        int setCourseThreeNumber = 3330;
        Program setProgramThree = Program.SOFTWARE_ENGINEERING;
        int setCourseThreeCredits = 3;

        Course baseCourse = new Course(setCourseThreeName, setCourseThreeNumber, setProgramThree, setCourseThreeCredits, preReqs);

        //check to see if the course already exists as a preReq
        boolean returnValue = baseCourse.containsPrerequisite(secondCourse);

        // Verify the output -> Output the information to a file and compare string output
        String outputString1 = courseCommons.generateStateString(baseCourse);
        String outputString2 = courseCommons.generateStateString(firstCourse);

        System.out.println("Return value: " + returnValue + "\n");

        System.out.println("Course:");
        System.out.println(outputString1);
        System.out.println("\n");

        System.out.println("Prerequisite Course:");
        System.out.println(outputString2);
    }
}
