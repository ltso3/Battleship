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
  private JPanel grids, ships;
  
  public SetupPanel() {
    setLayout(new BorderLayout()); // Sets panel layout to BoxLayout vertically
    
    grids = new JPanel();
    grids.setLayout(new BoxLayout(grids, BoxLayout.X_AXIS));
    GridPanel g1 = new GridPanel();
    g1.setPreferredSize(new Dimension(400,400));
    grids.add(g1);
    grids.add(Box.createRigidArea(new Dimension(10,0)));
    GridPanel g2 = new GridPanel();
    g2.setPreferredSize(new Dimension(400,400));
    grids.add(g2);
    add(grids, BorderLayout.CENTER);
    
    /*
    ships = new JPanel();
    ships.add(new JButton("Carrier"));
    ships.add(new JButton("Battleship"));
    ships.add(new JButton("Cruiser"));
    ships.add(new JButton("Submarine"));
    ships.add(new JButton("Destroyer"));
    add(ships, BorderLayout.SOUTH);
    */
  }

  private class ButtonListener implements ActionListener {
    public void actionPerformed (ActionEvent event) {
    }
  }
}