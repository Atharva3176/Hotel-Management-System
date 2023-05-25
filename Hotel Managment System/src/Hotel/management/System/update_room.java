package Hotel.management.System;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import net.proteanit.sql.DbUtils;
public class update_room extends JFrame implements ActionListener
{
	Choice Ccustomer;
	JButton check,back,update;
	JTextField tfroom,tfavail,tfstatus;
	update_room() 
	{
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel text= new JLabel("update Room Status");
		text.setFont(new Font("times roman",Font.BOLD,25));
		text.setBounds(90,20,250,30);
		text.setForeground(Color.blue);
		add(text);
		
		JLabel id= new JLabel("Customer id");
		id.setBounds(30,80,100,20);
		add(id);
		
		Ccustomer = new Choice();
		Ccustomer.setBounds(200,80,150,25);
		add(Ccustomer);
		
		try
		{
			Conn conn = new Conn();
			ResultSet rs=conn.s.executeQuery("select * from customer");
			while(rs.next())
			{
				Ccustomer.add(rs.getString("number"));
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		JLabel room= new JLabel("Room number");
		room.setBounds(30,130,100,20);
		add(room);
		
		tfroom=new JTextField();
		tfroom.setBounds(200,130,150,25);
		add(tfroom);
		
		JLabel avail= new JLabel("Availability");
		avail.setBounds(30,180,100,20);
		add(avail);
		
		tfavail=new JTextField();
		tfavail.setBounds(200,180,150,25);
		add(tfavail);
		
		JLabel CheckIn= new JLabel("Cleaning Status");
		CheckIn.setBounds(30,230,100,20);
		add(CheckIn);
		
		tfstatus=new JTextField();
		tfstatus.setBounds(200,230,150,25);
		add(tfstatus);
		
		check=new JButton("Check");
		check.setForeground(Color.WHITE);
		check.setBackground(Color.BLACK);
		check.setBounds(30,300,100,30);
		check.addActionListener(this);
		add(check);
		
		update=new JButton("update");
		update.setForeground(Color.WHITE);
		update.setBackground(Color.BLACK);
		update.setBounds(150,300,100,30);
		update.addActionListener(this);
		add(update);
		
		back=new JButton("Back");
		back.setForeground(Color.WHITE);
		back.setBackground(Color.BLACK);
		back.setBounds(270,300,100,30);
		back.addActionListener(this);
		add(back);
		

		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
		Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(400,50,500,300);
		add(image);
		
		setBounds(300,200,980,450);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == check) 
		{
			String id = Ccustomer.getSelectedItem();
			String query="select * from customer where number ='"+id+"'";
			try
			{
				Conn conn = new Conn();
				ResultSet rs=conn.s.executeQuery(query);
				while(rs.next())
				{
					tfroom.setText(rs.getString("room"));
				}
				
				ResultSet rs1=conn.s.executeQuery("select * from room6 where roomnumber='"+tfroom.getText()+"'");
				while(rs1.next())
				{
					tfavail.setText(rs1.getString("Availability"));
					tfstatus.setText(rs1.getString("Cleaning Status"));
				}
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==update)
		{
			//String number=Ccustomer.getSelectedItem();
			String room=tfroom.getText();
			String available=tfavail.getText();
			String status=tfstatus.getText();
			try
			{
				Conn conn = new Conn();
				conn.s.executeUpdate("update room6 set availability='"+available+"',status='"+status+"' where roomnumber='"+room+"'");
				JOptionPane.showMessageDialog(null,"Data Updated Successfully");
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
		new update_room();
	}

}
