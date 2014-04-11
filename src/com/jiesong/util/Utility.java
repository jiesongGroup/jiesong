package com.jiesong.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

import com.jiesong.model.Time;

/**
 * This class is for All the useful tools 
 * @author peidong
 *
 */
public class Utility {
	private static final String SALT = "HelloWorld!";
	
	/**
	 * MD5 Hash plus salt
	 * @param passwordToHash
	 * @return encrypted string
	 */
	public static String getSecurePassword(String passwordToHash) {
		String generatedPassword = null;
		try {
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			//Add password bytes to digest
			md.update(SALT.getBytes());
			//Get the hash's bytes 
			byte[] bytes = md.digest(passwordToHash.getBytes());
			//This bytes[] has bytes in decimal format;
			//Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();
			for(int i=0; i< bytes.length ;i++){
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			//Get complete hashed password in hex format
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}
	
	/**
	 * This class generate current time stamp
	 * @return current time stamp
	 */
	public static Timestamp getCurrentTimestamp(){
		return new Timestamp((new java.util.Date()).getTime());
	}
	
	/**
	 * This class for parse timeFrame from Integer to Time object
	 * @param timeFrame
	 * @return Time
	 */
	public static Time parseTimeFrame(int timeFrame){
		Time ret = new Time();
		int day = 0;
		int hour = 0;
		int minute = 0;
		
		for(day = 0; day < 7; day++){
			if(timeFrame < day*24*60) break;
		}
		timeFrame -= day*24*60;
		for(hour = 0; hour < 24; hour++){
			if(timeFrame < hour*60) break;
		}
		timeFrame -= hour*60;
		minute = timeFrame;
		
		ret.setDay(day);
		ret.setHour(hour);
		ret.setMinute(minute);
		
		return ret;
	}
	
	public static Timestamp parseStringtoTimestamp(String str){
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		ts = Timestamp.valueOf(str);
		return ts;
	}
	public static String generateCode(){
		final String[] str = { "0", "1", "2", "3", "4", "5", "6", "7", "8",
			  "9", "q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s",
			  "d", "f", "g", "h", "j", "k", "l", "z", "x", "c", "v", "b", "n",
			  "m" };
		String s = "";
		 for (int i = 0; i < 16; i++) {
		  int a=(int)(Math.random()*36);
		  s+=str[a];
		 }
		 return s;		 
	}
}
