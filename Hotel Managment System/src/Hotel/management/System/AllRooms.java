package Hotel.management.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class AllRooms extends JFrame implements ActionListener
{
	JTable table;
	JButton btn;
	AllRooms() 
	{
		getContentPane().setBackground(Color.white);
		setLayout(null);
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
		Image i2=i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(500,0,600,600);
		add(image);
		
		JLabel head = new JLabel("roomnumber");
		head.setBounds(10,10,100,20);
		add(head);
		
		JLabel avail = new JLabel("Availability");
		avail.setBounds(120,10,100,20);
		add(avail);
		
		JLabel l3= new JLabel("status");
		l3.setBounds(230,10,100,20);
		add(l3);
		
		JLabel l4= new JLabel("Price");
		l4.setBounds(330,10,100,20);
		add(l4);
		
		JLabel l5= new JLabel("BedType");
		l5.setBounds(410,10,100,20);
		add(l5);
		
		table = new JTable();
		table.setBounds(0,40,500,400);
		add(table);
		try
		{
			Conn conn = new Conn();
			ResultSet rs=conn.s.executeQuery("select * from room6");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		btn=new JButton("Back");
		btn.setForeground(Color.WHITE);
		btn.setBackground(Color.BLACK);
		btn.setBounds(200,500,120,30);
		btn.addActionListener(this);
		add(btn);
		setBounds(300,200,1050,600);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		setVisible(false);
		new Reception();
	}

	public static void main(String[] args) 
	{
		new AllRooms();
	}

}
