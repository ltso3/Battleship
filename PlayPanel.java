// CS 230 Final Project
// Riann, Lauren, Kalau
// Class creates panel with targetGrid, oceanGrid and GUI to fireMissile
// Class written by Lauren

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class PlayPanel extends JPanel {
  
  // Initialize private instance variables
  private JPanel shipLocs, grids, gridsLP, shipLocsLP, sunk, fire, tgp, ogp;
  private TextField fireCoord;
  private JButton help, fireBtn;
  private JLabel gridsL, sunkL, shipLocsL;
  protected PlayBattleship game;
  private BattleshipGUI b;
  private int counter;
  private JButton[][] tgpButtons, ogpButtons;
  
  public PlayPanel(PlayBattleship game, BattleshipGUI b) {
    // Assign private instance variables
    this.game = game;
    this.b = b;
    counter = 0;
    
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setBackground(new Color(92, 135, 149));
    
    // Panel for Target Grid label
    gridsLP = new JPanel();
    gridsLP.setBackground(new Color(92, 135, 149));
    gridsL = new JLabel("Target Grid");
    gridsL.setBackground(new Color(92, 135, 149));
    gridsL.setFont(new Font("Russo One",Font.PLAIN, 25));
    gridsL.setForeground(Color.white);
    gridsLP.add(gridsL);
    add(gridsLP);
    
    // Panel for Target Grid: grid layout of 11x11 JButtons
    tgp = new JPanel();
    grids = new JPanel();
    grids.setLayout(new BoxLayout(grids, BoxLayout.Y_AXIS));
    
    tgp.setLayout(new GridLayout(11, 11, 0, 0)); 
    tgp.setBackground(new Color(92, 135, 149));
    
    tgpButtons = new JButton[12][12];
    String[] letters = {"A","B","C","D","E","F","G","H","I","J"};
    
    for(int i = 0; i < 11; i++) {
      for(int j = 0; j < 11; j++) {
        if(i == 0 && j != 0) 
          tgpButtons[i][j] = new JButton(letters[j - 1]); // Add column labels
        else if(j == 0 && i != 0)
          tgpButtons[i][j] = new JButton(Integer.toString(i)); // Add row labels
        else {
          tgpButtons[i][j] = new JButton(""); // Add all other buttons
        }
        // Set look and feel of each button and add to panel
        tgpButtons[i][j].setBackground(new Color(197, 204, 208));
        tgpButtons[i][j].setOpaque(true);
        tgpButtons[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
        tgpButtons[i][j].setPreferredSize(new Dimension(110, 50));
        tgp.add(tgpButtons[i][j]); 
      }
    }
    
    grids.add(tgp);
    
    grids.add(Box.createRigidArea(new Dimension(0,20)));
    
    // Panel for firing coordinates
    fire = new JPanel();
    fireCoord = new TextField(3); 
    fire.add(new Label("Fire on: ")); // Enter coordinate to be fired on
    fire.add(fireCoord);
    
    // Create fire button to fire a missile in the game
    fireBtn = new JButton("Fire!");
    fire.add(fireBtn);
    fireBtn.setBackground(new Color(94, 197, 110));
    fireBtn.setOpaque(true);
    fireBtn.setBorder(BorderFactory.createLineBorder(Color.black));
    fireBtn.setPreferredSize(new Dimension(40, 25));
    fireBtn.addActionListener(new FireButtonListener());
    
    fire.setBackground(new Color(92, 135, 149));
    grids.add(fire);
    
    // Panel to hold label of number of ships sunk
    sunk = new JPanel();
    sunkL = new JLabel("You have have sunk " + counter + " out of 5 ships");
    sunkL.setFont(new Font("Russo One",Font.PLAIN, 14));
    sunk.add(sunkL);
    sunk.setBackground(new Color(92, 135, 149));
    grids.add(sunk);
    
    grids.add(Box.createRigidArea(new Dimension(0,20)));
    
    // Panel for Ocean Grid: grid layout of 11x11 JButtons
    ogp = new JPanel();
    ogp.setLayout(new GridLayout(11, 11, 0, 0)); 
    ogp.setBackground(new Color(92, 135, 149));
    
    ogpButtons = new JButton[12][12];
    
    for(int l = 0; l < 11; l++) {
      for(int m = 0; m < 11; m++) {
        if(l == 0 && m != 0) 
          ogpButtons[l][m] = new JButton(letters[m - 1]); // add column labels
        else if(m == 0 && l != 0)
          ogpButtons[l][m] = new JButton(Integer.toString(l)); // add row labels
        else {
          ogpButtons[l][m] = new JButton(""); // add all other buttons
        }
        // Set look and feel of all grid buttons
        ogpButtons[l][m].setBackground(new Color(197, 204, 208));
        ogpButtons[l][m].setOpaque(true);
        ogpButtons[l][m].setBorder(BorderFactory.createLineBorder(Color.black));
        ogpButtons[l][m].setPreferredSize(new Dimension(110, 50));
        ogp.add(ogpButtons[l][m]);
      }
    }
    
    grids.add(ogp); 
    
    // Add ship pictures to each ocean grid location with a ship
    for (int s = 0; s<game.getPGrid().getShipLocs().size(); s++) {
      for (String location : game.getPGrid().getShipLocs().get(s)) {
        int row = Integer.parseInt(location.substring(1));
        int column = (int) location.charAt(0) - 64;
        if (s == 0) {
          ogpButtons[row][column].setIcon(new ImageIcon("destroyer1_v.png"));
        }
        if (s == 1) {
          ogpButtons[row][column].setIcon(new ImageIcon("submarine1_v.png"));
        }
        if (s == 2) {
          ogpButtons[row][column].setIcon(new ImageIcon("cruiser1_v.png"));
        }
        if (s == 3) {
          ogpButtons[row][column].setIcon(new ImageIcon("battleship1_v.png"));
        }
        if (s == 4) {
          ogpButtons[row][column].setIcon(new ImageIcon("carrier1_v.png"));
        }
      }
    }
    
    add(grids, BorderLayout.CENTER);
    grids.setBackground(new Color(92, 135, 149));
    add(grids);
    
    // Panel to hold Ocean Grid label
    shipLocsLP = new JPanel();
    shipLocsLP.setBackground(new Color(92, 135, 149));
    shipLocsL = new JLabel("Ocean Grid");
    shipLocsL.setBackground(new Color(92, 135, 149));
    shipLocsL.setFont(new Font("Russo One",Font.PLAIN, 25));
    shipLocsL.setForeground(Color.white);
    shipLocsLP.add(shipLocsL);
    add(shipLocsLP);
    
    // Panel to hold help icon
    shipLocs = new JPanel();
    help = new JButton(new ImageIcon("help-icon.png"));
    help.setPreferredSize(new Dimension(35,35));
    help.addActionListener(new ButtonListener());
    help.setBackground(new Color(92, 135, 149));
    shipLocs.setBackground(new Color(92, 135, 149));
    shipLocs.add(help);
    add(shipLocs);
  }
  
  // Help button listener to display information tab when pressed
  private class ButtonListener implements ActionListener {
    public void actionPerformed (ActionEvent event) {
      JFrame frame = new JFrame ("BATTLESHIP"); // Create JFrame for overall structure of GUI
      frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE); // Close GUI upon pressing x
      
      InstructionTab it = new InstructionTab();
      frame.getContentPane().add(it);
      
      frame.pack();
      frame.setVisible(true);
    }
  }
  
  // Fire button listener to play the game of battleship
  private class FireButtonListener implements ActionListener {
    public void actionPerformed (ActionEvent event) { 
      JFrame frame = new JFrame ("BATTLESHIP"); // Create JFrame for overall structure of GUI
      frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE); // Close GUI upon pressing x
      
      String loc = fireCoord.getText();
      game.playerTurn(loc);
      int row = Integer.parseInt(loc.substring(1));
      int column = (int) loc.charAt(0) - 64;
      System.out.println(game.getCGrid().getShipLocs());
      
      // Player goes first
      //If player's missile is a hit,
      if(game.playerTurn(loc)) {
        tgpButtons[row][column].setIcon(new ImageIcon("red.gif")); // Set corresponding button to red
        // Check if hit location has sunk a battleship
        if (game.getCGrid().isSunk(loc)) { 
          counter++;
          sunkL.setText("You have sunk " + counter + " of 5 ships.");
        }
      }
      
      else {
        tgpButtons[row][column].setIcon(new ImageIcon("white.png"));
      }     
      
      System.out.println("counter: " + counter);
      if (counter == 5) { // Popup doesn't work
        System.out.println("HERE");
        frame.getContentPane().removeAll();
        b.frame.getContentPane().removeAll();
        b.asp = null;
        b.frame.getContentPane().add(new WinnerPopup(game, b));
        b.frame.setVisible(true);
      }
      
      if(game.computerTurn()) {
        ComputerHit ch = new ComputerHit(frame, game.getCCoord());
        frame.getContentPane().removeAll();
        frame.getContentPane().add(ch);
        ogpButtons[Integer.parseInt(game.getCCoord().substring(1))][(int) game.getCCoord().charAt(0) - 64].setIcon(new ImageIcon("red.gif"));
      }
      else {
        ComputerMiss cm = new ComputerMiss(frame, game.getCCoord());
        frame.getContentPane().removeAll();
        frame.getContentPane().add(cm);
        ogpButtons[Integer.parseInt(game.getCCoord().substring(1))][(int) game.getCCoord().charAt(0) - 64].setIcon(new ImageIcon("white.png"));
      }
      if (game.computerWin()) { // Popup doesn't work
        System.out.println("down HERE");
        frame.getContentPane().removeAll();
        b.frame.getContentPane().removeAll();
        b.asp = null;
        b.frame.getContentPane().add(new LoserPopup());
        b.frame.setVisible(true);
      }
      
//      }
      frame.pack();
      frame.setVisible(true);
      tgp.revalidate();
    }
  }
}