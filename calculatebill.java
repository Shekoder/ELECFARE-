package electricitybillingsystem;

import java.sql.ResultSetMetaData;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.*;

public class calculatebill extends JFrame implements ActionListener{
   JTextField tfunits;
    JButton cancel,submit;
    JLabel name,address;
    Choice meternumber,cmonth;
    calculatebill() {
        setSize(850, 550);
        setLocation(350, 100);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.GRAY);
        add(p);

        JLabel heading = new JLabel("Calculate Electricity Bill");
        heading.setBounds(250, 30, 200, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 16));
        heading.setForeground(Color.black);
        p.add(heading);

        JLabel lblmeternumber = new JLabel("Meter Number ");
        lblmeternumber.setBounds(180, 100, 170, 25);
        lblmeternumber.setFont(new Font("Calibiri", Font.BOLD, 12));
        lblmeternumber.setForeground(Color.BLACK);
        p.add(lblmeternumber);

        meternumber = new Choice();

       try {
            conn c = new conn();
             ResultSet rs = c.s.executeQuery("SELECT * FROM customer");
    
          while (rs.next()) {
        meternumber.add(rs.getString("meter"));
        }
  
          } catch (Exception e) {
             e.printStackTrace();
        }

          meternumber.setBounds(350, 100, 200, 20);
          p.add(meternumber);


        JLabel lblmeterno = new JLabel("Name");
        lblmeterno.setBounds(180, 150, 170, 25);
        lblmeterno.setFont(new Font("calibiri", Font.BOLD, 14));
        lblmeterno.setForeground(Color.BLACK);
        p.add(lblmeterno);
        
        name = new JLabel();
        name.setBounds(350, 150, 170, 25);       
        p.add(name);
        
     
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(180, 200, 170, 25);
        lbladdress.setFont(new Font("Calibiri", Font.BOLD, 12));
        lbladdress.setForeground(Color.BLACK);
        p.add(lbladdress);

      address = new JLabel();
      address.setBounds(350, 200, 200, 20);
       p.add(address);

       meternumber.addItemListener(new ItemListener(){
            public  void itemStateChanged(ItemEvent ie){
                try {
        conn c = new conn();
        ResultSet rs = c.s.executeQuery("SELECT * FROM customer WHERE meter='" + meternumber.getSelectedItem() + "'");
           while (rs.next()) {
               name.setText(rs.getString("name"));
               address.setText(rs.getString("address"));
           }
  
          } catch (Exception e) {
             e.printStackTrace();
        }
            }
        });
        
       
       
       
        JLabel lblcity = new JLabel("Unit Comsumed");
        lblcity.setBounds(180, 250, 170, 25);
        lblcity.setFont(new Font("Calibiri", Font.BOLD, 12));
        lblcity.setForeground(Color.BLACK);
        p.add(lblcity);

       tfunits = new JTextField();
       tfunits.setBounds(350, 250, 200, 20);
       p.add(tfunits);
        
        JLabel lblstate = new JLabel("Month");
        lblstate.setBounds(180, 300, 170, 25);
        lblstate.setFont(new Font("Calibiri", Font.BOLD, 12));
        lblstate.setForeground(Color.BLACK);
        p.add(lblstate);

       cmonth = new Choice();
       cmonth.add("January");
       cmonth.add("February");
       cmonth.add("March");
       cmonth.add("April");
       cmonth.add("June");
       cmonth.add("July");
       cmonth.add("August");
       cmonth.add("September");
       cmonth.add("October");
       cmonth.add("November");
       cmonth.add("December");
       cmonth.setBounds(350, 300, 200, 20);
       p.add(cmonth);
    
      submit=new JButton("submit");
      submit.setBounds(200,440,100,25);
      submit.addActionListener(this);
      p.add(submit);

      cancel=new JButton("Cancel");
      cancel.setBounds(400,440,100,25);
      cancel.addActionListener(this);
      p.add(cancel);
      
      
      setLayout(new BorderLayout());
       
      add(p,"Center");
      
      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
      Image i2=i1.getImage().getScaledInstance(200, 250, Image.SCALE_DEFAULT);
      ImageIcon i3=new ImageIcon(i2);
      JLabel image=new JLabel(i3); 
      add(image,"East");
      
        setVisible(true);
                      
    }
     public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == submit) {
        String meter = meternumber.getSelectedItem();
        String units= tfunits.getText();
        String month = cmonth.getSelectedItem();
        
        String query1 = "SELECT * FROM tax";
        int totalbill=0;
       int unitconsumed = Integer.parseInt(units);
      
try {
    conn c = new conn();
    ResultSet rs = c.s.executeQuery(query1);

    // Get metadata
    ResultSetMetaData metaData = (ResultSetMetaData) rs.getMetaData();

    // Print column names
    for (int i = 1; i <= metaData.getColumnCount(); i++) {
        System.out.println("Column Name: " + metaData.getColumnName(i));
    }

    while (rs.next()) {
        totalbill += unitconsumed * Integer.parseInt(rs.getString("costperunit"));
        totalbill += Integer.parseInt(rs.getString("meterrent"));
        totalbill += Integer.parseInt(rs.getString("servicecharge"));
        totalbill += Integer.parseInt(rs.getString("servicetax"));
        totalbill += Integer.parseInt(rs.getString("swacchbharatcess"));
        totalbill += Integer.parseInt(rs.getString("fixedtax"));
    }
} catch (Exception e) {
    e.printStackTrace();
}

        
        String query2="insert into bill values('"+meter+"','"+month+"','"+units+"','"+totalbill+"','not paid')";
        try{
            conn c = new conn();
            c.s.executeUpdate(query2);
            JOptionPane.showMessageDialog(null, "customer Information Bill updated successfullly");
            setVisible(false);
          
        }catch(Exception e){
            e.printStackTrace();
        }
    } else {
        setVisible(false);
    }
}


    public static void main(String[] args) {
        new calculatebill();
    }
}
