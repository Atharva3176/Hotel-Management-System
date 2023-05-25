package Hotel.management.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class SearchRoom extends JFrame implements ActionListener
{
	JTable table;
	JButton btn,Submit;
	JComboBox bedtype;
	JCheckBox check;
	SearchRoom() 
	{
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel title = new JLabel("Search For Room ");
		title.setFont(new Font("Times Roman",Font.BOLD,20));
		title.setBounds(400,30,200,30);
		add(title);
		
		JLabel bed = new JLabel("Bed Type");
		bed.setBounds(50,100,100,20);
		add(bed);
		
		bedtype = new JComboBox(new String[] {"Single Bed","Double Bed"});
		bedtype.setBounds(150,100,150,25);
		bedtype.setBackground(Color.white);
		add(bedtype);
		
		check = new JCheckBox("Only Display Available");
		check.setBounds(650,100,150,25);
		check.setBackground(Color.white);
		add(check);
		
		JLabel head = new JLabel("roomnumber");
		head.setBounds(50,160,100,20);
		add(head);
		
		JLabel avail = new JLabel("Availability");
		avail.setBounds(270,160,100,20);
		add(avail);
		
		JLabel l3= new JLabel("status");
		l3.setBounds(450,160,100,20);
		add(l3);
		
		JLabel l4= new JLabel("Price");
		l4.setBounds(670,160,100,20);
		add(l4);
		
		JLabel l5= new JLabel("BedType");
		l5.setBounds(870,160,100,20);
		add(l5);
		
		table = new JTable();
		table.setBounds(0,200,1000,300);
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
				String query1="select * from room6 where Bedtype='"+bedtype.getSelectedItem()+"'";
				String query2="select * from room6 where availability='Available' AND Bedtype='"+bedtype.getSelectedItem()+"'";
				ResultSet rs;
				if(check.isSelected())
				{
					rs=conn.s.executeQuery(query2);
				}
				
				else
				{
					rs=conn.s.executeQuery(query1);
				}
				
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
		new SearchRoom();
	}

}
