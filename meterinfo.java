package electricitybillingsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class meterinfo extends JFrame implements ActionListener {
    JButton next;
    Choice meterlocation,metertype,phasecode,billtype;
    String meternumber;
    meterinfo(String meter) {
        this.meternumber=meter;
    
    setSize(850, 550);
    setLocation(350, 100);
    
    JPanel p=new JPanel();
    p.setLayout(null);
    add(p);
    
        JLabel heading = new JLabel("METER INFORMATION");
        heading.setBounds(250, 30, 150, 20);
        heading.setFont(new Font("calibiri", Font.PLAIN, 20));
        heading.setForeground(Color.black);
        p.add(heading);

        JLabel lblname = new JLabel("METER NUMBER ");
        lblname.setBounds(180, 100, 170, 25);
        lblname.setFont(new Font("Calibiri", Font.BOLD, 12));
        lblname.setForeground(Color.BLACK);
        p.add(lblname);

        JLabel lblmeternumber = new JLabel(meternumber);
        lblmeternumber.setBounds(350, 100, 170, 25);
        lblmeternumber.setFont(new Font("Calibiri", Font.BOLD, 12));
        lblmeternumber.setForeground(Color.BLACK);
        p.add(lblmeternumber);

        JLabel lblmeterno = new JLabel("METER LOCATION");
        lblmeterno.setBounds(180, 150, 170, 25);
        lblmeterno.setFont(new Font("calibiri", Font.BOLD, 12));
        lblmeterno.setForeground(Color.BLACK);
        p.add(lblmeterno);
        
       meterlocation=new Choice();
       meterlocation.add("Outside");
        meterlocation.add("Inside");
        meterlocation.setBounds(350, 150, 200, 20); 
        p.add(meterlocation);
       
        
        JLabel lbladdress = new JLabel("METER TYPE");
        lbladdress.setBounds(180, 200, 170, 25);
        lbladdress.setFont(new Font("Calibiri", Font.BOLD, 12));
        lbladdress.setForeground(Color.BLACK);
        p.add(lbladdress);

        metertype=new Choice();
        metertype.add("Electric Meter");
        metertype.add("Smart Meter");
        metertype.add("Solar Meter");
        metertype.setBounds(350, 200, 200, 20); 
        p.add(metertype);
        
        
        JLabel lblphasecode = new JLabel("PHASE CODE");
        lblphasecode.setBounds(180, 250, 170, 25);
        lblphasecode.setFont(new Font("Calibiri", Font.BOLD, 12));
        lblphasecode.setForeground(Color.BLACK);
        p.add(lblphasecode);

        phasecode=new Choice();
        phasecode.add("011");
        phasecode.add("022");
        phasecode.add("033");
        phasecode.add("044");
        phasecode.add("055");
        phasecode.add("066");
        phasecode.add("077");
        phasecode.add("088");
        phasecode.add("099");
        phasecode.setBounds(350, 250, 200, 20); 
        p.add(phasecode);
                
        JLabel lblbilltype = new JLabel("BILL TYPE");
        lblbilltype.setBounds(180, 300, 170, 25);
        lblbilltype.setFont(new Font("Calibiri", Font.BOLD, 12));
        lblbilltype.setForeground(Color.BLACK);
        p.add(lblbilltype);

        billtype=new Choice();
        billtype.add("Normal");
        billtype.add("Industrial");
        billtype.setBounds(350, 300, 200, 20); 
        p.add(billtype);
        
       JLabel lblemail = new JLabel("DAYS");
        lblemail.setBounds(200, 350, 170, 25);
        lblemail.setFont(new Font("Calibiri", Font.BOLD, 12));
        lblemail.setForeground(Color.BLACK);
        p.add(lblemail);

        JLabel lblemails = new JLabel("30 DAYS");
        lblemails.setBounds(350, 350, 170, 25);
        lblemails.setFont(new Font("Calibiri", Font.BOLD, 12));
        lblemails.setForeground(Color.BLACK);
        p.add(lblemails);
        
        
       JLabel lblphoneno = new JLabel("NOTE");
        lblphoneno.setBounds(200, 400, 170, 25);
        lblphoneno.setFont(new Font("Calibiri", Font.BOLD, 12));
        lblphoneno.setForeground(Color.BLACK);
        p.add(lblphoneno);

      JLabel lblphonenos= new JLabel("By default Bill is calculated for 30 days only");
        lblphonenos.setBounds(350, 400, 300, 25);
        lblphonenos.setFont(new Font("Calibiri", Font.BOLD, 12));
        lblphonenos.setForeground(Color.BLACK);
        p.add(lblphonenos);
       
       
      next=new JButton("submit");
      next.setBounds(350,440,100,25);
      next.addActionListener(this);
      p.add(next);

      
      
      
      setLayout(new BorderLayout());
       
      add(p,"Center");
      
      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
      Image i2=i1.getImage().getScaledInstance(210, 510, Image.SCALE_DEFAULT);
      ImageIcon i3=new ImageIcon(i2);
      JLabel image=new JLabel(i3); 
      add(image,"East");
      
        setVisible(true);
                      
    }
     public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == next) {
        String meter =meternumber;
        String location = meterlocation.getSelectedItem();
        String mtype= metertype.getSelectedItem();
        String pcode =phasecode.getSelectedItem();
        String bills = billtype.getSelectedItem();
        String days = "30";
      
        String query = "insert into meterinfo (meter, location, mtype, pcode, bills, days) values('" + meter + "', '" +  location + "','" + mtype + "', '" + pcode + "', '" +bills + "', '" + days+ "')";
        
        try {
            conn c = new conn();

            c.s.executeUpdate(query);
           

            JOptionPane.showMessageDialog(null, "meter info added successfully");
            setVisible(false);
            
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        setVisible(false);
    }
}

    public static void main(String[] args){
    new meterinfo("");
}
}
