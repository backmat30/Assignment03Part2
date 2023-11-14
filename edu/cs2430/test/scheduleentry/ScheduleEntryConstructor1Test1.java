package edu.cs2430.test.scheduleentry;

// public ScheduleEntry(Semester semester, int year, Course course)

// Prerequisites:
// Course Constructor1 tests
// Course Constructor2 tests

import edu.cs2430.assignment3.Course;
import edu.cs2430.assignment3.Program;
import edu.cs2430.assignment3.ScheduleEntry;
import edu.cs2430.assignment3.Semester;

public class ScheduleEntryConstructor1Test1
{
    public static void main(String[] args) throws IllegalAccessException
    {
        ScheduleEntryCommons scheduleEntryCommons = new ScheduleEntryCommons();

        // Test input
        Semester setSemester = Semester.SPRING;
        int setYear = 2023;

        String setCourseName = "Object-Oriented Analysis and Design";
        int setCourseNumber = 3430;
        Program setCourseProgram = Program.SOFTWARE_ENGINEERING;
        int setCourseCredits = 3;

        Course setCourse = new Course(setCourseName, setCourseNumber, setCourseProgram, setCourseCredits);

        // Test method with test input
        ScheduleEntry newScheduleEntry = new ScheduleEntry(setSemester, setYear, setCourse);

        // Verify the output -> Output the information to a file and compare string output
        String outputString = scheduleEntryCommons.generateStateString(newScheduleEntry);

        System.out.println(outputString);
    }

}
