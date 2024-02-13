package electricitybillingsystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class depositdetails extends JFrame implements ActionListener {
    Choice meternumber, cmonth;
    JTable table;
    JButton search,print;
    depositdetails() {
        super("Deposit Details");
        setSize(700, 500);
        setLocation(350, 150);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel lblmeternumber = new JLabel("Search Meter Number");
        lblmeternumber.setBounds(20, 30, 150, 15);
        lblmeternumber.setFont(new Font("calibiri", Font.PLAIN, 14));
        lblmeternumber.setForeground(Color.black);
        add(lblmeternumber);

        meternumber = new Choice();
        meternumber.setBounds(180, 30, 150, 15);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM customer");
            while (rs.next()) {
                meternumber.add(rs.getString("meter"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        add(meternumber);

        JLabel lblmonth = new JLabel("Search Month");
        lblmonth.setBounds(400, 30, 100, 15);
        lblmonth.setFont(new Font("calibiri", Font.PLAIN, 14));
        lblmonth.setForeground(Color.black);
        add(lblmonth);

        cmonth = new Choice();
        cmonth.setBounds(500, 30, 150, 15);
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

        table = new JTable();

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM bill");

            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(10, 100, 668, 600);
        add(sp);
        
        search=new JButton("Search");
        search.setBounds(250,70,80,20);
        search.addActionListener(this);
        add(search);
        
        print=new JButton("Print");
        print.setBounds(350,70,80,20);
        print.addActionListener(this);
        add(print);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
    if (ae.getSource() == search) {
    String query="SELECT * FROM bill where meter='"+meternumber.getSelectedItem()+"'and month='"+cmonth.getSelectedItem()+"'";
    
    try{
    conn c = new conn();
    ResultSet rs = c.s.executeQuery(query);
    table.setModel(DbUtils.resultSetToTableModel(rs));
    }catch (Exception e){
    e.printStackTrace();
    }
    }else {
    try{
        table.print();
        
    }catch (Exception e){
     e.printStackTrace();
     
    }
    
    }
    }

    public static void main(String[] args) {
        new depositdetails();
    }
}
