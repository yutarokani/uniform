package bean;

public class OrderInfo {

	// フィールド変数定義
	private String ordernumber; // 注文番号
	private String name; // 氏名
	private String mail;//メール
	private String address;//住所
	private String uniname; // 商品名
	private String other;//備考欄
	private int buyquantity; // 購入個数
	private String day;//注文日
	private String sendday; // 発送日
	private String payment; // 入金状況
	private String shipping; // 発送状況

	// コンストラクタ定義（初期化処理）
	public OrderInfo() {
		this.ordernumber = null;
		this.name = null;
		this.mail = null;
		this.address = null;
		this.uniname = null;
		this.other = null;
		this.buyquantity = 0;
		this.day = null;
		this.sendday = null;
		this.payment = null;
		this.shipping = null;
	}

	// ordernumber アクセサメソッド
	public String getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
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
	public String getUniname() {
		return uniname;
	}

	public void setUniname(String uniname) {
		this.uniname = uniname;
	}
	
	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	// number アクセサメソッド
	public int getBuyquantity() {
		return buyquantity;
	}

	public void setBuyquantity(int buyquantity) {
		this.buyquantity = buyquantity;
	}
	
	public String getDday() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	// sendday アクセサメソッド
	public String getSendday() {
		return sendday;
	}

	public void setSendday(String sendday) {
		this.sendday = sendday;
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