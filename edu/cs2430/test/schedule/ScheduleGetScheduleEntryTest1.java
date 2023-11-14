package edu.cs2430.test.schedule;

import edu.cs2430.assignment3.*;
import edu.cs2430.test.scheduleentry.ScheduleEntryCommons;

// Prerequisites:
// Course Constructor tests
// ScheduleEntry Constructor tests
// AddScheduleEntry tests
// ScheduleConstructor1Test

/**
 * @author James G. Hickey
 */
public class ScheduleGetScheduleEntryTest1
{
    public static void main(String[] args) throws IllegalAccessException
    {
        ScheduleCommons scheduleCommons = new ScheduleCommons();
        ScheduleEntryCommons scheduleEntryCommons = new ScheduleEntryCommons();

        int studentId = 10;
        int year = 2023;
        //Create a schedule
        Schedule mySchedule = new Schedule(studentId);

        //Create a course to add to the schedule
        String setCourseName = "Object-Oriented Programming";
        int setCourseNumber = 2430;
        Program setCourseProgram = Program.COMPUTER_SCIENCE;
        int setCourseCredits = 3;

        Course newCourse = new Course(setCourseName, setCourseNumber, setCourseProgram, setCourseCredits);

        //Create a new ScheduleEntry Object

        ScheduleEntry myScheduleEntry = new ScheduleEntry(Semester.FALL, year, newCourse);

        // Adding a ScheduleEntry to the schedule -- test with only one in the array of
        // schedule entry objects
        mySchedule.addScheduleEntry(myScheduleEntry);

        //Get the schedule entry at index 0
        ScheduleEntry returnValue = mySchedule.getScheduleEntry(0);

        String outputString1 = scheduleEntryCommons.generateStateString(returnValue);
        String outputString2 = scheduleCommons.generateStateString(mySchedule);


        System.out.println("Return value:");
        System.out.println(outputString1);
        System.out.println("\n");
        System.out.println("Schedule:");
        System.out.println(outputString2);

    }

}
