package edu.cs2430.test.scheduleentry;

// public ScheduleEntry(UUID uuid, Semester semester, int year, Course course)

import edu.cs2430.assignment3.Course;
import edu.cs2430.assignment3.Program;
import edu.cs2430.assignment3.ScheduleEntry;
import edu.cs2430.assignment3.Semester;

import java.util.UUID;

// Prerequisites:
// Course Constructor tests

public class ScheduleEntryConstructor2Test1
{
    public static void main(String[] args) throws IllegalAccessException
    {
        ScheduleEntryCommons scheduleEntryCommons = new ScheduleEntryCommons();

        // Test input
        UUID setScheduleEntryUuid = UUID.randomUUID();
        Semester setScheduleEntrySemester = Semester.SPRING;
        int setYear = 2023;

        String setCourseName = "Intermediate Software Engineering";
        int setCourseNumber = 3330;
        Program setCourseProgram = Program.SOFTWARE_ENGINEERING;
        int setCourseCredits = 3;

        Course setCourse = new Course(setCourseName, setCourseNumber, setCourseProgram, setCourseCredits);

        // Test method with test input
        ScheduleEntry newScheduleEntry = new ScheduleEntry(setScheduleEntryUuid, setScheduleEntrySemester, setYear, setCourse);

        // Verify the output -> Output the information to a file and compare string output
        String outputString = scheduleEntryCommons.generateStateString(newScheduleEntry);

        System.out.println(outputString);
    }
}
