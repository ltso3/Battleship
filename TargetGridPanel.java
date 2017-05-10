import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TargetGridPanel extends JPanel {
  
  public JButton[][] buttons;
  private JButton letter;
  private JButton number;
  private JButton normal;
  
  public TargetGridPanel(PlayBattleship game) {
    
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
        }
        
        buttons[i][j].setBackground(new Color(197, 204, 208));
        buttons[i][j].setOpaque(true);
        buttons[i][j].addActionListener(new FireButtonListener());
        buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
        buttons[i][j].setPreferredSize(new Dimension(110, 50));
        add(buttons[i][j]);
      }
    }
  }
  
  public void changeToRed(LinkedList<Integer> loc) {
    buttons[loc.get(0)][loc.get(1)].setIcon(new ImageIcon("red.png"));
  }
  
  public void changeToWhite(LinkedList<Integer> loc) {
    buttons[loc.get(0)][loc.get(1)].setIcon(new ImageIcon("white.png"));
  }
  
  private class FireButtonListener implements ActionListener {
    public void actionPerformed (ActionEvent event) { 
//      String loc = fireCoord.getText();
//      game.playerTurn(loc);
//      int row = Integer.parseInt(loc.substring(1));
//      int column = (int) loc.charAt(0) - 64;
      
//      buttons[1][1].setText("HEY");
      
//      if(game.fireMissile(loc, game.getPGrid(), game.getCGrid()))
//        buttons[row][column].setIcon(new ImageIcon("red.png"));
//      else {
//        buttons[row][column].setIcon(new ImageIcon("white.png"));
//      }
    }
  }
}