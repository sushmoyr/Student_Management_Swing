package main.ui;

import main.logic.Model;
import main.logic.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRecord extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel buttonpanel;
    private JPanel bodyPanel;
    private JTextField nameT;
    private JTextField idT;
    private JTextField sectionT;
    private JTextField semesterT;

    public AddRecord() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        String name = nameT.getText();
        String id = idT.getText();
        String section = sectionT.getText();
        String semester = semesterT.getText();

        if(isValidInput(name, id, section, semester))
        {
            EventQueue.invokeLater(() -> {
                Student student = new Student(name, id, section, semester);
                new Model().insertData(student);
            });
            dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please fill all");
        }
    }

    private boolean isValidInput(String name, String id, String section, String semester) {
        if(name.isEmpty() || id.isEmpty() || section.isEmpty() || semester.isEmpty())
            return false;
        return true;
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        AddRecord dialog = new AddRecord();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
