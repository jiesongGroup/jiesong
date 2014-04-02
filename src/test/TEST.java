package test;

import java.sql.Timestamp;

import com.jiesong.jdbc.JieSongDAO;
import com.jiesong.jdbc.JieSongMysqlIpml;
import com.jiesong.model.Address;
import com.jiesong.model.Car;
import com.jiesong.model.User;
import com.jiesong.util.Gender;

public class TEST {

	public static void main(String[] args) {
		JieSongDAO dao = new JieSongMysqlIpml();
		User t = new User();
		
//		t.setUsername("root");
//		t.setPassword("123456");
//		t.setEmail("root@jiesong.com");
//		t.setDOB(new Timestamp((new java.util.Date()).getTime()));
//		t.setGender(Gender.male);
//		t.setActiveness(100);
//		t.setLastSignInTime(new Timestamp((new java.util.Date()).getTime()));
//		t.setNickname("root");
//		t.setServiceStatus(true);
//		
//		User root = new User();
//		root.setId(1);
//		dao.createUser(root, t);
//		dao.updateUser(root, t);
//		dao.suspendUser(root, t);
//		System.out.println(dao.listAllActiveUser(t).size());
//		System.out.println(dao.loginCheck("test3", "123"));
		
//		Car c = new Car();
//		c.setUserId(1);
//		c.setImageURI("www.jiesong.com/images/1/carImage.gif");
//		c.setMaxLuggages(2);
//		c.setMaxSeats(4);
//		t.setId(1);
//		
//		dao.addCar(t, c);
		
		Address a = new Address();
		a.setStree("Anzac pde");
		a.setSuburb("Kingsford");
		a.setProvince("NSW");
		a.setNation("Australian");
		a.setPostcode("2032");
		t.setId(1);
		
		dao.addAddress(t, a);
		
	}

}
