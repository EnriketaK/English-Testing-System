import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*; //actionlistener

public class Reading implements ActionListener {
	JFrame frame = new JFrame();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();

	JButton nextbButton = new JButton(" Next >> ");
	JLabel timerLabel = new JLabel();
	Border border, margin;

	JLabel title = new JLabel("Transcendentalism", SwingConstants.CENTER);
	JTextArea textarea = new JTextArea(
			"Beginning in the 1820s, a new intellectual movement known as transcendentalism began to grow in the Northeast. \r\nIn this context, to transcend means to go beyond the ordinary sensory world to grasp personal insights and gain an appreciation of a deeper reality, and transcendentalists believed that all people could attain an understanding of the world that goes past rational, sensory experience."
					+ "\r\nTranscendentalists were critical of mainstream American culture. They reacted against the age they lived in where people were"
					+ " encouraged to act the same as others and argued for greater individualism against conformity.\r\n"
					+ "European romanticism, a movement in literature and art that stressed emotion over cold, calculating reason, also"
					+ "influenced transcendentalists in the United States, especially the transcendentalists’ celebration of the"
					+ "uniqueness of individual feelings.\r\n"
					+ "Ralph Waldo Emerson emerged as the leading figure of this movement. Born in Boston in 1803, Emerson "
					+ "came from a religious family. His father served as a minister, and after graduating from Harvard Divinity "
					+ "School in the 1820s, Emerson followed in his father’s footsteps."
					+ "\r\n However, after his wife died in 1831, he"
					+ " left the clergy. On a trip to Europe in 1832, he met leading figures of romanticism who rejected the cold, "
					+ "strict rationalism of popular 18th century Enlightenment thought, emphasizing emotion instead.\r\n Emerson’s ideas struck a chord with a class of literate adults who also were dissatisfied with mainstream"
					+ "American life and searching for greater spiritual meaning. Many writers were drawn to transcendentalism,"
					+ "and they started to express its ideas through new stories, poems, essays, and articles. The ideas of"
					+ "transcendentalism were able to permeate American thought and culture through magazines, journals, and"
					+ "newspapers that were widely read.\r\nMargaret Fuller also came to prominence as a leading transcendentalist and advocate for women’s "
					+ "equality. Fuller was a friend of Emerson and Thoreau, and other intellectuals of her day. Because she was"
					+ "a woman, she could not attend Harvard, as it was a male-only institution for undergraduate students until "
					+ "1973. However, she was later granted the use of the library there because of her towering intellect.");

	Timer timer = new Timer();
	int timeCompleted = 0;
	int score = 0;
	JScrollPane scrollBar;

	JLabel question0 = new JLabel("Select the correct choice.", SwingConstants.CENTER);
	JLabel question1 = new JLabel("1. When did transcendentalism begin?");
	ButtonGroup group1 = new ButtonGroup();
	JRadioButton ans1 = new JRadioButton("1910");
	JRadioButton ans2 = new JRadioButton("1677");
	JRadioButton ans3 = new JRadioButton("1820");

	JLabel question2 = new JLabel("2. What was Transcendentalism about?");
	ButtonGroup group2 = new ButtonGroup();
	JRadioButton ans4 = new JRadioButton("Emphasizing emotions");
	JRadioButton ans5 = new JRadioButton("Pro conformity");
	JRadioButton ans6 = new JRadioButton("Both alternatives");

	JLabel question3 = new JLabel("3. Who sided with Emerson?");
	ButtonGroup group3 = new ButtonGroup();
	JRadioButton ans7 = new JRadioButton("Nobody");
	JRadioButton ans8 = new JRadioButton("Homeless people");
	JRadioButton ans9 = new JRadioButton("Literate aduls");

	Reading() {
		title.setFont(new Font("Nirmala UI", Font.BOLD, 20));
		textarea.setBounds(5, 10, 600, 500); //sets width, height
		textarea.setLineWrap(true); //lines will be wrapped if they are too long to fit within the allocated width
		textarea.setWrapStyleWord(true); // wrap text by words, not characters
		textarea.setBackground(new Color(249, 249, 249));
		textarea.setForeground(Color.BLACK);
		textarea.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		textarea.setBorder(BorderFactory.createBevelBorder(1)); //simple two line bevel border
		textarea.setEditable(false); //for reading only
		scrollBar = new JScrollPane(textarea); //vertical scrollbar for when text too long
		scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		//panel for title & textarea
		p1.setLayout(new BorderLayout(5, 10));
		p1.add(title, BorderLayout.NORTH);
		p1.add(scrollBar, BorderLayout.CENTER);
		p1.setBorder(new EmptyBorder(10, 15, 10, 10)); //margin
		
		
		question0.setFont(new Font("Nirmala UI", Font.BOLD + Font.ITALIC, 15));
		//grouping of radio buttons so that only one can be selected per group
		group1.add(ans1);
		group1.add(ans2);
		group1.add(ans3);

		group2.add(ans4);
		group2.add(ans5);
		group2.add(ans6);

		group3.add(ans7);
		group3.add(ans8);
		group3.add(ans9);
		
		//panel for questions & anwers
		p2.setLayout(new GridLayout(13, 1, 0, 0));
		p2.add(question0);
		p2.add(question1);
		p2.add(ans1);
		p2.add(ans2);
		p2.add(ans3);

		p2.add(question2);
		p2.add(ans4);
		p2.add(ans5);
		p2.add(ans6);

		p2.add(question3);
		p2.add(ans7);
		p2.add(ans8);
		p2.add(ans9);

		nextbButton.addActionListener(this); //if next button clicked
		
		border = BorderFactory.createLineBorder(Color.black, 1); //padding for timer
		timerLabel.setBorder(border);
		margin = new EmptyBorder(4, 15, 4, 15);
		timerLabel.setBorder(new CompoundBorder(border, margin));
		
		//panel for 2 els at the bottom
		p3.add(timerLabel);
		p3.add(nextbButton);
		p3.setBorder( new EmptyBorder( 0, 0, 15, 0 )); //add margin
		
		//group panels together
		p4.setLayout(new BorderLayout(5, 10));
		p4.add(p1, BorderLayout.WEST);
		p4.add(p2, BorderLayout.CENTER);
		p4.add(p3, BorderLayout.SOUTH);

		frame.add(p4);
		frame.setTitle("Reading section");
		frame.setSize(1000, 750);
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
					timeCompleted = 900 - counter; //keep track how long it took to complete the section
					
				} else { //if time is over, check the answers, adjust score
					if (ans3.isSelected()) {
						score++;
					}

					if (ans4.isSelected()) {
						score++;
					}

					if (ans9.isSelected()) {
						score++;
					}

					timer.cancel(); //stop timer
					frame.dispose(); //close window

					Writing writing = new Writing(timeCompleted, score); //create new window
				}
			}
		};

		timer.scheduleAtFixedRate(task, 0, 1000); //every one second do task
	}

	public void actionPerformed(ActionEvent e) { //if next button clicked  check the answers, adjust score
		if (ans3.isSelected()) {
			score++;
		}

		if (ans4.isSelected()) {
			score++;
		}

		if (ans9.isSelected()) {
			score++;
		}

		timer.cancel(); //stop timer
		frame.dispose(); //close window
		
		Writing writing = new Writing(timeCompleted, score); //create new window
	}
}
