<<<<<<< HEAD
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

class CouBook extends JFrame //implements ActionListener
{
    public static void main (String[] args)
    {
	new gui ();
    }
}

class gui extends JFrame implements ActionListener
{
	CouponArray couponArr = new CouponArray();
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

	mainmenu.setBounds (500, 700, 200, 100);

	viewcoupons.setBounds (80, 0, 340, 100);
	addcoupons.setBounds (125, 430, 250, 50);
	delete.setBounds (125, 500, 250, 50);

	setTitle ("Coubook");
	setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); //closes properly when exited
	setResizable (false); //can't resize the screen
	setSize (500, 700); //screen resolution
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
		new AddCoupon(couponArr);
	}
	else if ("C".equals (e.getActionCommand ()))
	{

	}
    }
}

class calendar extends JFrame implements ActionListener //formula taken from http://mathforum.org/library/drmath/view/55837.html
{

    JPanel calendarview = new JPanel ();


    protected int yr;
    protected int m;
    protected int N;
    protected int backupN;

    public calendar ()
    {

	DateFormat df = new SimpleDateFormat ("yyyy");
	Date date = new Date ();
	yr = Integer.parseInt (df.format (date));

	df = new SimpleDateFormat ("MM");
	date = new Date ();
	m = Integer.parseInt (df.format (date));

	if (m == 1 || m == 2)
	{
	    m = m + 12;
	    yr = yr - 1;
	}


	int d = 1;
	N = (d + 2 * m + ((int) 3 * (m + 1) / 5) + yr + ((int) yr / 4) - ((int) yr / 100) + ((int) yr / 400) + 2) % 7;
	if (N == 0)
	{
	    N = 7;
	}
	if (m == 13 || m == 14)
	{
	    m = m - 12;
	    yr = yr + 1;
	}
	
	drawcalendar (N);

	// get first day, get days in the month, use a times x (number of day)
	// to distance days
	// have buttons be same size and use a*x distance from each other
	// when pressed, display coupon info for the day
	//colour code coupon days non coupon days?
	// 1 is a sunday


    }


    public void drawcalendar (int startday)
    {
	backupN = N;
	Container contentPane = this.getContentPane ();
	JButton nextyear = new JButton (">");
	JButton prevyear = new JButton ("<");
	JButton nextmonth = new JButton (">");
	JButton prevmonth = new JButton ("<");

	JButton[] days = new JButton [32];

	JButton[] daylabel = new JButton [8];
	daylabel [1] = new JButton ("Sunday");
	daylabel [2] = new JButton ("Monday");
	daylabel [3] = new JButton ("Tuesday");
	daylabel [4] = new JButton ("Wednesday");
	daylabel [5] = new JButton ("Thursday");
	daylabel [6] = new JButton ("Friday");
	daylabel [7] = new JButton ("Saturday");

	JButton monthdisplay;
	JButton yeardisplay;

	yeardisplay = new JButton (Integer.toString (yr)); // Label showing the current year being shown

	if (m == 1)
	{
	    monthdisplay = new JButton ("January");
	}
	else if (m == 2)
	{
	    monthdisplay = new JButton ("February");
	}
	else if (m == 3)
	{
	    monthdisplay = new JButton ("March");
	}
	else if (m == 4)
	{
	    monthdisplay = new JButton ("April");
	}
	else if (m == 5)
	{
	    monthdisplay = new JButton ("May");
	}
	else if (m == 6)
	{
	    monthdisplay = new JButton ("June");
	}
	else if (m == 7)
	{
	    monthdisplay = new JButton ("July");
	}
	else if (m == 8)
	{
	    monthdisplay = new JButton ("August");
	}
	else if (m == 9)
	{
	    monthdisplay = new JButton ("September");
	}
	else if (m == 10)
	{
	    monthdisplay = new JButton ("October");
	}
	else if (m == 11)
	{
	    monthdisplay = new JButton ("November");
	}
	else
	{
	    monthdisplay = new JButton ("December");
	}
	monthdisplay.setBounds (300, 0, 200, 50);
	yeardisplay.setBounds (300, 50, 200, 50);
	monthdisplay.setVisible (true);
	yeardisplay.setVisible (true);
	this.getContentPane ().add (monthdisplay);
	this.getContentPane ().add (yeardisplay);

	for (int i = 1 ; i < 8 ; i++)
	{
	    this.getContentPane ().add (daylabel [i]);
	    daylabel [i].setBounds ((N - 1) * 82 + 113, 30 * 82, 82, 82);
	}


	nextyear.setActionCommand ("A");
	prevyear.setActionCommand ("B");
	nextmonth.setActionCommand ("C");
	prevmonth.setActionCommand ("D");

	for (int i = 1 ; i <= 31 ; i++)
	{
	    days [i] = new JButton (i + "\n "); // + couponslist[yr][m][i].getName()); //DEFINE COUPONS LIST
	    days [i].setActionCommand (Integer.toString (i));
	}

	this.getContentPane ().add (nextyear);
	this.getContentPane ().add (prevyear);
	this.getContentPane ().add (nextmonth);
	this.getContentPane ().add (prevmonth);
	int row = 1;
	int size = 82;

	for (int i = 1 ; i <= 31 ; i++)
	{
	    this.getContentPane ().add (days [i]);
	    days [i].setBounds ((N - 1) * size + 113, 30 + row * size, size, size);
	    N = N + 1;
	    if (N > 7)
	    {
		N = 1;
		row = row + 1;
	    }
	    days [i].addActionListener (this);
	}

	if (m == 9 || m == 4 || m == 6 || m == 11)
	{
	    days [31].setEnabled (false);
	    N = N - 1;
	    if (N < 1)
	    {
		N = 7;
	    }
	}
	if (m == 2)
	{
	    for (int i = 29 ; i <= 31 ; i++)
	    {
		days [i].setEnabled (false);
		if (N < 1)
		{
		    N = 7;
		}
	    }
	    if (yr % 4 == 0)
	    {
		days [29].setEnabled (true);
		if (N > 7)
		{
		    N = 1;
		}
	    }
	    if (yr % 100 == 0)
	    {
		days [29].setEnabled (false);
		if (N < 1)
		{
		    N = 7;
		}
	    }
	    if (yr % 400 == 0)
	    {
		days [29].setEnabled (true);
		if (N > 7)
		{
		    N = 1;
		}
	    }
	}
	
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



    }


    public void actionPerformed (ActionEvent e)
    {
	if ("A".equals (e.getActionCommand ()))
	{
	    yr = yr + 1;
	}
	else if ("B".equals (e.getActionCommand ()))
	{
	    yr = yr - 1;
	}
	else if ("C".equals (e.getActionCommand ()))
	{
	    m = m + 1;
	    if (m > 12)
	    {
		m = 1;
		yr = yr + 1;
	    }

	}
	else if ("D".equals (e.getActionCommand ()))
	{
	    m = m - 1;
	    if (m < 1)
	    {
		m = 12;
		yr = yr - 1;
	    }

	}

	for (int i = 1 ; i <= 31 ; i++)
	{
	    if ((Integer.toString (i)).equals (e.getActionCommand ()))
	    {
		N = backupN;    
	    //get the code
	    }
	}
	//calendarview.setVisible(false);
	getContentPane ().removeAll ();
	drawcalendar (N);
	//contentPane.validate();
	//contentPane.repaint();

	//drawcalendar (N);
    }
}

=======
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

class CouBook extends JFrame //implements ActionListener
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

	mainmenu.setBounds (500, 700, 200, 100);

	viewcoupons.setBounds (80, 0, 340, 100);
	addcoupons.setBounds (125, 430, 250, 50);
	delete.setBounds (125, 500, 250, 50);

	setTitle ("Coubook");
	setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); //closes properly when exited
	setResizable (false); //can't resize the screen
	setSize (500, 700); //screen resolution
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


    protected int yr;
    protected int m;
    protected int N;
    protected int backupN;

    public calendar ()
    {

	DateFormat df = new SimpleDateFormat ("yyyy");
	Date date = new Date ();
	yr = Integer.parseInt (df.format (date));

	df = new SimpleDateFormat ("MM");
	date = new Date ();
	m = Integer.parseInt (df.format (date));

	if (m == 1 || m == 2)
	{
	    m = m + 12;
	    yr = yr - 1;
	}


	int d = 1;
	N = (d + 2 * m + ((int) 3 * (m + 1) / 5) + yr + ((int) yr / 4) - ((int) yr / 100) + ((int) yr / 400) + 2) % 7;
	if (N == 0)
	{
	    N = 7;
	}
	if (m == 13 || m == 14)
	{
	    m = m - 12;
	    yr = yr + 1;
	}
	
	drawcalendar (N);

	// get first day, get days in the month, use a times x (number of day)
	// to distance days
	// have buttons be same size and use a*x distance from each other
	// when pressed, display coupon info for the day
	//colour code coupon days non coupon days?
	// 1 is a sunday


    }


    public void drawcalendar (int startday)
    {
	backupN = N;
	Container contentPane = this.getContentPane ();
	JButton nextyear = new JButton (">");
	JButton prevyear = new JButton ("<");
	JButton nextmonth = new JButton (">");
	JButton prevmonth = new JButton ("<");

	JButton[] days = new JButton [32];

	JButton[] daylabel = new JButton [8];
	daylabel [1] = new JButton ("Sunday");
	daylabel [2] = new JButton ("Monday");
	daylabel [3] = new JButton ("Tuesday");
	daylabel [4] = new JButton ("Wednesday");
	daylabel [5] = new JButton ("Thursday");
	daylabel [6] = new JButton ("Friday");
	daylabel [7] = new JButton ("Saturday");

	JButton monthdisplay;
	JButton yeardisplay;

	yeardisplay = new JButton (Integer.toString (yr)); // Label showing the current year being shown

	if (m == 1)
	{
	    monthdisplay = new JButton ("January");
	}
	else if (m == 2)
	{
	    monthdisplay = new JButton ("February");
	}
	else if (m == 3)
	{
	    monthdisplay = new JButton ("March");
	}
	else if (m == 4)
	{
	    monthdisplay = new JButton ("April");
	}
	else if (m == 5)
	{
	    monthdisplay = new JButton ("May");
	}
	else if (m == 6)
	{
	    monthdisplay = new JButton ("June");
	}
	else if (m == 7)
	{
	    monthdisplay = new JButton ("July");
	}
	else if (m == 8)
	{
	    monthdisplay = new JButton ("August");
	}
	else if (m == 9)
	{
	    monthdisplay = new JButton ("September");
	}
	else if (m == 10)
	{
	    monthdisplay = new JButton ("October");
	}
	else if (m == 11)
	{
	    monthdisplay = new JButton ("November");
	}
	else
	{
	    monthdisplay = new JButton ("December");
	}
	monthdisplay.setBounds (300, 0, 200, 50);
	yeardisplay.setBounds (300, 50, 200, 50);
	monthdisplay.setVisible (true);
	yeardisplay.setVisible (true);
	this.getContentPane ().add (monthdisplay);
	this.getContentPane ().add (yeardisplay);

	for (int i = 1 ; i < 8 ; i++)
	{
	    this.getContentPane ().add (daylabel [i]);
	    daylabel [i].setBounds ((N - 1) * 82 + 113, 30 * 82, 82, 82);
	}


	nextyear.setActionCommand ("A");
	prevyear.setActionCommand ("B");
	nextmonth.setActionCommand ("C");
	prevmonth.setActionCommand ("D");

	for (int i = 1 ; i <= 31 ; i++)
	{
	    days [i] = new JButton (i + "\n "); // + couponslist[yr][m][i].getName()); //DEFINE COUPONS LIST
	    days [i].setActionCommand (Integer.toString (i));
	}

	this.getContentPane ().add (nextyear);
	this.getContentPane ().add (prevyear);
	this.getContentPane ().add (nextmonth);
	this.getContentPane ().add (prevmonth);
	int row = 1;
	int size = 82;

	for (int i = 1 ; i <= 31 ; i++)
	{
	    this.getContentPane ().add (days [i]);
	    days [i].setBounds ((N - 1) * size + 113, 30 + row * size, size, size);
	    N = N + 1;
	    if (N > 7)
	    {
		N = 1;
		row = row + 1;
	    }
	    days [i].addActionListener (this);
	}

	if (m == 9 || m == 4 || m == 6 || m == 11)
	{
	    days [31].setEnabled (false);
	    N = N - 1;
	    if (N < 1)
	    {
		N = 7;
	    }
	}
	if (m == 2)
	{
	    for (int i = 29 ; i <= 31 ; i++)
	    {
		days [i].setEnabled (false);
		if (N < 1)
		{
		    N = 7;
		}
	    }
	    if (yr % 4 == 0)
	    {
		days [29].setEnabled (true);
		if (N > 7)
		{
		    N = 1;
		}
	    }
	    if (yr % 100 == 0)
	    {
		days [29].setEnabled (false);
		if (N < 1)
		{
		    N = 7;
		}
	    }
	    if (yr % 400 == 0)
	    {
		days [29].setEnabled (true);
		if (N > 7)
		{
		    N = 1;
		}
	    }
	}
	
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



    }


    public void actionPerformed (ActionEvent e)
    {
	if ("A".equals (e.getActionCommand ()))
	{
	    yr = yr + 1;
	}
	else if ("B".equals (e.getActionCommand ()))
	{
	    yr = yr - 1;
	}
	else if ("C".equals (e.getActionCommand ()))
	{
	    m = m + 1;
	    if (m > 12)
	    {
		m = 1;
		yr = yr + 1;
	    }

	}
	else if ("D".equals (e.getActionCommand ()))
	{
	    m = m - 1;
	    if (m < 1)
	    {
		m = 12;
		yr = yr - 1;
	    }

	}

	for (int i = 1 ; i <= 31 ; i++)
	{
	    if ((Integer.toString (i)).equals (e.getActionCommand ()))
	    {
		N = backupN;    
	    //get the code
	    }
	}
	//calendarview.setVisible(false);
	getContentPane ().removeAll ();
	drawcalendar (N);
	//contentPane.validate();
	//contentPane.repaint();

	//drawcalendar (N);
    }
}

>>>>>>> 74516bfa1f23447175d05ac75a8b2c30bb68aace
