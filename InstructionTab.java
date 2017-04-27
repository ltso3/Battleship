/** InstructionTab.java
  * Created by: Riann, Lauren, Kalau
  * CS 230 Final Project
  * 26 April 2017
  * This class creates an instruction page to add to the start page
  **/

import java.awt.*;
import javax.swing.*;

public class InstructionTab extends JPanel {
  public InstructionTab() {
    setBackground (Color.white);
    setLayout(New FlowLayout()); 
    
    //BoxLayout panels within a FlowLayout panel to create a column effect
    JPanel left = new JPanel();
    left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
    add(left);
    
    JPanel right = new JPanel();
    right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
    add(right);

    //JLabel for the game title
    JLabel title = new JLabel("BATTLESHIP");
    
    //JLabels for the left column 
    //Object, contents, game instructions, salvo version
    JLabel l1 = new JLabel("For 2 Players - Human vs Computer");
    JLabel l2 = new JLabel("OJBECT OF THE GAME");
    JLabel l3 = new JLabel("Be the first to sink all 5 of your opponent's ships.");
    JLabel l4 = new JLabel("CONTENTS");
    JLabel l5 = new JLabel("5 ships     white pegs     red pegs");
    JLabel l6 = new JLabel("     ocean grid     target grid");
    JLabel l7 = new JLabel("PREPARE FOR BATTLE");
    JLabel l8 = new JLabel("Each player must place all of their ships on their ocean grid");
    JLabel l9 = new JLabel("Rules for placing ships:");
    JLabel l10 = new JLabel("   -Ships may be placed horizontally or vertically, but not diagonally.");
    JLabel l11 = new JLabel("   -Ships are not allowed to overlap in letters, numbers, or the edge of the grid.");
    JLabel l12 = new JLabel("   -Position of the ships cannot be changed once the game has begun.");
    JLabel l13 = new JLabel("HOW TO PLAY");
    JLabel l14 = new JLabel("The human player will begin first. Then, the human and computer will alternate turns," + 
                              "calling out one shot per turn to try and hit each other's ships.");
    JLabel l15 = new JLabel("To begin each turn, a player must pick a location on their target grid. " +
                            "It will either be a HIT or MISS depending on whether the chosen location " +
                            "is occupied by a ship on the opponent's ocean grid. " +
                            "A HIT is recorded with a RED peg and a MISS is recorded with a WHITE peg.");
    JLabel l16 = new JLabel("Turns alternate with each shot called.");
    JLabel l17 = new JLabel("SINKING A SHIP");
    JLabel l18 = new JLabel("Once all the locations in any one ship are hit, it has been sunk. The name" +
                            " of the sunken ship is announced and is marked separately at the top of the" +
                            " game screen.");
    JLabel l19 = new JLabel("WINNING THE GAME");
    JLabel l20 = new JLabel("When a player sinks their opponent's entire fleet of five ships, they win the" +
                            " game! The player then has the option to play again or quit.");
    JLabel l21 = new JLabel("HOW TO PLAY SALVO");
    JLabel l22 = new JLabel("In Salva mode, gameplay remains the same, but with on exception. Instead of "+
                            "firing one missile at a time, the player can fire the same number of missiles "+
                            "as the number of ships the opponent has remaining (i.e. the more ships sunk, " +
                            "the fewer shots you get.");
    JLabel l23 = new JLabel("A more challenging game can also be played where players do not disclose which "+
                            "ships are hit.");
    
    //add JLabels to panels
    add(title);
    left.add(l1);
    left.add(l2);
    left.add(l3);
    left.add(l4);
    left.add(l5);
    left.add(l6);
    left.add(l7);
    left.add(l8);
    left.add(l9);
    left.add(l10);
    left.add(l11);
    left.add(l12);
    left.add(l13);
    left.add(l14);
    left.add(l15);
    left.add(l16);
    left.add(l7);
    left.add(l8);
    left.add(l9);
    left.add(l20);
    left.add(l21);
    left.add(l22);
    left.add(l23);
  }
}