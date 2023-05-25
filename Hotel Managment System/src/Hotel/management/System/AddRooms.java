package Hotel.management.System;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class AddRooms extends JFrame implements ActionListener
{
	JTextField tfroom,tfprice;
	JButton add,Cancel;
	JComboBox cleancombo,bedcombo,availablecombo;
	AddRooms() 
	{
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel head= new JLabel("Add Rooms");
		head.setFont(new Font("times roman",Font.BOLD,18));
		head.setBounds(150,20,200,20);
		add(head);
		
		JLabel roomno= new JLabel("Room number");
		roomno.setFont(new Font("times roman",Font.BOLD,16));
		roomno.setBounds(60,80,120,30);
		add(roomno);
		
		tfroom=new JTextField();
		tfroom.setBounds(200,80,150,30);
		add(tfroom);
		
		JLabel avail= new JLabel("Available");
		avail.setFont(new Font("times roman",Font.BOLD,16));
		avail.setBounds(60,130,120,30);
		add(avail);
		
		String availableoptions[]= {"Available","occupied"};
		availablecombo= new JComboBox(availableoptions);
		availablecombo.setBounds(200,130,150,30);
		availablecombo.setBackground(Color.WHITE);
		add(availablecombo);
		
		JLabel clean= new JLabel("Cleaning Status");
		clean.setFont(new Font("times roman",Font.BOLD,16));
		clean.setBounds(60,180,120,30);
		add(clean);
		
		String cleanoptions[]= {"Cleaned","Dirty"};
		cleancombo= new JComboBox(cleanoptions);
		cleancombo.setBounds(200,180,150,30);
		cleancombo.setBackground(Color.WHITE);
		add(cleancombo);
		
		JLabel price= new JLabel("Room Price");
		price.setFont(new Font("times roman",Font.BOLD,16));
		price.setBounds(60,230,120,30);
		add(price);
		
		tfprice=new JTextField();
		tfprice.setBounds(200,230,150,30);
		add(tfprice);
		
		JLabel bed= new JLabel("Bed Type");
		bed.setFont(new Font("times roman",Font.BOLD,16));
		bed.setBounds(60,280,120,30);
		add(bed);
		
		String bedoptions[]= {"Single bed","Double bed"};
		bedcombo= new JComboBox(bedoptions);
		bedcombo.setBounds(200,280,150,30);
		bedcombo.setBackground(Color.WHITE);
		add(bedcombo);
		
		add=new JButton("Add room");
		add.setForeground(Color.WHITE);
		add.setBackground(Color.BLACK);
		add.setBounds(60,350,130,30);
		add.addActionListener(this);
		add(add);
		
		Cancel=new JButton("Cancel");
		Cancel.setForeground(Color.WHITE);
		Cancel.setBackground(Color.BLACK);
		Cancel.setBounds(220,350,130,30);
		Cancel.addActionListener(this);
		add(Cancel);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
		JLabel image=new JLabel(i1);
		image.setBounds(400,30,500,300);
		add(image);
		
		setBounds(330,200,940,470);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == add) 
		{
			String roomnumber=tfroom.getText();
			String availability=(String) availablecombo.getSelectedItem();
			String status= (String) cleancombo.getSelectedItem();
			String price = tfprice.getText();
			String Bedtype= (String) bedcombo.getSelectedItem();
			
			try
			{
				Conn conn = new Conn();
				String query="insert into room6 values('"+roomnumber+"','"+availability+"','"+status+"','"+price+"','"+Bedtype+"')";
				conn.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"room Added Successfuly");
				setVisible(false);
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		else {
			setVisible(false);
		}
	}
	public static void main(String[] args) 
	{
		new AddRooms();
	}

}
