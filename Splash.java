
package electricitybillingsystem;
import java.awt.Image;
import javax.swing.*;


public class Splash extends JFrame implements Runnable{
   Thread t;
    Splash(){
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/elecfare.jpg"));
        Image i2=i1.getImage().getScaledInstance(650, 550, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3); 
        add(image);
        setVisible(true);
        int x=1;
        for(int i=2;i<500;i+=4,x+=1){
            setSize(i+x,i);
            setLocation(450,150);
            try{
            Thread.sleep(2);
            }catch(Exception e){
            e.printStackTrace();
    }
    }
          t=new Thread(this);
          t.start();
        
           setVisible(true);
    }
   
    public void run(){
        try{
            Thread.sleep(4000);
            setVisible(false);
            
            new login();
            }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    
   
    public static void main(String[] args) {
        new Splash();
    }
    
}