package Quiz.App;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login_user extends JFrame implements ActionListener{

    JPanel panel;
    JTextField textField;
    JPasswordField passwordField;
    JButton b1,b2,b3;


    public Login_user() {

        setBackground(new Color(169, 169, 169));
        setBounds(450, 200, 600, 400);

        panel = new JPanel();
        panel.setBackground(new Color(176, 224, 230));
        setContentPane(panel);
        panel.setLayout(null);

        JLabel l1 = new JLabel("Username : ");
        l1.setBounds(124, 89, 95, 24);
        panel.add(l1);

        textField = new JTextField();
        textField.setBounds(210, 93, 157, 20);
        panel.add(textField);

        JLabel l2 = new JLabel("Password: ");
        l2.setBounds(124, 124, 95, 24);
        panel.add(l2);

        passwordField = new JPasswordField();
        passwordField.setBounds(210, 128, 157, 20);
        panel.add(passwordField);


        b1 = new JButton("Login");
        b1.setForeground(new Color(46, 139, 87));
        b1.setBackground(new Color(250, 250, 210));
        b1.setBounds(149, 181, 113, 39);
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("SignUp");
        b2.setForeground(new Color(46, 139, 87));
        b2.setBackground(new Color(255, 235, 205));
        b2.setBounds(289, 181, 113, 39);
        b2.addActionListener(this);
        panel.add(b2);

        b3 = new JButton("Cancel");
        b3.setForeground(new Color(139, 69, 19));
        b3.setBackground(new Color(255, 235, 205));
        b3.setBounds(220, 235, 113, 39);
        b3.addActionListener(this);
        panel.add(b3);

        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(176, 224, 230));
        panel2.setBounds(24, 40, 434, 263);
        panel.add(panel2);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            Boolean status = false;
            try {
                conn con = new conn();
                String sql = "select * from Quiz where username=? and password=?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, textField.getText());
                st.setString(2, passwordField.getText());
                ResultSet rs = st.executeQuery();
                if(rs.next()){
                    this.setVisible(false);
                    new test().setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    setVisible(false);
                }

            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if(ae.getSource() == b2){
            this.setVisible(false);
            new Signup().setVisible(true);
        }
        if(ae.getSource() == b3){
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Login_user().setVisible(true);
    }

}