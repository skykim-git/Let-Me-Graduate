package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class SaveEndPanel extends JPanel {

    JFrame frame;
    JPanel panel;
    JButton infoButton1;
   // JButton infoButton2;
    JButton saveButton;
    JButton endButton;


    public SaveEndPanel(LetMeGraduate letMeGraduate) {

        frame = new JFrame("Save before ending?");
        panel = new JPanel();
        panel.setBounds(50, 50, 300, 300);
        panel.setBackground(Color.BLACK);

        infoButton1 = new JButton("Press Yes to save or No to end game");
        infoButton1.setBounds(30, 30, 20, 20);
        infoButton1.setBackground(Color.blue);

        infoButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("not that button");
            }
        });

        saveButton = new JButton("Yes");
        saveButton.setBounds(30, 30, 20, 20);
        saveButton.setBackground(Color.blue);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letMeGraduate.saveGame();
                System.out.println("Progress saved! Bye!");
            }
        });

        endButton = new JButton("No");
        endButton.setBounds(30, 30, 20, 20);
        endButton.setBackground(Color.blue);

        endButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Progress not saved! Bye!");
            }
        });

        panel.add(infoButton1);
     //   panel.add(infoButton2);
        panel.add(saveButton);
        panel.add(endButton);
//        panel.add(stu2Label);
//        panel.add(stu3Label);

        frame.add(panel);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);








    }
}
