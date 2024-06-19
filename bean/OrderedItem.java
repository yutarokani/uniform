package bean;

public class OrderedItem {

	// フィールド変数定義
	private int ordernumber; // 注文番号
	private String name;        // 氏名
	private String mail;        // メール
	private String addres;      // 住所
	private String uniname;     // 商品名
	private String other;       // 備考欄
	private String day;         // 注文日
	private String sendday;     // 発送日
	private String payment;     // 入金状況
	private String shipping;    // 発送状況
	
		
	// コンストラクタ定義（初期化処理）
	public OrderedItem(){
		this.ordernumber = 0;
		this.name = null;
		this.mail = null;
		this.addres = null;
		this.uniname = null;
		this.other = null;
		this.day = null;
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
		
	// mail アクセサメソッド
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	// addres アクセサメソッド
	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}
	
	// uniname アクセサメソッド
	public String getUniname() {
		return uniname;
	}

	public void setUniname(String uniname) {
		this.uniname = uniname;
	}
	
	// other アクセサメソッド
	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}
	
	// day アクセサメソッド
	public String getDay() {
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