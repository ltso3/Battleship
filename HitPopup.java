import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class HitPopup extends JPanel{
  private JPanel text1, text2, btns, hp;
  private JButton ok;
  private JFrame f;
  private String coord;
  private boolean ready;
  private PlayBattleship game;
  
  public HitPopup(JFrame f, String coord, PlayBattleship game) {
    this.f = f;
    hp = this;
    this.game = game;
    this.coord = coord;
    
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setBackground(new Color(197, 204, 208));
    
    // Initialize instance variables
    text1 = new JPanel();
    text2 = new JPanel();
    btns = new JPanel();
    ok = new JButton("OK");
    
    // Create labels
    JLabel l1 = new JLabel("Coordinate: [" + coord + "]");
    l1.setFont(new Font("Russo One",Font.PLAIN, 36));
    JLabel l2 = new JLabel("HIT");
    l2.setFont(new Font("Russo One",Font.BOLD, 60));
    l2.setForeground(Color.RED);
    
    // Edit buttons
    ok.setBackground(new Color(94, 197, 110));
    ok.setOpaque(true);
    ok.setBorder(BorderFactory.createLineBorder(Color.black));
    ok.setPreferredSize(new Dimension(110, 50));
    ok.addActionListener(new ButtonListener());
    
    // Add labels and buttons and format
    text1.setBackground(new Color(197, 204, 208));
    text2.setBackground(new Color(197, 204, 208));
    text1.add(l1);
    text2.add(l2);
    btns.add(ok);
    btns.setBackground(new Color(197, 204, 208));
    add(text1);
    add(text2);
    add(btns);
  }
  
  private class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      invalidate();
      setVisible(false);    
      f.getContentPane().remove(hp);
      f.setVisible(false);
       if(game.computerTurn()) {
         System.out.println("Hey");
          ComputerHit ch = new ComputerHit(f, game.getCCoord());
          f.getContentPane().add(ch);
        }
        else {
                   System.out.println("Hey here");
          ComputerMiss cm = new ComputerMiss(f, game.getCCoord());
          f.getContentPane().add(cm);
        }
    }
  }
}
