package main.logic;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Model {
    private static final File datafile = new File("student.db");
    private ArrayList<Student> students = new ArrayList<>();

    public Model() {
        System.out.println(students.size());
        readAll();
        System.out.println("Read all Called");
        System.out.println(students.size());
    }

    public void insertData(Student data)
    {
        checkFile();
        System.out.println("Inserting");
        System.out.println(students.size());
        students.add(data);
        System.out.println(students.size());
        writeAll();
        JOptionPane.showMessageDialog(null, "Data Inserted");
        show();
    }

    private void show()
    {
        for (var i: students)
        {
            i.printInfo();
        }
    }

    private void writeAll()
    {
        try {
            FileOutputStream f = new FileOutputStream(datafile);
            ObjectOutputStream o = new ObjectOutputStream(f);

            for (var i:students)
            {
                o.writeObject(i);
            }

            f.close();
            o.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readAll()
    {
        checkFile();
        students.clear();

        try {
            FileInputStream f = new FileInputStream(datafile);
            ObjectInputStream obj = new ObjectInputStream(f);

            while (f.available()>0)
            {
                Student s = (Student) obj.readObject();
                students.add(s);

            }

            f.close();
            obj.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Read all file size = "+students.size());
        show();
    }

    public ArrayList<Student> getStudents() {
        readAll();
        return students;
    }

    private void checkFile()
    {
        if(!datafile.exists()) {
            try {
                FileOutputStream f = new FileOutputStream(datafile);
                f.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setStudentList(ArrayList<Student> studentList) {
        checkFile();
        try{
            FileOutputStream file = new FileOutputStream(datafile);
            ObjectOutputStream out = new ObjectOutputStream(file);
            System.out.println("Writing doc");
            for (var i:studentList)
            {
                out.writeObject(i);

                i.printAllData();
            }

            file.close();
            out.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
