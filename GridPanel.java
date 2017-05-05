//********************************************************************
// CS230 Final Project
//
// SetupPanel.java       CS230 Staff
//
//********************************************************************

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GridPanel extends JPanel {
  
  private JButton letter;
  private JButton number;
  private JButton normal;
  
  public GridPanel() {
    setLayout(new GridLayout(11, 11, 0, 0)); 
    String[] letters = {"A","B","C","D","E","F","G","H","I","J"};
    int rowCounter = 0;
    int colCounter = 1;
    for(int i = 0; i < 121; i++) {
      String label = "";
      if(i > 0 && i < 11) {
        label = letters[rowCounter];
        letter = new JButton(label);
        add(letter);
        rowCounter++;
        //change type of buttons so labels cannot be accessed
      }
      else if(i > 0 && i % 11 == 0) {
        label = Integer.toString(colCounter);
        number = new JButton(label);
        add(number);
        colCounter++;
      }
      else {
        normal = new JButton();
        normal.addActionListener(new ButtonListener());
        normal.setContentAreaFilled(false);
        add(normal);
      }
    }
  }
  
  private class ButtonListener implements ActionListener {
    public void actionPerformed (ActionEvent event) {
      ((JButton) event.getSource()).setIcon(new ImageIcon("red.gif"));
    }
  }
}