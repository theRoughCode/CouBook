import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddCoupon extends JFrame implements ActionListener{
	JButton back, add, cancel;
	JTextField deal, company, location, date, pax, desc, refCode;
	CouponArray couponArr;
	
	public AddCoupon(CouponArray couponArr){		
		this.couponArr = couponArr;
		
		Container contentPane = this.getContentPane ();
		
		setTitle ("CouBook");
		setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE); //closes properly when exited
		setResizable (false); //can't resize the screen
		setSize (500, 700); //screen resolution
		setBackground (Color.BLACK);
		setVisible (true); //JFrame is visible
		
		JPanel top = new JPanel(new GridLayout(0,3));
		back = new JButton("Back to Main Menu");
		back.addActionListener(this);
		add = new JButton("Add");
		add.addActionListener(this);
		JLabel addTitle = new JLabel("Add Coupon");
        addTitle.setFont(new Font("SansSerif", 1, 30));
		top.add(back);
		top.add(addTitle);
		top.add(add);
		
		JPanel mid = new JPanel(new GridLayout(7,0));
		JPanel mid1 = new JPanel();
		mid1.add(new JLabel("Name:  "));
		deal = new JTextField("Enter Title of Deal");
		deal.addMouseListener(new MouseAdapter(){
	            public void mouseClicked(MouseEvent e){
	                deal.setText("");
	            }
	        });
		mid1.add(deal);
		JPanel mid2 = new JPanel();
		mid2.add(new JLabel("Organization:  "));
		company = new JTextField("Enter Name of Organization");
		company.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
            	company.setText("");
            }
        });
		mid2.add(company);
		JPanel mid3 = new JPanel();
		mid3.add(new JLabel("Location:  "));
		location = new JTextField("Enter Locations Where Valid");
		location.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
            	location.setText("");
            }
        });
		mid3.add(location);
		JPanel mid4 = new JPanel();
		mid4.add(new JLabel("Expiration Date:  "));
		date = new JTextField("(DD/MM/YYYY");
		date.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
            	date.setText("");
            }
        });
		mid4.add(date);
		JPanel mid5 = new JPanel();
		mid5.add(new JLabel("Pax:  "));
		pax = new JTextField("Enter Pax Limit");
		pax.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
            	pax.setText("");
            }
        });
		mid5.add(pax);
		JPanel mid6 = new JPanel();
		mid6.add(new JLabel("Additional Info:  "));
		desc = new JTextField("Enter Extra Details");
		desc.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
            	desc.setText("");
            }
        });
		mid6.add(desc);
		JPanel mid7 = new JPanel();
		mid7.add(new JLabel("Reference Code:  "));
		refCode = new JTextField("Enter Code if Available");
		refCode.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
            	refCode.setText("");
            }
        });
		mid7.add(refCode);
		
		mid.add(mid1);
		mid.add(mid2);
		mid.add(mid3);
		mid.add(mid4);
		mid.add(mid5);
		mid.add(mid6);
		mid.add(mid7);
		
		
		
		
		JPanel bot = new JPanel();
		
		JPanel mainPanel = new JPanel(new FlowLayout());
		mainPanel.add(top);
		mainPanel.add(mid);
		mainPanel.add(bot);
		
		contentPane.add(mainPanel);
		
		
		/*Scanner in = new Scanner(System.in);
		System.out.println("Enter Name of Restaurant: ");
		name = in.nextLine();
		
		System.out.println("Enter Coupon Deal Header: ");
		deal = in.nextLine();
		
		System.out.println("Enter Locations where this coupon is available (separate with ';'): ");
		location = in.nextLine();
		
		System.out.println("Expiration date (dd/mm/yyyy):  ");
		date = in.nextLine();
		
		System.out.println("Enter min pax: ");
		minPax = in.nextInt();
		System.out.println("Enter max pax: ");
		maxPax = in.nextInt();
		
		System.out.println("Enter any extra information: ");
		desc = in.nextLine();
		
		System.out.println("Enter reference code: ");
		refCode = in.nextLine();
		
		Coupon coupon = new Coupon(name, deal, location, date, minPax, maxPax, desc, refCode);
		System.out.println(coupon.output());
		*/
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == back){
			setVisible(false);
			dispose();
		} else if (e.getSource() == add){
			Coupon c = new Coupon(company.getText(), deal.getText(), location.getText(), 
					date.getText(), Integer.parseInt(pax.getText()), desc.getText(), refCode.getText());
			couponArr.add(c);
			JOptionPane.showMessageDialog(null, "Coupon Added!");
			setVisible(false);
			dispose();
		}
	}
}
