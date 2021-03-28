package ui;

import model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentSelectionPanel extends JPanel {
    JFrame frame;
    JPanel panel;
    JButton choose0;
    Image student1;
    JButton choose2;
    JButton choose3;
    JButton choose4;
    Boolean progressOkay;

    public StudentSelectionPanel(LetMeGraduate letMeGraduate) {
        frame = new JFrame("Student Selection");
        panel = new JPanel();
        progressOkay = false;
        panel.setBounds(50, 50, 300, 300);
        panel.setBackground(Color.BLACK);

        choose0 = new JButton("Click the number of student you want to add");
        choose0.setBounds(30, 30, 20, 20);
        choose0.setBackground(Color.blue);

        choose0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("not that button");
            }
        });

        choose2 = new JButton("When done, press 'a' to progress");
        choose2.setBounds(30, 60, 20, 20);
        choose2.setBackground(Color.blue);

        student1 = new ImageIcon(this.getClass()
                .getResource("/data/student1.png"))
                .getImage();
        student1 = student1.getScaledInstance(50,50, Image.SCALE_SMOOTH);
        ImageIcon stu1imageIcon = new ImageIcon(student1);

        JLabel stu1Label = new JLabel(stu1imageIcon);
        stu1Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("halajl");
                letMeGraduate.putNewStudent1();
                System.out.println(letMeGraduate.getStuList().getStuList().size());
                progressOkay = true;
            }
        });
        panel.add(choose0);
        panel.add(choose2);
        panel.add(stu1Label);
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public boolean getProgressOkay() {
        return this.progressOkay;
    }



    //public static void main(String args[]) {
    //    new StudentSelectionPanel();
    //}
}
