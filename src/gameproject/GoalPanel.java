package gameproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;//import libraries
/**
 * 
 * @author razi
 * Moves the figure across for progress
 *
 */
class GoalPanel extends JPanel{
	
	JButton goscore;//declare JButton to show the score 
	Image bob;
	Image bodbad;
	BorderLayout bordlayout;
	
	ProgressPanel progressp;
	DrawingPanel drawingp;
	MoveButtonPanel mbp;
	
	
	public GoalPanel() {//constructor
		//bob = Toolkit.getDefaultToolkit().getImage("/Users/RaziMahmood/eclipseworkspace/SchoolPrograms/src/gameproject/bob.jpg");//declare an image for Bob
		//bobdad = Toolkit.getDefaultToolkit().getImage("/Users/RaziMahmood/eclipseworkspace/SchoolPrograms/src/gameproject/bobdad.jpg");//declare an image for Bob's father
		//goscore = new JButton("CONTINUE");//initialize the components and add them
		bordlayout = new BorderLayout();//set the layout to a BorderLayout
		setLayout(borderlayout);
		progressp = new ProgressPanel();//add ProgressPanel
		drawingp = new DrawingPanel();//add DrawingPanel
		mbp = new MoveButtonPanel();//add MoveButtonPanel
		add(progressp, BorderLayout.NORTH);
		add(mbp, BorderLayout.SOUTH);
		add(drawingp, BorderLayout.CENTER);
	}
	
	class ProgressPanel extends JPanel {//ProgressPanel
		JLabel achieve;//declare and initialize JLabel for showing the progress
		public ProgressPanel() {//constructor
			setBackground(Color.PINK);
			achieve = new JLabel("CONGRATUALTIONS!! YOU COMPLETED YOUR MISSION!! \n BOB IS REUNITED WITH HIS FATHER!!");
			add(achieve);
		}
	}
}
			
	//DrawingPanel
		//paintComponent()
			//use the same image for Bob from WalkPanel
		
			//create Bob's father with the DarthVader pic
	
	//MoveButtonPanel
		//actionPerformed()
		//create instance of the Game Panel and 
			//if the score button is clicked
				//set boolean to true
				//call the score panel using the cardlayout extracted from the GamePanel instance	
