package edu.cs2430.test.schedule;


import edu.cs2430.assignment3.*;

// Prerequisites:
// Course Constructor tests
// ScheduleEntry Constructor tests
// Schedule Constructor tests


/**
 * This test will calculate the number of credits
 * Requires semester and year as arguments
 * @author James G. Hickey
 */
public class ScheduleCalculateCreditsYearTest2
{
    public static void main(String[] args) throws IllegalAccessException
    {

        ScheduleCommons scheduleCommons = new ScheduleCommons();

        int studentId = 100;
        int year = 2023;
        int year2 = 2024;
        //Create a schedule
        Schedule mySchedule = new Schedule(studentId);

        //Create the courses necessary
        String setCourseName = "Logic and Digital Design";
        int setCourseNumber = 3780;
        Program setProgram = Program.OTHER;
        int setCredits = 4;

        Course newCourse = new Course(setCourseName, setCourseNumber, setProgram, setCredits);

        String setCourseName1 = "Data Structures";
        int setCourseNumber1 = 2730;
        Program setProgram1 = Program.COMPUTER_SCIENCE;
        int setCredits1 = 3;

        Course newCourse2 = new Course(setCourseName1, setCourseNumber1, setProgram1, setCredits1);

        String setCourseName2 = "Intermediate Software Engineering";
        int setCourseNumber2 = 3330;
        Program setProgram2 = Program.SOFTWARE_ENGINEERING;
        int setCredits2 = 3;

        Course newCourse3 = new Course(setCourseName2, setCourseNumber2, setProgram2, setCredits2);

        //Add the courses to the schedule

        ScheduleEntry myScheduleEntry = new ScheduleEntry(Semester.FALL, year, newCourse);
        ScheduleEntry myScheduleEntry1 = new ScheduleEntry(Semester.FALL, year, newCourse2);
        //This schedule entry is for a different year
        ScheduleEntry myScheduleEntry2 = new ScheduleEntry(Semester.FALL, year2, newCourse3);

        mySchedule.addScheduleEntry(myScheduleEntry);
        mySchedule.addScheduleEntry(myScheduleEntry1);
        mySchedule.addScheduleEntry(myScheduleEntry2);

        //Test the method
        int returnValue = mySchedule.calculateCredits(Semester.FALL, year2);

        // Output
        String outputString1 = scheduleCommons.generateStateString(mySchedule);

        System.out.println("Return value: " + returnValue + "\n");
        System.out.println("Schedule:");
        System.out.println(outputString1);

    }
}
