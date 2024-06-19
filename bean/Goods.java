package bean;

public class Goods {

	private String uniId;	//商品ID

	private String uniName;	//商品名

	private int stock;		//在庫数
	
	private int price;		//価格

	public Goods() {
		this.uniId = null;
		this.uniName = null;
		this.stock = 0;
		this.price = 0;
	}

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
}

	