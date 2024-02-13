package electricitybillingsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class updateinformation extends JFrame implements ActionListener {
    JTextField tfphoneno,tfaddress,tfcity,tfstate,tfemail;
    JButton update,cancel;
    String meter;
    JLabel address;
    updateinformation(String meter){
    this.meter=meter;
    setBounds(300, 150, 850, 450);
    getContentPane().setBackground(Color.white);
    setLayout(null);
     
    JLabel heading = new JLabel("UPDATE CUSTOMER DETAILS");
    heading.setBounds(250, 0, 350, 40);
    heading.setFont(new Font("Tahoma", Font.BOLD, 16));
    add(heading);

    JLabel lblname = new JLabel("Name");
    lblname.setBounds(50, 80, 100, 20);
    add(lblname);

    JLabel name = new JLabel("");
    name.setBounds(200, 80, 100, 20);
    add(name);

    JLabel lblmeternumber=new JLabel("Meter Number");
    lblmeternumber.setBounds(50,120,100,20);
    add(lblmeternumber);
    
    JLabel meternumber=new JLabel("");
    meternumber.setBounds(200,120,100,20);
    add(meternumber);
    
    JLabel lbladdress=new JLabel("Address");
    lbladdress.setBounds(50,160,100,20);
    add(lbladdress);
    
    tfaddress=new JTextField();
    tfaddress.setBounds(200,160,150,20);
    add(tfaddress);
    
    JLabel lblcity=new JLabel("City");
    lblcity.setBounds(50,200,100,20);
    add(lblcity);
    
    tfcity=new JTextField();
    tfcity.setBounds(200,200,150,20);
    add(tfcity);
    
    JLabel lblstate=new JLabel("State");
    lblstate.setBounds(50,240,100,20);
    add(lblstate);
    
    tfstate=new JTextField();
    tfstate.setBounds(200,240,150,20);
    add(tfstate);
    
    JLabel lblemail=new JLabel("Email");
    lblemail.setBounds(50,280,100,20);
    add(lblemail);
    
    tfemail=new JTextField();
    tfemail.setBounds(200,280,150,20);
    add(tfemail);
    
    JLabel lblphoneno=new JLabel("Phone Number");
    lblphoneno.setBounds(50,320,100,20);
    add(lblphoneno);
    
    tfphoneno=new JTextField();
    tfphoneno.setBounds(200,320,150,20);
    add(tfphoneno); 
   
    
    try{
     conn c = new conn();
     ResultSet rs = c.s.executeQuery("SELECT * FROM customer where meter='"+meter+"'");
     while(rs.next()){
     name.setText(rs.getString("name"));
     tfaddress.setText(rs.getString("address"));
     tfcity.setText(rs.getString("city"));
     tfstate.setText(rs.getString("state"));
     tfemail.setText(rs.getString("email"));
     tfphoneno.setText(rs.getString("phoneno"));
     meternumber.setText(rs.getString("meter"));
    }
    }catch (Exception e){
        e.printStackTrace();
    }
    
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(50,380, 100, 20);
        update.addActionListener(this);
        add(update);  
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(200, 380, 100, 20);
        cancel.addActionListener(this);
        add(cancel);  
        
     
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 230, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,100,400,230);
        add(image);
                
     setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae) {
     if(ae.getSource()==update){
       String address=tfaddress.getText();
       String city=tfcity.getText();
       String state=tfstate.getText();
       String email=tfemail.getText();
       String phoneno=tfphoneno.getText();
        
      try{
      conn c = new conn();
      c.s.executeUpdate("update customer set address ='"+address+"',city='"+city+"',state='"+state+"',email='"+email+"',phoneno='"+phoneno+"'where meter='"+meter+"'");
      
        
     JOptionPane.showMessageDialog(null,"user information updated sucessfully");
     setVisible(false);
     
     
      }catch (Exception e){
      e.printStackTrace();
      }
        
     }else{
     setVisible(false);
     }
     }
    
    
    
      public static void main(String[] args) {
      new updateinformation("");
    }

}
