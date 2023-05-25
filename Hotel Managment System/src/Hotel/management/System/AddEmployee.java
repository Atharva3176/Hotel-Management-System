package Hotel.management.System;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class AddEmployee extends JFrame implements ActionListener
{
	JTextField tfname,tfage,tfsalary,tfphone,tfemail,tfadhar;
	JRadioButton male,female;
	JButton Submit;
	JComboBox job;
	AddEmployee() 
	{
		setLayout(null);
		JLabel lbname = new JLabel("Name");
		lbname.setBounds(60,30,120,30);
		lbname.setFont(new Font ("Times Roman",Font.BOLD,17));
		add(lbname);
		tfname=new JTextField();
		tfname.setBounds(200,30,150,30);
		add(tfname);
		
		JLabel lbage = new JLabel("Age");
		lbage.setBounds(60,80,120,30);
		lbage.setFont(new Font ("Times Roman",Font.BOLD,17));
		add(lbage);
		
		tfage=new JTextField();
		tfage.setBounds(200,80,150,30);
		add(tfage);
		
		JLabel lbgender = new JLabel("Gender");
		lbgender.setBounds(60,130,120,30);
		lbgender.setFont(new Font ("Times Roman",Font.BOLD,17));
		add(lbgender);
		
		male=new JRadioButton("Male");
		male.setBounds(200,130,70,30);
		male.setFont(new Font("times roman",Font.BOLD,14));
		male.setBackground(Color.white);
		add(male);
		
		female=new JRadioButton("Female");
		female.setBounds(280,130,80,30);
		female.setFont(new Font("times roman",Font.BOLD,14));
		female.setBackground(Color.white);
		add(female);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(male);
		bg.add(female);
		
		JLabel lbjob = new JLabel("JOB");
		lbjob.setBounds(60,180,120,30);
		lbjob.setFont(new Font ("Times Roman",Font.BOLD,17));
		add(lbjob);
		
		String str[]={"Front desk clerks","potters","housekeeping","shefs","Waiters","Accountants","Manager","Receptionist"};
		job = new JComboBox(str);
		job.setBounds(200,180,150,30);
		job.setBackground(Color.WHITE);
		add(job);
		
		JLabel lbsalary = new JLabel("Salary");
		lbsalary.setBounds(60,230,120,30);
		lbsalary.setFont(new Font ("Times Roman",Font.BOLD,17));
		add(lbsalary);
		
		tfsalary=new JTextField();
		tfsalary.setBounds(200,230,150,30);
		add(tfsalary);
		
		
		
		JLabel lbphone = new JLabel("Phone");
		lbphone.setBounds(60,280,120,30);
		lbphone.setFont(new Font ("Times Roman",Font.BOLD,17));
		add(lbphone);
		
		tfphone=new JTextField();
		tfphone.setBounds(200,280,150,30);
		add(tfphone);
		
		JLabel lbemail = new JLabel("Email ID");
		lbemail.setBounds(60,330,120,30);
		lbemail.setFont(new Font ("Times Roman",Font.BOLD,17));
		add(lbemail);
		
		tfemail=new JTextField();
		tfemail.setBounds(200,330,150,30);
		add(tfemail);
		
		JLabel lbAdhar = new JLabel("Adhar  NO.");
		lbAdhar.setBounds(60,380,120,30);
		lbAdhar.setFont(new Font ("Times Roman",Font.BOLD,17));
		add(lbAdhar);
		
		tfadhar=new JTextField();
		tfadhar.setBounds(200,380,150,30);
		add(tfadhar);
		
		Submit = new JButton("Submit");
		Submit.setBackground(Color.black);
		Submit.setForeground(Color.WHITE);
		Submit.setBounds(200,430,150,30);
		Submit.addActionListener(this);
		add(Submit);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
		Image i2=i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(380,60,450,370);
		add(image);
		
		getContentPane().setBackground(Color.white);
		setBounds(350,200,850,540);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae)
	{
		String name=tfname.getText();
		String age=tfage.getText();
		String salary=tfsalary.getText();
		String phone=tfphone.getText();
		String email=tfemail.getText();
		String adhar=tfadhar.getText();
		String gender=null;
		
		if(male.isSelected())
		{
			gender="Male";
		}
		
		else if(female.isSelected())
		{
			gender="Female";
		}
		
		String job1 = (String)job.getSelectedItem();
		
		try
		{
			Conn conn = new Conn();
			String query="insert into employee10 values('"+name+"','"+age+"','"+gender+"','"+job1+"','"+salary+"','"+phone+"','"+email+"','"+adhar+"')";
			conn.s.executeUpdate(query);
			JOptionPane.showMessageDialog(null,"Employee Added Successfuly");
			setVisible(false);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		new AddEmployee();
	}

}
