package Hotel.management.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class pickup extends JFrame implements ActionListener
{
	JTable table;
	JButton btn,Submit;
	Choice car1;
	JCheckBox check;
	pickup() 
	{
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel title = new JLabel("Pickup service");
		title.setFont(new Font("Times Roman",Font.BOLD,20));
		title.setBounds(400,30,200,30);
		add(title);
		
		JLabel car = new JLabel("car Type");
		car.setBounds(50,100,100,20);
		add(car);
		
		car1=new Choice();
		car1.setBounds(150,100,200,25);
		add(car1);
		
		try
		{
			Conn conn = new Conn();
			ResultSet rs=conn.s.executeQuery("select * from driver");
			while(rs.next())
			{
				car1.add(rs.getString("brand"));
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		JLabel head = new JLabel("Name");
		head.setBounds(30,160,100,20);
		add(head);
		
		JLabel avail = new JLabel("Age");
		avail.setBounds(200,160,100,20);
		add(avail);
		
		JLabel l3= new JLabel("Gender");
		l3.setBounds(330,160,100,20);
		add(l3);
		
		JLabel l4= new JLabel("Company");
		l4.setBounds(460,160,100,20);
		add(l4);
		
		JLabel l5= new JLabel("Brand");
		l5.setBounds(630,160,100,20);
		add(l5);
		
		JLabel l6= new JLabel("Availability");
		l6.setBounds(740,160,100,20);
		add(l6);
		
		JLabel l7= new JLabel("location");
		l7.setBounds(890,160,100,20);
		add(l7);
		
		table = new JTable();
		table.setBounds(0,200,1000,300);
		add(table);
		try
		{
			Conn conn = new Conn();
			ResultSet rs=conn.s.executeQuery("select * from driver");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		btn=new JButton("Back");
		btn.setForeground(Color.WHITE);
		btn.setBackground(Color.BLACK);
		btn.setBounds(500,520,120,30);
		btn.addActionListener(this);
		add(btn);
		
		Submit = new JButton("Submit");
		Submit.setBackground(Color.black);
		Submit.setForeground(Color.WHITE);
		Submit.setBounds(300,520,120,30);
		Submit.addActionListener(this);
		add(Submit);
		
		setBounds(300,200,1000,600);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource()==Submit) 
		{
			try
			{
				Conn conn = new Conn();
				String query1="select * from driver where brand='"+car1.getSelectedItem()+"'";
				ResultSet rs;
				rs=conn.s.executeQuery(query1);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		else
		{
			setVisible(false);
			new Reception();
		}
		
	}

	public static void main(String[] args) 
	{
		new pickup();
	}

}
