package model;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.xml.bind.DatatypeConverter;


public class UtilLogic {

	/**
	 * 渡された文字列がnullまたは空文字だった場合trueを返す
	 * @param str
	 * @return boolean
	 */
	public static boolean isEmpty(String str) {
		if (null == str || str == "") {
			return true;
		}
		return false;
	}

	/**
	 * 渡された文字列をMD5で暗号化して返す
	 * @param targetPass	暗号化前の文字列
	 * @return				暗号化後の文字列
	 */
	public static String encryption(String targetPass) {

		//ハッシュ生成前にバイト配列に置き換える際のCharset
        Charset charset = StandardCharsets.UTF_8;

        //ハッシュアルゴリズム
        String algorithm = "MD5";

        //ハッシュ生成処理
        try {
        	byte[] bytes = MessageDigest.getInstance(algorithm).digest(targetPass.getBytes(charset));
            String result = DatatypeConverter.printHexBinary(bytes);

            //暗号化された文章を返す
            return result;

        } catch(NoSuchAlgorithmException e) {
        	e.printStackTrace();
        }
        return null;
	}

	/**
	 * Date型の日付をString型("yyyy年MM月dd日")に変換して返す
	 * @param date	変換したいDate型の日付
	 * @return		"yyyy年MM月dd日"表示の日付
	 */
	public static String displayDate(Date date) {

            SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy年MM月dd日");
    		String displayDate = sdFormat.format(date);

    		return displayDate;
	}

	/**
	 * Timestamp型の日時をString型("yyyy年MM月dd日 kk:mm")にして返す
	 * @param ts	変換したいTimestamp型の日時
	 * @return
	 */
	public static String displayDateTime(Timestamp ts) {

            SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy年MM月dd日 kk:mm");
    		String displayDateTime = sdFormat.format(ts);

    		return displayDateTime;
	}

}
