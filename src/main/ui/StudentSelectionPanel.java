package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentSelectionPanel extends JPanel {
    JFrame frame;
    JPanel panel;
    JButton infoButton1;
    JButton infoButton2;
    Image student1;
    Image student2;
    Image student3;


    public StudentSelectionPanel(LetMeGraduate letMeGraduate) {
        frame = new JFrame("Student Selection");
        panel = new JPanel();
        panel.setBounds(50, 50, 300, 300);
        panel.setBackground(Color.BLACK);

        infoButton1 = new JButton("Click the number of student you want to add");
        infoButton1.setBounds(30, 30, 20, 20);
        infoButton1.setBackground(Color.blue);

        infoButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("not that button");
            }
        });

        infoButton2 = new JButton("When done, press 'a' to progress on the module");
        infoButton2.setBounds(30, 60, 20, 20);
        infoButton2.setBackground(Color.blue);

        //student 1

        student1 = new ImageIcon(this.getClass()
                .getResource("/data/student1.png"))
                .getImage();
        student1 = student1.getScaledInstance(50,50, Image.SCALE_SMOOTH);
        ImageIcon stu1imageIcon = new ImageIcon(student1);

        JLabel stu1Label = new JLabel(stu1imageIcon);
        stu1Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("1pressed");
                letMeGraduate.putNewStudent1();
                System.out.println(letMeGraduate.getStuList().getStuList().size());
            }
        });

        //student2

        student2 = new ImageIcon(this.getClass()
                .getResource("/data/student2.png"))
                .getImage();
        student2 = student2.getScaledInstance(50,50, Image.SCALE_SMOOTH);
        ImageIcon stu2imageIcon = new ImageIcon(student2);

        JLabel stu2Label = new JLabel(stu2imageIcon);
        stu2Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("2pressed");
                letMeGraduate.putNewStudent1();
                letMeGraduate.putNewStudent2();
                System.out.println(letMeGraduate.getStuList().getStuList().size());
            }
        });

        //student3

        student3 = new ImageIcon(this.getClass()
                .getResource("/data/student3.png"))
                .getImage();
        student3 = student3.getScaledInstance(50,50, Image.SCALE_SMOOTH);
        ImageIcon stu3imageIcon = new ImageIcon(student3);

        JLabel stu3Label = new JLabel(stu3imageIcon);
        stu3Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("3pressed");
                letMeGraduate.putNewStudent1();
                letMeGraduate.putNewStudent2();
                letMeGraduate.putNewStudent3();
                System.out.println(letMeGraduate.getStuList().getStuList().size());
            }
        });

        panel.add(infoButton1);
        panel.add(infoButton2);
        panel.add(stu1Label);
        panel.add(stu2Label);
        panel.add(stu3Label);

        frame.add(panel);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);

    }



    //public static void main(String args[]) {
    //    new StudentSelectionPanel();
    //}
}
