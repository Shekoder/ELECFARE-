package electricitybillingsystem;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.sql.ResultSet;

public class generatebill extends JFrame implements ActionListener{
    JButton bill;
    String meter;
    Choice cmonth;
    JTextArea area;
    generatebill(String meter){
        setSize(500, 650);
        setLocation(350, 10);
        setLayout(new BorderLayout());
        
        JPanel panel=new JPanel();
        
        JLabel heading=new JLabel("Generate Bill");
        JLabel meternumber=new JLabel(meter);
        cmonth=new Choice();
        
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
       
        area=new JTextArea(50,15);
        area.setText("\n\n\t--------Click on the--------\n\t Generate bill button to get\n\tthe bill of the Selected Month");
        area.setFont(new Font("Senserif",Font.ITALIC,18));
         
         JScrollPane pane = new JScrollPane(area);
          bill=new JButton("Generate Bill");
         bill.addActionListener(this);
          
         panel.add(heading);
         panel.add(meternumber);
         panel.add(cmonth);
         add(panel,"North");
         add(pane,"Center");
         add(bill,"South");        
         setVisible(true);
         
          this.meter = meter;
    }
      public void actionPerformed(ActionEvent ae) {
       try{
     conn c = new conn();
      
      area.setText("\tReliance Power Limited\n ELECTERICITY BILL GENERATED FOR THE MONTH\n\tOF"+cmonth.getSelectedItem()+",2023\n\n\n");
      ResultSet rs = c.s.executeQuery("SELECT * FROM customer where meter='"+meter+"'");
       if(rs.next()){
       area.append("\n    Customer Name   : " +rs.getString("name"));
       area.append("\n    Meter Number     : " +rs.getString("meter"));
       area.append("\n    Address             :" +rs.getString("address"));
       area.append("\n    City                   : " +rs.getString("city"));
       area.append("\n    State                : " +rs.getString("State"));
       area.append("\n    Email               : " +rs.getString("email"));
       area.append("\n    Phone             : " +rs.getString("phoneno"));
       area.append("\n------------------------------------------------------------");
       area.append("\n");      
       }
       rs = c.s.executeQuery("SELECT * FROM meterinfo where meter='"+meter+"'");
       if(rs.next()){
       area.append("\n    Meter Location   : " +rs.getString("location"));
       area.append("\n    Meter Type        : " +rs.getString("mtype"));
       area.append("\n    Phase Code      :" +rs.getString("pcode"));
       area.append("\n    Bill Type           : " +rs.getString("bills"));
       area.append("\n    Days                : " +rs.getString("days"));
       area.append("\n------------------------------------------------------------");
       area.append("\n");    
       }
       rs = c.s.executeQuery("SELECT * FROM tax ");
       if(rs.next()){
       area.append("\n");    
       area.append("\n");  
       area.append("\n    Cost Per Unit                  : " +rs.getString("costperunit"));
       area.append("\n    Meter Rent                     : " +rs.getString("meterrent"));
       area.append("\n    Service Charge               :" +rs.getString("servicecharge"));
       area.append("\n    Service Tax                  : " +rs.getString("servicetax"));
       area.append("\n    Swacch Bharat Cess         : " +rs.getString("swacchbharatcess"));
       area.append("\n     Fixed Tax                    : " +rs.getString("fixedtax"));
       area.append("\n------------------------------------------------------------");
       area.append("\n");  
       
       }
      rs = c.s.executeQuery("SELECT * FROM bill where meter='" + meter + "' and month='" + cmonth.getSelectedItem() + "'");
       if(rs.next()){
       area.append("\n");    
       area.append("\n");  
       area.append("\n    Current Month   : " +rs.getString("month"));
       area.append("\n    Units Consumed        : " +rs.getString("units"));
       area.append("\n    Total Charge      :" +rs.getString("totalbill"));
       area.append("\n------------------------------------------------------------");
       area.append("\n    Total Payable          : " +rs.getString("totalbill"));
       area.append("\n");    
       }
       }catch (Exception e){
        e.printStackTrace();
    }
          
    }    
      
   
    public static void main(String[] args) {
        new generatebill("");
     }
}
