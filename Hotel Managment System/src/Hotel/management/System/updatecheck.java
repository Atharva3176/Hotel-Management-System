package Hotel.management.System;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import net.proteanit.sql.DbUtils;
public class updatecheck extends JFrame implements ActionListener
{
	Choice Ccustomer;
	JButton check,back,update;
	JTextField tfroom,tfname,tfcheck,tfamount,tfpamount;
	updatecheck() 
	{
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel text= new JLabel("update Status");
		text.setFont(new Font("times roman",Font.BOLD,20));
		text.setBounds(90,20,200,30);
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
		room.setBounds(30,120,100,20);
		add(room);
		
		tfroom=new JTextField();
		tfroom.setBounds(200,120,150,25);
		add(tfroom);
		
		JLabel name= new JLabel("Name");
		name.setBounds(30,160,100,20);
		add(name);
		
		tfname=new JTextField();
		tfname.setBounds(200,160,150,25);
		add(tfname);
		
		JLabel CheckIn= new JLabel("CheckIn");
		CheckIn.setBounds(30,200,100,20);
		add(CheckIn);
		
		tfcheck=new JTextField();
		tfcheck.setBounds(200,200,150,25);
		add(tfcheck);
		
		JLabel Amount= new JLabel("Amount Paid");
		Amount.setBounds(30,240,100,20);
		add(Amount);
		
		tfamount=new JTextField();
		tfamount.setBounds(200,240,150,25);
		add(tfamount);
		
		
		JLabel pAmount= new JLabel("Amount pending");
		pAmount.setBounds(30,280,100,20);
		add(pAmount);
		
		tfpamount=new JTextField();
		tfpamount.setBounds(200,280,150,25);
		add(tfpamount);
		
		check=new JButton("Check");
		check.setForeground(Color.WHITE);
		check.setBackground(Color.BLACK);
		check.setBounds(30,340,100,30);
		check.addActionListener(this);
		add(check);
		
		update=new JButton("update");
		update.setForeground(Color.WHITE);
		update.setBackground(Color.BLACK);
		update.setBounds(150,340,100,30);
		update.addActionListener(this);
		add(update);
		
		back=new JButton("Back");
		back.setForeground(Color.WHITE);
		back.setBackground(Color.BLACK);
		back.setBounds(270,340,100,30);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
		JLabel image=new JLabel(i1);
		image.setBounds(450,50,500,300);
		add(image);
		
		setBounds(300,200,980,500);
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
					tfname.setText(rs.getString("name1"));
					tfcheck.setText(rs.getString("time"));
					tfamount.setText(rs.getString("dep"));
				}
				
				ResultSet rs1=conn.s.executeQuery("select * from room6 where roomnumber='"+tfroom.getText()+"'");
				while(rs1.next())
				{
					String price=rs1.getString("price");
					int amountpaid=Integer.parseInt(price)-Integer.parseInt(tfamount.getText());
					tfpamount.setText(""+amountpaid);
				}
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==update)
		{
			String number=Ccustomer.getSelectedItem();
			String room=tfroom.getText();
			String name=tfname.getText();
			String checkIn=tfcheck.getText();
			String deposit=tfamount.getText();
			try
			{
				Conn conn = new Conn();
				conn.s.executeUpdate("update customer set room='"+room+"',time='"+checkIn+"',dep='"+deposit+"'");
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
		new updatecheck();
	}

}
