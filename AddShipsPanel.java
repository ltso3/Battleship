import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddShipsPanel extends JPanel {
	private JPanel upperText, destroyer, submarine, cruiser, battleship, carrier;
	private JComboBox orientationCombo1, orientationCombo2, orientationCombo3, orientationCombo4, orientationCombo5;
	private TextField startCoord1, startCoord2, startCoord3, startCoord4, startCoord5;
	
	public AddShipsPanel() {
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// Creates panels 
		upperText = new JPanel();
		destroyer = new JPanel();
		submarine = new JPanel();
		cruiser = new JPanel();
		battleship = new JPanel();
		carrier = new JPanel();
		
		// Set  text for each panel
		JLabel l1 = new JLabel("To begin, input a starting coordinate and select an orientation for each ship, then click [Done]. 'Vertical' ships go "
				+ "from the given location down and 'horizontal' ships go from the given location to the right."); 
		upperText.add(l1);
		JLabel l2 = new JLabel("Add destroyer (length 2)"); 
		destroyer.add(l2);
		JLabel l3 = new JLabel("Add submarine (length 3)"); 
		submarine.add(l3);
		JLabel l4 = new JLabel("Add cruiser (length 3)"); 
		cruiser.add(l4);
		JLabel l5 = new JLabel("Add battleship (length 4)"); 
		battleship.add(l5);
		JLabel l6 = new JLabel("Add carrier (length 5)"); 
		carrier.add(l6);
		
		// Create text field to input starting location for each ship
	    startCoord1 = new TextField(3); // length 3
	    // startCoord.addActionListener (new AddShipListener());
	    destroyer.add(new Label("Starting coordinate: "));
	    destroyer.add(startCoord1);
	    startCoord2 = new TextField(3);
	    submarine.add(new Label("Starting coordinate: "));
	    submarine.add(startCoord2);
	    startCoord3 = new TextField(3);
	    cruiser.add(new Label("Starting coordinate: "));
	    cruiser.add(startCoord3);
	    startCoord4 = new TextField(3);
	    battleship.add(new Label("Starting coordinate: "));
	    battleship.add(startCoord4);
	    startCoord5 = new TextField(3);
	    carrier.add(new Label("Starting coordinate: "));
	    carrier.add(startCoord5);
		
		// Create combo box for ship orientation and add to all ship JPanels
		String[] orientation  = {"...", "Horizontal", "Vertical"};
		orientationCombo1 = new JComboBox(orientation);
	    destroyer.add(new Label("Orientation: "));
		destroyer.add(orientationCombo1);
		orientationCombo2 = new JComboBox(orientation);
	    submarine.add(new Label("Orientation: "));
		submarine.add(orientationCombo2);
		orientationCombo3 = new JComboBox(orientation);
	    cruiser.add(new Label("Orientation: "));
		cruiser.add(orientationCombo3);
		orientationCombo4 = new JComboBox(orientation);
	    battleship.add(new Label("Orientation: "));
		battleship.add(orientationCombo4);
		orientationCombo5 = new JComboBox(orientation);
	    carrier.add(new Label("Orientation: "));
		carrier.add(orientationCombo5);
		
		// Add panels
		add(upperText);
		add(destroyer);
		add(submarine);
		add(cruiser);
		add(battleship);
		add(carrier);
	}
}
