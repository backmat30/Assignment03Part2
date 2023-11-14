package edu.cs2430.test.courseplanningsystem;

import edu.cs2430.assignment3.Course;
import edu.cs2430.assignment3.CoursePlanningSystem;
import edu.cs2430.assignment3.Program;
import edu.cs2430.test.course.CourseCommons;

// public Course getCourse(int courseNumber, Program program)

// Prerequisites:
// Course Constructor tests
// ScheduleEntry Constructor tests
// Student Constructor tests
// CoursePlanningSystem Constructor tests
// CoursePlanningSystem AddCourse tests
public class CoursePlanningSystemGetCourseTest1
{
    public static void main(String[] args) throws IllegalAccessException
    {
        CoursePlanningSystemCommons coursePlanningSystemCommons = new CoursePlanningSystemCommons();
        CourseCommons courseCommons = new CourseCommons();

        CoursePlanningSystem setCoursePlanningSystem = new CoursePlanningSystem();

        String setCourse1Name = "Course 1";
        int setCourse1Number = 1;
        Program setCourse1Program = Program.CYBERSECURITY;
        int setCourse1Credits = 3;
        Course setCourse1 = new Course(setCourse1Name, setCourse1Number, setCourse1Program, setCourse1Credits);
        setCoursePlanningSystem.addCourse(setCourse1);

        String setCourse2Name = "Course 2";
        int setCourse2Number = 1;
        Program setCourse2Program = Program.SOFTWARE_ENGINEERING;
        int setCourse2Credits = 3;
        Course setCourse2 = new Course(setCourse2Name, setCourse2Number, setCourse2Program, setCourse2Credits);
        setCoursePlanningSystem.addCourse(setCourse2);

        // Test input
        int setCourseNumber = 1;
        Program setCourseProgram = Program.CYBERSECURITY;

        // Test method with test input
        Course returnValue = setCoursePlanningSystem.getCourse(setCourseNumber, setCourseProgram);

        // Verify the output -> Output the information to a file and compare string output
        String returnValueString = courseCommons.generateStateString(returnValue);
        String outputString = coursePlanningSystemCommons.generateStateString(setCoursePlanningSystem);

        System.out.println("Return Value:\n");
        System.out.println(returnValueString);
        System.out.println("\n");
        System.out.println("Course Planning System:");
        System.out.println(outputString);
    }
}
