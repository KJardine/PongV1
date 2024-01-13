import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;


public class PongPanel extends JPanel{
	//Properties
	int intP1Y = 100;
	int intP2Y = 100; 
	int intP1Def = 0;
	int intP2Def = 0;
	
	int intBallX = 300;
	int intBallY = 300;
	int intBallDefX = 3;
	int intBallDefY = 3;
	
	int intP1Score = 0;
	int intP2Score = 0;
	
	String strP1 = "0";
	String strP2 = "0";
	
	
	
	//Methods
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//Background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 720, 480);
		//P1
		g.setColor(Color.WHITE);
		g.fillRect(50, intP1Y, 10, 100);
		//P2
		g.setColor(Color.WHITE);
		g.fillRect(660, intP2Y, 10, 100);
		//Ball
		g.fillRect(intBallX, intBallY, 10, 10);
		
		g.drawString(strP1, 10, 10);
		g.drawString(strP2, 700, 10);
		
		//ball movement 
		intBallX = intBallX + intBallDefX;
		intBallY = intBallY + intBallDefY;
		if(intBallY > 470){
			intBallDefY = -3;
		}
		if(intBallY < 0){
			intBallDefY = 3;
		}
		if(intBallX > 710){
			intBallDefX = -3;
			intP1Score = intP1Score +1;
			strP1 = String.valueOf(intP1Score);
		}
		if(intBallX < 0){
			intBallDefX = 3;
			intP2Score = intP2Score +1;
			strP2 = String.valueOf(intP2Score);
		}
		
		//Left paddle collision detection
		if(intBallX <= 60 && intBallY > intP1Y - 10 && intBallY < intP1Y + 100){
			intBallDefX = 3;
		}
		
		//Right padd collision detection
		if(intBallX >= 650 && intBallY > intP2Y - 10 && intBallY < intP2Y + 100){
			intBallDefX = -3;
		}
		
		//paddle movement 
		intP1Y = intP1Y + intP1Def;
		intP2Y = intP2Y + intP2Def;
			
		
		
		
	}
	
	
	//Constructor
	public PongPanel(){
		super();
	
	}
}
