package gameproject;

import java.io.*;
import java.util.Scanner;

public class ReadText {
	Scanner y;
	File[] gradefiles;
	Question[][] gradeQuestions;
//	String header="/Users/RaziMahmood/eclipseworkspace/SchoolPrograms/src/gameproject";
	String header="/Users/tanveersyeda/Desktop/eclipseworkspaces/school/workspace/GameProject/src/gameproject";
	public static void main(String[] args) {//main() 
		ReadText read = new ReadText(1); //create constructor with param.
	}
	public ReadText(int numgrades) {
		gradefiles = new File[numgrades]; //make array with 9 cells
		gradeQuestions=new Question[numgrades][]; //make the first dimension of the array with 9 cells
		for (int i=0;i<numgrades;i++)
			{/*"/Users/RaziMahmood/eclipseworkspace/SchoolPrograms/src/gameproject/*/
				gradefiles[i]=new File(header+"/Grade"+(i+1)+".txt"); //fill the array with files
				processFile(i);
				
			}
		System.out.println("Number of question files = "+gradeQuestions.length);
		System.out.println("Number of question per file = "+gradeQuestions[0].length);
		checkQuestions();
		//   GradePanel gradep = new GradePanel();
		
		//gradeQuestions[0].length = number of columns
		//gradeQuestions.length = number of rows
	}
	public void checkQuestions()
	{
		for (int i=0;i<gradeQuestions.length;i++)
		{
			if (gradeQuestions[i]!=null)
			{
				for (int j=0;j<gradeQuestions[i].length;j++)
				{
					printQuestion(gradeQuestions[i][j]);
				}
			}
		}
	}
	public void printQuestion(Question q)
	{
		System.out.println(q.questionText);
		for (int i=0;i<q.answers.length;i++)
		System.out.println(q.answers[i]);
	}
	public void processFile(int grade)
	{
	
		boolean filefound;
		boolean questionfound;
		String q;
		String z;
		String a1;
		String a2;
		String a3;
		String a4;	
		String[] rightanswers;
		Question question;
		try
		{
			int i=0;
			
				y = new Scanner(gradefiles[grade]); //make a Scanner 9 files
				gradeQuestions[grade]=new Question[10];
				while (y.hasNext())
				{
				
				
					q = y.nextLine().trim();
					System.out.println(q);
					if(q.startsWith("Grade1 Questions and Answers:") || (q.startsWith("x"))) {
						question=new Question();
						question.questionText= y.nextLine().trim();	
						System.out.println(question.questionText);
						question.answers=new String[4];
						for (int j=0;j<4;j++) {
							question.answers[j]= y.nextLine().trim();
							System.out.println(question.answers[j]);
						}
						
						q = y.nextLine().trim();
						if (q.startsWith("right answer="))
						{
							System.out.println(q);
							rightanswers=q.split("=")[1].split(",");
							question.correctanswers=new String[rightanswers.length];
							for (int j=0;j<rightanswers.length;j++)
							{
							
								question.correctanswers[j]=question.answers[Integer.parseInt(rightanswers[j])];
							}
							
						}
						gradeQuestions[grade][i]=question;
						i++;
						//	filefound = true;			
						
						//gradep.gq(gradeQuestions[grade][i]);
					}
						
				}
				
			
		
		}
		catch(FileNotFoundException e){ //to catch FileNotFoundException
			e.printStackTrace();
			//System.out.println("Cannot find or create Grade file"); //generated in the files read or created
			System.exit(1);	//quit the program
		}
	}
}
class Question
{
	String questionText;
	String[] answers;
	String[] correctanswers;
}
		//if grade is 1
			//use for loop to extract question and answer choices
		    //send the questions to the gradepanel source
			//send the answer choices in the gradepanel source
	
		//if grade is 1			 
			//use for loop to extract question and answer choices
			//send the questions to the gradepanel source
			//send the answer choices in the gradepanel source
		//if the panel is grade3panel
			//use for loop to extract question and answer choices
			//send the questions to the gradepanel source
			//send the answer choices in the gradepanel source
		//if the panel is grade4panel
			//use for loop to extract question and answer choices
			//send the questions to the gradepanel source
			//send the answer choices in the gradepanel source
		//if the panel is grade5panel
			//use for loop to extract question and answer choices
			//send the questions to the gradepanel source
			//send the answer choices in the gradepanel source
		//if the panel is grade6panel
			//use for loop to extract question and answer choices
			//send the questions to the gradepanel source
			//send the answer choices in the gradepanel source
		//if the panel is grade7panel
			//use for loop to extract question and answer choices
			//send the questions to the gradepanel source
			//send the answer choices in the gradepanel source
		//if the panel is grade8panel
   		    //use for loop to extract question and answer choices
			//send the questions to the gradepanel source
			//send the answer choices in the gradepanel source
		//if the panel is grade9panel
   		    //use for loop to extract question and answer choices
		    //send the questions to the gradepanel source
			//send the answer choices in the gradepanel source
	
			//set the param equal to another int grade
			//declare and initialize the files
		 
	//declare method for reading the text files
		//declare boolean continueclick on whether the user clicked the continue button 
			
		//create typecasted instance of WalkPanels
		
		//if continueclick is true
			//if the panel is grade1panel
			  //use for loop to extract question and answer choices
		
				//send the questions to the gradepanel source
				//send the answer choices in the gradepanel source
		
