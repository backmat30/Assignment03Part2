package edu.cs2430.test.schedule;

import edu.cs2430.assignment3.*;
import edu.cs2430.test.course.CourseCommons;

import java.util.UUID;


// Prerequisites:
// Course CourseConstructor1Test1 test
// Course CourseConstructor2Test1 test
// ScheduleEntry ScheduleEntryConstructor1Test1 test
// Schedule ScheduleConstructor2Test1 test
// Schedule AddScheduleEntryTest1 test

/**
 * This tests the getter method for the courses in schedule with a given semester and year.
 * Three courses are returned for the given semester and year.
 * @author Christine Patterson
 */
public class ScheduleGetCoursesForSemesterTest1
{
    public static void main(String[] args) throws IllegalAccessException
    {
        ScheduleCommons scheduleCommons = new ScheduleCommons();
        CourseCommons courseCommons = new CourseCommons();

        //Create a prerequisite class for a course
        String preCourseName = "Introduction to Computer Programming";
        int preCourseNumber = 1430;
        Program preProgram = Program.COMPUTER_SCIENCE;
        int preCredits = 3;

        Course preCourse = new Course(preCourseName, preCourseNumber, preProgram, preCredits);
        Course[] setPrerequisiteCourses = new Course[2];
        setPrerequisiteCourses[0] = preCourse;

        //Create course for first schedule entry
        String setCourseName = "Intermediate Software Engineering";
        int setCourseNumber = 3330;
        Program setCourseProgram = Program.SOFTWARE_ENGINEERING;
        int setCourseCredits = 3;

        Course setCourse = new Course(setCourseName, setCourseNumber, setCourseProgram, setCourseCredits, setPrerequisiteCourses);

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

        //Get courses for the Semester
        Course[] returnValue = newSchedule.getCoursesForSemester(Semester.SPRING, 2023);

        // Verify the output -> Output the information to a file and compare string output

        String outputString2 = scheduleCommons.generateStateString(newSchedule);
        System.out.println("Return Value: ");

        for (Course course : returnValue)
        {
            String outputString = courseCommons.generateStateString(course);
            System.out.println(outputString);
        }

        System.out.println("\n");
        System.out.println("Schedule:");
        System.out.println(outputString2);
    }
}
