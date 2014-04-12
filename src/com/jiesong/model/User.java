package com.jiesong.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.jiesong.adapter.SqlTimestampAdapter;
import com.jiesong.model.util.Gender;

/**
 * User bean
 * @author peidong
 *
 */
@Entity
@Table(name = "userInfo")
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
	@XmlJavaTypeAdapter(SqlTimestampAdapter.class)
	private Timestamp createTime = null;
	private int createBy = 0;
	@XmlJavaTypeAdapter(SqlTimestampAdapter.class)
	private Timestamp modifyTime = null;
	private int modifyBy = 0;
	private boolean active = false;
	private int id = 0;
	private String username = null;
	private String password = null;
	private String nickname = null;
	private String email = null;
	private Gender gender = null;
	@XmlJavaTypeAdapter(SqlTimestampAdapter.class)
	private Timestamp dob = null;
	private boolean serviceStatus = false;
	private Timestamp lastSignInTime = null;
	private int activeness = 0;
	private boolean emailVerified = false;
	
	public User(){
		
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
	@GeneratedValue
	public int getId(){
		return this.id;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public void setNickname(String nickName){
		this.nickname = nickName;
	}
	
	public String getNickname(){
		return this.nickname;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public void setGender(Gender gender){
		this.gender = gender;
	}
	@Enumerated(EnumType.STRING)
	public Gender getGender(){
		return this.gender;
	}
	
	public void setDOB(Timestamp dob){
		this.dob = dob;
	}
	
	public Timestamp getDOB(){
		return this.dob;
	}
	
	public void setServiceStatus(boolean serviceStatus){
		this.serviceStatus = serviceStatus;
	}
	
	public boolean getServiceStatus(){
		return this.serviceStatus;
	}
	
	public void setLastSignInTime(Timestamp lastSignInTime){
		this.lastSignInTime = lastSignInTime;
	}
	
	public Timestamp getLastSignInTime(){
		return this.lastSignInTime;
	}
	
	public void setActiveness(int activeness){
		this.activeness = activeness;
	}
	
	public int getActiveness(){
		return this.activeness;
	}
	
	public void setEmailVerified(boolean emailVerified){
		this.emailVerified = emailVerified;
	}
	
	public boolean getEmailVerified(){
		return this.emailVerified;
	}
}
