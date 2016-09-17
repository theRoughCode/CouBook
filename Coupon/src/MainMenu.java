import java.util.Scanner;

public class MainMenu {
	public static void main (String args[]){
		String name, deal, location, desc, refCode, date;
		int minPax, maxPax;
		
		Scanner in = new Scanner(System.in);
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
	}
}
