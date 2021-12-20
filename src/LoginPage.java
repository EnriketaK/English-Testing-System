import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*; //actionlistener
import java.util.*;

public class LoginPage implements ActionListener {
	JFrame frame = new JFrame();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	
	ImageIcon picIcon = new ImageIcon("toefl.png");
	JLabel picLabel = new JLabel(picIcon);
	
	JLabel userLabel = new JLabel("User:");
	JLabel enterLabel = new JLabel("", SwingConstants.CENTER);
	JTextField userTxt = new JTextField(15);
	JLabel passLabel = new JLabel("Password:");
	JPasswordField passTxt = new JPasswordField(15);
	JLabel emailLabel = new JLabel("Email:");
	JTextField emailField = new JTextField(15);
	
	JButton loginBtn = new JButton("Sign In");
	
	JLabel signupLabel = new JLabel("Dont have an account? Sign up", SwingConstants.CENTER);
	
	Font basicFont = new Font("Nirmala UI",Font.BOLD, 15);
	Border border, margin;

	LoginPage() {
		p1.setLayout(new GridLayout(4, 2, 5, 10));
		userLabel.setFont(basicFont);
		passLabel.setFont(basicFont);
		emailLabel.setFont(basicFont);
		loginBtn.setFont(basicFont);
		emailLabel.setVisible(false);
		emailField.setVisible(false);
		enterLabel.setBorder( new EmptyBorder( 5, 0, 0 ,0 ));
		
		signupLabel.addMouseListener(new MouseAdapter() { //if clicked i dont have acc
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!emailField.isVisible()) { //if clicked i dont have acc
                	signupLabel.setText("Already have an account? Sign in");
                	emailLabel.setVisible(true); //unhide to signup
                	emailField.setVisible(true); //unhide to signup
                	loginBtn.setText("Sign Up");
                	p3.setBorder(new TitledBorder("Sign Up"));
                }
                else { //if clicked to sign in
                	signupLabel.setText("Dont have an account? Sign up");
                	emailLabel.setVisible(false);
                	emailField.setVisible(false);
                	loginBtn.setText("Sign In");
                	p3.setBorder(new TitledBorder("Sign In"));
                	
                }
                //fix border padding
                border = p3.getBorder();
        		margin = new EmptyBorder(15, 15, 15, 15);
        		p3.setBorder(new CompoundBorder(border, margin));
            }

        });
		
		//panel for labels & fields
		p1.add(userLabel);
		p1.add(userTxt);
		p1.add(passLabel);
		p1.add(passTxt);
		p1.add(emailLabel);
		p1.add(emailField);
		p1.setBorder( new EmptyBorder( 25, 0, -25, 0 ));
		
		//panel to group image, fields+labels & login button
		p2.setLayout(new BorderLayout(5, 10));
		p2.add(picLabel, BorderLayout.NORTH);
		p2.add(p1, BorderLayout.CENTER);
		p2.add(loginBtn, BorderLayout.SOUTH);
		loginBtn.addActionListener(this); //check if login/signup button clicked
		
		signupLabel.setFont(new Font("Nirmala UI Semilight",Font.ITALIC, 12));
		signupLabel.setForeground(Color.BLUE);
		//panel for signup/sign question & error of credentials
		p4.setLayout(new BorderLayout());
		p4.add(signupLabel, BorderLayout.NORTH);
		p4.add(enterLabel, BorderLayout.SOUTH);

		//panel to group the main panels together
		p3.setLayout(new BorderLayout(10, 20));
		p3.add(p2, BorderLayout.CENTER);
		p3.add(p4, BorderLayout.SOUTH);
		p3.setBorder(new TitledBorder("Log In"));

		border = p3.getBorder(); // add padding to border
		margin = new EmptyBorder(15, 15, 15, 15);
		p3.setBorder(new CompoundBorder(border, margin));

		frame.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		frame.add(p3);
		frame.setTitle("TOEFL English Test");
		frame.setSize(500, 560);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);//coz we dont need the window to be resizable
	}

	public void actionPerformed(ActionEvent e) { //if the signup/signin button is clicked
		String user = userTxt.getText();
		String pass = passTxt.getText();

		
		 if((user.length() < 3 || pass.length() < 3) && !emailField.isVisible()) { //if sign in
			 enterLabel.setForeground(Color.RED); enterLabel.setText("Wrong username or password.");
			 }
		else if (user.length() < 3 || pass.length() < 3  || (emailField.isVisible()  && emailField.getText().length() < 3)){ //if sign up
				 enterLabel.setForeground(Color.RED); enterLabel.setText("Try another username, password or email.");
		 }
		 else { //if credentials ok
			 frame.dispose(); //close current window
				int input = JOptionPane.showOptionDialog(null, //new window to inform user
						"Hello " + user + ".\nYou have 30 minutes to complete the test.\nYou will get your score in the end",
						"Get ready", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

				if (input == JOptionPane.OK_OPTION) {
					Reading reading = new Reading(); //open reading section window
				}
		}
	}
}
