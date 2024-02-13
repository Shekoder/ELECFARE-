package electricitybillingsystem;

import java.sql.ResultSet;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class login extends JFrame implements ActionListener{
   JButton login,cancel,signup;
   JTextField username,password;
   Choice loggingas;
   login() {
     super ("Login Page");
     getContentPane().setBackground(Color.WHITE);
     setLayout(null);
       
      JLabel lblusername=new JLabel("Username");
      lblusername.setBounds(250, 20, 100, 20);
      add(lblusername);
      
      username=new  JTextField ();
      username.setBounds(350,20,150,20);
      add(username);
      
    JLabel lblpassword=new JLabel("Password");
    lblpassword.setBounds(250, 60, 100, 20);
    add(lblpassword);     
       
    password=new  JTextField ();
    password.setBounds(350,60,150,20);
    add(password);
      
      JLabel lblloggingas=new JLabel("Login as");
      lblloggingas.setBounds(250, 100, 100, 20);
      add(lblloggingas);
      
      loggingas=new Choice();
      loggingas.add("Admin");
      loggingas.add("Customer");
      loggingas.setBounds(350,100,150,20);
      add(loggingas);
      
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
    Image i2=i1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
    login=new JButton("Login",new ImageIcon(i2));
    login.setBounds(260,170,100,20);
    login.addActionListener(this);
    add(login); 
      
     ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
     Image i4=i3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
     cancel=new JButton("Cancel",new ImageIcon(i4));
     cancel.setBounds(390,170,100,20);
     cancel.addActionListener(this);
     add(cancel); 
     
     ImageIcon i5=new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
     Image i6=i5.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
      signup=new JButton("Signup",new ImageIcon(i6));
     signup.setBounds(320,210,100,20);
     signup.addActionListener(this);
     add(signup); 
     
     
     ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
     Image i8=i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
     ImageIcon i9=new ImageIcon(i8);
      JLabel image=new JLabel(i9); 
      image.setBounds(20,10,200,200);
      add(image);
      
      
     setSize(600,300);
     setLocation(350,150);
     setVisible(true);
   }
   public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == login) {
        String susername = username.getText();
        String spassword = password.getText();
        String user = loggingas.getSelectedItem();

        try {
            conn c = new conn();
            String query = "select *from login where username='" + susername + "'and password='" + spassword + "' and user='" + user + "'";

            ResultSet rs = c.s.executeQuery(query);

            if (rs.next()) {
              String meter=rs.getString("meter");
              setVisible(false);
              new project(user,meter);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Login");
                username.setText("");
                password.setText("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else if (ae.getSource() == cancel) {
        setVisible(false);
    } else if (ae.getSource() == signup) {
        setVisible(false);
        new signup();
    }
}

public static void main(String[] args){
        new login();
}
}