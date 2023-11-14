package edu.cs2430.test.schedule;

import edu.cs2430.assignment3.*;


// Prerequisites:
// Course Constructor tests
// ScheduleEntry Constructor tests
// Schedule Constructor tests

/**
 * Test to calculate the credits in a given schedule
 *
 * @author James G. Hickey
 */
public class ScheduleCalculateCreditsTest1
{

    public static void main(String[] args) throws IllegalAccessException
    {
        ScheduleCommons scheduleCommons = new ScheduleCommons();

        int studentId = 100;
        int year = 2023;
        //Create a schedule
        Schedule mySchedule = new Schedule(studentId);

        //Create the courses necessary
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
        ScheduleEntry myScheduleEntry = new ScheduleEntry(Semester.FALL, year, newCourse);
        ScheduleEntry myScheduleEntry1 = new ScheduleEntry(Semester.FALL, year, newCourse2);
        ScheduleEntry myScheduleEntry2 = new ScheduleEntry(Semester.FALL, year, newCourse3);


        mySchedule.addScheduleEntry(myScheduleEntry);
        mySchedule.addScheduleEntry(myScheduleEntry1);
        mySchedule.addScheduleEntry(myScheduleEntry2);

        // Test method
        int returnValue = mySchedule.calculateCredits();

        // Output
        String outputString1 = scheduleCommons.generateStateString(mySchedule);

        System.out.println("Return value: " + returnValue + "\n");
        System.out.println("Schedule:");
        System.out.println(outputString1);
    }
}
