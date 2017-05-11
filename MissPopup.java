import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MissPopup extends JPanel{
  private JPanel text1, text2, btns, mp;
  private JButton ok;
  private JFrame f;
  private String coord;
  private PlayBattleship game;
  
  public MissPopup(JFrame f, String coord, PlayBattleship game) {
    this.f = f;
    mp = this;
    this.coord = coord;
    this.game = game;
    
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
    JLabel l2 = new JLabel("MISS");
    l2.setFont(new Font("Russo One",Font.BOLD, 60));
    l2.setForeground(Color.WHITE);
    
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
      f.getContentPane().remove(mp);
      f.setVisible(false);
    }
  }
}
