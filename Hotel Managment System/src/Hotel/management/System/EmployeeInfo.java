package Hotel.management.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class EmployeeInfo extends JFrame implements ActionListener
{
	JTable table;
	JButton btn;
	EmployeeInfo() 
	{
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel head = new JLabel("Name");
		head.setBounds(40,10,100,20);
		add(head);
		
		JLabel avail = new JLabel("Age");
		avail.setBounds(170,10,100,20);
		add(avail);
		
		JLabel l3= new JLabel("Gender");
		l3.setBounds(290,10,100,20);
		add(l3);
		
		JLabel l4= new JLabel("Job");
		l4.setBounds(400,10,100,20);
		add(l4);
		
		JLabel l5= new JLabel("Salary");
		l5.setBounds(540,10,100,20);
		add(l5);
		
		JLabel l6= new JLabel("PH NO.");
		l6.setBounds(670,10,100,20);
		add(l6);
		
		JLabel l7= new JLabel("Email ID");
		l7.setBounds(790,10,100,20);
		add(l7);
		
		JLabel l8= new JLabel("Adhar NO.");
		l8.setBounds(910,10,100,20);
		add(l8);
		
		table = new JTable();
		table.setBounds(0,40,1000,400);
		add(table);
		try
		{
			Conn conn = new Conn();
			ResultSet rs=conn.s.executeQuery("select * from employee10");
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
		new EmployeeInfo();
	}

}
