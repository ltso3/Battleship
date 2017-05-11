// CS 230 Final Project
// Riann, Lauren, Kalau
// Class creates popup inform player that they have won
// Class written by Kalau

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class WinnerPopup extends JPanel{
  private JPanel text1, text2, btns;
  private JButton again, done;
  private PlayBattleship game;
  private BattleshipGUI b;
  
  public WinnerPopup(PlayBattleship game, BattleshipGUI b) {
    
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setBackground(new Color(197, 204, 208));
    
    // Initialize instance variables
    text1 = new JPanel();
    text2 = new JPanel();
    btns = new JPanel();
    again = new JButton("Play Again");
    done = new JButton("I'm Done");
    
    // Create labels
    JLabel l1 = new JLabel("Congratulations!");
    l1.setFont(new Font("Russo One",Font.PLAIN, 36));
    JLabel l2 = new JLabel("YOU WON");
    l2.setFont(new Font("Russo One",Font.BOLD, 60));
    l2.setForeground(Color.blue);
    
    // Edit buttons
    again.setBackground(new Color(94, 197, 110));
    again.setOpaque(true);
    again.setBorder(BorderFactory.createLineBorder(Color.black));
    again.setPreferredSize(new Dimension(110, 50));
    again.addActionListener(new ButtonListener());
    done.setBackground(new Color(94, 197, 110));
    done.setOpaque(true);
    done.setBorder(BorderFactory.createLineBorder(Color.black));
    done.setPreferredSize(new Dimension(110, 50));
    done.addActionListener(new ButtonListener());
    
    // Add labels and buttons and format
    text1.setBackground(new Color(197, 204, 208));
    text2.setBackground(new Color(197, 204, 208));
    text1.add(l1);
    text2.add(l2);
    btns.add(again);
    btns.add(Box.createRigidArea(new Dimension(10,0)));
    btns.add(done);
    btns.setBackground(new Color(197, 204, 208));
    add(text1);
    add(text2);
    add(btns);
  }
  
  private class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      if (event.getSource() == done) 
        System.exit(0); 
      if (event.getSource() == again)  {
        resetGUIandGame();
      }
    }
    
    private void resetGUIandGame() {
      b = new BattleshipGUI();
      
      //get a new game to start again
      game = new PlayBattleship(); 
    }
  } // end of buttonListener inner class
}