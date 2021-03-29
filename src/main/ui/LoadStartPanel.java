package ui;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

// gui class for giving options to load or start a new game when the game starts.
public class LoadStartPanel extends JPanel {
    JFrame frame;
    JPanel panel;
    JButton infoButton1;
    JButton loadButton;
    JButton saveButton;
    LetMeGraduate letMeGraduate;

    public LoadStartPanel(LetMeGraduate letMeGraduate) {
        frame = new JFrame("Load or Start a New Game");
        panel = new JPanel();
        this.letMeGraduate = letMeGraduate;
        panel.setBounds(50, 50, 300, 300);
        panel.setBackground(Color.BLACK);

        //setInfoButton1
        this.setInfoButton1();
        this.setLoadButton();
        this.setSaveButton();
        //setSaveButton


        panel.add(infoButton1);
        panel.add(loadButton);
        panel.add(saveButton);

        frame.add(panel);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    // MODIFIES : this
    // EFFECTS  : initializes infoButton1, if clicked, display "not that button"
    public void setInfoButton1() {
        infoButton1 = new JButton("Press Load or New to start the game");
        infoButton1.setBounds(30, 30, 30, 30);
        infoButton1.setBackground(Color.blue);


        infoButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("not that button");
            }
        });
    }

    // MODIFIES : this, letMeGraduate
    // EFFECTS  : initializes loadButton, if clicked, letMeGraduate loads game.
    public void setLoadButton() {
        // changes field selectionRun... so makes minimum change.
        loadButton = new JButton("Load");
        loadButton.setBounds(30, 30, 20, 20);
        loadButton.setBackground(Color.blue);

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letMeGraduate.setSelection("l");
                playMusic("/Users/friday/IdeaProjects/project_g5b3mphase3/src/main/data/sounds/"
                        + "load game sound.wav");
                System.out.println("You choose to load!");
                System.out.println("enter 'a' to progress");
            }
        });
    }

    // MODIFIES : this, letMeGraduate
    // EFFECTS  : initializes saveButton , if clicked, letMeGraduate saves game.
    public void setSaveButton() {
        saveButton = new JButton("New");
        saveButton.setBounds(30, 30, 20, 20);
        saveButton.setBackground(Color.blue);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letMeGraduate.setSelection("n");
                playMusic("/Users/friday/IdeaProjects/project_g5b3mphase3/src/main/data/sounds/"
                        + "new game sound.wav");
                System.out.println("You choose to create a new game!");
                System.out.println("enter 'a' to progress");
            }
        });
    }

    //EFFECTS: play sound given the filepath
    public static void playMusic(String filepath) {
        InputStream music;
        try {
            music = new FileInputStream(new File(filepath));
            AudioStream audios = new AudioStream(music);
            AudioPlayer.player.start(audios);

        } catch (Exception e) {
            System.out.println("Wrong input");
        }

    }




}
