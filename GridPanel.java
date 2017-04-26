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
  
  public GridPanel() {
    setLayout(new GridLayout(11, 11, 0, 0)); // Sets panel layout to BoxLayout vertically
    String[] letters = {"A","B","C","D","E","F","G","H","I","J"};
    int rowCounter = 0;
    int colCounter = 1;
    for(int i = 0; i < 121; i++) {
      String label = "";
      if(i > 0 && i < 11) {
        label = letters[rowCounter];
        rowCounter++;
        //change type of buttons so labels cannot be accessed
      }
      else if(i > 0 && i % 11 == 0) {
        label = Integer.toString(colCounter);
        colCounter++;
      }
      add(new JButton(String.valueOf(label)));
    }
  }
  
  private class ButtonListener implements ActionListener {
    public void actionPerformed (ActionEvent event) {
      
      
    }
  }
}