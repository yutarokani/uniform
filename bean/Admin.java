package bean;

public class Admin {

	// フィールド変数定義
	private String userid; //ユーザーID
	private String password; //パスワード

	// コンストラクタ定義（初期化処理）
	public Admin() {
		this.userid = null;
		this.password = null;
	}

	// userid アクセサメソッド
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	// password アクセサメソッド
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}