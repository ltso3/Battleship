import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ComputerHit extends JPanel{
	private JPanel text1, text2, text3, btns;
	private JButton ok;
	
	public ComputerHit() {
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(new Color(197, 204, 208));
		
		// Initialize instance variables
		text1 = new JPanel();
		text2 = new JPanel();
		text3 = new JPanel();
		btns = new JPanel();
		ok = new JButton("OK");
		
		// Create labels
	    JLabel l1 = new JLabel("It's the computer's turn");
	    l1.setFont(new Font("Russo One",Font.PLAIN, 25));
	    JLabel l2 = new JLabel("Coordinate: [fill in]");
	    l2.setFont(new Font("Russo One",Font.PLAIN, 36));
	    JLabel l3 = new JLabel("HIT");
	    l3.setFont(new Font("Russo One",Font.BOLD, 60));
	    l3.setForeground(Color.RED);
	    
	    // Edit buttons
	    ok.setBackground(new Color(94, 197, 110));
	    ok.setOpaque(true);
	    ok.setBorder(BorderFactory.createLineBorder(Color.black));
	    ok.setPreferredSize(new Dimension(110, 50));
	    ok.addActionListener(new ButtonListener());
	    
	    // Add labels and buttons and format
	    text1.setBackground(new Color(197, 204, 208));
	    text2.setBackground(new Color(197, 204, 208));
	    text3.setBackground(new Color(197, 204, 208));
	    text1.add(l1);
	    text2.add(l2);
	    text3.add(l3);
	    btns.add(ok);
	    btns.setBackground(new Color(197, 204, 208));
	    add(text1);
	    add(text2);
	    add(text3);
	    add(btns);
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
		}
	}
}
