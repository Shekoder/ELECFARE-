package electricitybillingsystem;

import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class billdetails extends JFrame {
    JTable table;

    billdetails(String meter) {
        setSize(700, 600);
        setLocation(350, 100);

        getContentPane().setBackground(Color.WHITE);

        try {
            conn c = new conn();
            String query = "select * from bill where meter='" + meter + "'";
            ResultSet rs = c.s.executeQuery(query);

            table = new JTable();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            JScrollPane sp = new JScrollPane(table);
            sp.setBounds(0, 0, 700, 600);
            add(sp);

        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new billdetails("");
    }
}
