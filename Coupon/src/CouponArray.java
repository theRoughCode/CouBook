import java.util.ArrayList;

public class CouponArray {
	public static ArrayList<Coupon> couponArr;
	
	public CouponArray(){
		couponArr = new ArrayList<>();
	}
	
	public void add(Coupon c){
		couponArr.add(c);
	}
	
	public void remove(Coupon c){
		couponArr.remove(c);
	}
	
	public Coupon get(int i){
		return couponArr.get(i);
	}
}
