import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;


public class dialler extends JFrame implements ActionListener
{
 JTextField txtfield;
 JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9; 
 JButton bcall, bhangup, bclr, bdlt, bAngie, bTanya, bBlondie;
 JLabel dial;
 JComboBox box;
  String prev;
  
public dialler(){
  super("Dialler");
  
  Container container = this.getContentPane();
 
  try{
    FileReader r = new FileReader("friends.txt");
    Scanner scan = new Scanner(r);
    
     while(scan.hasNextLine())
    {
        
     String a = scan.nextLine();
      String b = scan.nextLine();
  String c = scan.nextLine();
  String d = scan.nextLine();
 String e = scan.nextLine();
  String f = scan.nextLine();
      
      int a1 = 0;
      while (!Character.isDigit(a.charAt(a1))) 
      { a1++; }
      
      int a2 = 0;
      while (!Character.isDigit(b.charAt(a2))) 
      { a2++; }
      
      int a3 = 0;
      while (!Character.isDigit(c.charAt(a3))) 
      { a3++; }
      
      int a4 = 0;
      while (!Character.isDigit(d.charAt(a4))) 
      { a4++; }
      
      int a5 = 0;
      while (!Character.isDigit(e.charAt(a5))) 
      { a5++; }
      
      int a6 = 0;
      while (!Character.isDigit(f.charAt(a6))) 
      { a6++; }
     
      String name1 = a.substring(0,a1);
     String name2 = b.substring(0,a2);
     String name3 = c.substring(0,a3); 
     String name4 = d.substring(0,a4); 
      String name5 = e.substring(0,a5);
      String name6 = f.substring(0,a6);
      
      String num1 = a.substring(a1);
     String num2 = b.substring(a2);
     String num3 = c.substring(a3); 
     String num4 = d.substring(a4); 
      String num5 = e.substring(a5);
      String num6 = f.substring(a6);
      
      String[] contacts = {"", name1,name2,name3,name4,name5,name6};
     final String[] numbers = {"", num1,num2,num3,num4,num5,num6};
       
  
  JPanel p1 = new JPanel();
  txtfield = new JTextField(10);
  p1.setLayout(new GridLayout(1, 4));
  p1.add(txtfield);
  container.add(p1, BorderLayout.NORTH);
  
  JPanel p2 = new JPanel();
  p2.setLayout(new GridLayout(3, 3));
  Icon angie = new ImageIcon("yoda.jpg");
  Icon tanya = new ImageIcon("chuwee.jpg");
  Icon blondie = new ImageIcon("vader.jpg");
  bAngie = new JButton();
  bTanya = new JButton();
  bBlondie = new JButton();
  bTanya.setIcon(tanya);
  bAngie.setIcon(angie);
  bBlondie.setIcon(blondie);
  bAngie.addActionListener(this);
   bTanya.addActionListener(this);
    bBlondie.addActionListener(this);
  p2.add(bAngie);
  p2.add(bTanya);
  p2.add(bBlondie);
  container.add(p2, BorderLayout.WEST);
  
  JPanel p3 = new JPanel();
  box = new JComboBox(contacts);
  box.addItemListener( new ItemListener(){
  public void itemStateChanged(ItemEvent event){
if (event.getStateChange() == ItemEvent.SELECTED)
  txtfield.setText(numbers[box.getSelectedIndex()]);
  }
}//end of item
  
  );
  p3.setLayout(new GridLayout(1, 4));
  p3.add(box);
  container.add(p3, BorderLayout.SOUTH);
  
  JPanel p4 = new JPanel();
  p4.setLayout(new GridLayout(3, 3));
  Icon call = new ImageIcon("dial.jpg");
  Icon hangup = new ImageIcon("hangup.jpg");
  bcall = new JButton();
  bcall.addActionListener(this);
  bhangup = new JButton();
  bhangup.addActionListener(this);
  dial = new JLabel("Disconnected");
  bcall.setIcon(call);
  bhangup.setIcon(hangup);
  
  p4.add(bcall);
  p4.add(bhangup);
  p4.add(dial);
  container.add(p4, BorderLayout.EAST);
 
  JPanel p5 = new JPanel();
  p5.setLayout(new GridLayout(4, 3));
  bdlt = new JButton("Del");
  bclr = new JButton("Clr");
   b1 = new JButton("1"); 
  b0 = new JButton("0");  b2 = new JButton("2");  b3 = new JButton("3");  b4 = new JButton("4");
  b5 = new JButton("5"); b6 = new JButton("6"); b7 = new JButton("7");  b8 = new JButton("8");
  b9 = new JButton("9");
  p5.add(b7); b7.addActionListener(this);
  p5.add(b8); b8.addActionListener(this);
  p5.add(b9); b9.addActionListener(this);
  p5.add(b4); b4.addActionListener(this);
  
  p5.add(b5); b5.addActionListener(this);
  p5.add(b6); b6.addActionListener(this);
  p5.add(b1); b1.addActionListener(this);
  p5.add(b2); b2.addActionListener(this);
  
  p5.add(b3); b3.addActionListener(this);
  p5.add(bdlt);  bdlt.addActionListener(this);
  p5.add(b0); b0.addActionListener(this);
  p5.add(bclr); bclr.addActionListener(this);
 
  container.add(p5, BorderLayout.CENTER);
  
  
  
  
      }// while end
     
 
      scan.close();
      
  } catch (Exception e) {
    System.out.println("File error");
    }
  
  setSize(500, 400);
  setVisible(true);
  
  
  
}// end

public static void main( String args[] ) { 
  
  dialler application = new dialler();
  application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE); 
}// end of main

public void actionPerformed(ActionEvent e){
  prev = txtfield.getText(); 
  
  if (e.getSource() == bdlt)
    txtfield.setText(prev.substring(0, prev.length() - 1));
  
  if (e.getSource() == bclr){
    box.setSelectedIndex(0);
    prev = " ";
    txtfield.setText(" ");}
  
  if(e.getSource() == bhangup){
    txtfield.setText(" ");
    dial.setText("Disconnected");
    box.setSelectedIndex(0);}
  
  if (e.getSource() == bAngie)
   box.setSelectedIndex(1);
  if (e.getSource() == bTanya)
     box.setSelectedIndex(2);
  if (e.getSource() == bBlondie)
     box.setSelectedIndex(3);
  
  if(e.getSource() == b0)
  txtfield.setText(prev + "0");
  if(e.getSource() == b1)
   txtfield.setText(prev + "1");
  if(e.getSource() == b2)
   txtfield.setText(prev + "2");
  if(e.getSource() == b3)
   txtfield.setText(prev + "3");
  if(e.getSource() == b4)
   txtfield.setText(prev + "4");
  if(e.getSource() == b5)
   txtfield.setText(prev + "5");
  if(e.getSource() == b6)
   txtfield.setText(prev + "6");
  if(e.getSource() == b7)
   txtfield.setText(prev + "7");
  if(e.getSource() == b8)
   txtfield.setText(prev + "8");
  if(e.getSource() == b9)
   txtfield.setText(prev + "9");
  
  if(e.getSource() == bcall)
    dial.setText("Dialling....");
  
  if (txtfield.getText().equals(""))
    box.setSelectedIndex(0);
  
  
  }//end of action 


}

