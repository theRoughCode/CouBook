
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
	
	public String output(){
		String output = "********************************************************";
		output = output.concat(String.format("\nName: %s\nDeal:%s\nLocation: ", getName(),getDeal()));
		for (int i = 0; i < location.length - 1; i++){
			output = output.concat(location[i]+", ");
		}
		output = output.concat(location[location.length - 1]);
		output = output.concat("\nExpiration Date: " + date[0]+"/"+date[1]+"/"+date[2]);
		output = output.concat("\nPax:\tMin: "+pax[0]+"\tMax: "+pax[1]);
		output = output.concat("\nAdditional Info: " + desc + "\nReference Code: " + refCode);
		
		return output;
	}
}
