package servlet;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class Util {

	public static void main(String[] args) {
		String str = Util.encryption("password");
		System.out.println(str);
	}

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
}
