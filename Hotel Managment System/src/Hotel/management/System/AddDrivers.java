package Hotel.management.System;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class AddDrivers extends JFrame implements ActionListener
{
	JTextField tfname,tfage,tfcompany,tfmodel,tfloc;
	JButton add,Cancel;
	JComboBox agecombo,bedcombo,availcombo;
	AddDrivers() 
	{
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel head= new JLabel("Add Drivers");
		head.setFont(new Font("times roman",Font.BOLD,18));
		head.setBounds(150,10,200,20);
		add(head);
		
		JLabel roomno= new JLabel("Name");
		roomno.setFont(new Font("times roman",Font.BOLD,16));
		roomno.setBounds(60,70,120,30);
		add(roomno);
		
		tfname=new JTextField();
		tfname.setBounds(200,70,150,30);
		add(tfname);
		
		JLabel age= new JLabel("Age");
		age.setFont(new Font("times roman",Font.BOLD,16));
		age.setBounds(60,110,120,30);
		add(age);
		
		tfage=new JTextField();
		tfage.setBounds(200,110,150,30);
		add(tfage);
		
		JLabel clean= new JLabel("Gender");
		clean.setFont(new Font("times roman",Font.BOLD,16));
		clean.setBounds(60,150,120,30);
		add(clean);
		
		String cleanoptions[]= {"Male","Female"};
		agecombo= new JComboBox(cleanoptions);
		agecombo.setBounds(200,150,150,30);
		agecombo.setBackground(Color.WHITE);
		add(agecombo);
		
		JLabel price= new JLabel("Car Company");
		price.setFont(new Font("times roman",Font.BOLD,16));
		price.setBounds(60,190,120,30);
		add(price);
		
		tfcompany=new JTextField();
		tfcompany.setBounds(200,190,150,30);
		add(tfcompany);
		
		JLabel bed= new JLabel("Car Model");
		bed.setFont(new Font("times roman",Font.BOLD,16));
		bed.setBounds(60,230,120,30);
		add(bed);
		
		tfmodel=new JTextField();
		tfmodel.setBounds(200,230,150,30);
		add(tfmodel);
		
		JLabel avail= new JLabel("Available");
		avail.setFont(new Font("times roman",Font.BOLD,16));
		avail.setBounds(60,270,120,30);
		add(avail);
		
		String availoptions[]= {"Available","Busy"};
		availcombo= new JComboBox(availoptions);
		availcombo.setBounds(200,270,150,30);
		availcombo.setBackground(Color.WHITE);
		add(availcombo);
		
		JLabel loc= new JLabel("Location");
		loc.setFont(new Font("times roman",Font.BOLD,16));
		loc.setBounds(60,310,120,30);
		add(loc);
		
		tfloc=new JTextField();
		tfloc.setBounds(200,310,150,30);
		add(tfloc);
		
		add=new JButton("Add Driver");
		add.setForeground(Color.WHITE);
		add.setBackground(Color.BLACK);
		add.setBounds(60,370,130,30);
		add.addActionListener(this);
		add(add);
		
		Cancel=new JButton("Cancel");
		Cancel.setForeground(Color.WHITE);
		Cancel.setBackground(Color.BLACK);
		Cancel.setBounds(220,370,130,30);
		Cancel.addActionListener(this);
		add(Cancel);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
		Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(400,30,500,300);
		add(image);
		
		setBounds(300,200,980,470);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == add) 
		{
			String name=tfname.getText();
			String age=tfage.getText();
			String gender= (String) agecombo.getSelectedItem();
			String company = tfcompany.getText();
			String brand= tfmodel.getText();
			String available= (String) availcombo.getSelectedItem();
			String location= tfloc.getText();
			
			
			try
			{
				Conn conn = new Conn();
				String query="insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+location+"')";
				conn.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"new Driver Added Successfuly");
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
		new AddDrivers();
	}

}

