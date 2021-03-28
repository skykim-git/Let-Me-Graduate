package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoadStartPanel extends JPanel {
    JFrame frame;
    JPanel panel;
    JButton infoButton1;
    JButton infoButton2;
    JButton loadButton;
    JButton saveButton;

    public LoadStartPanel(LetMeGraduate letMeGraduate) {
        frame = new JFrame("Load or Start a New Game");
        panel = new JPanel();
        panel.setBounds(50, 50, 300, 300);
        panel.setBackground(Color.BLACK);

        infoButton1 = new JButton("Press Load or New to start the game");
        infoButton1.setBounds(30, 30, 30, 30);
        infoButton1.setBackground(Color.blue);


        infoButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("not that button");
            }
        });

//        infoButton2 = new JButton("After pressing, enter 'a' to progress");
//        infoButton2.setBounds(30, 30, 20, 20);
//        infoButton2.setBackground(Color.blue);
//
//        infoButton2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("not that button");
//            }
//        });

        // changes field selectionRun... so makes minimum change.
        loadButton = new JButton("Load");
        loadButton.setBounds(30, 30, 20, 20);
        loadButton.setBackground(Color.blue);

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letMeGraduate.setSelection("l");
                System.out.println("You choose to load!");
                System.out.println("enter 'a' to progress");
            }
        });

        saveButton = new JButton("New");
        saveButton.setBounds(30, 30, 20, 20);
        saveButton.setBackground(Color.blue);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letMeGraduate.setSelection("n");
                System.out.println("You choose to create a new game!");
                System.out.println("enter 'a' to progress");
            }
        });

        panel.add(infoButton1);
//        panel.add(infoButton2);
        panel.add(loadButton);
        panel.add(saveButton);
//        panel.add(stu2Label);
//        panel.add(stu3Label);

        frame.add(panel);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);






    }




}
