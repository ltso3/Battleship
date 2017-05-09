import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class OceanGridPanel extends JPanel {
  
  private JButton[][] buttons;
  private JButton letter;
  private JButton number;
  private JButton normal;
  
  public OceanGridPanel(PlayBattleship game) {
   
    setLayout(new GridLayout(11, 11, 0, 0)); 
    setBackground(new Color(92, 135, 149));
    
    buttons = new JButton[12][12];
    String[] letters = {"A","B","C","D","E","F","G","H","I","J"};
    int rowCounter = 0;
    int colCounter = 1;
    
    for(int i = 0; i < 11; i++) {
      for(int j = 0; j < 11; j++) {
        if(i == 0 && j != 0) 
          buttons[i][j] = new JButton(letters[j - 1]);
        else if(j == 0 && i != 0)
          buttons[i][j] = new JButton(Integer.toString(i));
        else {
          buttons[i][j] = new JButton("");
          buttons[i][j].addActionListener(new ButtonListener());
        }

        buttons[i][j].setBackground(new Color(197, 204, 208));
        buttons[i][j].setOpaque(true);
        buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
        buttons[i][j].setPreferredSize(new Dimension(110, 50));
        add(buttons[i][j]);
      }
    }
    
    for(LinkedList<String> locs : game.getPGrid().getShipLocs()) {
      for(String loc : locs) {
        int row = Integer.parseInt(loc.substring(1));
        int column = (int) loc.charAt(0) - 64;
        buttons[row][column].setBackground(new Color(96, 96, 96));
      }
    }
  }
  
  private class ButtonListener implements ActionListener {
    public void actionPerformed (ActionEvent event) {
      ((JButton) event.getSource()).setIcon(new ImageIcon("white.png"));
    }
  }
}