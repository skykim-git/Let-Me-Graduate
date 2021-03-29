package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


// gui class for giving options to save or end a game when game ends.
public class SaveEndPanel extends JPanel {

    JFrame frame;
    JPanel panel;
    JButton infoButton1;
   // JButton infoButton2;
    JButton saveButton;
    JButton endButton;

    LetMeGraduate letMeGraduate;


    public SaveEndPanel(LetMeGraduate letMeGraduate) {

        frame = new JFrame("Save before ending?");
        panel = new JPanel();
        this.letMeGraduate = letMeGraduate;
        panel.setBounds(50, 50, 300, 300);
        panel.setBackground(Color.BLACK);

        //setInfoButton1
        this.setInfoButton1();
        //setSaveButton
        this.setSaveButton();
        //setEndButton
        this.setEndButton();



        panel.add(infoButton1);
        panel.add(saveButton);
        panel.add(endButton);


        frame.add(panel);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);


    }

    // MODIFIES : this
    // EFFECTS  : initializes infoButton1, if clicked, display "not that button"
    public void setInfoButton1() {
        infoButton1 = new JButton("Press Yes to save or No to end game");
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
    // EFFECTS  : initializes saveButton , if clicked, letMeGraduate saves game.
    public void setSaveButton() {
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
    }

    // MODIFIES : this
    // EFFECTS  : initializes endButton , if clicked, ends game
    public void setEndButton() {
        endButton = new JButton("No");
        endButton.setBounds(30, 30, 20, 20);
        endButton.setBackground(Color.blue);

        endButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Progress not saved! Bye!");
            }
        });
    }
}
