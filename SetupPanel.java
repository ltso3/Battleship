import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class SetupPanel extends JPanel {
  private JPanel ships, grids, gridsLP, shipsLP;
  private JButton help;
  private JLabel gridsL, shipsL;
  private PlayBattleship game;
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
    grids.add(new GridPanel());
    grids.add(Box.createRigidArea(new Dimension(0,30)));
    grids.add(new GridPanel());
    add(grids, BorderLayout.CENTER);
    grids.setBackground(new Color(92, 135, 149));
    add(grids);
    
    shipsLP = new JPanel();
    shipsLP.setBackground(new Color(92, 135, 149));
    shipsL = new JLabel("Ocean Grid");
    shipsL.setBackground(new Color(92, 135, 149));
    shipsL.setFont(new Font("Russo One",Font.PLAIN, 25));
    shipsL.setForeground(Color.white);
    shipsLP.add(shipsL);
    add(shipsLP);
    
    ships = new JPanel();
    help = new JButton(new ImageIcon("help-icon.png"));
    help.setPreferredSize(new Dimension(35,35));
    help.addActionListener(new ButtonListener());
    help.setBackground(new Color(92, 135, 149));
    ships.setBackground(new Color(92, 135, 149));
    ships.add(help);
    add(ships);
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
}