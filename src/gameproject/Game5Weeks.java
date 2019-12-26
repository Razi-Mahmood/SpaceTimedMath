package gameproject;

//Razi Mahmood
//4/20/15
//Period 5

//Game5Weeks is a program that contains math problems from 1st to 9th grade
//It contains a character named Bob who is trying to reach his father through space

//The goal of the program is to have the user solve the problems correctly to help Bob find his father
//The obstacles are the math problems from each grade level 
//If I have time, I am planning on putting a option for the user to solve the obstacles in a given amount of time

//Should Work: clicks on 1 JRadioButton, enters valid name into the JTextField, clicks directly on the JButtons
//Shouldn't work: doesn't enter name at all, clicks on a blank space on the JPanel

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*import libraries:
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javacourse.RajviPanel.BackPanel;
import javacourse.RajviPanel.MiddlePanel;
import javacourse.RajviPanel.TitlePanel; */



public class Game5Weeks extends JFrame{ //declare JFrame

	String playername;	
	JTextField txt;	
	int finalscore;//declare global int finalscore
	public static void main(String [] args) {//main()
		Game5Weeks gw = new Game5Weeks(); //declare instance for calling constructor
	}

	public Game5Weeks() { //constructor
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(600, 600);//set the size to be 1000,1000
		setLocation(0,0);
		setResizable(false);

		GamePanel gp = new GamePanel();
		setContentPane(gp);
		setVisible(true); //make it visible

		//declare and initialize TextFiles for questions and answers for grade levels
		//call the panel containing the other panels
		//call the method containing the text file

	}

	class GamePanel extends JPanel { //create Gamepanel containing each of the panels relating to the game stages
		CardLayout card;//create global cardlayout for showing the different panels
		GradePanel gp;//declare and initialize the different gradepanels
	
	    ContainPanel contain;
		//WalkPanel walk;//create a panel for Bob to just walk after the user has completed the challenges correctly
		//GoalPanel goal;//create a panel for when Bob finally meets his father
		//ScorePage scorepage;//create a panel calculating the points the user has received and the rank
		public ReadText rt; //create instance of ReadText 
		public GamePanel() {
			card = new CardLayout();//add these panels to the frame, create string labels for each panel added
			setLayout(card);
			rt=new ReadText(1);
			gp = new GradePanel(this);//declare and initialize 9 different panels for the type of grade being used 

		//	walk = new WalkPanel();
			
			contain = new ContainPanel();
			//goal = new GoalPanel();
			//scorepage = new ScorePage();

			//add(walk, "walkpanel");
			//add(goal, "goalpanel");
			add(contain, "containpanel");
			add(gp, "gradepanel");
			//add(scorepage, "scorepage");
		}
	}

	class ContainPanel extends JPanel {
			HomePanel home;//create a new panel for the Home page
			//FirstPanel buttonpanel;
			InstructionPanel inst;
			NamePanel namep; 	

			CardLayout cl;
			
			public ContainPanel() {
								
				cl = new CardLayout();
				setLayout(cl);
				
				home = new HomePanel();
				//buttonpanel=new FirstPanel();
				inst=new InstructionPanel();
				namep=new NamePanel();
				
				add(home, "homepanel");
				//add(buttonpanel,"buttons");
				add(namep,"namep");
				add(inst,"inst");
			}
			
		class HomePanel extends JPanel {//class Home Panel

			JLabel title;
			JLabel greeting;//JLabel for the game greeting 
			BorderLayout border;//set the layout as a GridLayout
			CardLayout c;

			GreetingsPanel greet;
			ButtonPan pan;

			String gamename; //use a String for the game name
			boolean playcheck;//use boolean if the user has clicked the play button: playcheck

			//NamePanel name; //create a user namepanel
			//SurePanel sure;

			public HomePanel() {//constructor

				border = new BorderLayout();
				setLayout(border);

				setBackground(Color.CYAN);
				pan = new ButtonPan();
				greet = new GreetingsPanel();

				add(pan, BorderLayout.SOUTH);
				add(greet, BorderLayout.CENTER);

			}

			class GreetingsPanel extends JPanel {

				Font cal;
				Font s;
				Font cg;
				Image space1;
				public GreetingsPanel() {
					
					setLayout(new BorderLayout());

					cal = new Font("Calibri", Font.BOLD, 20);
					s = new Font("Serif", Font.BOLD, 40);
					cg = new Font("Century Gothic", Font.ITALIC, 20);
					
					space1 = Toolkit.getDefaultToolkit().getImage("/Users/RaziMahmood/eclipseworkspace/SchoolPrograms/src/gameproject/space1.jpg");

					//title = new JLabel("SpaceTIMED MATH!! \n created by Razi Mahmood");
				      //setFont(n);
			      //this.add(title, BorderLayout.CENTER);    

				}
				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					setBackground(Color.CYAN);
					g.drawImage(space1,0,0,300,300,this);
					g.setFont(s);
					g.setColor(Color.RED);
					g.drawString("SpaceTimed MATH!!!", 150, 200);
					
					g.setFont(cg);
					g.setColor(Color.BLUE);
					g.drawString("created by Razi Mahmood", 120, 250);
				}		
			}
			class ButtonPan extends JPanel implements ActionListener{
				//CardLayout innerlayout;
				JButton play;
				JButton instructions;
				boolean playcheck;
				boolean instcheck;
					/*{
					//innerlayout=new CardLayout();
					//setLayout(innerlayout);
								
				}
				class FirstPanel extends JPanel implements ActionListener
				{

					public FirstPanel()*/
				public ButtonPan()
					{		
						instructions=new JButton("Instructions");
						play=new JButton("Play");
						instructions.addActionListener(this);
						play.addActionListener(this);
						add(instructions);
						add(play);
					}
					public void actionPerformed(ActionEvent e)
					{
						ContainPanel y = (ContainPanel)this.getParent().getParent();
						JButton jb=(JButton)e.getSource();
					
						if (jb.getText().equals("Instructions"))
						{
							System.out.println("Instructions selected");
							instcheck = true;
							y.cl.show(y, "inst");
						}
						else if (jb.getText().equals("Play"))
						{	
							System.out.println("play selected");
							playcheck = true;
							y.namep.x.show(y.namep, "getname");
							y.cl.show(y, "namep");
							
						}
					}
				}
			}
				class InstructionPanel extends JPanel //implements ActionListener
				{
				//	ContainPanel y = (ContainPanel)this.getParent().getParent();
					JTextArea z;
					String text;
					
					InstTitlePanel ipanel;
					TextPanel tpanel;
					BackHomePanel bpanel;
				
					public InstructionPanel()
					{
						setLayout(new BorderLayout());
						
						ipanel = new InstTitlePanel();//add 5 panels into the class     
					    tpanel=new TextPanel();
					    bpanel=new BackHomePanel();
					      
					    this.add(ipanel,BorderLayout.NORTH);
					    this.add(tpanel,BorderLayout.CENTER);
					    this.add(bpanel,BorderLayout.SOUTH);
						
					}
					class TextPanel extends JPanel { 
						
						public TextPanel() {						
							setBackground(Color.PINK);
							//JLabel instText=new JLabel("Instructions for how to play:");
							//add(instText);
							text = "This game is about a boy named Bob who is trying to find his lost father in outer space. " + 
									"\n To accomplish this mission, you need to help Bob solve different math problems to get him closer." +
									"\n You'll have 3 lives and every time you get a problem wrong, Bob loses a life." +
									"\n After all 3 lives are lost, you will start over";
							JTextArea z = new JTextArea(4, 60);
							add(z);
							z.setText(text);
							   JScrollPane scroll = new JScrollPane(z);
							add(scroll);
							
						}
					}
					class InstTitlePanel extends JPanel {
						JLabel instText;
						
						public InstTitlePanel() {
							setBackground(Color.CYAN);
							instText=new JLabel("Instructions for how to play:");
							add(instText);
						}
					}
					class BackHomePanel extends JPanel implements ActionListener {
												
						JButton backb;
						JButton conb;
						
						public BackHomePanel() {
							backb=new JButton("Back to Home");
							backb.addActionListener(this);
							this.add(backb);
							
							conb = new JButton("Continue");
							conb.addActionListener(this);
							this.add(conb);
						}
												
					public void actionPerformed(ActionEvent e)
					{
						ContainPanel y = (ContainPanel)this.getParent().getParent();
						
						
						if (e.getSource() instanceof JButton)
						{
							JButton jb=(JButton)e.getSource();
							if (jb.getText().equals("Back to Home"))
								y.cl.show(y,"homepanel");
							else if (jb.getText().equals("Continue"))
							{
								//go the same panel as play
								y.cl.show(y,"namep");
							}
						}
					}
				}
			}
				class NamePanel extends JPanel
				{	//namePanel
					//JLabel for asking name
					//JTextArea for typing name
					//boolean for the user to type: typedsomething
					//use getText() method for extracting the name
					//if typedsomething is true
					//call SurePanel
					GetName getname;
					SurePanel sure;
					CardLayout x;
					
					public NamePanel()
					{
						x = new CardLayout();
						setLayout(x);
											
						getname = new GetName();
						sure = new SurePanel();						
						add(getname, "getname");
						add(sure, "surepanel");
					}	
					
					class GetName extends JPanel {
										
						NameTitle nametitle;
						NameWrite namewrite;
						NameBackorForward nameback;
						
						public GetName() {
							setLayout(new BorderLayout());
							
							nametitle = new NameTitle();
							namewrite = new NameWrite();
							nameback = new NameBackorForward();
							
							add(nametitle, BorderLayout.NORTH);
							add(nameback, BorderLayout.SOUTH);
							add(namewrite, BorderLayout.CENTER);
						}
						
						class NameTitle extends JPanel {
							
							JLabel statename;
							Font font;
							
							public NameTitle() {
								setBackground(Color.PINK);
								font = new Font("Serif", Font.BOLD, 20); //set font as bold Calibri
								
								statename = new JLabel("FIRST, WE GOTTA KNOW WHO YOU ARE!");
								statename.setFont(font);
								add(statename);
							}
						}
						class NameWrite extends JPanel{
							
							
							JLabel jt;
							JLabel check;
							public NameWrite() {
								jt=new JLabel("Please enter your name");
								txt=new JTextField(20);
								check=new JLabel("");
								
								this.add(jt);
								this.add(txt);
								this.add(check);
								
							}
							
					    }
					    class NameBackorForward extends JPanel implements ActionListener {
							JButton con;
							JButton bt;
							Font f2;
								 
								//use continue and instructions
								//initialize all the global variables and set a background
							//set the layout as a cardlayout 

							//if continuecheck is true
							// call surepanel or namepanel using the show()

							public NameBackorForward() {	
								
								f2 = new Font("Calibri", Font.BOLD, 20);
															
								con=new JButton("Continue to play");								
								bt = new JButton("Back to Home");					
								
								con.setFont(f2);
								bt.setFont(f2);
								
								con.addActionListener(this);
								bt.addActionListener(this);
								
								add(con);
								add(bt);
							}
							public void actionPerformed(ActionEvent evt) {
								GetName gn=(GetName)this.getParent();
									
								NamePanel ntype = (NamePanel)this.getParent().getParent();
								
								ContainPanel cpan = (ContainPanel)ntype.getParent();
								
								JButton j=(JButton)evt.getSource();
								boolean continueclicked;
								boolean namebackclicked;
								
								
								if(j.getText().equals("Continue to play")) {
									if (txt.getText().length()>0)
									{
										System.out.println("You entered "+txt.getText());
										gn.namewrite.check.setText("");
										playername = txt.getText();
										continueclicked = true;
										ntype.sure.decision.setText(playername + ", are you sure you want to begin playing?");
										x.show(namep, "surepanel");
									
									}
									else
									{
										System.out.println("Please enter your name to proceed");
										gn.namewrite.check.setText("Please enter your name to proceed");
									}
								}
								else if (j.getText().equals("Back to Home")) {
									namebackclicked = true;
									cl.show(cpan, "homepanel");
								}							    								
							}				
					    }				    	
					}
					
					class SurePanel extends JPanel {//SurePanel uses actionlistener	
						
						StateDecision decide;
						JLabel decision;
						ButtonGroup makechoice;
						JButton yes;//create 2 JButtons for yes or no  choices	

						JButton no;
						
						boolean yesclicked;
						boolean noclicked;
						
						public SurePanel() {
							setBackground(Color.PINK);
							setLayout(new BorderLayout());//set layout as BorderLayout
							decide = new StateDecision();
							add(decide, BorderLayout.CENTER);
						}
						
						class StateDecision extends JPanel implements ActionListener {
							ContainPanel cpan;
							
							public StateDecision() {
								setBackground(Color.CYAN);
								decision = new JLabel(playername + ", are you sure you want to begin playing?");
								decision.setFont(new Font("Cambria", Font.ITALIC, 15));
								add(decision,BorderLayout.CENTER);
								//decision.setText(namep.getname.namewrite.txt.getText());
								//makechoice = new ButtonGroup();
								yes = new JButton("Yes");			
								no = new JButton("No");
								yes.setFont(new Font("Serif", Font.BOLD, 20));
								no.setFont(new Font("Serif", Font.BOLD, 20));
							//	makechoice.add(yes);
								//makechoice.add(no);
								//add(makechoice);
								yes.addActionListener(this);
								no.addActionListener(this);

								add(yes);
								add(no);
							}
							/*public void paint (Graphics g)
							{
								g.drawString("Hello", 0,0);
							}*/
							public void actionPerformed(ActionEvent evt) {
								JButton dark =(JButton)evt.getSource();
								cpan = (ContainPanel)(this.getParent().getParent().getParent());
								
								System.out.println("here");
								if (dark.getText().equals(yes.getText())) 
								{
									yesclicked = true;
									GamePanel gpanel=(GamePanel)cpan.getParent();
									//gp.startInt(1);
									gpanel.gp.startGame();
									
									gpanel.gp.gq.displayquestion.setQuestion(0,1);
									gpanel.card.show(gpanel, "gradepanel");	
								}
								else if(dark.getText().equals(no.getText())) {
									noclicked = true;	
									cl.show(cpan, "homepanel");
									System.out.println("No button");
								}	
							
							//create a new JLabel containing the text and a question
							//create 2 JButtons for yes or no  choices	
							//boolean if clicked	
							
				}						
			}			//constructor
						//initialize all variables
						//actionPerformed()						
						//if clicked is true	
						//call walkpanel where Bob is walking in the game
		}
	  }
	}
  }