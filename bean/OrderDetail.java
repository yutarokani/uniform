
package bean;

public class OrderDetail {

	private int orderNumber; //注文番号
	private String uniId;    //商品ID
	private int buyQuantity; //購入個数
	
	public OrderDetail() {

		this.orderNumber = 0;
		this.uniId = null;
		this.buyQuantity = 0;
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
	
	public int getBuyQuantity() {
		return buyQuantity;
	}
	
	public void setBuyQuantity(int buyQuantity) {
		this.buyQuantity = buyQuantity;
	}

}
