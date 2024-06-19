package bean;

public class OrderedItem {

	// フィールド変数定義
	private int ordernumber;    // 注文番号
	private String name;        // 氏名
	private String uniname;     // 商品名
	private int buyquantity;    // 購入個数
	private String sendday;     // 発送日
	private String payment;     // 入金状況
	private String shipping;    // 発送状況
	
		
	// コンストラクタ定義（初期化処理）
	public OrderedItem(){
		this.ordernumber = 0;
		this.name = null;
		this.uniname = null;
		this.buyquantity = 0;
		this.sendday = null;
		this.payment = null;
		this.shipping = null;
	}
		
	// ordernumber アクセサメソッド
	public int getOrdernumber() {
		return ordernumber;
	}
		
	public void setOrdernumber(int ordernumber) {
		this.ordernumber = ordernumber;
	}
		
	// name アクセサメソッド
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// uniname アクセサメソッド
	public String getUniname() {
		return uniname;
	}

	public void setUniname(String uniname) {
		this.uniname = uniname;
	}
	
	// buyquantity アクセサメソッド
	public int getBuyquantity() {
		return buyquantity;
	}
	
	public void setBuyquantity(int buyquantity) {
		this.buyquantity = buyquantity;
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