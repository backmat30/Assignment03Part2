package edu.cs2430.test.courseplanningsystem;

import edu.cs2430.assignment3.*;
import edu.cs2430.test.schedule.ScheduleCommons;

// public Schedule[] getSchedulesByStudentId(int studentId)

// Prerequisites:
// Course Constructor tests
// ScheduleEntry Constructor tests
// Student Constructor tests
// CoursePlanningSystem Constructor tests
// CoursePlanningSystem AddScheduleTest1
public class CoursePlanningSystemGetSchedulesByStudentIdTest1
{
    public static void main(String[] args) throws IllegalAccessException
    {
        CoursePlanningSystemCommons coursePlanningSystemCommons = new CoursePlanningSystemCommons();
        ScheduleCommons scheduleCommons = new ScheduleCommons();

        CoursePlanningSystem setCoursePlanningSystem = new CoursePlanningSystem();

        // Test input
        int setStudent1Id = 1;
        int setStudent2Id = 2;

        Schedule setSchedule1 = new Schedule(setStudent1Id);
        Schedule setSchedule2 = new Schedule(setStudent1Id);
        Schedule setSchedule3 = new Schedule(setStudent2Id);

        Semester setSemester1 = Semester.SPRING;
        int setYear1 = 2023;
        String setCourse1Name = "Object-Oriented Analysis and Design";
        int setCourse1Number = 3430;
        Program setCourse1Program = Program.SOFTWARE_ENGINEERING;
        int setCourse1Credits = 3;
        Course setCourse1 = new Course(setCourse1Name, setCourse1Number, setCourse1Program, setCourse1Credits);
        ScheduleEntry setScheduleEntry1 = new ScheduleEntry(setSemester1, setYear1, setCourse1);

        Semester setSemester2 = Semester.SPRING;
        int setYear2 = 2023;
        String setCourse2Name = "Introduction to Software Engineering";
        int setCourse2Number = 2730;
        Program setCourse2Program = Program.SOFTWARE_ENGINEERING;
        int setCourse2Credits = 3;
        Course setCourse2 = new Course(setCourse2Name, setCourse2Number, setCourse2Program, setCourse2Credits);
        ScheduleEntry setScheduleEntry2 = new ScheduleEntry(setSemester2, setYear2, setCourse2);

        Semester setSemester3 = Semester.SPRING;
        int setYear3 = 2023;
        String setCourse3Name = "Database Design and Implementation";
        int setCourse3Number = 3630;
        Program setCourse3Program = Program.COMPUTER_SCIENCE;
        int setCourse3Credits = 3;
        Course setCourse3 = new Course(setCourse3Name, setCourse3Number, setCourse3Program, setCourse3Credits);
        ScheduleEntry setScheduleEntry3 = new ScheduleEntry(setSemester3, setYear3, setCourse3);

        setSchedule1.addScheduleEntry(setScheduleEntry1);
        setSchedule2.addScheduleEntry(setScheduleEntry2);
        setSchedule3.addScheduleEntry(setScheduleEntry3);

        setCoursePlanningSystem.addSchedule(setSchedule1);
        setCoursePlanningSystem.addSchedule(setSchedule2);
        setCoursePlanningSystem.addSchedule(setSchedule3);

        // Test method with test input
        Schedule[] returnValue = setCoursePlanningSystem.getSchedulesByStudentId(setStudent1Id);

        // Verify the output -> Output the information to a file and compare string output
        String outputString = coursePlanningSystemCommons.generateStateString(setCoursePlanningSystem);

        System.out.println("Returned Schedules:\n");

        for (Schedule schedule : returnValue)
        {
            String scheduleString = scheduleCommons.generateStateString(schedule);
            System.out.println(scheduleString);
            System.out.println();
        }

        System.out.println("Course Planning System:");
        System.out.println(outputString);
    }
}
