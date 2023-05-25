package Hotel.management.System;

import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.util.Date;
public class checkout extends JFrame implements ActionListener{

	Choice Ccustomer;
	JLabel roomno,c1,out;
	JButton check1,back;
	checkout() 
	{
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel head= new JLabel("Checkout");
		head.setFont(new Font("Times Roman",Font.BOLD,20));
		head.setBounds(100,20,100,30);
		head.setForeground(Color.blue);
		add(head);
		
		JLabel id= new JLabel("Customer id");
		id.setBounds(30,80,100,30);
		add(id);
		
		Ccustomer = new Choice();
		Ccustomer.setBounds(150,80,150,25);
		add(Ccustomer);
		
		
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
		Image i2=i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(310,80,20,20);
		add(image);
		
		JLabel room= new JLabel("Room number");
		room.setBounds(30,130,100,30);
		add(room);
		
		roomno= new JLabel();
		roomno.setBounds(150,130,100,30);
		add(roomno);
		

		JLabel check= new JLabel("CheckIn time");
		check.setBounds(30,180,100,30);
		add(check);
		
		c1= new JLabel();
		c1.setBounds(150,180,100,30);
		add(c1);
		
		JLabel checkout= new JLabel("Checkout time");
		checkout.setBounds(30,230,100,30);
		add(checkout);
		
	    Date date=new Date();
		out= new JLabel(""+date);
		out.setBounds(150,230,150,30);
		add(out);
		
		check1=new JButton("Check");
		check1.setForeground(Color.WHITE);
		check1.setBackground(Color.BLACK);
		check1.setBounds(30,280,120,30);
		check1.addActionListener(this);
		add(check1);
		
		back=new JButton("Back");
		back.setForeground(Color.WHITE);
		back.setBackground(Color.BLACK);
		back.setBounds(170,280,120,30);
		back.addActionListener(this);
		add(back);
		
		try
		{
			Conn conn = new Conn();
			ResultSet rs=conn.s.executeQuery("select * from customer");
			while(rs.next())
			{
				Ccustomer.add(rs.getString("number"));
				roomno.setText(rs.getString("room"));
				c1.setText(rs.getString("time"));
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		ImageIcon i4= new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
		Image i5=i4.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
		ImageIcon i6=new ImageIcon(i5);
		JLabel image1=new JLabel(i6);
		image1.setBounds(350,50,400,250);
		add(image1);
		
		setBounds(300,200,800,400);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == check1) 
		{
			String query = "delete from customer where number ='"+Ccustomer.getSelectedItem()+"'";
			String query1 = "update room6 set availability ='Available' where roomnumber='"+roomno.getText()+"'";
		
		try
		{

			Conn conn = new Conn();
			conn.s.executeUpdate(query);
			conn.s.executeUpdate(query1);
			JOptionPane.showMessageDialog(null,"checkout done Successfully");
			setVisible(false);
			new Reception();
		}
		
		
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
		else if(ae.getSource()==back)
		{
			setVisible(false);
			new Reception();
		}
	}


	public static void main(String[] args) 
	{
		new checkout();
	}

}
