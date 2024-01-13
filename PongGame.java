import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class PongGame implements ActionListener, KeyListener, MouseMotionListener{
	//Properties
	JFrame theFrame = new JFrame("Pong");
	PongPanel thePanel = new PongPanel();
	Timer theTimer = new Timer(1000/60, this);
	
	
	//Methods
	public void mouseMoved(MouseEvent evt){
		int intY = evt.getY();
		if(intY > thePanel.intP2Y + 100){
			thePanel.intP2Def = 4;
		}else if(intY <= thePanel.intP2Y){
			thePanel.intP2Def = -4;
		}else{
			thePanel.intP2Def = 0;
		}
			
	}
	public void mouseDragged(MouseEvent evt){
	}
	
	
	
	
	
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == theTimer){
			thePanel.repaint();
		}
	}
	
	public void keyReleased(KeyEvent evt){
		if(evt.getKeyChar() == 'w'){
			thePanel.intP1Def = 0;
		}else if(evt.getKeyChar() == 's'){
			thePanel.intP1Def = 0;
		}
	}
	public void keyPressed(KeyEvent evt){
		if(evt.getKeyChar() == 'w'){
			thePanel.intP1Def = -4;
		}else if(evt.getKeyChar() == 's'){
			thePanel.intP1Def = +4;
		}
	}
	public void keyTyped(KeyEvent evt){
	}
	
	//Constructor
	public PongGame(){
		thePanel.setPreferredSize(new Dimension(720, 480));
		thePanel.addMouseMotionListener(this);
		theFrame.setContentPane(thePanel);
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.pack();
		theFrame.setVisible(true);
		theFrame.setResizable(false);
		theFrame.addKeyListener(this);
		theTimer.start();
		
		
		
	}
	
	//main method
	public static void main(String[] args){
		new PongGame(); 
	}
}
