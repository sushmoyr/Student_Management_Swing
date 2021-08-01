package main.ui;

import main.logic.Model;
import main.logic.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class AllStudents extends JFrame {
    Model model = new Model();

    public AllStudents() {
        ArrayList<Student> students = new ArrayList<>();
        students = model.getStudents();

        if (students.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No data found");
        } else {
            String[] columns = new String[]{
                    "Name", "Roll", "Section", "Semester",
                    "Phy 101", "Phy 102", "CSE 101", "CSE 102", "MATH",
                    "CGPA"
            };

            //actual data for the table in a 2d array
            Object[][] data = new Object[][]{
                    {1, "John", 40.0, false},
                    {2, "Rambo", 70.0, false},
                    {3, "Zorro", 60.0, true},
            };

            Object[][] tableData = new Object[students.size()][10];
            for (int i = 0; i < students.size(); i++) {
                tableData[i][0] = students.get(i).getName();
                tableData[i][1] = students.get(i).getRoll();
                tableData[i][2] = students.get(i).getSection();
                tableData[i][3] = students.get(i).getSemester();
                tableData[i][4] = students.get(i).getPhy1();
                tableData[i][5] = students.get(i).getPhy2();
                tableData[i][6] = students.get(i).getCse1();
                tableData[i][7] = students.get(i).getCse2();
                tableData[i][8] = students.get(i).getMath1();
                tableData[i][9] = students.get(i).getCgpa();
            }

            //create table with data
            JTable table = new JTable(tableData, columns);
            table.setFont(new Font("Open Sans", Font.BOLD, 16));
            table.setRowHeight(36);
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            JTable initialTable = new JTable(tableData,columns);
            JScrollPane jScrollPane = new JScrollPane(table);
            jScrollPane.setPreferredSize(new Dimension(1000,600));
            //add the table to the frame
            this.add(jScrollPane);
            this.setBackground(Color.BLACK);

            this.setTitle("Table Example");
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.pack();
            this.setVisible(true);
            this.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    update(table, initialTable);

                }
            });
        }

    }

    public static void main(String[] args) {

    }

    private void update(JTable table, JTable oldTable) {
        ArrayList<Student> students = new ArrayList<>();
        String name, semester, section, roll;
        double phy1, phy2, cse1, cse2, math1;
        double cgpa;
        String a,b,c,d,e;


        for (int i = 0; i < table.getRowCount(); i++) {
            name = (String) table.getValueAt(i,0);
            roll = (String) table.getValueAt(i,1);
            section = (String) table.getValueAt(i,2);
            semester = (String) table.getValueAt(i,3);

            a = table.getValueAt(i,4).toString();
            b = table.getValueAt(i,5).toString();
            c = table.getValueAt(i,6).toString();
            d = table.getValueAt(i,7).toString();
            e = table.getValueAt(i,8).toString();

            phy1 = Double.parseDouble(a);
            phy2 = Double.parseDouble(b);
            cse1 = Double.parseDouble(c);
            cse2 = Double.parseDouble(d);
            math1 = Double.parseDouble(e);

            /*if(table.getValueAt(i,4)!=oldTable.getValueAt(i,4))
            {
                phy1 = Double.parseDouble((String) table.getValueAt(i,4));
            }
            else
                phy1 = (double) oldTable.getValueAt(i,4);

            if(table.getValueAt(i,4)!=oldTable.getValueAt(i,5))
            {
                phy2 = Double.parseDouble((String) table.getValueAt(i,5));
            }
            else
                phy2 = (double) oldTable.getValueAt(i,5);

            if(table.getValueAt(i,4)!=oldTable.getValueAt(i,6))
            {
                cse1 = Double.parseDouble((String) table.getValueAt(i,6));
            }
            else
                cse1 = (double) oldTable.getValueAt(i,6);

            if(table.getValueAt(i,4)!=oldTable.getValueAt(i,7))
            {
                cse2= Double.parseDouble((String) table.getValueAt(i,7));
            }
            else
                cse2 = (double) oldTable.getValueAt(i,7);

            if(table.getValueAt(i,4)!=oldTable.getValueAt(i,8))
            {
                math1 = Double.parseDouble((String) table.getValueAt(i,8));
            }
            else
                math1 = (double) oldTable.getValueAt(i,8);



            /*phy1 = (double) table.getValueAt(i,4);
            phy2 = (double) table.getValueAt(i,5);
            cse1 = (double) table.getValueAt(i,6);
            cse2 = (double) table.getValueAt(i,7);
            math1 = (double) table.getValueAt(i,8);*/
            Student st = new Student(name, roll, section, semester);
            st.setResult(phy1, phy2, cse1, cse2, math1);
            st.printAllData();
            students.add(st);
        }

        model.setStudentList(students);
    }
}
