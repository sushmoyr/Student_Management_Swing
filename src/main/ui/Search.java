package main.ui;

import main.logic.Model;
import main.logic.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class Search extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JRadioButton searchByNameRadioButton;
    private JRadioButton searchByIdRadioButton;
    private JTextField query;
    private JButton searchButton;
    private JPanel result;
    private JLabel roll;
    private JLabel section;
    private JLabel semester;
    private JLabel name;
    private JLabel phy1;
    private JLabel phy2;
    private JLabel cse1;
    private JLabel cse2;
    private JLabel math1;
    private JLabel cgpa;
    private ArrayList<Student> students = new ArrayList<>();
    private Model model = new Model();

    public Search() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        students = model.getStudents();

        //Initial radio button
        searchByNameRadioButton.setSelected(true);
        searchByIdRadioButton.setSelected(false);
        result.setVisible(false);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String text;
                int selection;
                text = query.getText();
                if(searchByNameRadioButton.isSelected())
                    selection = 0;
                else
                    selection = 1;
                searchItem(text, selection);
            }
        });
        searchByNameRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                searchByIdRadioButton.setSelected(!searchByNameRadioButton.isSelected());
            }
        });

        searchByIdRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                searchByNameRadioButton.setSelected(!searchByIdRadioButton.isSelected());
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    public void searchItem(String text, int selection)
    {
        if(text.isEmpty())
            JOptionPane.showMessageDialog(null, "Field can't be empty");
        else
        {
            if(selection==0)
            {
                //search by name
                boolean found=false;
                for(var i:students)
                {
                    if(i.getName().contains(text))
                    {
                        found = true;
                        displaySearchResult(i);
                        break;
                    }
                }
                if(!found)
                    JOptionPane.showMessageDialog(null,"Result Not Found!! Try Again");
            }
            else
            {
                //search by id
                boolean found=false;
                for(var i:students)
                {
                    if(i.getRoll().contains(text))
                    {
                        found = true;
                        displaySearchResult(i);
                        break;
                    }
                }
                if(!found)
                    JOptionPane.showMessageDialog(null,"Result Not Found!! Try Again");
            }
        }
    }

    private void displaySearchResult(Student student)
    {
        result.setVisible(true);
        name.setText(student.getName());
        roll.setText(student.getRoll());
        section.setText(student.getSection());
        semester.setText(student.getSemester());
        phy1.setText(Double.toString(student.getPhy1()));
        phy2.setText(Double.toString(student.getPhy2()));
        cse1.setText(Double.toString(student.getCse1()));
        cse2.setText(Double.toString(student.getCse2()));
        math1.setText(Double.toString(student.getMath1()));
        cgpa.setText(Double.toString(student.getCgpa()));
    }

    public static void main(String[] args) {
        Search dialog = new Search();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);

    }
}
