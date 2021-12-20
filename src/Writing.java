
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;


public class Writing implements ActionListener {
	JFrame frame = new JFrame();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	JPanel p5 = new JPanel();
	ImageIcon picIcon = new ImageIcon("m1.jpg");
	JLabel picLabel = new JLabel(picIcon);
	JLabel title = new JLabel("Essay: Mona Lisa", SwingConstants.CENTER);
	JLabel miniTitle = new JLabel("Write about this famous painting 100-200 words.", SwingConstants.CENTER);
	JTextArea textarea = new JTextArea();
	JScrollPane scrollBar;
	JButton nextButton = new JButton(" Next >> ");
	JLabel timerLabel = new JLabel();
	Border border, margin;
	Timer timer = new Timer();
	String essay;
	int scoreReading;
	int timeTaken, timeCompletedWriting = 0;
	
	JLabel fontLabel = new JLabel("Font: ");
	JSpinner fontSizeSpinner = new JSpinner();
	JButton fontColorButton = new JButton("Color");
	JComboBox fontBox;
	String[] fonts;

	Writing(int timeCompleted, int score) {
		scoreReading = score;
		timeTaken = timeCompleted;
		
		fontColorButton.addActionListener(this);
		fontSizeSpinner.setValue(15); //size default that we are using
		fontSizeSpinner.addChangeListener(new ChangeListener() { //if size changed

		   @Override
		   public void stateChanged(ChangeEvent e) {
		    //gets current family coz it can be changed by user, harcoded style, size selected
		    textarea.setFont(new Font(textarea.getFont().getFamily(),Font.PLAIN,(int) fontSizeSpinner.getValue())); 
		   }
		   
		  });
		 
		//available fonts at users system
		fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		fontBox = new JComboBox(fonts);
		fontBox.addActionListener(this);
		fontBox.setSelectedItem("Nirmala UI"); //default choice
		
		//panel for editing tools
		p5.setLayout(new GridLayout(1, 3, 10, 10));
		p5.add(fontColorButton);
		p5.add(fontSizeSpinner);
		p5.add(fontBox);
		 
		//panel to group headings & editing tools
		p3.setLayout(new BorderLayout(5, 5));
		p3.add(title, BorderLayout.NORTH);
		p3.add(miniTitle, BorderLayout.CENTER);
		p3.add(p5, BorderLayout.SOUTH);
		
		
		title.setFont(new Font("Nirmala UI", Font.BOLD, 20));
		miniTitle.setFont(new Font("Nirmala UI", Font.ITALIC, 15));
		textarea.setLineWrap(true); //lines will be wrapped if they are too long to fit within the allocated width
		textarea.setWrapStyleWord(true); // wrap text by words, not characters
		textarea.setBackground(new Color(249, 249, 249));
		textarea.setForeground(Color.BLACK);
		textarea.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		scrollBar = new JScrollPane(textarea); //vertical scrollbar for when text too long
		scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		//panel for textarea & headings+editing tools
		p2.setLayout(new BorderLayout(5, 10));
		p2.add(p3, BorderLayout.NORTH);
		p2.add(scrollBar, BorderLayout.CENTER); //we have added textarea me ane te kesaj
		p2.setBorder(new EmptyBorder( 10, 10, 40, 20 )); //margin
		
		nextButton.addActionListener(this);
		
		border = BorderFactory.createLineBorder(Color.black, 1); //create padding for timer
		timerLabel.setBorder(border);
		margin = new EmptyBorder(4, 15, 4, 15);
		timerLabel.setBorder(new CompoundBorder(border, margin));
		
		//panel for 2 els at the bottom
		p4.add(timerLabel);
		p4.add(nextButton);
		//add panel to textarea+headings+editing tools
		p2.add(p4, BorderLayout.SOUTH);
		
		picLabel.setBorder(new EmptyBorder( 35, 20, 20, 10 )); //margin for pic
		
		//main panel for photo & textarea+headings+editing+timer+button
		p1.setLayout(new BorderLayout(5, 10));
		p1.add(picLabel, BorderLayout.WEST); //piclabel coz u cant add imageicon directly
		p1.add(p2, BorderLayout.CENTER);
		
		frame.add(p1);
		frame.setTitle("Writing section");
		frame.setSize(1050, 700);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	
		TimerTask task = new TimerTask() {
			//called every one second by timer
			int counter = 900; // sekonda ose 15 mins
			int min = 0;
			int sec = 0;
			String s;

			@Override
			public void run() {
				if (counter > 0) {
					if (sec >= 60) {
						min++; //count minutes
						sec = 0;
					}

					if (min <= 9) { //fix timer string
						s = "0" + String.valueOf(min);
					} else {
						s = String.valueOf(min);
					}

					if (sec <= 9) {
						s += " : 0" + String.valueOf(sec);
					} else {
						s += " : " + String.valueOf(sec);
					}


					timerLabel.setText(s);
					if (min >= 10) { //if 5 min left, red cause too little time
						timerLabel.setForeground(Color.RED);
					}
					
					
					counter--;
					sec++;
					timeCompletedWriting = 900 - counter; //keep track how long it took to complete the section
				} else {
					essay = textarea.getText();	//get text content
					timeTaken += timeCompletedWriting; //add time of writing to that of reading
					
					timer.cancel(); //stop timer
					frame.dispose(); //close window
					Grading grading = new Grading(timeTaken, scoreReading, essay); //create new window for grading
				}
			}
		};

		timer.scheduleAtFixedRate(task, 0, 1000); //every one second do task
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == fontColorButton) { //if color button clicked
			JColorChooser colorChooser = new JColorChooser(); //create color panel
			Color color = colorChooser.showDialog(null, "Choose a color", Color.black); //create window for color choosing and store selected color
			textarea.setForeground(color); //change text color
			}
		else if(e.getSource() == fontBox) { //if font family it clicked
			textarea.setFont(new Font((String)fontBox.getSelectedItem(),Font.PLAIN,textarea.getFont().getSize())); //assign text new font family
			}
		else if (e.getSource()== nextButton){
			essay = textarea.getText();
			timeTaken += timeCompletedWriting;

			frame.dispose();
			timer.cancel();
			Grading grading = new Grading(timeTaken, scoreReading, essay);  //create new window for grading
		}
	}
}
