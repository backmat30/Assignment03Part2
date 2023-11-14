package edu.cs2430.test.courseplanningsystem;

import edu.cs2430.assignment3.*;

// public boolean addSchedule(Schedule schedule)

// Prerequisites:
// Course Constructor tests
// ScheduleEntry Constructor tests
// Student Constructor tests
// CoursePlanningSystem Constructor tests
public class CoursePlanningSystemAddScheduleTest1
{
    public static void main(String[] args) throws IllegalAccessException
    {
        CoursePlanningSystemCommons coursePlanningSystemCommons = new CoursePlanningSystemCommons();

        CoursePlanningSystem setCoursePlanningSystem = new CoursePlanningSystem();

        // Test input
        int setStudent1Id = 1;

        Schedule setSchedule1 = new Schedule(setStudent1Id);

        Semester setSemester1 = Semester.SPRING;
        int setYear1 = 2023;
        String setCourse1Name = "Object-Oriented Analysis and Design";
        int setCourse1Number = 3430;
        Program setCourse1Program = Program.SOFTWARE_ENGINEERING;
        int setCourse1Credits = 3;
        Course setCourse1 = new Course(setCourse1Name, setCourse1Number, setCourse1Program, setCourse1Credits);
        ScheduleEntry setScheduleEntry1 = new ScheduleEntry(setSemester1, setYear1, setCourse1);


        setSchedule1.addScheduleEntry(setScheduleEntry1);

        // Test method with test input
        boolean returnValue = setCoursePlanningSystem.addSchedule(setSchedule1);

        // Verify the output -> Output the information to a file and compare string output
        String outputString = coursePlanningSystemCommons.generateStateString(setCoursePlanningSystem);

        System.out.println("Return Value:  " + returnValue + "\n");
        System.out.println("Course Planning System:");
        System.out.println(outputString);
    }
}
