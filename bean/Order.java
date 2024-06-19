package bean;

public class Order {

	// フィールド変数定義
	private String uniname;    // 商品名
	private int buyquantity;        // 購入個数

	// コンストラクタ定義（初期化処理）
	public Order(){
		this.uniname = null;
		this.buyquantity = 0;
	}

	// uniname アクセサメソッド
	public String getUniname() {
		return uniname;
	}

	public void setUniname(String uniname) {
		this.uniname = uniname;
	}

	// number アクセサメソッド
	public int getBuyquantity() {
		return buyquantity;
	}

	public void setBuyquantity(int buyquantity) {
		this.buyquantity = buyquantity;
	}

}
