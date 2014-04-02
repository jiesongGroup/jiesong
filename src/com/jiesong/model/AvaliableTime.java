package com.jiesong.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.jiesong.adapter.SqlTimestampAdapter;

/**
 * Java bean for avaliableTime
 * @author peidong
 *
 */
@Entity
@Table(name = "avaliableTime")
@XmlRootElement(name = "abaliableTime")
@XmlAccessorType(XmlAccessType.FIELD)
public class AvaliableTime {
	@XmlJavaTypeAdapter(SqlTimestampAdapter.class)
	private Timestamp createTime = null;
	private int createBy = 0;
	@XmlJavaTypeAdapter(SqlTimestampAdapter.class)
	private Timestamp modifyTime = null;
	private int modifyBy = 0;
	private boolean active = false;
	private int id = 0;
	private int userId = 0;
	private int timeFrame = 0;
	
	public AvaliableTime(){
		
	}
	
	public void setCreateTime(Timestamp createTime){
		this.createTime = createTime;
	}

	public Timestamp getCreateTime(){
		return this.createTime;
	}

	public void setCreateBy(int createBy){
		this.createBy = createBy;
	}

	public int getCreateBy(){
		return this.createBy;
	}

	public void setModifyTime(Timestamp modifyTime){
		this.modifyTime = modifyTime;
	}

	public Timestamp getModifyTime(){
		return this.modifyTime;
	}

	public void setModifyBy(int modifyBy){
		this.modifyBy = modifyBy;
	}

	public int getModifyBy(){
		return this.modifyBy;
	}

	public void setActive(boolean active){
		this.active = active;
	}
	
	public boolean getActive(){
		return this.active;
	}
	
	public void setId(int id){
		this.id = id;
	}
	@Id
	public int getId(){
		return this.id;
	}
	
	public void setUserId(int userId){
		this.userId = userId;
	}
	
	public int getUserId(){
		return this.userId;
	}
	
	public void setTimeFrame(int timeFrame){
		this.timeFrame = timeFrame;
	}
	
	public int getTimeFrame(){
		return this.timeFrame;
	}
}
