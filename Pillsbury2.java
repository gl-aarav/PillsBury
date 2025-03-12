/* Aarav Goyal
 * 3.12.25
 * Pillsbury2.java  
 * 
 * A panel in which a button is used to make the panel giggle.
 * Pillsbury Dough Boy. poke his belly and he giggled.  
 * User interacts with a button labeled "press my tummy."  Upon pressing, "tee hee" 
 * is drawnand the button gets relabeled "reset."  Upon pressing, screen refreshes, 
 * meaning the text goes away.
 * 
 * This version uses a seperate class to handle the button action.
 * ButtonHandler then implements ActionListener, not the JPanel.
 */ 


import java.awt.Color;	
import java.awt.Graphics;
import java.awt.Font;

import javax.swing.JFrame;	
import javax.swing.JPanel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pillsbury2
{	
	public static void main(String[] args)
	{
		Pillsbury2 pillsbury2 = new Pillsbury2();
		pillsbury2.runIt();
	}
	
	public void runIt()
	{
		JFrame frame = new JFrame("Pillsbury Dough boy");
		frame.setSize( 400, 300);				
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setLocation(400,50);
		frame.setResizable(true);
		PillsburyPanel2 pillsPanel2 = new PillsburyPanel2(); 		
		frame.getContentPane().add(pillsPanel2);	
		frame.setVisible(true);		
	}
}
  
class PillsburyPanel2 extends JPanel
{
	private boolean pressed;	
	private JButton button;
	private Font font;
	
	public PillsburyPanel2()
	{
		pressed = false;		
		font = new Font ("Serif", Font.BOLD, 30);
		button = new JButton("Press my belly.");
		ButtonHandler bhandler = new ButtonHandler();
		button.addActionListener(bhandler);
		add(button);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);	
		g.setFont(font);	
			
		if (pressed)
		{
			g.drawString("tee hee", 100, 100);
		}
	}
	
	class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{ 	
			String command = evt.getActionCommand();	
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
}
