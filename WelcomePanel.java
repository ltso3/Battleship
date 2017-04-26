//********************************************************************
// CS230 Final Project
//
// WelcomePanel.java       CS230 Staff
//
//********************************************************************

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.applet.AudioClip;
import java.net.URL;

public class WelcomePanel extends JPanel {
  private JButton start;
  private AudioClip song;
  
  public WelcomePanel() {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Sets panel layout to BoxLayout vertically
    JPanel coverPic = new JPanel();
    JLabel cover = new JLabel(new ImageIcon("battleshipCover.png"));
    coverPic.add(cover);
    add(coverPic);
    
    JPanel button = new JPanel();
    start = new JButton("Start");
    start.setPreferredSize(new Dimension(100,50));
    start.setSize(100, 100);
    start.addActionListener(new ButtonListener());
    button.add(start);
    add(button);
    
    URL url1 = null; 
    
    try {
      URL u1 = new URL ("file", "/Users/christinetso/Desktop/CS230/Final%20Project/", "GameOfThrones.wav");
      System.out.println(u1);
      song = JApplet.newAudioClip(u1);
    }
    catch(Exception e) {
      System.out.println(e);
    }
  }

  private class ButtonListener implements ActionListener {
    public void actionPerformed (ActionEvent event) {
      if(event.getSource() == start)
        song.play();
      System.out.println(song);
    }
  }
}