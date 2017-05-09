import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TargetGridPanel extends JPanel {
  
  private JButton letter;
  private JButton number;
  private JButton normal;
  
  public TargetGridPanel(PlayBattleship game) {
   
    setLayout(new GridLayout(11, 11, 0, 0)); 
    setBackground(new Color(92, 135, 149));
    
    String[] letters = {"A","B","C","D","E","F","G","H","I","J"};
    int rowCounter = 0;
    int colCounter = 1;
    
    for(int i = 0; i < 121; i++) {
      String label = "";
      if(i > 0 && i < 11) {
        label = letters[rowCounter];
        letter = new JButton(label);
        letter.setBackground(new Color(197, 204, 208));
        letter.setOpaque(true);
        letter.setBorder(BorderFactory.createLineBorder(Color.black));
        letter.setPreferredSize(new Dimension(110, 50));
        add(letter);
        rowCounter++;
      }
      else if(i > 0 && i % 11 == 0) {
        label = Integer.toString(colCounter);
        number = new JButton(label);
        number.setBackground(new Color(197, 204, 208));
        number.setOpaque(true);
        number.setBorder(BorderFactory.createLineBorder(Color.black));
        number.setPreferredSize(new Dimension(110, 50));
        add(number);
        colCounter++;
      }
      else {
        normal = new JButton();
        normal.addActionListener(new ButtonListener());
        normal.setBackground(new Color(197, 204, 208));
        normal.setOpaque(true);
        normal.setBorder(BorderFactory.createLineBorder(Color.black));
        normal.setPreferredSize(new Dimension(110, 50));
        add(normal);
      }
    }
  }
  
  private class ButtonListener implements ActionListener {
    public void actionPerformed (ActionEvent event) {
//      playerTurn(
//      ((JButton) event.getSource()).setIcon(new ImageIcon("white.png"));
//      if(
      // fire shot by pressing
         //how to get grid to display red peg if grid is comprised of unnamed buttons
    }
  }
}