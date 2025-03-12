/* Aarav Goyal
 * 3.12.25
 * Pillsbury.java  
 * 
 * A panel in which a button is used to make the panel giggle.
 * Pillsbury Dough Boy. poke his belly and he giggled.  
 * User interacts with a button labeled "press my tummy."  Upon pressing, "tee hee" 
 * is drawnand the button gets relabeled "reset."  Upon pressing, screen refreshes, 
 * meaning the text goes away.
 */ 


import java.awt.Color;	
import java.awt.Graphics;
import java.awt.Font;

import javax.swing.JFrame;	
import javax.swing.JPanel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pillsbury
{	
	public static void main(String[] args)
	{
		Pillsbury pillsbury = new Pillsbury();
		pillsbury.runIt();
	}

	public void runIt()
	{
		JFrame frame = new JFrame("Pillsbury Dough boy");
		frame.setSize(400, 300);				
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setLocation(400,50);
		frame.setResizable(true);
		PillsburyPanel pillsPanel = new PillsburyPanel(); 		
		frame.getContentPane().add( pillsPanel );	
		frame.setVisible(true);		
	}
}

class PillsburyPanel extends JPanel implements ActionListener
{
	private boolean pressed;
	private JButton button;
	
	public PillsburyPanel()
	{
		pressed = false;		
		button = new JButton("Press my belly.");
		button.addActionListener(this);
		add(button);
	}
	
	public void paintComponent(Graphics g)	
	{
		super.paintComponent (g);		
		Font font = new Font ("Serif", Font.BOLD, 30);
		g.setFont(font);	
		
		if (pressed)
		{
			g.drawString("tee hee", 10, 100);
		}
	}
	
	public void actionPerformed(ActionEvent evt)
	{ 
		String command = button.getText();	
		if (command.equals("Press my belly.")) 
		{
			pressed = true;
			button.setText("reset");
		}
		else
		{
			button.setText("Press my belly.");
			pressed = false;
		}
		repaint();
	}

}
