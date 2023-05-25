package Hotel.management.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class CustomerInfo extends JFrame implements ActionListener
{
	JTable table;
	JButton btn;
	CustomerInfo() 
	{
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel head = new JLabel("Document Type");
		head.setBounds(10,10,100,20);
		add(head);
		
		JLabel avail = new JLabel("Number");
		avail.setBounds(160,10,100,20);
		add(avail);
		
		JLabel l3= new JLabel("Name");
		l3.setBounds(290,10,100,20);
		add(l3);
		
		JLabel l4= new JLabel("Gender");
		l4.setBounds(410,10,100,20);
		add(l4);
		
		JLabel l5= new JLabel("Country");
		l5.setBounds(540,10,100,20);
		add(l5);
		
		JLabel l6= new JLabel("Room number");
		l6.setBounds(640,10,100,20);
		add(l6);
		
		JLabel l7= new JLabel("Check in time");
		l7.setBounds(760,10,100,20);
		add(l7);
		
		JLabel l8= new JLabel("Deposit");
		l8.setBounds(910,10,100,20);
		add(l8);
		
		table = new JTable();
		table.setBounds(0,40,1000,400);
		add(table);
		try
		{
			Conn conn = new Conn();
			ResultSet rs=conn.s.executeQuery("select * from customer");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		btn=new JButton("Back");
		btn.setForeground(Color.WHITE);
		btn.setBackground(Color.BLACK);
		btn.setBounds(420,500,120,30);
		btn.addActionListener(this);
		add(btn);
		setBounds(300,200,1000,600);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		setVisible(false);
		new Reception();
	}

	public static void main(String[] args) 
	{
		new CustomerInfo();
	}

}
