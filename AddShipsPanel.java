import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddShipsPanel extends JPanel {
  
  private JPanel upperText1, upperText2, upperText3, add, done, lowerText,
                 destroyer, sub, cruiser, battleship, carrier;
  private JComboBox shipCombo, orientationCombo, shipCombo1, orientationCombo1, shipCombo2, orientationCombo2, 
                    shipCombo3, orientationCombo3, shipCombo4, orientationCombo4;
  private TextField startCoord, startCoord1, startCoord2, startCoord3, startCoord4;
  private JButton doneBtn;
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
    add.setLayout(new BoxLayout(add, BoxLayout.Y_AXIS));
    done.setBackground(new Color(197, 204, 208));
    lowerText.setBackground(new Color(197, 204, 208));
    
    // Set  text for each panel
    l1 = new JLabel("To begin, input a starting coordinate and select an orientation for each ship, then click [Add]."); 
    l2 = new JLabel("'Vertical' ships go from the given location down and 'horizontal' ships go from the given location right.");
    l3 = new JLabel("Once you've entered all 5 ships, press [Let's Play!]"); 
    l1.setFont(new Font("Russo One", Font.PLAIN, 14));
    l2.setFont(new Font("Russo One", Font.PLAIN, 14));
    l3.setFont(new Font("Russo One", Font.PLAIN, 14));
    upperText1.add(l1);
    upperText2.add(l2);
    upperText3.add(l3);

    l4 = new JLabel("");
    lowerText.add(l4);
    newShip = new JLabel("");
    
    destroyer = new JPanel();
    sub = new JPanel();
    cruiser = new JPanel();
    battleship = new JPanel();
    carrier = new JPanel();
    destroyer.setBackground(new Color(197, 204, 208));
    sub.setBackground(new Color(197, 204, 208));
    cruiser.setBackground(new Color(197, 204, 208));
    battleship.setBackground(new Color(197, 204, 208));
    carrier.setBackground(new Color(197, 204, 208));
    
    // Destoyer input line
    // Create combo box for ship type
    destroyer.add(new Label("Destroyer (Length 2) | "));
    
    // Create combo box for ship orientation and add to all ship JPanels
    String[] orientation  = {"...", "Horizontal", "Vertical"};
    orientationCombo = new JComboBox(orientation);
    destroyer.add(new Label("Orientation: "));
    destroyer.add(orientationCombo);
    
    // Create text field to input starting location for each ship
    startCoord = new TextField(3); // length 3
    destroyer.add(new Label("Starting coordinate: "));
    destroyer.add(startCoord);
    
    add.add(destroyer);
    
    // Submarine input line
    sub.add(new Label("Submarine (Length 3) | "));
    
    // Create combo box for ship orientation and add to all ship JPanels
    String[] orientation1  = {"...", "Horizontal", "Vertical"};
    orientationCombo1 = new JComboBox(orientation1);
    sub.add(new Label("Orientation: "));
    sub.add(orientationCombo1);
    
    // Create text field to input starting location for each ship
    startCoord1 = new TextField(3); // length 3
    sub.add(new Label("Starting coordinate: "));
    sub.add(startCoord1);
    
    add.add(sub);
    
    // Cruiser input line
    cruiser.add(new Label("Cruiser (Length 3) | "));
    
    // Create combo box for ship orientation and add to all ship JPanels
    String[] orientation2  = {"...", "Horizontal", "Vertical"};
    orientationCombo2 = new JComboBox(orientation2);
    cruiser.add(new Label("Orientation: "));
    cruiser.add(orientationCombo2);
    
    // Create text field to input starting location for each ship
    startCoord2 = new TextField(3); // length 3
    cruiser.add(new Label("Starting coordinate: "));
    cruiser.add(startCoord2);
    
    add.add(cruiser);
    
    // Battleship input line
    battleship.add(new Label("Battleship (Length 4) | "));
    
    // Create combo box for ship orientation and add to all ship JPanels
    String[] orientation3  = {"...", "Horizontal", "Vertical"};
    orientationCombo3 = new JComboBox(orientation3);
    battleship.add(new Label("Orientation: "));
    battleship.add(orientationCombo3);
    
    // Create text field to input starting location for each ship
    startCoord3 = new TextField(3); // length 3
    battleship.add(new Label("Starting coordinate: "));
    battleship.add(startCoord3);
    
    add.add(battleship);
    
    // Carrier input line
    carrier.add(new Label("Carrier (Length 5) | "));
    
    // Create combo box for ship orientation and add to all ship JPanels
    String[] orientation4  = {"...", "Horizontal", "Vertical"};
    orientationCombo4 = new JComboBox(orientation4);
    carrier.add(new Label("Orientation: "));
    carrier.add(orientationCombo4);
    
    // Create text field to input starting location for each ship
    startCoord4 = new TextField(3); // length 3
    carrier.add(new Label("Starting coordinate: "));
    carrier.add(startCoord4);
    
    add.add(carrier);
    
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
  
  // Need way to ensure play button only works if the ships have already been added
  private class DoneListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      String sType, sCoord, orientation, sType1, sCoord1, orientation1, sType2, sCoord2, orientation2,
             sType3, sCoord3, orientation3, sType4, sCoord4, orientation4;
        
      // Gets values user has selected
      orientation = orientationCombo.getSelectedItem().toString();
      sCoord = startCoord.getText(); // Need to check that starting coordinate is valid
      
      orientation1 = orientationCombo1.getSelectedItem().toString();
      sCoord1 = startCoord1.getText(); // Need to check that starting coordinate is valid
      
      orientation2 = orientationCombo2.getSelectedItem().toString();
      sCoord2 = startCoord2.getText(); // Need to check that starting coordinate is valid
      
      orientation3 = orientationCombo3.getSelectedItem().toString();
      sCoord3 = startCoord3.getText(); // Need to check that starting coordinate is valid
      
      orientation4 = orientationCombo4.getSelectedItem().toString();
      sCoord4 = startCoord4.getText(); // Need to check that starting coordinate is valid
      
      
      // Make sure that user has selected  a value for everything
      if (!orientation.equals("...") && !sCoord.equals("") && !orientation1.equals("...") && !sCoord1.equals("")
         && !orientation2.equals("...") && !sCoord2.equals("") && !orientation3.equals("...") && !sCoord3.equals("")
         && !orientation4.equals("...") && !sCoord4.equals("")) {
        Ship destroyer = new Ship("Destroyer", orientation, sCoord);
        Ship submarine = new Ship("Submarine", orientation1, sCoord1);
        Ship cruiser = new Ship("Cruiser", orientation2, sCoord2);
        Ship battleship = new Ship("Battleship", orientation3, sCoord3);
        Ship carrier = new Ship("Carrier", orientation4, sCoord4);
        if(game.getPGrid().isValidStart(destroyer) && game.getPGrid().isValidStart(submarine)
          && game.getPGrid().isValidStart(cruiser) && game.getPGrid().isValidStart(battleship) 
          && game.getPGrid().isValidStart(carrier)) {
          game.getPGrid().addShip(destroyer);
          game.getPGrid().addShip(submarine);
          game.getPGrid().addShip(cruiser);
          game.getPGrid().addShip(battleship);
          game.getPGrid().addShip(carrier);
          l4.setText("");
          lowerText.add(newShip, 0);
        }
        else 
          l4.setText("Please enter a valid start coordinate.");
      }
      else {
        l4.setText("Please make sure that you have typed in a coordinate and selected values for all the dropdown boxes");
      }
      boolean allShipsAdded = true;
      for(int i = 0; i < game.getPGrid().getShipLocs().size(); i++) {
        if(game.getPGrid().getShipLocs().get(i).size() == 0) 
          allShipsAdded = false;
      }
      if(allShipsAdded) {
        b.frame.getContentPane().removeAll();
        b.asp = null;
        b.frame.getContentPane().add(new PlayPanel(game, b));
        b.frame.setVisible(true);
      }
      
      else {
        l4.setText("Please make sure that you have added all ships");
      }
    }
  }
}