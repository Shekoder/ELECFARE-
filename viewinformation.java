package electricitybillingsystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class viewinformation extends JFrame implements ActionListener{
    JButton cancel;

    viewinformation(String meter) {
        setBounds(300, 10, 800, 655);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("VIEW CUSTOMER DETAILS");
        heading.setBounds(250, 0, 350, 40);
        heading.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 80, 100, 20);
        add(lblname);

        JLabel name = new JLabel("");
        name.setBounds(200, 80, 100, 20);
        add(name);

        JLabel lblmeternumber=new JLabel("Meter Number");
        lblmeternumber.setBounds(450,80,100,20);
        add(lblmeternumber);
    
         JLabel meternumber=new JLabel("");
    meternumber.setBounds(600,80,100,20);
    add(meternumber);
    
    JLabel lbladdress=new JLabel("Address");
    lbladdress.setBounds(50,160,100,20);
    add(lbladdress);
    
    JLabel address=new JLabel("");
    address.setBounds(200,160,100,20);
    add(address);
    
    JLabel lblcity=new JLabel("City");
    lblcity.setBounds(450,160,100,20);
    add(lblcity);
    
    JLabel city=new JLabel("");
    city.setBounds(600,160,100,20);
    add(city);
    
    JLabel lblstate=new JLabel("State");
    lblstate.setBounds(50,240,100,20);
    add(lblstate);
    
    JLabel state=new JLabel("");
    state.setBounds(200,240,100,20);
    add(state);
    
    JLabel lblemail=new JLabel("Email");
    lblemail.setBounds(450,240,100,20);
    add(lblemail);
    
    JLabel email=new JLabel("");
    email.setBounds(600,240,100,20);
    add(email);
    
    JLabel lblphoneno=new JLabel("Phone Number");
    lblphoneno.setBounds(50,320,100,20);
    add(lblphoneno);
    
    JLabel phoneno=new JLabel("");
    phoneno.setBounds(200,320,100,20);
    add(phoneno); 
       
    try{
      conn c = new conn();
      ResultSet rs = c.s.executeQuery("SELECT * FROM customer where meter='"+meter+"'");
     while(rs.next()){
     name.setText(rs.getString("name"));
     address.setText(rs.getString("address"));
     city.setText(rs.getString("city"));
     state.setText(rs.getString("state"));
     email.setText(rs.getString("email"));
     phoneno.setText(rs.getString("phoneno"));
     meternumber.setText(rs.getString("meter"));
    }
    }catch (Exception e){
        e.printStackTrace();
    }
    
    
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(368, 380, 100, 20);
        cancel.addActionListener(this);
        add(cancel);  
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 230, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        int x = (getWidth() - i3.getIconWidth()) / 2;
        int y = (getHeight() - i3.getIconHeight()/1);
        image.setBounds(x, y, i3.getIconWidth(), i3.getIconHeight());
        add(image);

    setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
      setVisible(false);
   }
    public static void main(String[] args) {
        new viewinformation("");
    }
}
