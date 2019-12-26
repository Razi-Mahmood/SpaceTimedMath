package gameproject;

//ScorePanel 
//This program is used for calculating the final score of the user 
//It combines how many problems the user got wrong and how many lives were lost

//Each GradePanel 1-9 = 10 points

//Each life = 5 points
//Each life lost = -5 points
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;*/
/** Gives the overall score*/
class ScorePage extends JPanel { //declare class
	int livescore;//declare global int livescore
	/*int grade1;//declare global ints that refer to each of the 9 gradepanels
	int grade2;
	int grade3;
	int grade4;
	int grade5;
	int grade6;
	int grade7;
	int grade8;
	int grade9;*/

	ScoreTitle st;
	ScoreRows sr;

	public ScorePage(int panelscore) {//constructor with score param.
		bl = new BorderLayout();
		setLayout(bl);
		
		st = new ScoreTitle();
		sr = new ScoreRows();
		add(st,BorderLayour.NORTH);
		add(sr,BorderLayout.CENTER);
	}
	
	class ScoreTitle extends JPanel {
		JLabel herescore; 
		
		public ScoreTitle() {
			
	setBackground(Color.PINK);
			herescore = new JLabel("Here is your Score Data");
			add(herescore);
		}
	}
	class ScoreRows extends JPanel {
		JButton restart;//declare global JButtons for the user to quit or continue playing
		JLabel rank;//declare global JLabel rank
		String ranking;//declare global string ranking
		int finalscore;//declare global int finalscore
		Gridlayout g;
		BorderLayout bl;
		
		JLabel bonusscore;//declare global JLabel bonusscore
		JLabel finaldisplay;//declare global JLabel finalscore
		InitPanel inp;
		LivePanel lvp;
		TotalPanel ttp;
		
		public ScoreRows() {
			g = new GridLayout(3,1,0,0);
			setlayout(g);//set param to int score
			
			inp = new InitPanel();
			lvp = new LivePanel();
			ttp = new TotalPanel();
			
			add(inp);
			add(lvp);
			add(ttp);
		}
		
		class InitPanel extends JPanel {
			JLabel initscore;//declare global JLabel initscore
			
			public InitPanel(int score) {
				initscore = new JLabel("Here is the initial score: " );
			}
		}			
	}
}

			//initializs JLabel with the heading 
			//call SetRank class
		
		//SetRank
			//create instances of each of the gradepanels
			
			//extract the liveslost data from each gradepanel-->set the int to liveslost
			//extract the livesgain data from each gradepanel-->set the int to livesgain
			
			//extract the integer values of each score from each grade panel by setting them to new ints
			//add all the grade scores together to get one final int
				//set this int as the String for initscore
			
			//if the liveslost equals 0 for all gradepanels
				//add 15 points to livescore
			//else if the liveslost equals 1
				//add 10 points to livescore
			//else if liveslost equals 2
				//add 5 points to livescore
			
			//set livescore as a String for bonusscore
			
			//add livescore to the final score
	
			//set finalscore as String for finalscore
	
			//if final score equals 105
				//set rank equal to Jedi Knight 
			//if final score equals 100
				//set rank equal to Admiral Skywalker
			//if final score equals 95
				//set rank equal to Commander Spock
			
			//initialize JButton Restart
			//initialize Jbutton Quit
	
			//if Restart is clicked
				//use the cardlayout from GamePanel to show Home
			
			//if Quit is clicked
				//automatically terminate the program 
			
