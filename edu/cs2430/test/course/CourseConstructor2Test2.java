package edu.cs2430.test.course;

import edu.cs2430.assignment3.Course;
import edu.cs2430.assignment3.Program;

// Prerequisites:
// Course Constructor1 tests
// Course Constructor2 Test1

public class CourseConstructor2Test2
{
    public static void main(String[] args) throws IllegalAccessException
    {
        CourseCommons courseCommons = new CourseCommons();

        // Test input
        String setCourseName = "Software Engineering Project I";
        int setCourseNumber = 4330;
        Program setCourseProgram = Program.SOFTWARE_ENGINEERING;
        int setCourseCredits = 3;

        Course[] setPrerequisiteCourses = new Course[2];
        Course[] setPrerequisite1Courses = new Course[1];
        Course[] setPrerequisite2Courses = new Course[1];

        String setPrerequisite1CourseName = "Intermediate Software Engineering";
        int setPrerequisite1CourseNumber = 3330;
        Program setPrerequisite1CourseProgram = Program.SOFTWARE_ENGINEERING;
        int setPrerequisite1CourseCredits = 3;

        String setPrerequisite2CourseName = "Object-Oriented Analysis and Design";
        int setPrerequisite2CourseNumber = 3430;
        Program setPrerequisite2CourseProgram = Program.SOFTWARE_ENGINEERING;
        int setPrerequisite2CourseCredits = 3;

        String setPrerequisite3CourseName = "Introduction to Software Engineering";
        int setPrerequisite3CourseNumber = 2730;
        Program setPrerequisite3CourseProgram = Program.SOFTWARE_ENGINEERING;
        int setPrerequisite3CourseCredits = 3;

        Course prerequisite3Course = new Course(setPrerequisite3CourseName, setPrerequisite3CourseNumber, setPrerequisite3CourseProgram, setPrerequisite3CourseCredits);

        setPrerequisite1Courses[0] = prerequisite3Course;
        setPrerequisite2Courses[0] = prerequisite3Course;

        Course prerequisite1Course = new Course(setPrerequisite1CourseName, setPrerequisite1CourseNumber, setPrerequisite1CourseProgram, setPrerequisite1CourseCredits, setPrerequisite1Courses);
        Course prerequisite2Course = new Course(setPrerequisite2CourseName, setPrerequisite2CourseNumber, setPrerequisite2CourseProgram, setPrerequisite2CourseCredits, setPrerequisite2Courses);

        setPrerequisiteCourses[0] = prerequisite1Course;
        setPrerequisiteCourses[1] = prerequisite2Course;

        // Test method with test input
        Course newCourse = new Course(setCourseName, setCourseNumber, setCourseProgram, setCourseCredits, setPrerequisiteCourses);

        // Verify the output -> Output the information to a file and compare string output
        String outputString = courseCommons.generateStateString(newCourse);

        System.out.println(outputString);
    }
}
