package electricitybillingsystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class newcustomer extends JFrame implements ActionListener{
    JTextField tfname,tfaddress,tfcity,tfstate,tfemail,tfphoneno;
    JButton cancel,next;
    JLabel lblmeter;
    newcustomer() {
        setSize(850, 550);
        setLocation(350, 100);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.GRAY);
        add(p);

        JLabel heading = new JLabel("NEW CUSTOMER");
        heading.setBounds(250, 30, 150, 20);
        heading.setFont(new Font("calibiri", Font.PLAIN, 20));
        heading.setForeground(Color.black);
        p.add(heading);

        JLabel lblname = new JLabel("CUSTOMER NAME");
        lblname.setBounds(180, 100, 170, 25);
        lblname.setFont(new Font("Calibiri", Font.BOLD, 12));
        lblname.setForeground(Color.BLACK);
        p.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(350, 100, 200, 20);
        p.add(tfname);

        JLabel lblmeterno = new JLabel("METER NUMBER");
        lblmeterno.setBounds(180, 150, 170, 25);
        heading.setFont(new Font("calibiri", Font.BOLD, 14));
        heading.setForeground(Color.BLACK);
        p.add(lblmeterno);
        
        lblmeter = new JLabel("");
        lblmeter.setBounds(350, 150, 170, 25);       
        p.add(lblmeter);
        
        Random ran= new Random();
        long number=ran.nextLong()% 1000000;
        lblmeter.setText(""+Math.abs(number));
        
        
        JLabel lbladdress = new JLabel("ADDRESS");
        lbladdress.setBounds(180, 200, 170, 25);
        lbladdress.setFont(new Font("Calibiri", Font.BOLD, 12));
        lbladdress.setForeground(Color.BLACK);
        p.add(lbladdress);

       tfaddress = new JTextField();
       tfaddress.setBounds(350, 200, 200, 20);
       p.add(tfaddress);

        JLabel lblcity = new JLabel("CITY");
        lblcity.setBounds(180, 250, 170, 25);
        lblcity.setFont(new Font("Calibiri", Font.BOLD, 12));
        lblcity.setForeground(Color.BLACK);
        p.add(lblcity);

       tfcity = new JTextField();
       tfcity.setBounds(350, 250, 200, 20);
       p.add(tfcity);
        
        JLabel lblstate = new JLabel("STATE");
        lblstate.setBounds(180, 300, 170, 25);
        lblstate.setFont(new Font("Calibiri", Font.BOLD, 12));
        lblstate.setForeground(Color.BLACK);
        p.add(lblstate);

       tfstate = new JTextField();
       tfstate.setBounds(350, 300, 200, 20);
       p.add(tfstate);
    
       JLabel lblemail = new JLabel("EMAIL");
        lblemail.setBounds(180, 350, 170, 25);
        lblemail.setFont(new Font("Calibiri", Font.BOLD, 12));
        lblemail.setForeground(Color.BLACK);
        p.add(lblemail);

       tfemail = new JTextField();
       tfemail.setBounds(350, 350, 200, 20);
       p.add(tfemail);
    
       JLabel lblphoneno = new JLabel("PHONE NUMBER");
        lblphoneno.setBounds(180, 400, 170, 25);
        lblphoneno.setFont(new Font("Calibiri", Font.BOLD, 12));
        lblphoneno.setForeground(Color.BLACK);
        p.add(lblphoneno);

       tfphoneno = new JTextField();
       tfphoneno.setBounds(350, 400, 200, 20);
       p.add(tfphoneno);
       
       
      next=new JButton("Next");
      next.setBounds(200,440,100,25);
      next.addActionListener(this);
      p.add(next);

      cancel=new JButton("Cancel");
      cancel.setBounds(400,440,100,25);
      cancel.addActionListener(this);
      p.add(cancel);
      
      
      setLayout(new BorderLayout());
       
      add(p,"Center");
      
      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
      Image i2=i1.getImage().getScaledInstance(200, 250, Image.SCALE_DEFAULT);
      ImageIcon i3=new ImageIcon(i2);
      JLabel image=new JLabel(i3); 
      add(image,"East");
      
        setVisible(true);
                      
    }
     public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == next) {
        String name = tfname.getText();
        String meter = lblmeter.getText();
        String address = tfaddress.getText();
        String city = tfcity.getText();
        String state = tfstate.getText();
        String email = tfemail.getText();
        String phoneno = tfphoneno.getText();

        String query1 = "insert into customer (name, meter, address, city, state, email, phoneno) values('" + name + "', '" + meter + "','" + address + "', '" + city + "', '" + state + "', '" + email + "', '" + phoneno + "')";
        String query2 = "INSERT INTO login(meter, name, username, password,user) VALUES ('" + meter + "','" + name + "', '', '','')";

        try {
            conn c = new conn();
            
            // Use executeUpdate() instead of executeQuery()
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);

            JOptionPane.showMessageDialog(null, "Customer details added successfully");
            setVisible(false);
            
            new meterinfo(meter);

        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        setVisible(false);
    }
}


    public static void main(String[] args) {
        new newcustomer();
    }
}
