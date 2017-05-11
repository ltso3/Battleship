// CS 230 Final Project
// Riann, Lauren, Kalau
// Class creates panel informing player that computer has missed them
// Class written by Kalau

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ComputerMiss extends JPanel{
  private JPanel text1, text2, text3, btns, cm;
  private JButton ok;
  private JFrame f;
  private String coord;
  
  public ComputerMiss(JFrame f, String coord) {
    this.f = f;
    cm = this;
    this.coord = coord;
    
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setBackground(new Color(197, 204, 208));
    
    // Initialize instance variables
    text1 = new JPanel();
    text2 = new JPanel();
    text3 = new JPanel();
    btns = new JPanel();
    ok = new JButton("OK");
    
    // Create labels
    JLabel l1 = new JLabel("It's the computer's turn");
    l1.setFont(new Font("Russo One",Font.PLAIN, 25));
    JLabel l2 = new JLabel("Coordinate: [" + coord + "]");
    l2.setFont(new Font("Russo One", Font.PLAIN, 36));
    JLabel l3 = new JLabel("MISS");
    l3.setFont(new Font("Russo One",Font.BOLD, 60));
    l3.setForeground(Color.WHITE);
    
    // Edit buttons
    ok.setBackground(new Color(94, 197, 110));
    ok.setOpaque(true);
    ok.setBorder(BorderFactory.createLineBorder(Color.black));
    ok.setPreferredSize(new Dimension(110, 50));
    ok.addActionListener(new ButtonListener());
    
    // Add labels and buttons and format
    text1.setBackground(new Color(197, 204, 208));
    text2.setBackground(new Color(197, 204, 208));
    text3.setBackground(new Color(197, 204, 208));
    text1.add(l1);
    text2.add(l2);
    text3.add(l3);
    btns.add(ok);
    btns.setBackground(new Color(197, 204, 208));
    add(text1);
    add(text2);
    add(text3);
    add(btns);
  }
  
  private class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      invalidate();
      setVisible(false);    
      f.getContentPane().remove(cm);
      f.setVisible(false);
    }
  }
}