package edu.cs2430.test.course;

import edu.cs2430.assignment3.Course;
import edu.cs2430.assignment3.Program;

// Prerequisites:
// Course Constructor1 tests
// Course Constructor2 tests

/**
 * This test adds a prerequisite course when there is already 5 in the list. This will be false.
 * @author Christine Patterson
 */
public class CourseAddPrerequisiteCourseTest3
{

    public static void main(String[] args) throws IllegalAccessException
    {
        //This test adds a prerequisite course when there are already 5 in the list. It will be false.
        CourseCommons courseCommons = new CourseCommons();

        //Create pre-courses
        String setCourseName0 = "Introduction to Computer Science";
        int setCourseNumber0 = 1010;
        Program setCourseProgram0 = Program.COMPUTER_SCIENCE;
        int setCourseCredits0 = 3;

        Course preCourse0 = new Course(setCourseName0, setCourseNumber0, setCourseProgram0, setCourseCredits0);

        String setCourseName1 = "Introduction to Computer Programming";
        int setCourseNumber1 = 1430;
        Program setCourseProgram1 = Program.COMPUTER_SCIENCE;
        int setCourseCredits1 = 3;

        Course preCourse1 = new Course(setCourseName1, setCourseNumber1, setCourseProgram1, setCourseCredits1);

        String setCourseName2 = "Object-Oriented Programming";
        int setCourseNumber2 = 2430;
        Program setCourseProgram2 = Program.COMPUTER_SCIENCE;
        int setCourseCredits2 = 3;

        Course preCourse2 = new Course(setCourseName2, setCourseNumber2, setCourseProgram2, setCourseCredits2);

        // Test input
        String setCourseName3 = "Data Structures";
        int setCourseNumber3 = 2630;
        Program setCourseProgram3 = Program.COMPUTER_SCIENCE;
        int setCourseCredits3 = 3;

        Course preCourse3 = new Course(setCourseName3, setCourseNumber3, setCourseProgram3, setCourseCredits3);

        String setCourseName4 = "Algorithms";
        int setCourseNumber4 = 3010;
        Program setCourseProgram4 = Program.COMPUTER_SCIENCE;
        int setCourseCredits4 = 3;

        Course preCourse4 = new Course(setCourseName4, setCourseNumber4, setCourseProgram4, setCourseCredits4);

        Course[] preReqs = new Course[5];
        preReqs[0] = preCourse0;
        preReqs[1] = preCourse1;
        preReqs[2] = preCourse2;
        preReqs[3] = preCourse3;
        preReqs[4] = preCourse4;

        //Main course
        String setCourseName = "Software Engineering Project II";
        int setCourseNumber = 4730;
        Program setCourseProgram = Program.SOFTWARE_ENGINEERING;
        int setCourseCredits = 3;

        Course setCourse = new Course(setCourseName, setCourseNumber, setCourseProgram, setCourseCredits, preReqs);

        //Pre course to add:
        String preCourseName5 = "Software Engineering Project I";
        int preCourseNumber5 = 4330;
        Program preProgram5 = Program.SOFTWARE_ENGINEERING;
        int preCredits5 = 3;

        Course preCourse5 = new Course(preCourseName5, preCourseNumber5, preProgram5, preCredits5);

        boolean courseAdded = setCourse.addPrerequisiteCourse(preCourse5);

        // Verify the output -> Output the information to a file and compare string output
        String outputString1 = courseCommons.generateStateString(preCourse1);
        String outputString2 = courseCommons.generateStateString(preCourse2);
        String outputString3 = courseCommons.generateStateString(preCourse3);
        String outputString4 = courseCommons.generateStateString(preCourse4);
        String outputString5 = courseCommons.generateStateString(preCourse5);
        String outputString6 = courseCommons.generateStateString(setCourse);

        System.out.println("Return Value: " + courseAdded + "\n");

        System.out.println("Prerequisite Course 1:");
        System.out.println(outputString1);
        System.out.println("\n");

        System.out.println("Prerequisite Course 2:");
        System.out.println(outputString2);
        System.out.println("\n");

        System.out.println("Prerequisite Course 3:");
        System.out.println(outputString3);
        System.out.println("\n");

        System.out.println("Prerequisite Course 4:");
        System.out.println(outputString4);
        System.out.println("\n");

        System.out.println("Prerequisite Course 5:");
        System.out.println(outputString5);
        System.out.println("\n");

        System.out.println("Current Course:");
        System.out.println(outputString6);
    }
}
