//********************************************************************
// CS230 Final Project
//
// WelcomePage.java       CS230 Staff
//
//********************************************************************

import javax.swing.*;

public class BattleshipGUI {
  
  protected static JFrame frame;
  protected static WelcomePanel wp;

  //-----------------------------------------------------------------
  //  Creates and displays the main program frame.
  //-----------------------------------------------------------------
  public static void main (String[] args) {
    frame = new JFrame ("Welcome to Battleship!"); // Create JFrame for overall structure of GUI
    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); // Close GUI upon pressing x
    
    wp = new WelcomePanel();
    frame.getContentPane().add(wp);
    
//  AddShipsPanel asp = new AddShipsPanel();
//  frame.getContentPane().add(asp);
//  SetupPanel sp = new SetupPanel();
//  frame.getContentPane().add(sp);
//  InstructionTab it = new InstructionTab();
//  frame.getContentPane().add(it);
    
    frame.pack();
    frame.setVisible(true);
  }
}
