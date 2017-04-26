//********************************************************************
// CS230 Final Project
//
// WelcomePage.java       CS230 Staff
//
//********************************************************************

import javax.swing.*;

public class BattleshipGUI {
   //-----------------------------------------------------------------
   //  Creates and displays the main program frame.
   //-----------------------------------------------------------------
   public static void main (String[] args) {
      JFrame frame = new JFrame ("Welcome to Battleship!"); // Create JFrame for overall structure of GUI
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); // Close GUI upon pressing x
     
//      WelcomePanel wp = new WelcomePanel();
//      frame.getContentPane().add(wp);

      SetupPanel sp = new SetupPanel();
      frame.getContentPane().add(sp);
      
      frame.pack();
      frame.setVisible(true);
   }
}
