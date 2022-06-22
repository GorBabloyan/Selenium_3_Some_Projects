package AnnNew;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Visualisation {
    public static JFrame frame = new JFrame("Name");
    public static JPanel panel1 = new JPanel();
    public static JPanel panel2 = new JPanel();
    public static JPanel panel3 = new JPanel();
    public static JLabel loggedInLabel = new JLabel("<html><p>LoggedIn Menu<br/></p></html>");
    public static JLabel loggedIn = new JLabel("<html>1 for write post<br/>2 for read all posts<br/>3 for logout<br/>4 for exit</html>");
    public static JLabel loggedOutLabel = new JLabel("<html><p>LoggedOut Menu<br/></p</html>");
    public static JLabel loggedOut = new JLabel("<html>1 for reg <br/>2 for login<br/>3 for exit <br/></html>");

    public static JLabel textField_1_Text = new JLabel("<html><p>Enter Your Choice </p></html>");
    public static   JTextField textField_1 = new JTextField(10);


    public static String choice=null;

    public Visualisation(String ch){

    }

    public Visualisation() {

        panel1.setBackground(Color.WHITE);
        panel2.setBackground(Color.GRAY);
        panel3.setBackground(Color.ORANGE);
        frame.add(panel1, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.PAGE_START);
        frame.add(panel3, BorderLayout.PAGE_END);
        frame.setSize(250, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        panel3.add(textField_1_Text);
        panel3.add(textField_1);
        textField_1.setVisible(true);
        textField_1_Text.setVisible(true);
        textField_1.addKeyListener(new MyKeyListener());
    }

    public void setLoggedOut() {
        choice=null;
        loggedIn.setVisible(false);
        loggedInLabel.setVisible(false);

        loggedOut.setVisible(true);
        loggedOutLabel.setVisible(true);
        panel1.add(loggedOut);
        panel2.add(loggedOutLabel);

    }

    public void Registration(){

    }

    public void setLoggedIn() {
        loggedOutLabel.setVisible(false);
        loggedOut.setVisible(false);

        loggedIn.setVisible(true);
        loggedInLabel.setVisible(true);
        panel1.add(loggedIn);
        panel2.add(loggedInLabel);
    }
}
class MyKeyListener extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent event) {
        Visualisation v = new Visualisation("");
        if (event.getKeyCode() == KeyEvent.VK_ENTER) {
            //System.out.println("Key codes: " + event.getKeyCode());
            Visualisation.choice = Visualisation.textField_1.getText();
            //Visualisation.textField_1.setText(null);
            System.out.println("Enter");
        }
    }
}

