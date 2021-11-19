import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*; //actionlistener
import java.util.*;

public class Reading implements ActionListener {
    JFrame frame = new JFrame();
    //JPanel p1 = new JPanel(new BorderLayout(10, 20));
    JPanel p1 = new JPanel();
    JLabel question = new JLabel();
    JRadioButton ans1;
    JRadioButton ans2;
    JRadioButton ans3;
    JTextArea textarea = new JTextArea("Hey");
    
    Reading() {

        frame.setSize(500, 500);
        frame.setResizable(false);

        textarea.setBounds(0,0,500,0);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(new Color(25,25,25));
		textarea.setForeground(new Color(25,255,0));
		textarea.setFont(new Font("MV Boli",Font.BOLD,25));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);


        ans1 = new JRadioButton("Answer 1");
        ans2 = new JRadioButton("Answer 2");
        ans3 = new JRadioButton("Answer 3");
        //p1.add(question, BorderLayout.NORTH);
        p1.add(question);
        p1.add(ans1);
        p1.add(ans2);
        p1.add(ans3);
        p1.add(textarea);


        frame.add(p1);
        frame.setTitle("Welcome to English Test");
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
		System.out.println("Yeet");
	}	
}
