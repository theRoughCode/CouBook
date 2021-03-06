import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Viewer extends JFrame implements ActionListener, Runnable{
	JButton back, delete;
	CouponArray couponArr;
	
	public static void main(String args[]){
		new Viewer();
	}
	
	public Viewer(){
		couponArr = new CouponArray();
		
		Container contentPane = this.getContentPane ();
		
		setTitle ("CouBook");
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); //closes properly when exited
		setResizable (false); //can't resize the screen
		setSize (500, 700); //screen resolution
		setBackground (Color.BLACK);
		setVisible (true); //JFrame is visible
		
		JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
		back = new JButton("Back to Main Menu");
		back.addActionListener(this);
		top.add(back);
		
		JPanel mid = new JPanel();
		/*JTextField body = new JTextField();
		String bodyS = "";
		if (couponArr.getSize() > 0)
			for (int i = 0; i < couponArr.getSize(); i++){
				bodyS = bodyS.concat("");
			}*/
		
		JPanel bot = new JPanel();
		
		JPanel mainPanel = new JPanel(new GridLayout(3, 0));
		mainPanel.add(top);
		mainPanel.add(mid);
		mainPanel.add(bot);
		
		contentPane.add(mainPanel);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == back){
			System.out.println("Back to Main Menu");
		}
		
	}

}
