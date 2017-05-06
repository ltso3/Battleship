import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import MissPopup.ButtonListener;

public class AddShipsPanel extends JPanel {
	private JPanel upperText1, upperText2, mid1, mid2, mid3, mid4, mid5, destroyer, submarine, cruiser, battleship, carrier, done, lowerText;
	private JComboBox orientationCombo1, orientationCombo2, orientationCombo3, orientationCombo4, orientationCombo5;
	private TextField startCoord1, startCoord2, startCoord3, startCoord4, startCoord5;
	private JButton addDestroyer, addSubmarine, addCruiser, addBattleship, addCarrier, doneBtn;
	
	public AddShipsPanel() {
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// Creates panels 
		upperText1 = new JPanel();
		upperText2 = new JPanel();
		destroyer = new JPanel();
		submarine = new JPanel();
		cruiser = new JPanel();
		battleship = new JPanel();
		carrier = new JPanel();
		mid1 = new JPanel();
		mid2 = new JPanel();
		mid3 = new JPanel();
		mid4 = new JPanel();
		mid5 = new JPanel();
		done = new JPanel();
		lowerText = new JPanel();
		
		// Set background color for panels
		upperText1.setBackground(new Color(197, 204, 208));
		upperText2.setBackground(new Color(197, 204, 208));
		mid1.setBackground(new Color(197, 204, 208));
		mid2.setBackground(new Color(197, 204, 208));
		mid3.setBackground(new Color(197, 204, 208));
		mid4.setBackground(new Color(197, 204, 208));
		mid5.setBackground(new Color(197, 204, 208));
		destroyer.setBackground(new Color(197, 204, 208));
		submarine.setBackground(new Color(197, 204, 208));
		cruiser.setBackground(new Color(197, 204, 208));
		battleship.setBackground(new Color(197, 204, 208));
		carrier.setBackground(new Color(197, 204, 208));
		done.setBackground(new Color(197, 204, 208));
		lowerText.setBackground(new Color(197, 204, 208));
		
		// Set  text for each panel
		JLabel l1 = new JLabel("To begin, input a starting coordinate and select an orientation for each ship, then click [Add]."); 
		JLabel l2 = new JLabel("'Vertical' ships go from the given location down and 'horizontal' ships go from the given location to the right.");
		JLabel l9 = new JLabel("Once you've entered all 5 ships, press [Let's Play!]"); 
		l1.setFont(new Font("Russo One",Font.BOLD, 14));
		l2.setFont(new Font("Russo One",Font.BOLD, 14));
		l9.setFont(new Font("Russo One",Font.BOLD, 14));
		upperText1.add(l1);
		upperText1.add(l2);
		upperText2.add(l9);
		JLabel l3 = new JLabel("Add destroyer (length 2):"); 
	    l3.setFont(new Font("Russo One",Font.BOLD, 14));
		mid1.add(l3);
		JLabel l4 = new JLabel("Add submarine (length 3):"); 
		mid2.add(l4);
		l4.setFont(new Font("Russo One",Font.BOLD, 14));
		JLabel l5 = new JLabel("Add cruiser (length 3):"); 
		mid3.add(l5);
		l5.setFont(new Font("Russo One",Font.BOLD, 14));
		JLabel l6 = new JLabel("Add battleship (length 4):"); 
		mid4.add(l6);
		l6.setFont(new Font("Russo One",Font.BOLD, 14));
		JLabel l7 = new JLabel("Add carrier (length 5):"); 
		mid5.add(l7);
		l7.setFont(new Font("Russo One",Font.BOLD, 14));
		JLabel l8 = new JLabel("Information on added ships will appear here.");
		lowerText.add(l8);
		
		// Create text field to input starting location for each ship
	    startCoord1 = new TextField(3); // length 3
	    startCoord1.addActionListener (new AddShipsListener());
	    destroyer.add(new Label("Starting coordinate: "));
	    destroyer.add(startCoord1);
	    startCoord2 = new TextField(3);
	    startCoord2.addActionListener (new AddShipsListener());
	    submarine.add(new Label("Starting coordinate: "));
	    submarine.add(startCoord2);
	    startCoord3 = new TextField(3);
	    startCoord3.addActionListener (new AddShipsListener());
	    cruiser.add(new Label("Starting coordinate: "));
	    cruiser.add(startCoord3);
	    startCoord4 = new TextField(3);
	    startCoord3.addActionListener (new AddShipsListener());
	    battleship.add(new Label("Starting coordinate: "));
	    battleship.add(startCoord4);
	    startCoord5 = new TextField(3);
	    startCoord5.addActionListener (new AddShipsListener());
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
		
		// Create add buttons for each ship
		addDestroyer = new JButton("Add");
		addSubmarine = new JButton("Add");
		addCruiser = new JButton("Add"); 
		addBattleship = new JButton("Add");
		addCarrier = new JButton("Add");
		addDestroyer.addActionListener(new AddShipsListener());
		addSubmarine.addActionListener(new AddShipsListener());
		addCruiser.addActionListener(new AddShipsListener());
		addBattleship.addActionListener(new AddShipsListener());
		addCarrier.addActionListener(new AddShipsListener());
		destroyer.add(addDestroyer);
		submarine.add(addSubmarine);
		cruiser.add(addCruiser);
		battleship.add(addBattleship);
		carrier.add(addCarrier);
		
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
		add(mid1);
		add(destroyer);
		add(mid2);
		add(submarine);
		add(mid3);
		add(cruiser);
		add(mid4);
		add(battleship);
		add(mid5);
		add(carrier);
		add(done);
		add(lowerText);
	}
	
	private class AddShipsListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
		}
	}
	
	private class DoneListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
		}
	}
}
