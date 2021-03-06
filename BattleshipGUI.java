// CS 230 Final Project
// Riann, Lauren, Kalau
// Class creates main frame for GUIs
// Class written by Lauren

import javax.swing.*;

public class BattleshipGUI {
  
  protected static JFrame frame;
  protected static WelcomePanel wp;
  protected static AddShipsPanel asp;
  protected static PlayBattleship game;
  
  //-----------------------------------------------------------------
  //  Creates and displays the main program frame.
  //-----------------------------------------------------------------
  
  public static void main (String[] args) {
    frame = new JFrame ("Welcome to Battleship!"); // Create JFrame for overall structure of GUI
    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); // Close GUI upon pressing x
    game = new PlayBattleship();
    
    wp = new WelcomePanel(game);
    frame.getContentPane().add(wp);

    frame.pack();
    frame.setVisible(true);
  }
}