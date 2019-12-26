package gameproject;
//GradePanels 1-9

//This program is used for giving the different types of math questions for the user
//It extracts questions from the text file corresponding to the grade

//In the text files, I will label the questions and the answers with a number to match
//This panel will called after the continue button has been pressed

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import gameproject.Game5Weeks.GamePanel;

/*import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.CardLayout;//import libraries
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
//import java.io.PrintWriter;//import PrintWriter*/	
/** * @author RaziMahmood
 * Has 2 cards.
 * 1.shows the questions per grade
 * 2.Gives right answer and proceed to next grade
 * 3. Give wrong answer and retry for the same grade
 * 4. Give 3 wrong the game ends and restart goes back to home page
 * 5. OPtional page to show progress along the way interpersed with the question pages for progress.
 * Loop over 1-4 iterating over grades and using one panel to accomplush 2-4. */
class GradePanel extends JPanel {//declare Grade1Panel
	CardLayout v; //make global cardlayout
	GiveQuestion gq;
	RightOrWrong rw; //will show the right or wrong message
	GamePanel mygame;
	int currGrade;
	int countcorrect;
	int countincorrect;
	boolean correctchoice;
	int numTries;
//	String header="/Users/RaziMahmood/eclipseworkspace/SchoolPrograms/src/gameproject";
	String header="/Users/tanveersyeda/Desktop/eclipseworkspaces/school/workspace/GameProject/src/gameproject";
	int maxTries=2;
	int overallscore;
	//int lostlives; //keep at scores here . Isn't that the same as countincorrect?
	public GradePanel(GamePanel gp) {//constructor 
		//declare the text file for grade1
		int begin;
		mygame=gp;
		v = new CardLayout();
		setLayout(v);
		gq = new GiveQuestion();
		rw = new RightOrWrong();		
		add(gq, "givequestion");
		add(rw, "rightorwrong");
	}
	
	public void updateScore()
	{
		if (correctchoice)
		{
			if (currGrade<9)
			overallscore+=10;
			else overallscore+=20;
		}
	}
	public void startGame()
	{
		countcorrect=0;
		countincorrect=0;
		numTries=0;
		correctchoice=true;
		overallscore=0;
		currGrade=1;
	}

	class GiveQuestion extends JPanel {
		GridLayout gridL;
		JRadioButton choice1; //declare String answer1
		JRadioButton choice2; //declare String answer2
		JRadioButton choice3; //declare String answer3
		JRadioButton choice4; //declare String answer4	
		String c1;
		String c2;
		String c3;
		String c4;
		ReadText rt;
		JLabel problem;//problem
		String question;//declare String question
		int grade;
		int i;
		BorderLayout bordL;
		Question selectedQuestion;

		GradeTitle gradetitle;
		DisplayQuestion displayquestion;
		SubmitPanel submitpanel;

		public GiveQuestion() {

			bordL = new BorderLayout();
			setLayout(bordL);

			gradetitle = new GradeTitle();
			displayquestion = new DisplayQuestion();
			submitpanel = new SubmitPanel();

			add(gradetitle, BorderLayout.NORTH);
			add(submitpanel, BorderLayout.SOUTH);
			add(displayquestion, BorderLayout.CENTER);
		}
		class GradeTitle extends JPanel {
			JLabel gradeinstructions;

			public GradeTitle() {
				setBackground(Color.GREEN);
				gradeinstructions = new JLabel("Choose the correct answer. Press Submit when you're done.");
				add(gradeinstructions);
			}
		}
		class DisplayQuestion extends JPanel {

			public DisplayQuestion() {
				setBackground(Color.ORANGE);			
				gridL = new GridLayout(5,1,0,0);
				setLayout(gridL);//set layout as gridlayout

				choice1 = new JRadioButton("");
				choice2 = new JRadioButton("");
				choice3 = new JRadioButton("");
				choice4 = new JRadioButton("");

				c1 = "";
				c2 = "";
				c3 = "";
				c4 = "";

				question = "";		
				problem = new JLabel(" ");

				add(problem);
				add(choice1);
				add(choice2);
				add(choice3);
				add(choice4);
			}

			public void setQuestion(int grade, int question)
			{
				selectedQuestion=mygame.rt.gradeQuestions[grade][question];
				mygame.rt.printQuestion(selectedQuestion);
				c1 = selectedQuestion.answers[0];
				c2 = selectedQuestion.answers[1];
				c3 = selectedQuestion.answers[2];
				c4 = selectedQuestion.answers[3];

				choice1.setText(c1);
				choice2.setText(c2);
				choice3.setText(c3);
				choice4.setText(c4);
				problem.setText(selectedQuestion.questionText);

			}

		}
		class SubmitPanel extends JPanel implements ActionListener {
			JButton submit;

			public SubmitPanel() {
				setBackground(Color.PINK);
				submit = new JButton("SUBMIT");
				add(submit);
				
				choice1.addActionListener(this);
				choice2.addActionListener(this);
				choice3.addActionListener(this);
				choice4.addActionListener(this);
			}
			public void actionPerformed(ActionEvent evt)
			{
				JRadioButton choice=(JRadioButton)evt.getSource();
				GradePanel gradep = (GradePanel)this.getParent().getParent();
				numTries++; //increment the number of tries
				if (numTries==maxTries)
				{
					System.out.println("Game is to stop");
				}
				else if (choice.getText().equals(selectedQuestion.correctanswers[0]))
				{
					System.out.println("Answer is correct");
					countcorrect++;
					correctchoice=true;
					//make the status panel say the right message
					//add the relevant buttons in the trypanel
					//switch the card layout to the rightorwrong panel
					rw.sp.setLabelText();
					rw.path.face.repaint();
					rw.path.toc.tryagain.setVisible(false);
					//gradep.rw.sp.getInt(gradep,countcorrect, countincorrect);
					//gradep.rw.path.face.intSmileSad(countcorrect, countincorrect);
					
					
				}
				else {
					countincorrect++;
					System.out.println("Answer is incorrect");
					correctchoice=false;
					//countcorrect--;			
					rw.sp.setLabelText();
					rw.path.face.repaint();
					rw.path.toc.tryagain.setVisible(true);
				
					//gradep.rw.sp.getInt(gradep,countcorrect, countincorrect);
					//gradep.rw.path.face.intSmileSad(countcorrect, countincorrect);
					
				}
				v.show(gradep,"rightorwrong");
			}
		}
	}

	class RightOrWrong extends JPanel { 

		GridLayout g;
		StatusPanel sp;
		PathPanel path;
		boolean rightchoice;//declare boolean for correctchoice
		boolean wrongchoice;//declare boolean for incorrectchoice
		boolean restartchoice;
		
		public RightOrWrong() {
			g = new GridLayout(2,1,0,0);
			setLayout(g);

			sp = new StatusPanel();
			path = new PathPanel();

			add(sp);
			add(path);
		}

		class StatusPanel extends JPanel {
			JLabel status;
			String right= "Congratulations, you got the problem right. You get 10 points for completing this panel";
			String wrong = "Oh. sorry! Your answer was incorrect. You've just lost" ;
			String remain="lives. Try doing the problem again";
			
			String alllost = "Oh. sorry! Your answer was incorrect. You've just lost all";
			String remain2="lives. Press the restart button to replay the game";
			
			
			//int lostlives=0;
			//declare int lostlives for how many problems the user has gotten wrong
			
			public StatusPanel() {
				setBackground(Color.ORANGE);
				status = new JLabel("text goes here");
				add(status);
			}
			public void setLabelText()
			{
				if (correctchoice)
					status.setText(right);
				else if (countincorrect==1)
					
				{
					status.setText(wrong+countincorrect+remain);
				}
				else
				{
					status.setText(wrong+countincorrect+remain2);
				}
			}
			
		/*	public void getInt(GradePanel gradep,int recievecorrect, 
					int recieveincorrect) 
			{
				
				if ((recievecorrect == 1) && (recieveincorrect == 0)) {
					setBackground(Color.CYAN);
					status.setText(right);
					rightchoice = true;
					System.out.println("Try again should not be visible");
					gradep.rw.path.toc.tryagain.setVisible(false);
					gradep.rw.path.toc.getBooleans(rightchoice);
				}
				else {
					lostlives++;
					if ((recieveincorrect == 1) || (recieveincorrect == 2)) {
						setBackground(Color.RED);
						
						status.setText(wrong+lostlives+remain);
						wrongchoice = true;
						
						gradep.rw.path.toc.tryagain.setVisible(true);
					
						gradep.rw.path.toc.getBooleans(wrongchoice);
					}
					else if(recieveincorrect == 3) {
						setBackground(Color.PINK);
						status.setText(alllost+lostlives+remain2);
						restartchoice = true;
						gradep.rw.path.toc.getBooleans(restartchoice);
					}
				}
			}*/
		}
		class PathPanel extends JPanel {

			FacePanel face;
			TryOrContinue toc;
			boolean decide;
			public PathPanel() {
				setLayout(new GridLayout(1,2,0,0));
				face = new FacePanel();
				toc = new TryOrContinue();
				add(face);
				add(toc);
			}
			
			
			//displays images
			class FacePanel extends JPanel {
				Image smile;
				Image sad;
				Image angry;
				int correct;
				int wrong;
				public FacePanel() {
					smile = Toolkit.getDefaultToolkit().getImage(header+"/smile.jpg");
					sad = Toolkit.getDefaultToolkit().getImage(header+"/sad.jpg");
					angry = Toolkit.getDefaultToolkit().getImage(header+"/angry.jpg");
				}
				/*public void intSmileSad(int r, int d) {
					correct = r;
					wrong = d;
					repaint();
				}*/
				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					if(correctchoice)  
						g.drawImage(smile,0,0,150, 150,this);
					else
						g.drawImage(sad,0,0,150,150,this);
					
				}
			}
			class TryOrContinue extends JPanel implements ActionListener {
				JButton tryagain;
				JButton keepplaying;
				JButton restart;
				public TryOrContinue() {
					tryagain = new JButton("Try again");
					keepplaying = new JButton("Continue");
					restart = new JButton("Restart");
					
					tryagain.addActionListener(this);
					keepplaying.addActionListener(this);
					restart.addActionListener(this);
					
					add(tryagain);
					add(keepplaying);
					add(restart);
				}
				public void getBooleans(boolean d) {
					decide = d;
				}
				public void actionPerformed(ActionEvent evt) {
					//this should take action on tryagain or continue
					/*if (rightchoice) {
						System.out.println("Try again should not be visible");
						tryagain.setVisible(false);
						keepplaying.setVisible(true);
					}
					else if (wrongchoice) {
						tryagain.setVisible(true);
						keepplaying.setVisible(false);
					}
					else if (restartchoice) {
						tryagain.setVisible(false);
						keepplaying.setVisible(false);
						restart.setVisible(true);
					}*/
					
				JButton mybutton=(JButton)evt.getSource();
				GradePanel gp=(GradePanel)this.getParent().getParent().getParent();
				if (mybutton.getText().equals(tryagain.getText()))
				{
					System.out.println("Try again");
					
				}
				else if (mybutton.getText().equals(keepplaying.getText()))
				{
					System.out.println("Keep playing");
					//go to the next question
					gp.gq.displayquestion.setQuestion(0,2);
					gp.v.show(gp, "givequestion");	
				}
				else if (mybutton.getText().equals(restart.getText()))
				{
					System.out.println("Start over");
				}
				}
			}
		}
	}
}




//set the background to a specific background
//initialize JLabel 
//initialize JRadioButtons with the text extracted from the TextFile

//call readtext with int refering to the grade

//use the strategy of answer choices:
//at the first question, the first choice is correct 
//at second question, second choice is correct
//at third question, 3rd choice is correct

//call statuspage

//

//if correctchoice 
//use a JLabel to show the user has answered properly
//create a JButton for the user to continue

//if the continuebutton is clicked 
//call the walk panel

//if incorrectchoice
//use a JLabel to show the user has answered wrong
//also indicate that the user has lost one life
//create JButton to go back to the problempanel
//increment lostlives

//if lostlives is 3
//use another JLabel saying that the user has lost all lives
//use a JButton redirecting back to Home

//**Grade9Panel: if correctchoice is true for both questions--simply call the goalpanel instead of the walkpanel 