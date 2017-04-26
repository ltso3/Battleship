//********************************************************************
// CS230 Final Project
//
// SetupPanel.java       CS230 Staff
//
//********************************************************************

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SetupPanel extends JPanel {
  private JPanel ships;
  
  public SetupPanel() {
    setLayout(new BorderLayout()); // Sets panel layout to BoxLayout vertically
    
    add(new GridPanel(), BorderLayout.CENTER);
    
    ships = new JPanel();
    ships.add(new JButton("Carrier"));
    ships.add(new JButton("Battleship"));
    ships.add(new JButton("Cruiser"));
    ships.add(new JButton("Submarine"));
    ships.add(new JButton("Destroyer"));
    add(ships, BorderLayout.SOUTH);
  }

  private class ButtonListener implements ActionListener {
    public void actionPerformed (ActionEvent event) {
    }
  }
}