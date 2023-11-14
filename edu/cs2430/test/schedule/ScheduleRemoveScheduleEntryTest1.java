package edu.cs2430.test.schedule;

import edu.cs2430.assignment3.*;
import edu.cs2430.test.scheduleentry.ScheduleEntryCommons;

import java.util.UUID;

// Prerequisites:
// Course Constructor tests
// ScheduleEntry Constructor tests
// Schedule ScheduleConstructor1Test1 test

/**
 * This test is to see if a schedule entry is removed
 * uses the UUID to identify which course to remove
 *
 * @author James G. Hickey
 */
public class ScheduleRemoveScheduleEntryTest1
{
    public static void main(String[] args) throws IllegalAccessException
    {
        ScheduleCommons scheduleCommons = new ScheduleCommons();
        ScheduleEntryCommons scheduleEntryCommons = new ScheduleEntryCommons();

        int studentId = 100;
        int year = 2023;
        //Create a schedule
        Schedule mySchedule = new Schedule(studentId);

        //Create the courses necessary
        String setCourseName = "Object-Oriented Programming";
        int setCourseNumber = 2430;
        Program setProgram = Program.COMPUTER_SCIENCE;
        int setCredits = 3;
        UUID uuid = UUID.randomUUID();

        Course newCourse = new Course(setCourseName, setCourseNumber, setProgram, setCredits);

        String setCourseName1 = "Data Structures";
        int setCourseNumber1 = 2730;
        Program setProgram1 = Program.COMPUTER_SCIENCE;
        int setCredits1 = 3;
        UUID uuid1 = UUID.randomUUID();

        Course newCourse2 = new Course(setCourseName1, setCourseNumber1, setProgram1, setCredits1);

        String setCourseName2 = "Intermediate Software Engineering";
        int setCourseNumber2 = 3330;
        Program setProgram2 = Program.SOFTWARE_ENGINEERING;
        int setCredits2 = 3;
        UUID uuid2 = UUID.randomUUID();

        Course newCourse3 = new Course(setCourseName2, setCourseNumber2, setProgram2, setCredits2);

        //Create a new ScheduleEntries
        ScheduleEntry myScheduleEntry = new ScheduleEntry(uuid, Semester.FALL, year, newCourse);
        ScheduleEntry myScheduleEntry1 = new ScheduleEntry(uuid1, Semester.FALL, year, newCourse2);
        ScheduleEntry myScheduleEntry2 = new ScheduleEntry(uuid2, Semester.FALL, year, newCourse3);

        //Adding the schedule entries to the schedule
        mySchedule.addScheduleEntry(myScheduleEntry);
        mySchedule.addScheduleEntry(myScheduleEntry1);
        mySchedule.addScheduleEntry(myScheduleEntry2);

        //Testing the removal method given a UUID
        boolean returnValue = mySchedule.removeScheduleEntry(uuid);

        // Output
        String outputString1 = scheduleCommons.generateStateString(mySchedule);

        System.out.println("Return value:  " + returnValue + "\n");

        System.out.println("Schedule:");
        System.out.println(outputString1);

    }
}
