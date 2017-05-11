/** InstructionTab.java
  * Created by: Riann, Lauren, Kalau
  * CS 230 Final Project
  * Created: 26 April 2017
  * Modified: 10 May 2017
  * This class creates an instruction page that explains how the game works
  * and how users should interact with the GUIs
  **/

import java.awt.*;
import javax.swing.*;

public class InstructionTab extends JPanel {
  private JPanel text;
  private JLabel title, players, object, object1, contents, contents1, contents2,
          howPlay, howPlay1,sinkShip, sinkShip1, winGame, winGame1, notes, insertPic;
  private JScrollPane scroll;
  private ImageIcon boatPic;
  
  
  public InstructionTab() {
    setBackground(new Color(197,204,208));
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    
    //BoxLayout panel within a BoxLayout panel to create a column effect
    text = new JPanel();
    text.setLayout(new BoxLayout(text, BoxLayout.Y_AXIS));
    text.setBackground(new Color(197,204,208));
    
    //allows panel to scroll when there's not enough space to see all info 
    scroll = new JScrollPane(text);
    add(scroll);

    //JLabel for the game title
    title = new JLabel("BATTLESHIP");
    title.setFont(new Font("Serif",Font.BOLD, 36));

    //JLabels for the text JPanel 
    //Object of game, game "pieces", gameplay instructions, salvo version, author notes
    //uses HTML in some JLabels for formatting purposes
    players = new JLabel("For 1 Player - Human vs Computer");
    players.setFont(new Font("Sans Serif",Font.PLAIN, 18));
    
    object = new JLabel("OJBECT OF THE GAME");
    object1 = new JLabel("Sink all 5 of the computer's ships before it sinks yours.");
    object.setFont(new Font("Serif",Font.BOLD, 26));
    object1.setFont(new Font("Sans Serif",Font.PLAIN, 18));
    
    contents = new JLabel("CONTENTS");
    contents1 = new JLabel("5 ships     white pegs     red pegs");
    contents2 = new JLabel("     ocean grid     target grid");
    contents.setFont(new Font("Serif",Font.BOLD, 26));
    contents1.setFont(new Font("Sans Serif",Font.PLAIN, 18));
    contents2.setFont(new Font("Sans Serif",Font.PLAIN, 18));
    
    howPlay = new JLabel("HOW TO PLAY");
    howPlay1 = new JLabel("<html>The human player will begin first. Then, the human and computer will <br>" + 
                              " alternate turns, firing one shot per turn to try and hit each other's ships.<br><br>" +
                          "On each turn, the player will input a coordinate and press [Fire!]. Once the <br>" +
                          "missile is fired, the target grid will mark the chosen location.<br><br>" +
                          "The player will be notified of a HIT or MISS depending on whether the chosen <br>"+
                          "location is occupied by a ship.<br><br>" +
                          "A HIT is recorded with a RED peg and a MISS is recorded with a WHITE peg.<br><br>" +
                          "The computer's missiles will be marked on the player's ocean grid.");
    howPlay.setFont(new Font("Serif",Font.BOLD, 26));
    howPlay1.setFont(new Font("Sans Serif",Font.PLAIN, 18));
    
    sinkShip = new JLabel("SINKING A SHIP");
    sinkShip1 = new JLabel("<html>Once all the locations in any one ship are hit, it has been sunk. The name<br>" +
                           " of the sunken ship is announced and the sunken ship counter on the screen <br>" +
                           "is incremented on the game screen.");
    sinkShip.setFont(new Font("Serif",Font.BOLD, 26));
    sinkShip1.setFont(new Font("Sans Serif",Font.PLAIN, 18));
    
    winGame = new JLabel("WINNING THE GAME");
    winGame1 = new JLabel("<html>When the player sinks the computer's entire fleet of five ships, they win <br>the" +
                          " game! The player then has the option to play again or quit.");
    winGame.setFont(new Font("Serif",Font.BOLD, 26));
    winGame1.setFont(new Font("Sans Serif",Font.PLAIN, 18));
    
    //author notes
    notes = new JLabel("<html>CS 230 Final Project: An adaption of Hasbro's Battleship made by Riann, Kalau, and "+
                       "Lauren. BananaBoatCo."); 
    notes.setFont(new Font("Sans Serif",Font.PLAIN, 12));
    
    //create banana boat picture; to be inserted at the bottom of page
    boatPic = new ImageIcon("bananaBoat.png");
    insertPic = new JLabel(boatPic);

    //add JLabels to text panel
    text.add(title);
    text.add(Box.createRigidArea(new Dimension(0,10)));
    text.add(players);
    text.add(Box.createRigidArea(new Dimension(0,15)));
    text.add(object);
    text.add(object1);
    text.add(Box.createRigidArea(new Dimension(0,15)));
    text.add(contents);
    text.add(contents1);
    text.add(contents2);
    text.add(Box.createRigidArea(new Dimension(0,15)));
    text.add(howPlay);
    text.add(howPlay1);
    text.add(Box.createRigidArea(new Dimension(0,15)));
    text.add(sinkShip);
    text.add(sinkShip1);
    text.add(Box.createRigidArea(new Dimension(0,15)));
    text.add(winGame);
    text.add(winGame1);
    text.add(Box.createRigidArea(new Dimension(0,15)));
    text.add(notes);
    text.add(insertPic);
  }
}
