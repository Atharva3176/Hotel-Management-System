package Hotel.management.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class Department extends JFrame implements ActionListener
{
	JTable table;
	JButton btn;
	Department() 
	{
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel head = new JLabel("Department");
		head.setBounds(100,10,100,20);
		add(head);
		
		JLabel avail = new JLabel("Budget");
		avail.setBounds(500,10,100,20);
		add(avail);
		
		table = new JTable();
		table.setBounds(0,50,700,350);
		add(table);
		try
		{
			Conn conn = new Conn();
			ResultSet rs=conn.s.executeQuery("select * from department");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		btn=new JButton("Back");
		btn.setForeground(Color.WHITE);
		btn.setBackground(Color.BLACK);
		btn.setBounds(280,400,120,30);
		btn.addActionListener(this);
		add(btn);
		setBounds(400,200,700,480);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		setVisible(false);
		new Reception();
	}

	public static void main(String[] args) 
	{
		new Department();
	}

}
