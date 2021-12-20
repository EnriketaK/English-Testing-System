import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Grading implements ActionListener {
	JFrame frame = new JFrame();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JLabel mainHeading = new JLabel("Congratulations, you finished!", SwingConstants.CENTER);
	JLabel miniHeading = new JLabel("Let's take a look at how you did:", SwingConstants.CENTER);
	JLabel readingLabel = new JLabel();
	JLabel writingLabel = new JLabel("Writing: Your essay's reading level is ");
	JLabel timeLabel = new JLabel("Time: You took ");
	JLabel infoLabel = new JLabel("Tell us more about yourself!", SwingConstants.CENTER);
	JLabel ageLabel = new JLabel("How old are you?");
	JLabel languagesLabel = new JLabel("How many languages do you know?");
	JLabel countryLabel = new JLabel("Where are you from?");
	JButton doneButton = new JButton("Done");
	Font basicFont = new Font("Nirmala UI",Font.PLAIN, 15);
	Font miniHeadingFont = new Font("Nirmala UI Semilight",Font.ITALIC, 17);
	String s;
	int min = 0, sec = 0;
	
	//menut dropdown
	String [] age = {"18", "19", "20", "21", "22", "23", "24", "25"};
	String [] languages = {"1", "2", "3", "4", "5+"};
	String [] countries = {"Albania", "Italy", "UK", "USA", "Germany", "Greece", "Canada"};
	JComboBox ageMenuBox = new JComboBox(age);
	JComboBox languagesMenuBox = new JComboBox(languages);
	JComboBox countryMenuBox  = new JComboBox(countries);
	
	int time, score;
	String writing;
	int countLetters = 0, countWords = 0, countSentences = 0;
	double avgLetters = 0, avgSentences = 0;
	int grade;
	
	Grading(int timeTaken, int scoreReading, String essay) {
		time = timeTaken;
		score = scoreReading;
		writing = essay;
		
		//to check writing level, count letters, words, sentences
		if (!writing.isEmpty()) { //if string is not null
			countWords++; //kur arrijm nfund, fjala e fundit nuk numerohet prej pikes prandajm e numerojm qe ktu
			
			for (int i = 0; i < writing.length(); i++) { 
				if ((writing.charAt(i) >= 'A' && writing.charAt(i) <= 'Z') || ((writing.charAt(i) >= 'a' && writing.charAt(i) <= 'z'))) {
					countLetters++;
				}
				
				if (writing.charAt(i) == ' ') {
					countWords++;
				}
				
				if (writing.charAt(i) == '.' || writing.charAt(i) == '!' || writing.charAt(i) == '?') {
					countSentences++;
				}
			}
			
			//Coleman-Liau index for readability
			avgLetters = (countLetters * 100) / countWords;
			avgSentences = (countSentences * 100) / countWords;
			grade = (int) (0.0588 * avgLetters - 0.296 * avgSentences - 15.8);
		}
		else { //if nothing written
			grade = 0;
		}
		
		mainHeading.setForeground(Color.GREEN);
		mainHeading.setFont(new Font("Nirmala UI", Font.BOLD, 25));
		
		miniHeading.setFont(miniHeadingFont);
		
		//fix reading result string
		readingLabel.setText("Reading: You got correct " + score + " out of 3 questions. ");
		if (score == 0) {
			s = "Thats bad!";
		}
		else if (score == 1) {
			s = "Not good!";
		}
		else if (score == 2) {
			s = "Good!";
		}
		else {
			s = "Awesome!";
		}
		readingLabel.setText(readingLabel.getText() + s);
		readingLabel.setFont(basicFont);
		
		//fix writing result string
		if (grade < 1) {
			s= "before grade 1.";
		}
		else if (grade > 16) {
			s= "grade +16.";
		}
		else {
			s = "grade " + String.valueOf(grade);
		}
		writingLabel.setText(writingLabel.getText() + s);
		writingLabel.setFont(basicFont);
		
		//fix time result string
		min = time / 60;
		sec = time % 60;
		if (min == 1) {
			s = String.valueOf(min) + " minute and ";
		}
		else {
			s = String.valueOf(min) + " minutes and ";
		}
		
		if (sec == 1) {
			s += String.valueOf(sec) + " second.";
		}
		else {
			s += String.valueOf(sec) + " seconds.";
		}
		timeLabel.setText(timeLabel.getText()  + s);
		timeLabel.setFont(basicFont);
		
		infoLabel.setFont(miniHeadingFont);
		
		ageLabel.setFont(basicFont);
		languagesLabel.setFont(basicFont);
		countryLabel.setFont(basicFont);
		
		//panel for drop down menus
		p2.setLayout(new GridLayout(3, 2, 5, 5));
		p2.add(ageLabel);
		p2.add(ageMenuBox);
		p2.add(languagesLabel);
		p2.add(languagesMenuBox);
		p2.add(countryLabel);
		p2.add(countryMenuBox);
		
		doneButton.addActionListener(this);
		p3.setLayout(new BorderLayout());
		p3.add(doneButton, BorderLayout.SOUTH);
		
		//panel for results + drop down menus + done btn
		p1.setLayout(new GridLayout(8, 1));
		p1.add(mainHeading);
		p1.add(miniHeading);
		p1.add(readingLabel);
		p1.add(writingLabel);
		p1.add(timeLabel);
		p1.add(infoLabel);
		p1.add(p2);
		p1.add(p3);
		p1.setBorder( new EmptyBorder(10, 20, 20, 20));
				
		frame.add(p1);
		frame.setTitle("The End");
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
	}
}
