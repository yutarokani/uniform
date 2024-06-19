package bean;

public class OrderDetail {

	private String uniId;
	
	private int orderNumber;

	private int buyQuantity;

	public orderDetail() {
		this.uniId = null;
		this.orderNumber = 0;
		this.buyQuantity = 0;
	}

	public String getUniId() {
		return uniId;
	}

	public void setUniId(String uniId) {
		this.uniId = uniId;
	}
	
	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	
		public int getBuyQuantity() {
		return buyQuantity;
	}

	public void setBuyQuantity(int buyQuantity) {
		this.buyQuantity = buyQuantity;
	}
}

	