package com.xx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrintTest {

	public static void main(String[] args) {
		String fileType = "jfj,jpg,jpeg,bmp";
		String fileName = "sdf.dsafasd.fasdf.jpg";
		int fix = fileName.lastIndexOf(".");
		System.out.println(fileName.substring(fix));
		System.out.println(fileType.contains(fileName.substring(fix+1)));
	}
	
	public static boolean isTel(String tel)
    {
        String check = "^0[1-9](\\d{1,2}\\-?)\\d{7,8}";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(tel);
        return matcher.matches();
    }

}
