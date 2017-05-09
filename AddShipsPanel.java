import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddShipsPanel extends JPanel {
  
  private JPanel upperText1, upperText2, upperText3, add, done, lowerText;
  private JComboBox shipCombo, orientationCombo;
  private TextField startCoord;
  private JButton addBtn, doneBtn;
  private JLabel l1, l2, l3, l4, newShip;
  private PlayBattleship game;
  private BattleshipGUI b;
  
  public AddShipsPanel(PlayBattleship game, BattleshipGUI b) {
    
    this.game = game;
    this.b = b;
    
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setBackground(new Color(197, 204, 208));
    
    // Creates panels 
    upperText1 = new JPanel();
    upperText2 = new JPanel();
    upperText3 = new JPanel();
    add = new JPanel();
    done = new JPanel();
    lowerText = new JPanel();
    
    // Set background color for panels
    upperText1.setBackground(new Color(197, 204, 208));
    upperText2.setBackground(new Color(197, 204, 208));
    upperText3.setBackground(new Color(197, 204, 208));
    add.setBackground(new Color(197, 204, 208));
    done.setBackground(new Color(197, 204, 208));
    lowerText.setBackground(new Color(197, 204, 208));
    
    // Set  text for each panel
    l1 = new JLabel("To begin, input a starting coordinate and select an orientation for each ship, then click [Add]."); 
    l2 = new JLabel("'Vertical' shipLocs go from the given location down and 'horizontal' shipLocs go from the given location right.");
    l3 = new JLabel("Once you've entered all 5 shipLocs, press [Let's Play!]"); 
    l1.setFont(new Font("Russo One", Font.PLAIN, 14));
    l2.setFont(new Font("Russo One", Font.PLAIN, 14));
    l3.setFont(new Font("Russo One", Font.PLAIN, 14));
    upperText1.add(l1);
    upperText2.add(l2);
    upperText3.add(l3);

    l4 = new JLabel("Information on added shipLocs will appear here.");
    lowerText.add(l4);
    newShip = new JLabel("");
    
    // Create combo box for ship type
    String[] shipTs  = {"...", "Destroyer", "Submarine", "Cruiser", "Battleship", "Carrier"};
    shipCombo = new JComboBox(shipTs);
    add.add(new Label("Ship type: "));
    add.add(shipCombo);
    
    // Create combo box for ship orientation and add to all ship JPanels
    String[] orientation  = {"...", "Horizontal", "Vertical"};
    orientationCombo = new JComboBox(orientation);
    add.add(new Label("Orientation: "));
    add.add(orientationCombo);
    
    // Create text field to input starting location for each ship
    startCoord = new TextField(3); // length 3
    startCoord.addActionListener(new AddShipsListener());
    add.add(new Label("Starting coordinate: "));
    add.add(startCoord);
    
    // Create add buttons for each ship
    addBtn = new JButton("Add");
    addBtn.addActionListener(new AddShipsListener());
    add.add(addBtn);
    
    // Create done button
    doneBtn = new JButton("Let's Play!");
    done.add(doneBtn);
    doneBtn.setBackground(new Color(94, 197, 110));
    doneBtn.setOpaque(true);
    doneBtn.setBorder(BorderFactory.createLineBorder(Color.black));
    doneBtn.setPreferredSize(new Dimension(90, 40));
    doneBtn.addActionListener(new DoneListener());
    
    // Add panels
    add(upperText1);
    add(upperText2);
    add(upperText3);
    add(add);
    add(done);
    add(lowerText);
  }
  
  // Need method to ensure only one of each type of ship is added
  // Also need to update grid with different color buttons, or a ship picture. Picture would need to be split into many pieces and resized.
  private class AddShipsListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      String sType, sCoord, orientation;
      
      // Gets values user has selected
      sType = shipCombo.getSelectedItem().toString();
      orientation = orientationCombo.getSelectedItem().toString();
      sCoord = startCoord.getText(); // Need to check that starting coordinate is valid
      
      l4.setText("");
      
      // Make sure that user has selected  a value for everything
      if (!sType.equals("...") && !orientation.equals("...") && !sCoord.equals("") ) {
        Ship temp = new Ship(sType, orientation, sCoord);
        if(game.getPGrid().isValidStart(temp)) {
          game.getPGrid().addShip(temp);
          l4.setText("");
          newShip = new JLabel(temp.toString());
          lowerText.add(newShip, 0);
        }
        else 
          l4.setText("Please enter a valid start coordinate.");
      }
      else {
        l4.setText("Please make sure that you have typed in a coordinate and selected values for all the dropdown boxes");
      }
    }
  }
  
  // Need way to ensure play button only works if the ships have already been added
  private class DoneListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      boolean allShipsAdded = true;
      for(int i = 0; i < game.getPGrid().getShipLocs().size(); i++) {
        if(game.getPGrid().getShipLocs().get(i).size() == 0) 
          allShipsAdded = false;
      }
      if(allShipsAdded) {
        b.frame.getContentPane().removeAll();
        b.asp = null;
        b.frame.getContentPane().add(new SetupPanel(game, b));
        b.frame.setVisible(true);
      }
      
      else {
        l4.setText("Please make sure that you have added all shipLocs");
      }
    }
  }
}
