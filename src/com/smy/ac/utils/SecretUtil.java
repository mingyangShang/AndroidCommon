package com.smy.ac.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 安全工具类
 * @author smy
 * @since 2015/04/16
 */
public class SecretUtil {
	
	/**
	 * md5 32位加密
	 * @param srcCode 要加密的字符串
	 * @return 加密后的32位字符串
	 */
	public static String md5(String srcCode){
		if(srcCode==null){
			throw new IllegalAccessError("the string to be md5ed can\'t be null");
		}
		String reStr = "";  
        try {  
            MessageDigest md5 = MessageDigest.getInstance("MD5");  
            byte[] bytes = md5.digest(srcCode.getBytes());  
            StringBuffer stringBuffer = new StringBuffer();  
            for (byte b : bytes){  
                int bt = b&0xff;  
                if (bt < 16){  
                    stringBuffer.append(0);  
                }   
                stringBuffer.append(Integer.toHexString(bt));  
            }  
            reStr = stringBuffer.toString();  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }  
        return reStr;  
	}

}
