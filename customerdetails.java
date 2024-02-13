
package electricitybillingsystem;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class customerdetails extends JFrame implements ActionListener {
    JTable table;
    JButton print;
    Choice meternumber, cmonth;

    customerdetails() {
        super("Customer Details");
        setSize(1200, 650);
        setLocation(50, 100);

        table = new JTable();

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(table);
        add(sp);

        JPanel buttonPanel = new JPanel();
        print = new JButton("Print");
        print.addActionListener(this);
        buttonPanel.add(print); // Add the button to the panel

        add(buttonPanel, BorderLayout.SOUTH); // Use BorderLayout to position the panel in the south

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
     try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            
        }
   }
    public static void main(String[] args) {
        new customerdetails();
    }

}