package ui;

import model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// gui class for showing options to add students, to show only students with personal project time more than 3
// and display original students.
public class StudentSelectionPanel extends JPanel {
    JFrame frame;
    JPanel panel;
    LetMeGraduate letMeGraduate;
    JButton infoButton1;
    JButton infoButton2;
    JButton showPersonalMoreThan3;
    JButton add0Button;
    JLabel stu1Label;
    JLabel stu2Label;
    JLabel stu3Label;
    Image student1;
    Image student2;
    Image student3;


    public StudentSelectionPanel(LetMeGraduate letMeGraduate) {
        frame = new JFrame("Student Selection");
        panel = new JPanel();
        this.letMeGraduate = letMeGraduate;
        panel.setBounds(50, 50, 300, 300);
        panel.setBackground(Color.BLACK);

        this.setAdd0Button();
        this.setInfoButton1();
        this.setInfoButton2();
        this.setShowPersonalMoreThan3();
        this.setStudent1();
        this.setStudent2();
        this.setStudent3();

        panel.add(infoButton1);
        panel.add(infoButton2);
        panel.add(add0Button);
        panel.add(stu1Label);
        panel.add(stu2Label);
        panel.add(stu3Label);
        panel.add(showPersonalMoreThan3);

        frame.add(panel);
        //frame.pack();
        //frame.add(stuLabel);
        frame.setSize(430, 600);

        //frame.setLayout(null);
        frame.setVisible(true);

    }

    // MODIFIES : this
    // EFFECTS  : initializes infoButton1, if clicked, display "not that button"
    public void setInfoButton1() {
        //infoButton1
        infoButton1 = new JButton("Click the number of student you want to add");
        infoButton1.setBounds(30, 30, 20, 20);
        infoButton1.setBackground(Color.blue);

        infoButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("not that button");
            }
        });
    }

    // MODIFIES : this
    // EFFECTS  : initializes infoButton2
    public void setInfoButton2() {
        String stuString = "Original Students: ";
        for (Student s : letMeGraduate.getStuList().getStuList()) {
            String name = s.getName();
            stuString = stuString + "  " +  name;
        }

        JLabel stuLabel = new JLabel(stuString);
        stuLabel.setBounds(30,300,110,110);
        stuLabel.setBackground(Color.CYAN);

        infoButton2 = new JButton(stuString);
        infoButton2.setBounds(30, 30, 20, 20);
    }


    // MODIFIES : this
    // EFFECTS  : initializes add0Button, if clicked, add no one and display "0 button pressed, press 'a' to continue"
    public void setAdd0Button() {
        //add 0

        add0Button = new JButton("I'm fine with my teammates");
        add0Button.setBounds(30, 30, 20, 20);
        add0Button.setBackground(Color.blue);

        add0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("0 button pressed, press 'a' to continue");
            }
        });
    }

    // MODIFIES : this, letMeGraduate
    // EFFECTS  : initializes stu1Label, if clicked, add a student and display "1 button pressed, press 'a' to continue"
    public void setStudent1() {
        //student 1

        student1 = new ImageIcon(this.getClass()
                .getResource("/data/student1.png"))
                .getImage();
        student1 = student1.getScaledInstance(80,80, Image.SCALE_SMOOTH);
        ImageIcon stu1imageIcon = new ImageIcon(student1);

        stu1Label = new JLabel(stu1imageIcon);
        stu1Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("1 button pressed, press 'a' to continue");
                letMeGraduate.putNewStudent1();
                System.out.println(letMeGraduate.getStuList().getStuList().size());
            }
        });
    }


    // MODIFIES : this, letMeGraduate
    // EFFECTS  : initializes stu2Label, if clicked add2 students and display "2 button pressed, press 'a' to continue"
    public void setStudent2() {
        //student2

        student2 = new ImageIcon(this.getClass()
                .getResource("/data/student2.png"))
                .getImage();
        student2 = student2.getScaledInstance(80,80, Image.SCALE_SMOOTH);
        ImageIcon stu2imageIcon = new ImageIcon(student2);

        stu2Label = new JLabel(stu2imageIcon);
        stu2Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("2 button pressed, press 'a' to continue");
                letMeGraduate.putNewStudent1();
                letMeGraduate.putNewStudent2();
                System.out.println(letMeGraduate.getStuList().getStuList().size());
            }
        });
    }

    // MODIFIES : this, letMeGraduate
    // EFFECTS  : initializes stu3Label, if clicked add 3 studentsand display "3 button pressed, press 'a' to continue"
    public void setStudent3() {
        //student3

        student3 = new ImageIcon(this.getClass()
                .getResource("/data/student3.png"))
                .getImage();
        student3 = student3.getScaledInstance(80,80, Image.SCALE_SMOOTH);
        ImageIcon stu3imageIcon = new ImageIcon(student3);

        stu3Label = new JLabel(stu3imageIcon);

        stu3Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("3pressed, press 'a' to continue");
                letMeGraduate.putNewStudent1();
                letMeGraduate.putNewStudent2();
                letMeGraduate.putNewStudent3();
                System.out.println(letMeGraduate.getStuList().getStuList().size());
            }
        });
    }

    // MODIFIES : this
    // EFFECTS  : initializes showPersonalMoreThan3 button
    //          : if clicked, show the Students with the time to work on PersonalTask is more than 3
    public void setShowPersonalMoreThan3() {
        //showPersonalMoreThan3
        showPersonalMoreThan3 = new JButton("Show Students With time to work on PersonalTasks is More Than 3");
        showPersonalMoreThan3.setBounds(30, 30, 20, 20);

        showPersonalMoreThan3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String printMe = "Over 3 are: ";
                for (Student s : letMeGraduate.getStuList().getStuList()) {
                    printMe = printMe + " " + s.getName();
                }
                System.out.println(printMe);
            }
        });
    }
}
