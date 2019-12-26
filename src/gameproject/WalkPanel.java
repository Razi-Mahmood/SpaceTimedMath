package gameproject;
//WalkPanel.java
//This program is used for displaying Bob when he is walking
//shows a background with Bob's stick figure
//import libraries
//This panel will be always be called after the user has finished solving the problems 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;//import libraries

//10 points worth each grade panel 
//20 points worth Grade9Panel
//5 points worth each life --> contribute to bonus */
 
class WalkPanel extends JPanel {//declare WalkPanel 	
	BorderLayout bord;//make global cardlayout
	BobSpacePanel bobspace;//create instance of BobPanel
	WalkStatus walks;
	ButtonContinue bc;
	public WalkPanel(int y) {//constructor 
		setLayout(bord);//set layout as cardlayout		
		bobspace = new BobSpacePanel(); //add continuepanel to the bottom 							
		walks = new WalkStatus();//add spacepanel at center
		bc = new ButtonContinue();
		add(walks, BorderLayout.NORTH);
		add(bc, BorderLayout.SOUTH);
		add(bobspace, BorderLayout.CENTER);

	}
		
	class WalkStatus extends JPanel {//create WalkStatus  
		JLabel bobdoing;//declare global JLabel for telling what Bob is doing
		String word;
		Image bob;//delcare an image for Bob
		int y;
		public WalkStatus() {//constructor 
			setBackground(Color.PINK);
			bobdoing = new JLabel();//set Layout as BorderLayout
			add(bobdoing);
			if(y > 0 && y < 9) 
				bobdoing.setText("Bob is on his way through the dangerous journey through space. Click continue to move him further");
			else if(y==9)
				bobdoing.setText("Bob is on his way through the dangerous journey through space. Click continue to finish the last problem");
			}
		}
	}
		
	class ButtonContinue extends JPanel implements ActionListener {//buttoncontinue implementing an ActionListener
		JButton continuing; //initialize and add the button for moving to the next panel
					
		public ButtonContinue() {
			setBackground(Color.PINK);//set background to pink
			continuing = new JButton("Continue to the next question");
			boolean clickcheck; //create booleans for checking if the grade panels have been clicked
		}
		public void actionPerformed(ActionEvent e) {//actionPerformed() 				
			while (clickcheck == true) {//if clickcheck is true
				if(y > 0 && y < 10) //if gradepanel1 is chosen
					card.show(contain, "gradepanel");
			}
		}
	}
						//use the Game cardlayout to call the gradepanel2  
					//if gradepanel2 is chosen
						//use the Game cardlayout to call the gradepanel3
					//if gradepane13 is chosen
						//use the Game cardlayout to call the gradepanel4
					//if gradepanel4 is chosen
						//use the Game cardlayout to call the gradepanel5
					//if gradepanel5 is chosen
						//use the Game cardlayout to call the gradepanel6
					//if gradepanel6 is chosen
						//use the Game cardlayout to call the gradepanel7
					//if gradepanel7 is chosen
						//use the Game cardlayout to call the gradepanel8	
					//if gradepanel8 is chosen
						//use the Game cardlayout to call the gradepanel9

	class BobSpacePanel extends JPanel {//bobspacepanel for drawing Bob in outer space	
		JLabel dialogue;//initialize JLabels 				
		Image bob;
		public BobSpacePanel() {
			setBackground(Color.BLACK);
		    bob = Toolkit.getDefaultToolkit().getImage("bob.jpg");
		}	
		public void paintComponent(Graphics g) {//paintComponent()
			g.drawImage(bob, 0,30,40,40,this);//initialize and draw Bob's picture	
			
			/*for (int x = 0; x <= 600; x+=100) {//use a for loop 
				for (int y = 0; x <= 500; x+=100) {
					g.setColor(Color.WHITE);
					g.fillOval(x,y,50,50);//used for drawing different circles as stars
				}
			}		
			for (int x = 0; x <= 600; x+=20) {//use a for loop 
				for (int y = 0; x <= 500; x+=30) {
					g.setColor(Color.YELLOW);//draw the different Star Wars and Star Trek planets
					g.fillOval(x, y, 30, 30); 
				}
			}
			for (int x = 0; x <= 600; x+=50) {//use a for loop 
				for (int y = 0; x <= 500; x+=30) {
					g.setColor(Color.BLUE);
					g.fillOval(x,y,40,40);
				}
			}
			for (int x = 0; x <= 600; x+=80) {//use a for loop 
				for (int y = 0; x <= 500; x+=50) {			
					g.setColor(Color.RED);
					g.fillOval(x,y,50,70);
				}
			}
			for (int x = 0; x <= 600; x+=100) {//use a for loop 
				for (int y = 0; x <= 500; x+=100) {
					g.setColor(Color.GREEN);
					g.fillOval(x,y,20,20);
				}
			}*/
		}
	}