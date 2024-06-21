package bean;

public class Goods {
	//商品ID
	private String uniId;
	//商品名
	private String uniName;
	//在庫数
	private int stock;
	//価格
	private int price;
	//購入個数
	private int buyQuantity;

	
	public String getUniId() {
		return uniId;
	}

	public void setUniId(String uniId) {
		this.uniId = uniId;
	}
	
	public String getUniName() {
		return uniName;
	}

	public void setUniName(String uniName) {
		this.uniName = uniName;
	}
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getBuyQuantity() {
		return buyQuantity;
	}
	
	public void setBuyQuantity(int buyQuantity) {
		this.buyQuantity = buyQuantity;
	}
}

	