package edu.cs2430.test.schedule;

import edu.cs2430.assignment3.*;
import edu.cs2430.test.scheduleentry.ScheduleEntryCommons;

import java.util.UUID;

// Prerequisites:
// ScheduleConstructor1Test1
// Course Constructor tests

/**
 * This test is testing the copy constructor
 *
 * @author James G. Hickey
 */
public class ScheduleConstructor2Test2
{

    public static void main(String[] args) throws IllegalAccessException
    {

        ScheduleCommons scheduleCommons = new ScheduleCommons();
        ScheduleEntryCommons scheduleEntryCommons = new ScheduleEntryCommons();

        //Create a first "base" schedule
        int studentId = 100;
        int year = 2023;
        //Create a schedule
        Schedule mySchedule = new Schedule(studentId);

        //Create the courses necessary
        String setCourseName = "Object-Oriented Programming";
        int setCourseNumber = 2430;
        Program setCourseProgram = Program.COMPUTER_SCIENCE;
        int setCourseCredits = 3;
        UUID uuid = UUID.randomUUID();

        Course newCourse = new Course(setCourseName, setCourseNumber, setCourseProgram, setCourseCredits);

        String setCourseName1 = "Data Structures";
        int setCourseNumber1 = 2730;
        Program setProgram1 = Program.COMPUTER_SCIENCE;
        int setCredits1 = 3;
        UUID uuid1 = UUID.randomUUID();

        Course newCourse2 = new Course(setCourseName1, setCourseNumber1, setProgram1, setCredits1);


        //Create a new ScheduleEntries
        ScheduleEntry myScheduleEntry = new ScheduleEntry(uuid, Semester.SUMMER, year, newCourse);
        ScheduleEntry myScheduleEntry1 = new ScheduleEntry(uuid1, Semester.FALL, year, newCourse2);

        //Adding the schedule entries to the schedule
        mySchedule.addScheduleEntry(myScheduleEntry);
        mySchedule.addScheduleEntry(myScheduleEntry1);

        //Testing the method

        Schedule mySchedule1 = new Schedule(mySchedule);

        //output

        String outputString1 = scheduleCommons.generateStateString(mySchedule1);
        String outputString2 = scheduleCommons.generateStateString(mySchedule);

        System.out.println("Original schedule:");
        System.out.println(outputString2);
        System.out.println("\n");
        System.out.println("Copied schedule:");
        System.out.println(outputString1);

    }

}
