import java.awt.Graphics;
import java.awt.event.*;
import java.awt.Toolkit;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;

//Used to give JButtons function
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.awt.Container; //allows JButtons to be added tothe JPanel

class menuscreen extends JFrame //implements ActionListener
{
    public static void main (String[] args)
    {
	new gui ();
    }
}

class gui extends JFrame implements ActionListener
{
    JPanel mainmenu = new JPanel ();
    protected JButton viewcoupons = new JButton ("View Schedule");
    protected JButton addcoupons = new JButton ("Add Coupons");
    protected JButton delete = new JButton ("Delete Coupons");

    public gui ()
    {
	Container contentPane = this.getContentPane ();

	viewcoupons.setActionCommand ("A");
	addcoupons.setActionCommand ("B");
	delete.setActionCommand ("C");

	this.getContentPane ().add (viewcoupons);
	this.getContentPane ().add (addcoupons);
	this.getContentPane ().add (delete);

	this.getContentPane ().add (mainmenu);

	mainmenu.setBounds (800, 600, 200, 100);

	viewcoupons.setBounds (230, 0, 340, 100);
	addcoupons.setBounds (530, 430, 250, 50);
	delete.setBounds (530, 500, 250, 50);

	setTitle ("CouBook");
	setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); //closes properly when exited
	setResizable (false); //can't resize the screen
	setSize (800, 600); //screen resolution
	setBackground (Color.BLACK);
	setVisible (true); //JFrame is visible

	viewcoupons.addActionListener (this);
	addcoupons.addActionListener (this);
	delete.addActionListener (this);
    }


    public void actionPerformed (ActionEvent e)
    {
	if ("A".equals (e.getActionCommand ()))
	{
	    new calendar ();
	}
	else if ("B".equals (e.getActionCommand ()))
	{

	}
	else if ("C".equals (e.getActionCommand ()))
	{

	}
    }
    
    
    
    
    
    
    
    
    
}

class calendar extends JFrame implements ActionListener //formula taken from http://mathforum.org/library/drmath/view/55837.html
{

    JPanel calendarview = new JPanel ();
    protected JButton nextyear = new JButton (">");
    protected JButton prevyear = new JButton ("<");
    protected JButton nextmonth = new JButton (">");
    protected JButton prevmonth = new JButton ("<");

    //protected JButton[] days = new JButton [32];

    //protected JLabel[] daylabel = new JLabel [8];

    protected JLabel monthdisplay;
    protected JLabel yeardisplay;

    public calendar ()
    {
	Container contentPane = this.getContentPane ();
	
	nextyear.setActionCommand ("A");
	prevyear.setActionCommand ("B");
	nextmonth.setActionCommand ("C");
	prevmonth.setActionCommand ("D");
	
	this.getContentPane ().add (nextyear);
	this.getContentPane ().add (prevyear);
	this.getContentPane ().add (nextmonth);
	this.getContentPane ().add (prevmonth);
	
	this.getContentPane ().add (calendarview);
	
	calendarview.setBounds (800, 600, 200, 100);
	
	nextyear.setBounds (550, 50, 45, 45);
	prevyear.setBounds (205, 50, 45, 45);
	nextmonth.setBounds (550, 0, 45, 45);
	prevmonth.setBounds (205, 0, 45, 45);
	
	setTitle ("Coubook");
	setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); //closes properly when exited
	setResizable (false); //can't resize the screen
	setSize (800, 600); //screen resolution
	setBackground (Color.BLACK);
	setVisible (true); //JFrame is visible
	
	nextyear.addActionListener (this);
	prevyear.addActionListener (this);
	nextmonth.addActionListener (this);
	prevmonth.addActionListener (this);
	
	DateFormat df = new SimpleDateFormat ("yy");
	Date date = new Date ();
	int yr = Integer.parseInt (df.format (date)) + 2000;

	df = new SimpleDateFormat ("MM");
	date = new Date ();
	int m = Integer.parseInt (df.format (date));

	if (m == 1 || m == 2)
	{
	    m = m + 12;
	    yr = yr - 1;
	}


	int d = 1;


	int N = (d + 2 * m + ((int) 3 * (m + 1) / 5) + yr + ((int) yr / 4) - ((int) yr / 100) + ((int) yr / 400) + 2) % 7;
	if (N == 0)
	{
	    N = 7;
	}
	yr = yr + 1;
	//yeardisplay.setText (Integer.toString(yr)); // Label showing the current year being shown

	/*if (m == 13)
	{
	    monthdisplay.setText ("January");
	}
	else if (m == 14)
	{
	    monthdisplay.setText ("February");
	}
	else if (m == 3)
	{
	    monthdisplay.setText ("March");
	}
	else if (m == 4)
	{
	    monthdisplay.setText ("April");
	}
	else if (m == 5)
	{
	    monthdisplay.setText ("May");
	}
	else if (m == 6)
	{
	    monthdisplay.setText ("June");
	}
	else if (m == 7)
	{
	    monthdisplay.setText ("July");
	}
	else if (m == 8)
	{
	    monthdisplay.setText ("August");
	}
	else if (m == 9)
	{
	    monthdisplay.setText ("September");
	}
	else if (m == 10)
	{
	    monthdisplay.setText ("October");
	}
	else if (m == 11)
	{
	    monthdisplay.setText ("November");
	}
	else if (m == 12)
	{
	    monthdisplay.setText ("December");
	}*/
	
	// get first day, get days in the month, use a times x (number of day)
	// to distance days
	// have buttons be same size and use a*x distance from each other
	// when pressed, display coupon info for the day
	//colour code coupon days non coupon days?
	// 1 is a sunday



    }
    
    public void actionPerformed (ActionEvent e)
    {
	if ("A".equals (e.getActionCommand ()))
	{
	    
	}
	else if ("B".equals (e.getActionCommand ()))
	{

	}
	else if ("C".equals (e.getActionCommand ()))
	{

	}
	else if ("D".equals (e.getActionCommand ()))
	{
	
	}
    }
}

