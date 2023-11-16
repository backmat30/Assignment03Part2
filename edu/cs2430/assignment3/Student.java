package edu.cs2430.assignment3;

public class Student {
    private int id;
    private static final int MAX_SCHEDULES = 5;
    private String name;
    private static int nextStudentID = 1;
    private int scheduleIndex;
    private Schedule[] schedules;

    public Student(String name){
        id = nextStudentID++;
        this.name = name;
        schedules = new Schedule[MAX_SCHEDULES];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Schedule[] getSchedules() {
        return schedules;
    }

    public void setSchedules(Schedule[] schedules) {
        this.schedules = schedules;
    }
}