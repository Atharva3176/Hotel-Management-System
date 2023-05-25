package Hotel.management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Reception extends JFrame implements ActionListener
{
	JButton ne,rooms,dept,emp,manager,cust,Search,update,roomup,pickup,checkout,logout;
	Reception() 
	{
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		ne = new JButton("New Customer Form");
		ne.setBounds(10,30,200,30);
		ne.setBackground(Color.black);
		ne.setForeground(Color.WHITE);
		ne.addActionListener(this);
		add(ne);
		
		rooms = new JButton("Rooms");
		rooms.setBounds(10,70,200,30);
		rooms.setBackground(Color.black);
		rooms.setForeground(Color.WHITE);
		rooms.addActionListener(this);
		add(rooms);
		
		dept = new JButton("Department");
		dept.setBounds(10,110,200,30);
		dept.setBackground(Color.black);
		dept.setForeground(Color.WHITE);
		dept.addActionListener(this);
		add(dept);
		
		emp = new JButton("All Employees");
		emp.setBounds(10,150,200,30);
		emp.setBackground(Color.black);
		emp.setForeground(Color.WHITE);
		emp.addActionListener(this);
		add(emp);
		

		cust = new JButton("CustomerInfo");
		cust.setBounds(10,190,200,30);
		cust.setBackground(Color.black);
		cust.setForeground(Color.WHITE);
		cust.addActionListener(this);
		add(cust);
		
		manager = new JButton("ManagerInfo");
		manager.setBounds(10,230,200,30);
		manager.setBackground(Color.black);
		manager.setForeground(Color.WHITE);
		manager.addActionListener(this);
		add(manager);
		
		checkout = new JButton("Checkout");
		checkout.setBounds(10,270,200,30);
		checkout.setBackground(Color.black);
		checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
		add(checkout);
		
		update = new JButton("Update Status");
		update.setBounds(10,310,200,30);
		update.setBackground(Color.black);
		update.setForeground(Color.WHITE);
		update.addActionListener(this);
		add(update);
		
		roomup = new JButton("Room Status");
		roomup.setBounds(10,350,200,30);
		roomup.setBackground(Color.black);
		roomup.setForeground(Color.WHITE);
		roomup.addActionListener(this);
		add(roomup);
		
	    pickup = new JButton("Pickup Service");
		pickup.setBounds(10,390,200,30);
		pickup.setBackground(Color.black);
		pickup.setForeground(Color.WHITE);
		pickup.addActionListener(this);
		add(pickup);
		
	    Search = new JButton("Search Room");
		Search.setBounds(10,430,200,30);
		Search.setBackground(Color.black);
		Search.setForeground(Color.WHITE);
		Search.addActionListener(this);
		add(Search);
		
		logout = new JButton("LogOut");
		logout.setBounds(10,470,200,30);
		logout.setBackground(Color.black);
		logout.setForeground(Color.WHITE);
		logout.addActionListener(this);
		add(logout);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
		JLabel image=new JLabel(i1);
		image.setBounds(250,30,500,470);
		add(image);
		
		setBounds(350,200,800,570);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource()==ne) 
		{
			setVisible(false);
			new AddCustomer();
		}
		
		else if (ae.getSource()==rooms) 
		{
			setVisible(false);
			new AllRooms();
		}
		
		else if (ae.getSource()==dept) 
		{
			setVisible(false);
			new Department();
		}
		
		else if (ae.getSource()==emp) 
		{
			setVisible(false);
			new EmployeeInfo();
		}
		

		else if (ae.getSource()==manager) 
		{
			setVisible(false);
			new ManagerInfo();
		}
		
		else if (ae.getSource()==cust) 
		{
			setVisible(false);
			new CustomerInfo();
		}
		
		else if (ae.getSource()==Search) 
		{
			setVisible(false);
			new SearchRoom();
		}
		
		else if (ae.getSource()==update) 
		{
			setVisible(false);
			new updatecheck();
		}
		
		else if (ae.getSource()==roomup) 
		{
			setVisible(false);
			new update_room();
		}
		
		else if (ae.getSource()==pickup) 
		{
			setVisible(false);
			new pickup();
		}
		
		else if (ae.getSource()==checkout) 
		{
			setVisible(false);
			new checkout();
		}
		
		else if (ae.getSource()==logout) 
		{
			setVisible(false);
			System.exit(0);
		}
	}
	
	public static void main(String[] args) 
	{
		new Reception();

	}

}
