package electricitybillingsystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.border.*;


public class signup extends  JFrame implements ActionListener{
    JButton create,back;
    Choice accountype;
    JTextField meter,username,name, password;
    
    signup(){
    
    setSize(700,500);
    setLocation(350,150);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    
    JPanel panel=new JPanel();
    panel.setBounds(20, 30, 650, 425);
    panel.setBorder(new TitledBorder(new LineBorder(new Color(173,216,230),2),"Create-Account",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(176,216,230)) );
    panel.setBackground(Color.WHITE);
    panel.setLayout(null);
    panel.setForeground(Color.GRAY);
    add(panel);
     
    
     JLabel heading=new JLabel("Create Account");
     heading.setBounds(100, 50, 150, 30);
     heading.setFont(new Font("Tahoma",Font.BOLD,14));
     heading.setForeground(Color.GRAY);
     panel.add(heading);
     
     accountype=new Choice();
     accountype.add("Admin");
     accountype.add("Customer");
     accountype.setBounds(300,55,128,31);
     panel.add(accountype);
     
     JLabel lblmeter=new JLabel("Meter Number");
     lblmeter.setBounds(100, 100, 300, 30);
     lblmeter.setFont(new Font("Tahoma",Font.BOLD,14));
     lblmeter.setForeground(Color.GRAY);
     lblmeter.setVisible(false);
     panel.add(lblmeter);
    
    meter=new JTextField();
    meter.setBounds(300,105,128,21);
    meter.setVisible(false);
     panel.add(meter);
   
    
     
     JLabel lblusername=new JLabel("Username");
     lblusername.setBounds(100, 150, 300, 30);
     lblusername.setFont(new Font("Tahoma",Font.BOLD,14));
     lblusername.setForeground(Color.GRAY);
     panel.add(lblusername);
     
     username=new JTextField();
     username.setBounds(300,155,128,21);
     panel.add(username);
             
    JLabel lblname=new JLabel("Name");
    lblname.setBounds(100, 200, 300, 30);
    lblname.setFont(new Font("Tahoma",Font.BOLD,14));
    lblname.setForeground(Color.GRAY);
    panel.add(lblname);
     
    name=new JTextField();
    name.setBounds(300,205,128,21);
    panel.add(name);
    
      meter.addFocusListener(new FocusListener() {
    @Override
    public void focusGained(FocusEvent fe) {
    }

    @Override
    public void focusLost(FocusEvent fe) {
     try{
       conn c=new conn();
       ResultSet rs = c.s.executeQuery("SELECT * FROM login where meter='"+meter.getText()+"'");
       while(rs.next()){
       name.setText(rs.getString("name"));
       }
     }catch(Exception e){
     e.printStackTrace();
     
     }
    }
});
 
    JLabel lblpassword=new JLabel("Password");
    lblpassword.setBounds(100, 250, 300, 30);
    lblpassword.setFont(new Font("Tahoma",Font.BOLD,14));
    lblpassword.setForeground(Color.GRAY);
    panel.add(lblpassword);
     
    password=new JTextField();
    password.setBounds(300,255,128,21);
    panel.add(password);
   
   accountype.addItemListener(new ItemListener() {
    public void itemStateChanged(ItemEvent ae) {
    String user = accountype.getSelectedItem();
    if(user.equals("Customer")){
    lblmeter.setVisible(true);
    meter.setVisible(true);
    name.setEditable(false);
    } else{
    lblmeter.setVisible(false);
    meter.setVisible(false);
    name.setEditable(true);

    } 
    }
});

            
    
    
   create =new JButton("create");
   create.setBounds(120,300,100,21);
   create.addActionListener(this);
   panel.add(create); 
     
   back =new JButton("Back");
   back.setBounds(280,300,100,21);
   back.addActionListener(this);
   panel.add(back); 
   
   ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
   Image i2=i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
   ImageIcon i3=new ImageIcon(i2);
   JLabel image=new JLabel(i3); 
   image.setBounds(425,30,250,250);
   panel.add(image);
   
   
   
    setVisible(true);
    
    }
    
     public  void actionPerformed(ActionEvent ae){
        if(ae.getSource()== create){
            String atype=accountype.getSelectedItem();
            String susername =username.getText();
            String sname =name.getText();
            String smeter =meter.getText();
            String spassword =password.getText();
              
            try{
            conn c=new conn();
            
            String query =null;
            if(atype.equals("Admin")){
            query= "INSERT INTO login(meter, username, name, password, user) VALUES ('" + smeter + "','" + susername + "','" + sname + "','" + spassword + "','" +atype + "')";
            }else{
            query="update login set username='"+susername+"',password='"+spassword+"',user='"+atype+"' where meter='"+smeter+"'";
            }
            c.s.executeUpdate(query);
            

            JOptionPane.showMessageDialog(null,"Account created sucessfully");
            
            setVisible(false);
            new login();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()== back){
            setVisible(false);
           
            new login();
        }
     }
    public static void main(String[] args){
        new signup();
    }
    
    }