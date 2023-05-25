package Hotel.management.System;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class Dashboard extends JFrame implements ActionListener{

	Dashboard() 
	{
		setBounds(0,0,1550,1000);
		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,1550,1000);
		add(image);
		JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU");
		text.setBounds(400,80,1000,50);
		text.setFont(new Font("Times Roman",Font.BOLD,46));
		text.setForeground(Color.white);
		image.add(text);
		JMenuBar mb = new JMenuBar();
		mb.setBounds(0,0,1550,30);
		image.add(mb);
		JMenu hotel = new JMenu("HOTEL MANAGEMENT");
		mb.add(hotel);
		hotel.setForeground(Color.orange);
		JMenuItem reception = new JMenuItem("RECEPTION");
		reception.addActionListener(this);
		hotel.add(reception);
		JMenu admin= new JMenu("ADMIN");
		mb.add(admin);
		admin.setForeground(Color.BLUE);
		JMenuItem addEmployee= new JMenuItem("Add Employee");
		addEmployee.addActionListener(this);
		admin.add(addEmployee);
		JMenuItem addRooms= new JMenuItem("Add Rooms");
		addRooms.addActionListener(this);
		admin.add(addRooms);
		JMenuItem addDrivers= new JMenuItem("Add Drivers");
		addDrivers.addActionListener(this);
		admin.add(addDrivers);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getActionCommand().equals("Add Employee")) 
		{
			new AddEmployee();
		}
		
		else if(ae.getActionCommand().equals("Add Rooms")) 
		{
			new AddRooms();
		}
		
		else if(ae.getActionCommand().equals("Add Drivers")) 
		{
			new AddDrivers();
		}
		
		else if(ae.getActionCommand().equals("RECEPTION")) 
		{
			new Reception();

		}
	}
	public static void main(String[] args){
		new Dashboard();
	}
}
