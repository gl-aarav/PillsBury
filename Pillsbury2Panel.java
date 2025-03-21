/* Aarav Goyal
 * 3.12.25
 * Pillsbury2Panel.java  
 * 
 * This program:
 * 	1. This has a button handler class to respond to the action.
 * 	2. The panels are added to one panel, which is added to the frame.
 * 	3. the panels use common info
 * 	4. The button is added to the panel, which has a FlowLayout, and is regular size.
 * 	5. Try different layouts
 */ 

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Color;	
import java.awt.Graphics;
import java.awt.Font;
import javax.swing.JFrame;	
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pillsbury2Panel
{    
    public static void main(String[] args)
    {
        Pillsbury2Panel pillsbury2panel = new Pillsbury2Panel();
        pillsbury2panel.runIt();
    }
    
    public void runIt()
    {
        JFrame frame = new JFrame("Pillsbury Dough boy");
        frame.setSize(400, 300);                
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        frame.setLocation(400, 50);
        frame.setResizable(true);
        PillsburyPanel2 pillsPanel2 = new PillsburyPanel2();         
        frame.getContentPane().add(pillsPanel2);    
        frame.setVisible(true);        
    }
}
  
class PillsburyPanel2 extends JPanel
{
    private DrawPanel drawP;    
    private PressPanel pressP;
    private boolean pressed;
    private JButton button1;
    
    public PillsburyPanel2()
    {
        setLayout(new GridLayout(1, 2));
        pressP = new PressPanel();
        add(pressP);
        
        drawP = new DrawPanel();
        add(drawP);
    }
    
    public class PressPanel extends JPanel
    {
        public PressPanel()
        {
            setLayout(new FlowLayout());
            button1 = new JButton("Press my belly.");
            
            Button1Handler bhandler1 = new Button1Handler();
            button1.addActionListener(bhandler1);
            add(button1);
            pressed = false;
        }
    }
    
    class Button1Handler implements ActionListener
    {
        public void actionPerformed(ActionEvent evt)
        {     
            String command = evt.getActionCommand();    
            if (command.equals("Press my belly."))
            {
                pressed = true;
                button1.setText("reset");
            }
            else
            {
                button1.setText("Press my belly.");
                pressed = false;
            }
            drawP.repaint();
        }    
    }
    
    public class DrawPanel extends JPanel
    {
        public DrawPanel()
        {
            setBackground(Color.MAGENTA);
        }
        
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            Font font = new Font("Serif", Font.BOLD, 30);
            g.setFont(font);
            if (pressed)
            {
                g.drawString("tee hee", 70, 100);
            }
        }
    }
}
