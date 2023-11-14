package edu.cs2430.test.scheduleentry;

import edu.cs2430.assignment3.Course;
import edu.cs2430.assignment3.Program;
import edu.cs2430.assignment3.ScheduleEntry;
import edu.cs2430.assignment3.Semester;

import java.util.UUID;

// Prerequisites:
// Course Constructor tests
// ScheduleEntry Constructor2 tests

// Since course does not have a copy constructor, this test will not test for a deep copy of Course
public class ScheduleEntryCopyConstructorTest1
{
    public static void main(String[] args) throws IllegalAccessException
    {
        ScheduleEntryCommons scheduleEntryCommons = new ScheduleEntryCommons();

        // Test input
        UUID setScheduleEntryUuid = UUID.randomUUID();
        Semester setScheduleEntrySemester = Semester.FALL;
        int setYear = 2020;

        String setCourseName = "Intermediate Software Engineering";
        int setCourseNumber = 3330;
        Program setCourseProgram = Program.SOFTWARE_ENGINEERING;
        int setCourseCredits = 3;

        String setPrerequisite1CourseName = "Introduction to Software Engineering";
        int setPrerequisite1CourseNumber = 2730;
        Program setPrerequisite1CourseProgram = Program.SOFTWARE_ENGINEERING;
        int setPrerequisite1CourseCredits = 3;

        Course setPrerequisite1Course = new Course(setPrerequisite1CourseName, setPrerequisite1CourseNumber, setPrerequisite1CourseProgram, setPrerequisite1CourseCredits);
        Course[] prerequsiteCourses = {setPrerequisite1Course};
        Course setCourse = new Course(setCourseName, setCourseNumber, setCourseProgram, setCourseCredits, prerequsiteCourses);

        ScheduleEntry setScheduleEntry = new ScheduleEntry(setScheduleEntryUuid, setScheduleEntrySemester, setYear, setCourse);

        // Test method with test input
        ScheduleEntry newScheduleEntry = new ScheduleEntry(setScheduleEntry);

        // Verify the output -> Output the information to a file and compare string output
        String originalString = scheduleEntryCommons.generateStateString(setScheduleEntry);
        String copyString = scheduleEntryCommons.generateStateString(newScheduleEntry);

        System.out.println("Original ScheduleEntry:");
        System.out.println(originalString);
        System.out.println("\n");
        System.out.println("Copy ScheduleEntry:");
        System.out.println(copyString);
    }

}
