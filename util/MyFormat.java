package util;

import java.text.DecimalFormat;

public class MyFormat {

	public String moneyFormat(int price) {

		// formatPrice にフォーマットを設定
		DecimalFormat formatPrcie = new DecimalFormat("\u00A5,000");
		// フォーマットされた price の値を返す
		return formatPrcie.format(price);

	}
}
