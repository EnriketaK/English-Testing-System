import javax.swing.*;
import java.awt.*;

public class WelcomePage {

	JFrame frame = new JFrame();
	
	WelcomePage(String user){
        JOptionPane.showMessageDialog(null, "Hello " + user + ".\nYou have 30 minutes to complete the test. You will get your score in the end");
		

        //frame.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
}