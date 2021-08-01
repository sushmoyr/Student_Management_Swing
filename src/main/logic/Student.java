package main.logic;

import java.io.Serializable;

public class Student implements Serializable {

    private String name, semester, section, roll;
    private double phy1, phy2, cse1, cse2, math1;
    private double cgpa;
    private boolean isResult;

    public Student(String name, String roll, String section, String semester) {
        this.name = name;
        this.section = section;
        this.semester = semester;
        this.roll = roll;
        isResult = false;
    }

    public void updateInfo(String name, String roll, String section, String semester) {
        this.name = name;
        this.section = section;
        this.semester = semester;
        this.roll = roll;
    }

    public void setResult(double a, double b, double c, double d, double e) {
        phy1 = a;
        phy2 = b;
        cse1 = c;
        cse2 = d;
        math1 = e;
        isResult = true;
        calculateCgpa();
    }

    private void calculateCgpa() {
        cgpa = (phy1 + phy2 + cse1 + cse2 + math1) / 5.0;
    }

    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Roll: " + roll);
        System.out.println("Section: "+section);
        System.out.println("Semester: " + semester);
    }

    public void printResult() {
        if (isResult) {
            System.out.println("| Course Name | GPA |");
            System.out.println("  Physics 101:  " + phy1);
            System.out.println("  Physics 102:  " + phy2);
            System.out.println("    CSE 101:    " + cse1);
            System.out.println("    CSE 102:    " + cse2);
            System.out.println("    Math 101:   " + math1);
        } else {
            System.out.println("No result data found for " + name + " (" + roll + ")");
        }
    }

    public void printAllData() {
        printInfo();
        printResult();
        System.out.println("Total CGPA is: " + cgpa);
        System.out.println();
    }


    public double getCgpa() {
        return cgpa;
    }

    //all getters

    public String getName() {
        return name;
    }

    public String getSemester() {
        return semester;
    }

    public String getSection() {
        return section;
    }

    public String getRoll() {
        return roll;
    }

    public double getPhy1() {
        return phy1;
    }

    public double getPhy2() {
        return phy2;
    }

    public double getCse1() {
        return cse1;
    }

    public double getCse2() {
        return cse2;
    }

    public double getMath1() {
        return math1;
    }
}

