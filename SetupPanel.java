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
  private JButton help;
  
  public SetupPanel() {
    setLayout(new BorderLayout()); // Sets panel layout to BoxLayout vertically
    
    add(new GridPanel(), BorderLayout.CENTER);
    
    ships = new JPanel();
	help = new JButton("Need help?");
	help.addActionListener(new ButtonListener());
	ships.add(help);
    add(ships, BorderLayout.SOUTH);
  }

  private class ButtonListener implements ActionListener {
    public void actionPerformed (ActionEvent event) {
    	if (event.getSource() == help) {
    		JFrame frame = new JFrame ("BATTLESHIP"); // Create JFrame for overall structure of GUI
    	    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); // Close GUI upon pressing x

    	    InstructionTab it = new InstructionTab();
    	    frame.getContentPane().add(it);
    	       
    	    frame.pack();
    	    frame.setVisible(true);
    	}
    }
  }
}