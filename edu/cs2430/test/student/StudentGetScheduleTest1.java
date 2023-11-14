package edu.cs2430.test.student;

import edu.cs2430.assignment3.*;
import edu.cs2430.test.schedule.ScheduleCommons;

import java.util.UUID;

// Prerequisites:
// Student Constructor tests
// Schedule Constructor tests
// ScheduleEntry tests
// Course Constructor tests
// Schedule SetSchedule tests

public class StudentGetScheduleTest1
{
    public static void main(String[] args) throws IllegalAccessException
    {
        //This test will retrieve the semester of a schedule entry.
        StudentCommons studentCommons = new StudentCommons();
        ScheduleCommons scheduleCommons = new ScheduleCommons();

        // Test input
        String setStudentName = "Doug Selent";
        Student setStudent = new Student(setStudentName);
        Schedule newSchedule = new Schedule(setStudent.getId());

        UUID setScheduleEntryUuid = UUID.randomUUID();
        Semester setScheduleEntrySemester = Semester.SPRING;
        int setYear = 2023;

        String setCourseName = "Intermediate Software Engineering";
        int setCourseNumber = 3330;
        Program setCourseProgram = Program.SOFTWARE_ENGINEERING;
        int setCourseCredits = 3;

        Course setCourse = new Course(setCourseName, setCourseNumber, setCourseProgram, setCourseCredits);
        ScheduleEntry newScheduleEntry1 = new ScheduleEntry(setScheduleEntryUuid, setScheduleEntrySemester, setYear, setCourse);

        UUID setScheduleEntryUuid2 = UUID.randomUUID();
        Semester setScheduleEntrySemester2 = Semester.FALL;
        int setYear2 = 2020;

        String setCourseName2 = "Algorithms";
        int setCourseNumber2 = 3010;
        Program setCourseProgram2 = Program.COMPUTER_SCIENCE;
        int setCourseCredits2 = 3;

        Course setCourse2 = new Course(setCourseName2, setCourseNumber2, setCourseProgram2, setCourseCredits2);
        ScheduleEntry newScheduleEntry2 = new ScheduleEntry(setScheduleEntryUuid2, setScheduleEntrySemester2, setYear2, setCourse2);

        newSchedule.addScheduleEntry(newScheduleEntry1);
        newSchedule.addScheduleEntry(newScheduleEntry2);

        Schedule[] scheduleArray = {newSchedule};

        setStudent.setSchedules(scheduleArray);

        // Test method
        Schedule[] returnValue = setStudent.getSchedules();

        // Verify the output -> Output the information to a file and compare string output
        String outputString = studentCommons.generateStateString(setStudent);

        System.out.println("Return Value:\n");

        for (Schedule schedule : returnValue)
        {
            String scheduleString = scheduleCommons.generateStateString(schedule);
            System.out.println(scheduleString);
        }

        System.out.println("\n");
        System.out.println("Student:");
        System.out.println(outputString);
    }
}
