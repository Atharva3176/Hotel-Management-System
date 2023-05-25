package Hotel.management.System;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.util.Date;
import java.awt.event.*;
public class AddCustomer extends JFrame implements ActionListener
{
	JComboBox comboid;
	JTextField tfnum,tfname,tfCountry,tfdeposit;
	JRadioButton male,female;
	Choice croom;
	JLabel dateT,checkintime;
	JButton add,back;
	AddCustomer() 
	{
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel text= new JLabel("Add Customer Form");
		text.setFont(new Font("times roman",Font.BOLD,20));
		text.setBounds(100,20,300,30);
		add(text);
		
		JLabel id= new JLabel("ID");
		id.setFont(new Font("times roman",Font.BOLD,20));
		id.setBounds(35,80,100,20);
		add(id);
		
		String idoptions[]= {"Adhar card","Passport","Driving Licence","VoterID"};
		comboid= new JComboBox(idoptions);
		comboid.setBounds(200,80,150,25);
		comboid.setBackground(Color.WHITE);
		add(comboid);
		
		JLabel num= new JLabel("ID Number");
		num.setFont(new Font("times roman",Font.BOLD,20));
		num.setBounds(35,120,100,20);
		add(num);
		
		tfnum=new JTextField();
		tfnum.setBounds(200,120,150,25);
		add(tfnum);
		
		JLabel name= new JLabel("Name");
		name.setFont(new Font("times roman",Font.BOLD,20));
		name.setBounds(35,160,100,20);
		add(name);
		
		tfname=new JTextField();
		tfname.setBounds(200,160,150,25);
		add(tfname);
		
		JLabel gender= new JLabel("Gender");
		gender.setFont(new Font("times roman",Font.BOLD,20));
		gender.setBounds(35,200,100,20);
		add(gender);
		
		male=new JRadioButton("Male");
		male.setBounds(200,200,60,25);
		male.setFont(new Font("times roman",Font.BOLD,14));
		male.setBackground(Color.white);
		add(male);
		
		female=new JRadioButton("Female");
		female.setBounds(270,200,100,25);
		female.setFont(new Font("times roman",Font.BOLD,14));
		female.setBackground(Color.white);
		add(female);
		
		JLabel Country= new JLabel("Country");
		Country.setFont(new Font("times roman",Font.BOLD,20));
		Country.setBounds(35,240,100,20);
		add(Country);
		
		tfCountry=new JTextField();
		tfCountry.setBounds(200,240,150,25);
		add(tfCountry);
		
		JLabel roomno= new JLabel("Room Number");
		roomno.setFont(new Font("times roman",Font.BOLD,20));
		roomno.setBounds(35,280,150,20);
		add(roomno);
		
		croom = new Choice();
		
		try
		{
			Conn conn = new Conn();
			String query="select * from room6 where availability ='Available'";
			ResultSet rs= conn.s.executeQuery(query);
			while(rs.next())
			{
				croom.add(rs.getString("roomnumber"));
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		croom.setBounds(200,280,150,25);
		add(croom);
		
		dateT= new JLabel("Checkin Time");
		dateT.setFont(new Font("times roman",Font.BOLD,20));
		dateT.setBounds(35,320,150,20);
		add(dateT);
		
		Date date=new Date();
		
		checkintime= new JLabel(""+ date);
		checkintime.setFont(new Font("times roman",Font.BOLD,16));
		checkintime.setBounds(200,320,170,25);
		add(checkintime);
		
		JLabel deposit= new JLabel("Deposit");
		deposit.setFont(new Font("times roman",Font.BOLD,20));
		deposit.setBounds(35,360,100,20);
		add(deposit);
		
		tfdeposit=new JTextField();
		tfdeposit.setBounds(200,360,150,25);
		add(tfdeposit);
		
		add=new JButton("Add Customer");
		add.setForeground(Color.WHITE);
		add.setBackground(Color.BLACK);
		add.setBounds(50,410,120,25);
		add.addActionListener(this);
		add(add);
		
		back=new JButton("Back");
		back.setForeground(Color.WHITE);
		back.setBackground(Color.BLACK);
		back.setBounds(200,410,120,25);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
		Image i2=i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(400,50,300,400);
		add(image);
		
		setBounds(350,200,800,550);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == add) 
		{
			String ID1=(String) comboid.getSelectedItem();
			String number=tfnum.getText();
			String name1= tfname.getText();
			String gen= null;
			if(male.isSelected())
			{
				gen="male";
			}
			
			else
			{
				gen="Female";
			}
			
			String contry=tfCountry.getText();
			String room=croom.getSelectedItem();
			String time = checkintime.getText();
			String dep=tfdeposit.getText();
			try
			{
				Conn conn = new Conn();
				String query="insert into customer values('"+ID1+"','"+number+"','"+name1+"','"+gen+"','"+contry+"','"+room+"','"+time+"','"+dep+"')";
				String query2="update room6 set availability='Occupied' where roomnumber= '"+room+"'";
				conn.s.executeUpdate(query);
				conn.s.executeUpdate(query2);
				JOptionPane.showMessageDialog(null,"New customer Added Successfuly");
				setVisible(false);
				new Reception();
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		else if(ae.getSource()==back){
			setVisible(false);
			new Reception();
		}
	}

	public static void main(String[] args) 
	{
		new AddCustomer();

	}

}
