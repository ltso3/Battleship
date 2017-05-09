import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class OceanGridPanel extends JPanel {
  
  private JButton letter;
  private JButton number;
  private JButton normal;
  
  public OceanGridPanel(PlayBattleship game) {
   
    setLayout(new GridLayout(11, 11, 0, 0)); 
    setBackground(new Color(92, 135, 149));
    
    String[] letters = {"A","B","C","D","E","F","G","H","I","J"};
    int rowCounter = 0;
    int colCounter = 1;
    
    Vector<Integer> ships = new Vector<Integer>();
    for(LinkedList<String> locs : game.getPGrid().getShipLocs()) {
      for(String loc : locs) {
        int row = Integer.parseInt(loc.substring(1));
        int column = (int) loc.charAt(0) - 64;
        ships.add(11 * row + column);
      }
    }
    
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
        if(ships.contains(i)) {
          normal.setBackground(new Color(96, 96, 96));
        }
        else {
           normal.setBackground(new Color(197, 204, 208));
           normal.addActionListener(new ButtonListener());
        }
        normal.setOpaque(true);
        normal.setBorder(BorderFactory.createLineBorder(Color.black));
        normal.setPreferredSize(new Dimension(110, 50));
        add(normal);
      }
    } 
  }
  
  private class ButtonListener implements ActionListener {
    public void actionPerformed (ActionEvent event) {
      ((JButton) event.getSource()).setIcon(new ImageIcon("white.png"));
    }
  }
}