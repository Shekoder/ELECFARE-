package electricitybillingsystem;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class paytm  extends JFrame implements ActionListener{
    String meter;
     JButton back;
    paytm(String meter){
     this.meter=meter;
    
    JEditorPane j=new JEditorPane();
    j.setEditable(false);
    
    try{
    j.setPage("https://paytm.com/online-payments");
    
    }catch (Exception e) {
            j.setContentType("Text/html");
            j.setText("<html>Could not load<html>");
    }
    JScrollPane pane = new JScrollPane(j);
    add(pane);
    
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(550, 20, 80, 30);
        back.addActionListener(this);
        j.add(back);
        
    setSize(700, 600);
    setLocation(350, 100);
     setVisible(true);

    }
     public void actionPerformed(ActionEvent ae) {
     setVisible(false);
     new paybills(meter);
    }
    
     public static void main(String[] args) {
        new paytm("");
     }

   
}

