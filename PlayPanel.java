import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class PlayPanel extends JPanel {
  private JPanel shipLocs, grids, gridsLP, shipLocsLP, fire, tgp, ogp;
  private TextField fireCoord;
  private JButton help, fireBtn;
  private JLabel gridsL, shipLocsL;
  protected PlayBattleship game;
  private BattleshipGUI b;
  
  private JButton[][] tgpButtons;
  private JButton[][] ogpButtons;
  
  public PlayPanel(PlayBattleship game, BattleshipGUI b) {
    this.game = game;
    this.b = b;
    
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setBackground(new Color(92, 135, 149));
    
    gridsLP = new JPanel();
    gridsLP.setBackground(new Color(92, 135, 149));
    gridsL = new JLabel("Target Grid");
    gridsL.setBackground(new Color(92, 135, 149));
    gridsL.setFont(new Font("Russo One",Font.PLAIN, 25));
    gridsL.setForeground(Color.white);
    gridsLP.add(gridsL);
    add(gridsLP);
    
    // ---------------------------------------------------------------------------//
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
          tgpButtons[i][j] = new JButton(letters[j - 1]);
        else if(j == 0 && i != 0)
          tgpButtons[i][j] = new JButton(Integer.toString(i));
        else {
          tgpButtons[i][j] = new JButton("");
        }
        
        tgpButtons[i][j].setBackground(new Color(197, 204, 208));
        tgpButtons[i][j].setOpaque(true);
        tgpButtons[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
        tgpButtons[i][j].setPreferredSize(new Dimension(110, 50));
        tgp.add(tgpButtons[i][j]);
      }
    }
    
    grids.add(tgp);
    
    //----------------------------------------------------------------------------------------//
    
    grids.add(Box.createRigidArea(new Dimension(0,30)));
    
    fire = new JPanel();
    fireCoord = new TextField(3); // length 3
    fire.add(new Label("Fire on: "));
    fire.add(fireCoord);
    
    fireBtn = new JButton("Fire!");
    fire.add(fireBtn);
    fireBtn.setBackground(new Color(94, 197, 110));
    fireBtn.setOpaque(true);
    fireBtn.setBorder(BorderFactory.createLineBorder(Color.black));
    fireBtn.setPreferredSize(new Dimension(40, 25));
    fireBtn.addActionListener(new FireButtonListener());
    
    fire.setBackground(new Color(92, 135, 149));
    grids.add(fire);
    
    grids.add(Box.createRigidArea(new Dimension(0,30)));
    
    ogp = new JPanel();
    ogp.setLayout(new GridLayout(11, 11, 0, 0)); 
    ogp.setBackground(new Color(92, 135, 149));
    
    ogpButtons = new JButton[12][12];
    
    for(int l = 0; l < 11; l++) {
      for(int m = 0; m < 11; m++) {
        if(l == 0 && m != 0) 
          ogpButtons[l][m] = new JButton(letters[m - 1]);
        else if(m == 0 && l != 0)
          ogpButtons[l][m] = new JButton(Integer.toString(l));
        else {
          ogpButtons[l][m] = new JButton("");
        }
        
        ogpButtons[l][m].setBackground(new Color(197, 204, 208));
        ogpButtons[l][m].setOpaque(true);
        ogpButtons[l][m].setBorder(BorderFactory.createLineBorder(Color.black));
        ogpButtons[l][m].setPreferredSize(new Dimension(110, 50));
        ogp.add(ogpButtons[l][m]);
      }
    }
    
    grids.add(ogp); 
    
    for(LinkedList<String> locs : game.getPGrid().getShipLocs()) {
      for(String loc : locs) {
        int row = Integer.parseInt(loc.substring(1));
        int column = (int) loc.charAt(0) - 64;
        ogpButtons[row][column].setIcon(new ImageIcon("carrier1_v.png"));
      }
    }
    
    add(grids, BorderLayout.CENTER);
    grids.setBackground(new Color(92, 135, 149));
    add(grids);
    
    shipLocsLP = new JPanel();
    shipLocsLP.setBackground(new Color(92, 135, 149));
    shipLocsL = new JLabel("Ocean Grid");
    shipLocsL.setBackground(new Color(92, 135, 149));
    shipLocsL.setFont(new Font("Russo One",Font.PLAIN, 25));
    shipLocsL.setForeground(Color.white);
    shipLocsLP.add(shipLocsL);
    add(shipLocsLP);
    
    shipLocs = new JPanel();
    help = new JButton(new ImageIcon("help-icon.png"));
    help.setPreferredSize(new Dimension(35,35));
    help.addActionListener(new ButtonListener());
    help.setBackground(new Color(92, 135, 149));
    shipLocs.setBackground(new Color(92, 135, 149));
    shipLocs.add(help);
    add(shipLocs);
  }
  
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
  
  private class FireButtonListener implements ActionListener {
    public void actionPerformed (ActionEvent event) { 
      JFrame frame = new JFrame ("BATTLESHIP"); // Create JFrame for overall structure of GUI
      frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE); // Close GUI upon pressing x
      
      String loc = fireCoord.getText();
      game.playerTurn(loc);
      int row = Integer.parseInt(loc.substring(1));
      int column = (int) loc.charAt(0) - 64;
      
      if(!game.getPGrid().allSunk() && !game.getCGrid().allSunk()) {
        if(game.playerTurn(loc)) {
          HitPopup hp = new HitPopup(frame, fireCoord.getText(), game);
          frame.getContentPane().add(hp);
          tgpButtons[row][column].setIcon(new ImageIcon("red.gif"));          
        }
        else {
          MissPopup mp = new MissPopup(frame, fireCoord.getText(), game);
          frame.getContentPane().add(mp);
          tgpButtons[row][column].setIcon(new ImageIcon("white.png"));
        }
        if(game.computerTurn()) {
//          ComputerHit ch = new ComputerHit(frame, game.getCCoord());
//          frame.getContentPane().add(ch);
          ogpButtons[Integer.parseInt(game.getCCoord().substring(1))][(int) game.getCCoord().charAt(0) - 64].setIcon(new ImageIcon("red.gif"));
        }
        else {
//          ComputerMiss cm = new ComputerMiss(frame, game.getCCoord());
//          frame.getContentPane().add(cm);
          ogpButtons[Integer.parseInt(game.getCCoord().substring(1))][(int) game.getCCoord().charAt(0) - 64].setIcon(new ImageIcon("white.png"));
        }
      }
      frame.pack();
      frame.setVisible(true);
      tgp.revalidate();
    }
  }
}


