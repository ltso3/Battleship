import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class SetupPanel extends JPanel {
  private JPanel shipLocs, grids, gridsLP, shipLocsLP, fire;
  private TextField fireCoord;
  private JButton help, fireBtn;
  private JLabel gridsL, shipLocsL;
  protected PlayBattleship game;
  private BattleshipGUI b;
  
  public SetupPanel(PlayBattleship game, BattleshipGUI b) {
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
    
    grids = new JPanel();
    grids.setLayout(new BoxLayout(grids, BoxLayout.Y_AXIS));
    grids.add(new TargetGridPanel(game));
    
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
    
    grids.add(new OceanGridPanel(game));
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
      game.playerTurn(fireCoord.getText());
//      if(game.getPGrid().getOceanGrid().hasShip()) {
//        gridsLP.
          //how to get grid to display red peg if grid is comprised of unnamed buttons
//      }
    }
  }
}