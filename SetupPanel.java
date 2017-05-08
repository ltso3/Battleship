import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class SetupPanel extends JPanel {
  private JPanel ships;
  private JButton help;
  private JPanel grids;
  
  public SetupPanel() {
    setLayout(new BorderLayout()); // Sets panel layout to BoxLayout vertically
    
    grids = new JPanel();
    grids.setLayout(new BoxLayout(grids, BoxLayout.Y_AXIS));
    grids.add(new GridPanel());
    grids.add(Box.createRigidArea(new Dimension(0,30)));
    grids.add(new GridPanel());
    add(grids, BorderLayout.CENTER);
    
    ships = new JPanel();
    help = new JButton(new ImageIcon("help-icon.png"));
    help.setPreferredSize(new Dimension(35,35));
    help.addActionListener(new ButtonListener());
    ships.add(help);
    add(ships, BorderLayout.SOUTH);
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