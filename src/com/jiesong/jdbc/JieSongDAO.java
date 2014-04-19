package com.jiesong.jdbc;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.jiesong.model.Address;
import com.jiesong.model.AvaliableTime;
import com.jiesong.model.Car;
import com.jiesong.model.Time;
import com.jiesong.model.User;
import com.jiesong.model.util.Airport;
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
	/**
	 * This is a manually update user unless really confidence of
	 * knowing of what to change, otherwise do not use it.
	 * @param mender
	 * @param u
	 * @return status code
	 */
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
	/**
	 * Change the password
	 * @param userId
	 * @param newPassword
	 * @return status code
	 */
	public int changePassword(int userId, String newPassword);
	
	public int addCar(User u, Car c);
	public int suspendCar(User u, Car c);
	public int updateCarInformationByUserId(int carId, int maxSeats, int maxLuggages);
	public int updateCarImage(int carId, String imageURI);
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
	/**
	 * This interface is for select the Address fit the condition of a Address
	 * Currently only supports userId search.
	 * 
	 * @param address
	 * @return ArrayList<Address>
	 */
	public ArrayList<Address> searchAddress(Address a);
	
	public int updateAvaliableTimeSchedule(User u, ArrayList<AvaliableTime> a);
	/**
	 * This interface is for select the AvaliableTime fit the condition of a AvaliableTime
	 * Currently only supports userId search.
	 * 
	 * @param AvaliableTime
	 * @return ArrayList<AvaliableTime>
	 */
	public ArrayList<AvaliableTime> searchAvaliableTime(User u, AvaliableTime a);
	
	public Address getUserAddressByUserId(int userId);
	
	public ArrayList<User> getAvaliableServiceProviderList(Time timeFrame, Airport airport);
	
	public int updateUserInformation(User mendor, String nickname, String email, Timestamp dob);
	
	public int changeServiceStatus(int userId, boolean serviceStatus);
	
	public int changeEmailVerificationStatus(int userId, boolean emailStatus);
	
	public int changeLastLoginTime(int userId);
}
