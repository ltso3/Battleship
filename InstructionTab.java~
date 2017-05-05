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
    setLayout(new GridLayout(1,2)); 
    
    //BoxLayout panels within a FlowLayout panel to create a column effect
    JPanel left = new JPanel();
    left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
    add(left);
    
    JPanel right = new JPanel();
    right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
    add(right);

    //JLabel for the game title
    JLabel title = new JLabel("BATTLESHIP"); //insert picture? 
    title.setFont(new Font("Serif",Font.BOLD, 36));

    //JLabels for the left column 
    //Object of game, game "pieces", gameplay instructions, salvo version
    JLabel l1 = new JLabel("For 2 Players - Human vs Computer");
    l1.setFont(new Font("Sans Serif",Font.PLAIN, 18));
    JLabel l2 = new JLabel("OJBECT OF THE GAME");
    l2.setFont(new Font("Serif",Font.BOLD, 26));
    JLabel l3 = new JLabel("Be the first to sink all 5 of your opponent's ships.");
    l3.setFont(new Font("Sans Serif",Font.PLAIN, 18));
    JLabel l4 = new JLabel("CONTENTS");
    l4.setFont(new Font("Serif",Font.BOLD, 26));
    JLabel l5 = new JLabel("5 ships     white pegs     red pegs");
    JLabel l6 = new JLabel("     ocean grid     target grid");
    l5.setFont(new Font("Sans Serif",Font.PLAIN, 18));
    l6.setFont(new Font("Sans Serif",Font.PLAIN, 18));
    JLabel l7 = new JLabel("PREPARE FOR BATTLE");
    l7.setFont(new Font("Serif",Font.BOLD, 26));
    JLabel l8 = new JLabel("Each player must place all of their ships on their ocean grid.");
    JLabel l9 = new JLabel("Rules for placing ships:");
    JLabel l10 = new JLabel("   -Ships may be placed horizontally or vertically, but not diagonally.");
    JLabel l11 = new JLabel("   -Ships are not allowed to overlap in letters, numbers, or the edge of the grid.");
    JLabel l12 = new JLabel("   -Position of the ships cannot be changed once the game has begun.");
    l8.setFont(new Font("Sans Serif",Font.PLAIN, 18));
    l9.setFont(new Font("Sans Serif",Font.PLAIN, 18));
    l10.setFont(new Font("Sans Serif",Font.PLAIN, 18));
    l11.setFont(new Font("Sans Serif",Font.PLAIN, 18));
    l12.setFont(new Font("Sans Serif",Font.PLAIN, 18));
    JLabel l13 = new JLabel("HOW TO PLAY");
    l13.setFont(new Font("Serif",Font.BOLD, 26));
    JLabel l14 = new JLabel("<html>The human player will begin first. Then, the human and computer will <br>" + 
                              " alternate turns, calling out one shot per turn to try and hit each other's ships.");
    JLabel l15 = new JLabel("<html>To begin each turn, a player must pick a location on their target grid.<br>" +
                            "It will either be a HIT or MISS depending on whether the chosen location<br>" +
                            "is occupied by a ship on the opponent's ocean grid.<br>" +
                            "A HIT is recorded with a RED peg and a MISS is recorded with a WHITE peg.");
    JLabel l16 = new JLabel("Turns alternate with each shot called.");
    l14.setFont(new Font("Sans Serif",Font.PLAIN, 18));
    l15.setFont(new Font("Sans Serif",Font.PLAIN, 18));
    l16.setFont(new Font("Sans Serif",Font.PLAIN, 18));
    JLabel l17 = new JLabel("SINKING A SHIP");
    l17.setFont(new Font("Serif",Font.BOLD, 26));
    JLabel l18 = new JLabel("<html>Once all the locations in any one ship are hit, it has been sunk. The name<br>" +
                            " of the sunken ship is announced and is marked separately at the top of the<br>" +
                            " game screen.");
    l18.setFont(new Font("Sans Serif",Font.PLAIN, 18));
    JLabel l19 = new JLabel("WINNING THE GAME");
    l19.setFont(new Font("Serif",Font.BOLD, 26));
    JLabel l20 = new JLabel("<html>When a player sinks their opponent's entire fleet of five ships, they win <br>the" +
                            " game! The player then has the option to play again or quit.");
    l20.setFont(new Font("Sans Serif",Font.PLAIN, 18));
    JLabel l21 = new JLabel("HOW TO PLAY SALVO");
    l21.setFont(new Font("Serif",Font.BOLD, 26));
    JLabel l22 = new JLabel("<html>In Salvo mode, gameplay remains the same, but with on exception. Instead of <br>"+
                            "firing one missile at a time, the player can fire the same number of missiles <br>"+
                            "as the number of ships the opponent has remaining (i.e. the more ships sunk, <br>" +
                            "the fewer shots you get.");
    JLabel l23 = new JLabel("<html>A more challenging game can also be played where players do not disclose which <br>"+
                            "ships are hit.<br><br>");
    l22.setFont(new Font("Sans Serif",Font.PLAIN, 18));
    l23.setFont(new Font("Sans Serif",Font.PLAIN, 18));
    
    //add JLabels to left panel
    left.add(title);
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
    left.add(l17);
    left.add(l18);
    left.add(l19);
    left.add(l20);
    left.add(l21);
    left.add(l22);
    left.add(l23);
    left.add(new JButton("Let's Play")); //add play button at the bottom of the instruction page
    
    //JLabels for right column 
    //visuals 
    JLabel r1 = new JLabel("FIGURE 1");
    JLabel r2 = new JLabel("FIGURE 2");
    JLabel r3 = new JLabel("FIGURE 3");
    JLabel r4 = new JLabel("FIGURE 4");
    JLabel r5 = new JLabel("FIGURE 5");
    JLabel r6 = new JLabel("FIGURE 6");
    
    //add JLabels to right panel
    right.add(r1);
    right.add(r2);
    right.add(r3);
    right.add(r4);
    right.add(r5);
    right.add(r6);
  }
}