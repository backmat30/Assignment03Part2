package edu.cs2430.test.schedule;
import edu.cs2430.assignment3.*;

import java.util.UUID;

// Prerequisites:
// Course CourseConstructor1Test1 test
// ScheduleEntry ScheduleEntryConstructor1Test1
// Schedule Constructor tests

/**
 * This tests if a schedule entry can be added to a schedule.
 * @author Christine Patterson
 */
public class ScheduleAddScheduleEntryTest1
{

    public static void main(String[] args) throws IllegalAccessException
    {
        // Create course object
        //This test will retrieve the semester of a schedule entry.
        ScheduleCommons scheduleCommons = new ScheduleCommons();

        //Create course
        String setCourseName = "Intermediate Software Engineering";
        int setCourseNumber = 3330;
        Program setCourseProgram = Program.SOFTWARE_ENGINEERING;
        int setCourseCredits = 3;

        Course setCourse = new Course(setCourseName, setCourseNumber, setCourseProgram, setCourseCredits);

        //Create schedule entry
        UUID setScheduleEntryUuid = UUID.randomUUID();
        Semester setScheduleEntrySemester = Semester.SPRING;
        int setYear = 2023;
        ScheduleEntry newScheduleEntry = new ScheduleEntry(setScheduleEntryUuid, setScheduleEntrySemester, setYear, setCourse);

        //Create schedule
        int studentID = 1116;
        Schedule newSchedule = new Schedule(studentID);

        //Add schedule entry to schedule
        boolean entryAdded = newSchedule.addScheduleEntry(newScheduleEntry);

        // Verify the output -> Output the information to a file and compare string output
        String outputString3 = scheduleCommons.generateStateString(newSchedule);

        System.out.println("Return Value: " + entryAdded + "\n");

        System.out.println("Schedule:");
        System.out.println(outputString3);
    }
}
