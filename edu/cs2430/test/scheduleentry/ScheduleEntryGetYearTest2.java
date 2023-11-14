package edu.cs2430.test.scheduleentry;

import edu.cs2430.assignment3.Course;
import edu.cs2430.assignment3.Program;
import edu.cs2430.assignment3.ScheduleEntry;
import edu.cs2430.assignment3.Semester;

import java.util.UUID;

/**
 *
 * @author James G. Hickey
 */

// Prerequisites:
// Course Constructor tests
// ScheduleEntry Constructor2 tests

public class ScheduleEntryGetYearTest2
{

    public static void main(String[] args) throws IllegalAccessException
    {
        ScheduleEntryCommons scheduleEntryCommons = new ScheduleEntryCommons();

        // Test input
        UUID setScheduleEntryUuid = UUID.randomUUID();
        Semester setScheduleEntrySemester = Semester.FALL;
        int setYear = 3000;

        //Test course for input
        String setCourseName = "Intermediate Software Engineering";
        int setCourseNumber = 3330;
        Program setCourseProgram = Program.COMPUTER_SCIENCE;
        int setCourseCredits = 3;

        //Object creation
        Course setCourse = new Course(setCourseName, setCourseNumber, setCourseProgram, setCourseCredits);
        ScheduleEntry setScheduleEntry = new ScheduleEntry(setScheduleEntryUuid, setScheduleEntrySemester, setYear, setCourse);

        // Verify the output -> Output the information to a file and compare string output
        String outputString = scheduleEntryCommons.generateStateString(setScheduleEntry);

        System.out.println("Return value: " + setScheduleEntry.getYear() + "\n");

        System.out.println("ScheduleEntry:");
        System.out.println(outputString);
    }
}
