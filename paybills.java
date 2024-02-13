package electricitybillingsystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class paybills extends JFrame implements ActionListener{
     JButton pay,back;
    Choice cmonth;
     String meter;
    paybills(String meter){ 
    this.meter=meter;
   
    setLayout(null);    
    setBounds(250, 50, 750, 550);
     
    JLabel heading = new JLabel("Electicity Bill");
    heading.setBounds(325, 0, 350, 40);
    heading.setFont(new Font("Tahoma", Font.BOLD, 16));
    add(heading);
    
    JLabel lblmeternumber = new JLabel("Meter Number");
    lblmeternumber.setBounds(120, 60, 150, 20);
    lblmeternumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
    add(lblmeternumber);
    
    JLabel meternumber = new JLabel("");
    meternumber.setBounds(240, 60, 150, 20);
    meternumber.setFont(new Font("Tahoma", Font.BOLD, 14));
    add(meternumber);
    
     JLabel lblname = new JLabel("Name");
    lblname.setBounds(120, 120, 150, 20);
    lblname.setFont(new Font("Tahoma", Font.PLAIN, 14));
    add(lblname);
    
    JLabel labelname = new JLabel("");
    labelname.setBounds(240, 120, 150, 20);
    labelname.setFont(new Font("Tahoma", Font.BOLD, 14));
    add(labelname);
    
     JLabel lblmonth = new JLabel("Month");
    lblmonth.setBounds(120, 180, 100, 20);
    lblmonth.setFont(new Font("Tahoma", Font.PLAIN, 14));
    add(lblmonth);
    
        cmonth = new Choice();
        cmonth.setBounds(240, 180, 150, 20);
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
        add(cmonth);
    
    JLabel lblunits = new JLabel("Units");
    lblunits.setBounds(120, 240, 150, 20);
    lblunits.setFont(new Font("Tahoma", Font.PLAIN, 14));
    add(lblunits);
    
    JLabel labelunits = new JLabel("");
    labelunits.setBounds(240, 240, 150, 20);
    labelunits.setFont(new Font("Tahoma", Font.BOLD, 14));
    add(labelunits);
    
    JLabel lbltotalbills = new JLabel("Total Bills");
    lbltotalbills.setBounds(120, 300, 150, 20);
    lbltotalbills.setFont(new Font("Tahoma", Font.PLAIN, 14));
    add(lbltotalbills);
    
    JLabel labeltotalbills = new JLabel("");
    labeltotalbills.setBounds(240, 300, 150, 20);
    labeltotalbills.setFont(new Font("Tahoma", Font.BOLD, 14));
    add(labeltotalbills);
   
    JLabel lblstatus = new JLabel("Status");
    lblstatus.setBounds(120, 360, 150, 20);
    lblstatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
    add(lblstatus);
    
    JLabel labelstatus = new JLabel("");
    labelstatus.setBounds(240, 360, 150, 20);
    labelstatus.setFont(new Font("Tahoma", Font.BOLD, 14));
    labelstatus.setForeground(Color.red);
    add(labelstatus);   
       
     try{
      conn c = new conn();
      ResultSet rs = c.s.executeQuery("SELECT * FROM customer where meter='"+meter+"'");
      while(rs.next()){
       meternumber.setText(meter);
       labelname.setText(rs.getString("name"));
      
      }
     
      rs = c.s.executeQuery("SELECT * FROM bill where meter='"+meter+"' and month='"+cmonth.getSelectedItem()+"'");
      while(rs.next()){
       labelunits.setText("units");
       labeltotalbills.setText(rs.getString("totalbill"));
       labelstatus.setText(rs.getString("status"));

      }
     }catch (Exception e){
       e.printStackTrace();
      }
    
     cmonth.addItemListener(new ItemListener(){
        @Override
        public void itemStateChanged(ItemEvent ae) {
           try{
      conn c = new conn();
      ResultSet rs = c.s.executeQuery("SELECT * FROM bill where meter='"+meter+"' and month='"+cmonth.getSelectedItem()+"'");
      while(rs.next()){
       labelunits.setText("units");
       labeltotalbills.setText(rs.getString("totalbill"));
       labelstatus.setText(rs.getString("status"));

      }
      }catch (Exception e){
       e.printStackTrace();
        }
    }
         
     });
      pay = new JButton("Pay");
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.setBounds(120, 420, 100, 20);
        pay.addActionListener(this);
        add(pay);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(300, 420, 100, 20);
        back.addActionListener(this);
        add(back);
   
     getContentPane().setBackground(Color.white);
 
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
     Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
     ImageIcon i3 = new ImageIcon(i2);
     JLabel image = new JLabel(i3);
     image.setBounds(340, 50,500, 300);
     add(image);
        
    setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
      if(ae.getSource()==pay){
           try{
     conn c = new conn();
     c.s.executeUpdate("update bill set status='Paid' where meter='" + meter + "' and month='" + cmonth.getSelectedItem() + "'");
    }catch (Exception e){
        e.printStackTrace();
    }
   setVisible(false);
     new paytm(meter);
    }else{
      setVisible(false);
   }
    }
     public static void main(String[] args) {
        new paybills("");
    }
}

