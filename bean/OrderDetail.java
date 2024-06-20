package bean;

public class OrderDetail {

	private int orderNumber; //注文番号
	private String uniId;    //商品ID
	private String uniname;  //商品名
	
	public OrderDetail() {

		this.orderNumber = 0;
		this.uniId = null;
		this.uniname = null;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getUniId() {
		return uniId;
	}

	public void setUniId(String uniId) {
		this.uniId = uniId;
	}

	public String getUniname() {
		return uniname;
	}
	
	public void setUniname(String uniname) {
		this.uniname = uniname;
	}

}