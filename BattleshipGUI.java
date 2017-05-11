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
    
//      asp = new AddShipsPanel(game, this);
//      frame.getContentPane().add(asp);
    
//    OceanGridPanel ogp = new OceanGridPanel(game);
//    frame.getContentPane().add(ogp);
    
//    SetupPanel sp = new SetupPanel();
//    frame.getContentPane().add(sp);
// 
//  InstructionTab it = new InstructionTab();
//  frame.getContentPane().add(it);
// 
//  WinnerPopup wp = new WinnerPopup();
//  frame.getContentPane().add(wp);
    
//  LoserPopup lp = new LoserPopup();
//  frame.getContentPane().add(lp);
    
//  HitPopup hp = new HitPopup();
//  frame.getContentPane().add(hp);
    
//  MissPopup mp = new MissPopup();
//  frame.getContentPane().add(mp);
    
    frame.pack();
    frame.setVisible(true);
  }
}