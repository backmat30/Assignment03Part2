package edu.cs2430.assignment3;

import java.util.UUID;

import edu.cs2430.test.scheduleentry.ScheduleEntryGetYearTest1;

public class CoursePlanningSystem {
    private static final int ARRAY_MAX = 1000;
    private int courseIndex;
    private Course[] courses;
    private int scheduleIndex;
    private Schedule[] schedules;
    private int studentIndex;
    private Student[] students;

    public CoursePlanningSystem() {
        courses = new Course[ARRAY_MAX];
        schedules = new Schedule[ARRAY_MAX];
        students = new Student[ARRAY_MAX];
    }

    public boolean addCourse(Course course) {
        if (courseIndex < ARRAY_MAX) {
            courses[courseIndex++] = course;
            return true;
        }
        return false;
    }

    public boolean addSchedule(Schedule schedule) {
        if (scheduleIndex < ARRAY_MAX) {
            schedules[scheduleIndex++] = schedule;
            return true;
        }
        return false;
    }

    public boolean addScheduleByScheduleUuid(UUID scheduleUuid, ScheduleEntry scheduleEntry) {
        return (getScheduleByUuid(scheduleUuid) != null && getScheduleByUuid(scheduleUuid).addScheduleEntry(scheduleEntry));
    }

    public boolean addStudent(Student student) {
        if (studentIndex < ARRAY_MAX) {
            students[studentIndex++] = student;
            return true;
        }
        return false;
    }

    public Course getCourse(int courseNumber, Program program) {
        for (Course course : courses) {
            if (course != null && course.getNumber() == courseNumber && course.getProgram() == program) {
                return course;
            }
        }
        return null;
    }

    public Course[] getCourses() {
        return courses;
    }

    public Schedule getScheduleByUuid(UUID uuid) {
        for (Schedule schedule : schedules) {
            if (schedule != null && schedule.getUuid().equals(uuid)) {
                return schedule;
            }
        }
        return null;
    }

    public Schedule[] getSchedulesByStudentId(int studentId) {
        Schedule[] studentSchedules = new Schedule[0];
        for (Schedule schedule : schedules) {
            if (schedule != null && schedule.getStudentId() == studentId) {
                Schedule[] tempSchedules = new Schedule[studentSchedules.length + 1];
                for(int i = 0; i < studentSchedules.length; i++){
                    tempSchedules[i] = studentSchedules[i];
                }
                studentSchedules = tempSchedules.clone();
                studentSchedules[studentSchedules.length - 1] = schedule;
            }
        }

        return studentSchedules;
    }

    public Student getStudent(int studentID) {
        for (Student student : students) {
            if(student != null && student.getId() == studentID){
                return student;
            }
        }
        return null;
    }

    public Student[] getStudents(){
        return students;
    }

    public boolean removeCourse(int courseNumber, Program program){
        boolean removed = false;
        for(int i = 0; i < courseIndex - 1; i++){
            if(courses[i].getNumber() == courseNumber && courses[i].getProgram() == program){
                removed = true;
            }
            if(removed){
                courses[i] = courses[i + 1];
            }
        }
        if(removed || (courses[courseIndex - 1].getNumber() == courseNumber && courses[courseIndex - 1].getProgram() == program)){
            removed = true;
            courses[--courseIndex] = null;
        }
        return removed;
    }

    public void removeCourseEntry(int index){
        if(index < courseIndex){
            for (int i = index; i < courseIndex - 1; i++) {
                courses[i] = courses[i + 1];
            }
            courses[--courseIndex] = null;
        }
    }

    public void removeSchedule(int index){
        if(index < scheduleIndex){
            for (int i = index; i < scheduleIndex - 1; i++) {
                schedules[i] = schedules[i + 1];
            }
            schedules[--scheduleIndex] = null;
        }
    }

    public boolean removeSchedule(UUID uuid){
        boolean removed = false;
        for(int i = 0; i < scheduleIndex - 1; i++){
            if(schedules[i].getUuid().equals(uuid)){
                removed = true;
            }
            if(removed){
                schedules[i] = schedules[i + 1];
            }
        }
        if(removed || (schedules[scheduleIndex - 1].getUuid().equals(uuid))){
            removed = true;
            schedules[--scheduleIndex] = null;
        }
        return removed;
    }

    public boolean removeScheduleEntryByScheduleUuid(UUID scheduleUuid, ScheduleEntry scheduleEntry){
        return (getScheduleByUuid(scheduleUuid) != null && getScheduleByUuid(scheduleUuid).removeScheduleEntry(scheduleEntry.getUuid()));
    }

    public boolean removeStudent(int studentId){
         boolean removed = false;
        for(int i = 0; i < studentIndex - 1; i++){
            if(students[i].getId() == studentId){
                removed = true;
            }
            if(removed){
                students[i] = students[i + 1];
            }
        }
        if(removed || (students[studentIndex - 1].getId() == studentId)){
            removed = true;
            students[--studentIndex] = null;
        }
        return removed;
    }

    public void removeStudentEntry(int index){
        if(index < studentIndex){
            for (int i = index; i < studentIndex - 1; i++) {
                students[i] = students[i + 1];
            }
            students[--studentIndex] = null;
        }
    }
}
