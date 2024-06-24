
package bean;

public class OrderInfo {

	// フィールド変数定義
	private int orderNumber; // 注文番号
	private String name; // 氏名
	private String mail;//メール
	private String address;//住所
	private String uniId; // 商品ID
	private String other;//備考欄
	private int buyQuantity; // 購入個数
	private String day;//注文日
	private String sendDay; // 発送日
	private String payment; // 入金状況
	private String shipping; // 発送状況

	// コンストラクタ定義（初期化処理）
	public OrderInfo() {
		this.orderNumber = 0;
		this.name = null;
		this.mail = null;
		this.address = null;
		this.uniId = null;
		this.other = null;
		this.buyQuantity = 0;
		this.day = null;
		this.sendDay = null;
		this.payment = null;
		this.shipping = null;
	}

	// ordernumber アクセサメソッド
	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	// name アクセサメソッド
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
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// uniname アクセサメソッド
	public String getUniId() {
		return uniId;
	}

	public void setUniId(String uniId) {
		this.uniId = uniId;
	}
	
	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	// number アクセサメソッド
	public int getBuyQuantity() {
		return buyQuantity;
	}

	public void setBuyQuantity(int buyQuantity) {
		this.buyQuantity = buyQuantity;
	}
	
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	// sendday アクセサメソッド
	public String getSendDay() {
		return sendDay;
	}

	public void setSendDay(String sendday) {
		this.sendDay = sendday;
	}

	// payment アクセサメソッド
	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	// shipping アクセサメソッド
	public String getShipping() {
		return shipping;
	}

	public void setShipping(String shipping) {
		this.shipping = shipping;
	}

}
