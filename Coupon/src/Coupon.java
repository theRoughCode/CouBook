
public class Coupon {
	private String name, deal, desc, refCode;
	private int pax;
	private String[] location;
	private int[] date;
	
	public Coupon(String name, String deal, String location, 
			String date, int pax, String desc, String refCode){
		this.name = name;
		this.deal = deal;
		this.location = setLocation(location);
		this.desc = desc;
		this.refCode = refCode;
		this.date = setDate(date);
		this.pax = pax;
	}
	
	private int[] setDate(String date){
		String[] dateS = date.split("/");
		// (dd, mm, yy)
		int[] dateArr = new int[dateS.length];
		for (int i = 0; i < dateS.length; i++){
			dateArr[i] = Integer.parseInt(dateS[i]);
		}
		return dateArr;
	}
	
	private String[] setLocation(String location){
		String[] locArr = location.split(";");
		return locArr;
	}
	
	public String getName(){
		return name;
	}
	public String getDeal(){
		return deal;
	}
	public String[] getLocation(){
		return location;
	}
	public String getDesc(){
		return desc;
	}
	public String getCode(){
		return refCode;
	}
	public int[] getDate(){
		return date;
	}
	public int getPax(){
		return pax;
	}
}
