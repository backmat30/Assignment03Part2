package edu.cs2430.test.scheduleentry;

import edu.cs2430.assignment3.Course;
import edu.cs2430.assignment3.Program;
import edu.cs2430.assignment3.ScheduleEntry;
import edu.cs2430.assignment3.Semester;
import edu.cs2430.test.course.CourseCommons;

import java.util.UUID;

// Prerequisites:
// Course Constructor tests
// ScheduleEntry Constructor2 tests

/**
 * This tests the getter method for the course in the schedule entry.
 * @author Christine Patterson
 */
public class ScheduleEntryGetCourseTest2
{

    public static void main(String[] args) throws IllegalAccessException {

        //This test will retrieve the semester of a schedule entry.
        ScheduleEntryCommons scheduleEntryCommons = new ScheduleEntryCommons();
        CourseCommons courseCommons = new CourseCommons();

        // Test input
        UUID setScheduleEntryUuid = UUID.randomUUID();
        Semester setScheduleEntrySemester = Semester.SPRING;
        int setYear = 2023;

        String setCourseName = "Intermediate Software Engineering";
        int setCourseNumber = 3330;
        Program setCourseProgram = Program.SOFTWARE_ENGINEERING;
        int setCourseCredits = 3;

        String setPrerequisite1CourseName = "Introduction to Software Engineering";
        int setPrerequisite1CourseNumber = 2730;
        Program setPrerequisite1CourseProgram = Program.SOFTWARE_ENGINEERING;
        int setPrerequisite1CourseCredits = 3;

        Course setPrerequisite1Course = new Course(setPrerequisite1CourseName, setPrerequisite1CourseNumber, setPrerequisite1CourseProgram, setPrerequisite1CourseCredits);
        Course[] prerequisiteCourse = {setPrerequisite1Course};
        Course setCourse = new Course(setCourseName, setCourseNumber, setCourseProgram, setCourseCredits, prerequisiteCourse);

        //Construct schedule entry
        ScheduleEntry newScheduleEntry = new ScheduleEntry(setScheduleEntryUuid, setScheduleEntrySemester, setYear, setCourse);

        // Test method
        Course course = newScheduleEntry.getCourse();

        // Verify the output -> Output the information to a file and compare string output
        String outputString = scheduleEntryCommons.generateStateString(newScheduleEntry);
        String returnValue = courseCommons.generateStateString(course);

        System.out.println("Return Value:");
        System.out.println(returnValue);
        System.out.println("\n");
        System.out.println("ScheduleEntry:");
        System.out.println(outputString);
    }
}
