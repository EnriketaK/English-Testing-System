import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*; //actionlistener
import java.util.*;

public class LoginPage implements ActionListener{
    JFrame frame = new JFrame();
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JLabel userLabel = new JLabel("User:");
    JLabel enterLabel = new JLabel("");
    JTextField userTxt = new JTextField(15);
    JLabel passLabel = new JLabel("Password:");
    JPasswordField passTxt = new JPasswordField(15);;
    JButton loginBtn = new JButton("Log In");
    Border border, margin;

    LoginPage() {
        p1.setLayout(new GridLayout(3, 2, 5, 10));
        p1.add(userLabel);
        p1.add(userTxt);
        p1.add(passLabel);
        p1.add(passTxt);

        p2.setLayout(new BorderLayout(5, 10));
        p2.add(p1, BorderLayout.CENTER);
        p2.add(loginBtn, BorderLayout.SOUTH);
        loginBtn.addActionListener(this);

        p3.setLayout(new BorderLayout(10, 20));
        p3.add(p2, BorderLayout.CENTER);
        p3.add(enterLabel, BorderLayout.SOUTH);
        p3.setBorder(new TitledBorder("Log In"));

        border = p3.getBorder(); // add padding to border
        margin = new EmptyBorder(15, 15, 15, 15);
        p3.setBorder(new CompoundBorder(border, margin));

        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
        frame.add(p3);
        frame.setTitle("Welcome to English Test");
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==loginBtn) {
            String user = userTxt.getText();
            String pass = passTxt.getText();
            System.out.println(pass);

            if(user.length() < 3 || pass.length() < 3) {
                enterLabel.setForeground(Color.RED);
                enterLabel.setText("Try again");
            }
            else {
                enterLabel.setForeground(Color.GREEN);
                enterLabel.setText("Login successful");
                frame.dispose();
                int input = JOptionPane.showOptionDialog(null, "Hello " + user + ".\nYou have 30 minutes to complete the test. You will get your score in the end", "Get ready", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                
                if(input == JOptionPane.OK_OPTION) {
                    Reading reading = new Reading();
                    System.out.println("Uooo");
                }
            }
		}
	}	
}
