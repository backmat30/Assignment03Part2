package edu.cs2430.test.schedule;


import edu.cs2430.assignment3.*;


// Prerequisites:
// Course Constructor tests
// ScheduleEntry Constructor tests
// Schedule Constructor tests

/**
 * This test will calculate the number of credits
 * Requires semester and year as arguments
 * This test has courses in different semesters
 *
 * @author James G. Hickey
 */
public class ScheduleCalculateCreditsSemesterTest2
{

    public static void main(String[] args) throws IllegalAccessException
    {

        ScheduleCommons scheduleCommons = new ScheduleCommons();

        int studentId = 100;
        int year = 2023;
        //Create a schedule
        Schedule mySchedule = new Schedule(studentId);

        //Create the courses necessary
        String setCourseName = "Logic and Digital Design";
        int setCourseNumber = 3780;
        Program setCourseProgram = Program.OTHER;
        int setCourseCredits = 4;

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

        //Add the courses to the schedule

        ScheduleEntry myScheduleEntry = new ScheduleEntry(Semester.FALL, year, newCourse);
        ScheduleEntry myScheduleEntry1 = new ScheduleEntry(Semester.SUMMER, year, newCourse2);
        //This schedule entry is for a different semester
        ScheduleEntry myScheduleEntry2 = new ScheduleEntry(Semester.FALL, year, newCourse3);

        mySchedule.addScheduleEntry(myScheduleEntry);
        mySchedule.addScheduleEntry(myScheduleEntry1);
        mySchedule.addScheduleEntry(myScheduleEntry2);

        //Test the method
        int myCredits = mySchedule.calculateCredits(Semester.SUMMER, year);

        String outputString = scheduleCommons.generateStateString(mySchedule);

        //Printing results
        System.out.println("Return value: " + myCredits + "\n");
        System.out.println("Schedule:");
        System.out.println(outputString);

    }
}

