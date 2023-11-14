package edu.cs2430.test.scheduleentry;

import edu.cs2430.assignment3.Course;
import edu.cs2430.assignment3.Program;
import edu.cs2430.assignment3.ScheduleEntry;
import edu.cs2430.assignment3.Semester;

import java.util.UUID;

// Prerequisites:
// Course Constructor tests
// ScheduleEntry Constructor2 tests

/**
 * This tests the getter method for the semester in the schedule entry.
 * @author Christine Patterson
 */
public class ScheduleEntryGetSemesterTest1
{

    public static void main(String[] args) throws IllegalAccessException
    {

        //This test will retrieve the semester of a schedule entry.
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

        //Construct schedule entry
        ScheduleEntry newScheduleEntry = new ScheduleEntry(setScheduleEntryUuid, setScheduleEntrySemester, setYear, setCourse);

        Semester semester = newScheduleEntry.getSemester();

        // Verify the output -> Output the information to a file and compare string output
        String outputString = scheduleEntryCommons.generateStateString(newScheduleEntry);

        System.out.println("Return Value: " + semester + "\n");

        System.out.println("ScheduleEntry:");
        System.out.println(outputString);
    }
}
