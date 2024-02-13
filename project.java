package electricitybillingsystem;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;

public class project extends JFrame implements ActionListener{
   String atype,meter;
   
    project(String atype,String meter){
       this.atype=atype;
       this.meter=meter;
       
       setExtendedState(JFrame.MAXIMIZED_BOTH);
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/elect01.jpg"));
       Image i2=i1.getImage().getScaledInstance(1280, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3); 
        add(image);
        
      JMenuBar mb=new   JMenuBar();
      setJMenuBar(mb);
      
      JMenu master= new  JMenu("Master");
      master.setForeground(Color.DARK_GRAY);
     
      JMenuItem newcustomer= new  JMenuItem("New Customer");
      newcustomer.setFont(new Font("monospaced",Font.PLAIN,12));
      newcustomer.setBackground(Color.WHITE);
      ImageIcon icon1=new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
      Image image1=icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
      newcustomer.setIcon(new ImageIcon(image1));
      newcustomer.setMnemonic('D');
      newcustomer.addActionListener(this);
      newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
      master.add(newcustomer);
      
      JMenuItem customerdetails= new  JMenuItem("Customer Details");
      customerdetails.setFont(new Font("monospaced",Font.PLAIN,12));
      customerdetails.setBackground(Color.WHITE);
      ImageIcon icon2=new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
      Image image2=icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
      customerdetails.setIcon(new ImageIcon(image2));
      customerdetails.setMnemonic('M');
      customerdetails.addActionListener(this);
      customerdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
      master.add(customerdetails);
      
     JMenuItem depositdetails= new  JMenuItem("Deposit Details");
     depositdetails.setFont(new Font("monospaced",Font.PLAIN,12));
     depositdetails.setBackground(Color.WHITE);
     ImageIcon icon3=new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
     Image image3=icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
     depositdetails.setIcon(new ImageIcon(image3));
     depositdetails.setMnemonic('N');
      depositdetails.addActionListener(this);
     depositdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
     master.add( depositdetails);
      
     JMenuItem calculatebill= new  JMenuItem("Calculate Bill");
     calculatebill.setFont(new Font("monospaced",Font.PLAIN,12));
     calculatebill.setBackground(Color.WHITE);
     ImageIcon icon4=new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
     Image image4=icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
     calculatebill.setIcon(new ImageIcon(image4));
     calculatebill.setMnemonic('B');
    calculatebill.addActionListener(this);
     calculatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
     master.add( calculatebill);
      
     
      JMenu info= new  JMenu("Information");
      info.setForeground(Color.RED);
    
      
     JMenuItem updateinformation= new  JMenuItem("Update Information");
     updateinformation.setFont(new Font("monospaced",Font.PLAIN,12));
     updateinformation.setBackground(Color.WHITE);
     ImageIcon icon5=new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
     Image image5=icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
     updateinformation.setIcon(new ImageIcon(image5));
     updateinformation.setMnemonic('U');
     updateinformation.addActionListener(this);
     updateinformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
     info.add( updateinformation);
      
     JMenuItem viewinformation= new  JMenuItem("View Information");
     viewinformation.setFont(new Font("monospaced",Font.PLAIN,12));
     viewinformation.setBackground(Color.WHITE);
     ImageIcon icon6=new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
     Image image6=icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
     viewinformation.setIcon(new ImageIcon(image6));
     viewinformation.setMnemonic('I');
     viewinformation.addActionListener(this);
     viewinformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.CTRL_MASK));
     info.add( viewinformation);
    
     
      JMenu user= new  JMenu("User");
      user.setForeground(Color.DARK_GRAY);
      
      
     JMenuItem paybill= new  JMenuItem("Pay Bill");
     paybill.setFont(new Font("monospaced",Font.PLAIN,12));
     paybill.setBackground(Color.WHITE);
     ImageIcon icon7=new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
     Image image7=icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
     paybill.setIcon(new ImageIcon(image7));
     paybill.setMnemonic('P');
     paybill.addActionListener(this);
     paybill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
     user.add( paybill);
      
     JMenuItem bildetails= new  JMenuItem("Bill Details");
     bildetails.setFont(new Font("monospaced",Font.PLAIN,12));
     bildetails.setBackground(Color.WHITE);
     ImageIcon icon8=new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
     Image image8=icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
     bildetails.setIcon(new ImageIcon(image8));
     bildetails.setMnemonic('L');
     bildetails.addActionListener(this);
     bildetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
     user.add( bildetails);
     
     JMenu report= new  JMenu("Report");
      report.setForeground(Color.RED);
     
      
     JMenuItem generatebill= new  JMenuItem("Generate Bill");
     generatebill.setFont(new Font("monospaced",Font.PLAIN,12));
     generatebill.setBackground(Color.WHITE);
     ImageIcon icon9=new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
     Image image9=icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
     generatebill.setIcon(new ImageIcon(image9));
     generatebill.setMnemonic('G');
     generatebill.addActionListener(this);
     generatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
     report.add( generatebill);
     
     JMenu utility= new  JMenu("Utility");
      utility.setForeground(Color.DARK_GRAY);
      
      
     JMenuItem notepad= new  JMenuItem("Notepad");
     notepad.setFont(new Font("monospaced",Font.PLAIN,12));
     notepad.setBackground(Color.WHITE);
     ImageIcon icon10=new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
     Image image10=icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
     notepad.setIcon(new ImageIcon(image10));
     notepad.setMnemonic('S');
     notepad.addActionListener(this);
     notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
     utility.add( notepad);
     
      JMenuItem calculator= new  JMenuItem("Calculator");
     calculator.setFont(new Font("monospaced",Font.PLAIN,12));
     calculator.setBackground(Color.WHITE);
     ImageIcon icon11=new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
     Image image11=icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
     calculator.setIcon(new ImageIcon(image11));
     calculator.setMnemonic('S');
     calculator.addActionListener(this);
     calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
     utility.add( calculator);
     
     JMenu mexit= new  JMenu("Exit");
      mexit.setForeground(Color.DARK_GRAY);
    
      
     JMenuItem exit= new  JMenuItem("Exit");
     exit.setFont(new Font("monospaced",Font.PLAIN,12));
     exit.setBackground(Color.WHITE);
     ImageIcon icon12=new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
     Image image12=icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
     exit.setIcon(new ImageIcon(image12));
     exit.setMnemonic('W');
     exit.addActionListener(this);
     exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,ActionEvent.CTRL_MASK));
     mexit.add( exit);     
   
     if(atype.equals("Admin")){
         mb.add(master);
     }else{
       mb.add(info);
       mb.add(user);
       mb.add(report);
       
     }
  
      mb.add(utility);
      mb.add(mexit);
      
     setLayout(new FlowLayout());
      
      
        setVisible(true);
       
       

}

    public void actionPerformed(ActionEvent ae){
    String msg=ae.getActionCommand();
    if(msg.equals("New Customer")){
        new newcustomer();
    }else if(msg.equals("Customer Details")){
        new customerdetails();
    }else if(msg.equals("Deposit Details")){
        new depositdetails();
    }else if(msg.equals("Calculate Bill")){
        new  calculatebill();
    }else if(msg.equals("View Information")){
        new  viewinformation(meter);
    }else if(msg.equals("Update Information")){
        new updateinformation(meter);
    }else if(msg.equals("Bill Details")){
        new billdetails(meter);
    }else if(msg.equals("Notepad")){
      try{
          Runtime.getRuntime().exec("notepad.exe");
      }  catch(Exception e) {
      e.printStackTrace();
      }
    }else if(msg.equals("Calculator")){
      try{
          Runtime.getRuntime().exec("calc.exe");
      }  catch(Exception e) {
      e.printStackTrace();
      }
      }else if(msg.equals("Exit")){
      setVisible(false);       
    new login();
    }else if(msg.equals("Pay Bill")){
     new paybills(meter);
    }else if(msg.equals("Generate Bill")){
     new generatebill(meter);
   }
   }
   public static void main(String[] args){
        new project("Admin","");
    }
    
}

