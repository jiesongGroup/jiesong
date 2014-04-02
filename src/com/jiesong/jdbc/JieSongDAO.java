package com.jiesong.jdbc;

import java.util.ArrayList;

import com.jiesong.model.Address;
import com.jiesong.model.AvaliableTime;
import com.jiesong.model.Car;
import com.jiesong.model.User;
/**
 * This class is a data access object for database jiesongDB.
 * <p> status code 0 is always means SUCCESS.
 * 
 * @author peidong
 * @see ArrayList
 */
public interface JieSongDAO {
	public int createUser(User creator, User u); 
	public int suspendUser(User mender, User u);
	public int updateUser(User mender, User u);
	public ArrayList<User> listAllActiveUser(User u);
	/**
	 * This interface is for checking login.
	 *  <p>The status code 0: success, 1: can not find record
	 *  and 2: email is not verified.
	 * @param username
	 * @param password
	 * @return status code
	 */
	public int loginCheck(String username, String password);
	
	public int addCar(User u, Car c);
	public int suspendCar(User u, Car c);
	public int updateCar(User u, Car c);
	/**
	 * This interface is for select the Car fit the condition of a Car
	 * Currently only supports userId search.
	 * 
	 * @param car
	 * @return ArrayList<Car>
	 */
	public ArrayList<Car> searchCar(Car c);
	
	public int addAddress(User u, Address a);
	public int suspendAddress(User u, Address a);
	public int updateAddress(User u, Address a);
	/**
	 * This interface is for select the Address fit the condition of a Address
	 * Currently only supports userId search.
	 * 
	 * @param address
	 * @return ArrayList<Address>
	 */
	public ArrayList<Address> searchAddress(Address a);
	
	public int addAvaliableTime(User u, AvaliableTime a);
	public int suspendAvaliableTime(User u, AvaliableTime a);
	public int updateAvaliableTime(User u, AvaliableTime a);
	/**
	 * This interface is for select the AvaliableTime fit the condition of a AvaliableTime
	 * Currently only supports userId search.
	 * 
	 * @param AvaliableTime
	 * @return ArrayList<AvaliableTime>
	 */
	public ArrayList<AvaliableTime> searchAvaliableTime(User u, AvaliableTime a);
}
