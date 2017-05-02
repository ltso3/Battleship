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
import javax.sound.sampled.*;

public class WelcomePanel extends JPanel {
  private JButton start;
  AudioFormat audioFormat;
  AudioInputStream audioInputStream;
  SourceDataLine sourceDataLine;
  boolean stopPlayback = false;
  
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
    start.setEnabled(true);
    start.addActionListener(new ButtonListener());
    button.add(start);
    add(button);
  }
  
  private class ButtonListener implements ActionListener {
    public void actionPerformed (ActionEvent event) {
      start.setEnabled(false);
      playAudio();
    }
  }
  
  private void playAudio() {
    try {
      File soundFile = new File("GameOfThrones.wav");
      audioInputStream = AudioSystem.getAudioInputStream(soundFile);
      audioFormat = audioInputStream.getFormat();
      System.out.println(audioFormat);
      
      DataLine.Info dataLineInfo =  new DataLine.Info(SourceDataLine.class, audioFormat);
      
      sourceDataLine = (SourceDataLine)AudioSystem.getLine(dataLineInfo);
      
      //Create a thread to play back the data and start it running.  It will run until the
      // end of file, or the Stop button is clicked, whichever occurs first.
      // Because of the data buffers involved there will normally be a delay between
      // the click on the Stop button and the actual termination of playback.
      new PlayThread().start();
    }
    catch (Exception e) {
      e.printStackTrace();
      System.exit(0);
    }//end catch
  }//end playAudio
  

//Inner class to play back the data from the
s// audio file.
  class PlayThread extends Thread{
    byte tempBuffer[] = new byte[10000];
    
    public void run(){
      try{
        sourceDataLine.open(audioFormat);
        sourceDataLine.start();
        
        int cnt;
        //Keep looping until the input read method returns -1 for empty stream or the
        // user clicks the Stop button causing stopPlayback to switch from false to
        // true.
        while((cnt = audioInputStream.read(tempBuffer,0,tempBuffer.length)) != -1 && stopPlayback == false){
          if(cnt > 0){
            //Write data to the internal buffer of
            // the data line where it will be
            // delivered to the speaker.
            sourceDataLine.write(tempBuffer, 0, cnt);
          }//end if
        }//end while
        //Block and wait for internal buffer of the
        // data line to empty.
        sourceDataLine.drain();
        sourceDataLine.close();
        
        //Prepare to playback another file
        start.setEnabled(true);
        stopPlayback = false;
      }catch (Exception e) {
        e.printStackTrace();
        System.exit(0);
      }//end catch
    }//end run
  }//end inner class PlayThread
}