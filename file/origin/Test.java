package test;

import java.io.UnsupportedEncodingException;

public class Test {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String web = "½ðË¿Ñà";
		byte[] byteArray = web.getBytes("gbk");
		String result = new String(byteArray, "utf-8");
		System.out.println(result);
	}
}
