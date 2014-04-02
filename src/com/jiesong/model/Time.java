package com.jiesong.model;

/**
 * This class provides time object
 * 
 * @author peidong
 */
public class Time {
	private int day = 0;
	private int hour = 0;
	private int minute = 0;
	
	public void setDay(int day){
		this.day = day;
	}
	
	public int getDay(){
		return this.day;
	}
	
	public void setHour(int hour){
		this.hour = hour;
	}
	
	public int getHour(){
		return this.hour;
	}
	
	public void setMinute(int minute){
		this.minute = minute;
	}
	
	public int getMinute(){
		return this.minute;
	}
}
