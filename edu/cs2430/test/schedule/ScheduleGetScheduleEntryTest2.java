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
public class ScheduleGetScheduleEntryTest2
{

    public static void main(String[] args) throws IllegalAccessException
    {
        ScheduleCommons scheduleCommons = new ScheduleCommons();
        ScheduleEntryCommons scheduleEntryCommons = new ScheduleEntryCommons();

        //Create a schedule
        Schedule mySchedule = new Schedule(10);

        //Create a courses to add to the schedule
        String setCourseName = "Object-Oriented Programming";
        int setCourseNumber = 2430;
        Program setCourseProgram = Program.COMPUTER_SCIENCE;
        int setCourseCredits = 3;

        Course newCourse = new Course(setCourseName, setCourseNumber, setCourseProgram, setCourseCredits);

        String setCourseName1 = "Data Structures";
        int setCourseNumber1 = 2730;
        Program setCourseProgram1 = Program.COMPUTER_SCIENCE;
        int setCourseCredits1 = 3;

        Course newCourse2 = new Course(setCourseName1, setCourseNumber1, setCourseProgram1, setCourseCredits1);

        String setCourseName2 = "Intermediate Software Engineering";
        int setCourseNumber2 = 3330;
        Program setCourseProgram2 = Program.SOFTWARE_ENGINEERING;
        int setCourseCredits2 = 3;

        Course newCourse3 = new Course(setCourseName2, setCourseNumber2, setCourseProgram2, setCourseCredits2);


        //Create a new ScheduleEntries

        ScheduleEntry myScheduleEntry = new ScheduleEntry(Semester.FALL, 2023, newCourse);
        ScheduleEntry myScheduleEntry1 = new ScheduleEntry(Semester.FALL, 2023, newCourse2);
        ScheduleEntry myScheduleEntry2 = new ScheduleEntry(Semester.FALL, 2023, newCourse3);

        // Adding a ScheduleEntry to the schedule -- test with only one in the array of
        // schedule entry objects
        mySchedule.addScheduleEntry(myScheduleEntry);
        mySchedule.addScheduleEntry(myScheduleEntry1);
        mySchedule.addScheduleEntry(myScheduleEntry2);

        // Get the schedule entry at index 1
        ScheduleEntry returnValue = mySchedule.getScheduleEntry(2);

        // Output
        String outputString1 = scheduleEntryCommons.generateStateString(returnValue);
        String outputString2 = scheduleCommons.generateStateString(mySchedule);

        System.out.println("Return value:");
        System.out.println(outputString1);
        System.out.println("\n");
        System.out.println("Schedule:");
        System.out.println(outputString2);

    }

}
