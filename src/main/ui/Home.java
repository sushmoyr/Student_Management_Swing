package main.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {
    private JPanel mainWindow;
    private JPanel mainbar;
    private JButton homeButton;
    private JButton addButton;
    private JButton quit;
    private JButton searchResult;

    public Home() {
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view();
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add();
            }
        });
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        searchResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search();
            }
        });
    }

    private void search()
    {
        EventQueue.invokeLater(()-> {
            Search search = new Search();
            search.setVisible(true);
        });
    }


    private void add(){
        EventQueue.invokeLater(() -> {
            AddRecord addRecord = new AddRecord();
            addRecord.setVisible(true);
        });
    }

    private void view()
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                AllStudents allStudents = new AllStudents();
            }
        });
    }



    public JPanel getWindow()
    {
        return this.mainWindow;
    }



}
