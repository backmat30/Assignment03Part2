package edu.cs2430.assignment3;

import java.util.Arrays;

public class Course {
    private int currentPrerequisiteIndex;

    private static final int MAX_PREREQUISITES = 5;
    private String name;
    private int number;
    private int numberOfCredits;
    private Course[] prerequisiteCourses;
    private Program program;

    public Course(String name, int number, Program program, int numberOfCredits) {
        this(name, number, program, numberOfCredits, new Course[MAX_PREREQUISITES]);
        // setName(name);
        // setNumber(number);
        // setProgram(program);
        // setNumberOfCredits(numberOfCredits);
    }

    public Course(String name, int number, Program program, int numberOfCredits, Course[] prerequisiteCourses) {
        setName(name);
        setNumber(number);
        setProgram(program);
        setNumberOfCredits(numberOfCredits);
        setprerequisiteCourses(prerequisiteCourses);
    }

    public boolean addPrerequisiteCourse(Course prerequisiteCourse) {
        if (validateAddPrerequisiteCourse(prerequisiteCourse)) {
            prerequisiteCourses[currentPrerequisiteIndex] = prerequisiteCourse;
            currentPrerequisiteIndex += 1;
            return true;
        }
        return false;
    }

    public boolean containsPrerequisite(Course prerequisiteCourse) {
        for (Course course : prerequisiteCourses) {
            if (course == null)
                continue;

            if (prerequisiteCourse.equals(course)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsPrerequisiteCycle(Course prerequisiteCourse) {
        if (containsPrerequisite(prerequisiteCourse)) {
            return true;
        }
        for (Course course : prerequisiteCourses) {
            if (course != null && course.containsPrerequisiteCycle(prerequisiteCourse)) {
                return true;
            }
        }
        return false;
    }

    public boolean validateAddPrerequisiteCourse(Course prerequisiteCourse) {
        return !(currentPrerequisiteIndex >= MAX_PREREQUISITES || containsPrerequisite(prerequisiteCourse)
                || containsPrerequisiteCycle(prerequisiteCourse) || equals(prerequisiteCourse) || prerequisiteCourse == null);
    }

    public int getCurrentPrerequisiteIndex() {
        return currentPrerequisiteIndex;
    }

    public void setCurrentPrerequisiteIndex(int currentPrerequisiteIndex) {
        this.currentPrerequisiteIndex = currentPrerequisiteIndex;
    }

    public static int getMaxPrerequisites() {
        return MAX_PREREQUISITES;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    public Course[] getPrerequisiteCourses() {
        return prerequisiteCourses;
    }

    public void setprerequisiteCourses(Course[] prerequisiteCourses) {
        this.prerequisiteCourses = new Course[MAX_PREREQUISITES];
        for (Course course : prerequisiteCourses) {
            if (currentPrerequisiteIndex < MAX_PREREQUISITES && course != null) {
                this.prerequisiteCourses[currentPrerequisiteIndex] = course;
                currentPrerequisiteIndex += 1;
            }

        }
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + currentPrerequisiteIndex;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + number;
        result = prime * result + numberOfCredits;
        result = prime * result + Arrays.hashCode(prerequisiteCourses);
        result = prime * result + ((program == null) ? 0 : program.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Course other = (Course) obj;
        if (currentPrerequisiteIndex != other.currentPrerequisiteIndex)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (number != other.number)
            return false;
        if (numberOfCredits != other.numberOfCredits)
            return false;
        if (!Arrays.equals(prerequisiteCourses, other.prerequisiteCourses))
            return false;
        if (program != other.program)
            return false;
        return true;
    }

}
