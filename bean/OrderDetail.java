package bean;

public class OrderDetail {

	private int orderNumber;//注文番号
	private String name;//購入者氏名
	private String mail;//購入者メールアドレス
	private String uniId;//商品名
	private int buyQuantity;//購入個数
	private String other;//備考欄
	private String day;//注文日

	public OrderDetail() {

		this.orderNumber = 0;
		this.name = null;
		this.mail = null;
		this.uniId = null;
		this.buyQuantity = 0;
		this.day = null;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
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
	
	public String getOter() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
}
