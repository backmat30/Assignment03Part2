package edu.cs2430.test.schedule;

import edu.cs2430.assignment3.*;
import edu.cs2430.test.course.CourseCommons;

import java.util.UUID;


// Prerequisites:
// Course CourseConstructor1Test1 test
// ScheduleEntry ScheduleEntryConstructor1Test1 test
// Schedule ScheduleConstructor2Test1 test
// Schedule AddScheduleEntryTest1 test

/**
 * This tests if a specified course is in a schedule. Will return true.
 * @author Christine Patterson
 */
public class ScheduleIsCourseInScheduleTest1
{
    public static void main(String[] args) throws IllegalAccessException
    {
        CourseCommons courseCommons = new CourseCommons();
        ScheduleCommons scheduleCommons = new ScheduleCommons();

        //Create course for first schedule entry
        String setCourseName = "Intermediate Software Engineering";
        int setCourseNumber = 3330;
        Program setCourseProgram = Program.SOFTWARE_ENGINEERING;
        int setCourseCredits = 3;

        Course setCourse = new Course(setCourseName, setCourseNumber, setCourseProgram, setCourseCredits);

        //Create first schedule entry
        UUID setScheduleEntryUuid = UUID.randomUUID();
        Semester setScheduleEntrySemester = Semester.SPRING;
        int setYear = 2023;
        ScheduleEntry newScheduleEntry = new ScheduleEntry(setScheduleEntryUuid, setScheduleEntrySemester, setYear, setCourse);

        //Create course for second schedule entry
        String setCourseName2 = "Object-Oriented Programming";
        int setCourseNumber2 = 2430;
        Program setCourseProgram2 = Program.COMPUTER_SCIENCE;
        int setCourseCredits2 = 3;

        Course setCourse2 = new Course(setCourseName2, setCourseNumber2, setCourseProgram2, setCourseCredits2);

        //Create second schedule entry
        UUID setScheduleEntryUuid2 = UUID.randomUUID();
        Semester setScheduleEntrySemester2 = Semester.SPRING;
        int setYear2 = 2023;
        ScheduleEntry newScheduleEntry2 = new ScheduleEntry(setScheduleEntryUuid2, setScheduleEntrySemester2, setYear2, setCourse2);

        //Create course for third schedule entry
        String setCourseName3 = "Data Structures";
        int setCourseNumber3 = 2730;
        Program setProgram3 = Program.COMPUTER_SCIENCE;
        int setCredits3 = 3;

        Course setCourse3 = new Course(setCourseName3, setCourseNumber3, setProgram3, setCredits3);

        //Create third schedule entry
        UUID setScheduleEntryUuid3 = UUID.randomUUID();
        Semester setScheduleEntrySemester3 = Semester.SPRING;
        int setYear3 = 2023;
        ScheduleEntry newScheduleEntry3 = new ScheduleEntry(setScheduleEntryUuid3, setScheduleEntrySemester3, setYear3, setCourse3);

        //Create schedule
        int studentID = 1116;
        Schedule newSchedule = new Schedule(studentID);

        //Add schedule entries to schedule
        newSchedule.addScheduleEntry(newScheduleEntry);
        newSchedule.addScheduleEntry(newScheduleEntry2);
        newSchedule.addScheduleEntry(newScheduleEntry3);

        //Check if Object-Oriented Programming is in schedule
        boolean returnValue = newSchedule.isCourseInSchedule(setCourse2);

        // Verify the output -> Output the information to a file and compare string output
        String outputString2 = courseCommons.generateStateString(setCourse2);
        String outputString4 = scheduleCommons.generateStateString(newSchedule);

        System.out.println("Return Value: " + returnValue + "\n");

        System.out.println("Course:");
        System.out.println(outputString2);
        System.out.println("\n");

        System.out.println("Schedule:");
        System.out.println(outputString4);
    }
}
