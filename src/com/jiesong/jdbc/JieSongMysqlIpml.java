package com.jiesong.jdbc;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jiesong.model.Address;
import com.jiesong.model.AvaliableTime;
import com.jiesong.model.Car;
import com.jiesong.model.Time;
import com.jiesong.model.User;
import com.jiesong.model.util.Airport;
import com.jiesong.util.HibernateUtil;
import com.jiesong.util.Utility;

/**
 * MySql implementation of jieSongDAO based on Hibernate4.3.4
 * @author peidong
 *
 */
public class JieSongMysqlIpml implements JieSongDAO{

	@Override
	public int createUser(User creator, User u) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try{
			u.setCreateTime(Utility.getCurrentTimestamp());
			u.setCreateBy(creator.getId());
			u.setModifyTime(Utility.getCurrentTimestamp());
			u.setModifyBy(creator.getId());
			u.setActive(true);
			u.setPassword(Utility.getSecurePassword(u.getPassword()));
					
			transaction = session.beginTransaction();
			session.save(u);
			transaction.commit();
		} catch (HibernateException e){

		} finally {
			session.close();
		}
		return 0;
	}

	@Override
	public int suspendUser(User mender, User u) {
		u.setActive(false);
		return updateUser(mender, u);
	}

	public int updateUser(User mender, User u) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try{
			u.setModifyBy(mender.getId());
			transaction = session.beginTransaction();
			session.update(u);
			transaction.commit();
		} catch (HibernateException e){

		} finally {
			session.close();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<User> listAllActiveUser(User u) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transcation = null;
		ArrayList<User> ret = null;
		String hql = null;

		try{
			transcation = session.beginTransaction();
			
			hql = "FROM User where active=true";
			Query query = session.createQuery(hql);
			ret = (ArrayList<User>) query.list();

			transcation.commit();
		} catch(HibernateException e){
			
		} finally {
			session.close();
		}
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public int loginCheck(String username, String password){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transcation = null;
		String hql = null;
		ArrayList<User> result = null;
		User u = null;
		
		try{
			u = new User();
			u.setUsername(username);
			u.setPassword(Utility.getSecurePassword(password));
			
			transcation = session.beginTransaction();
			
			hql = "FROM User u where active=true";
			hql += " and u.username='" + u.getUsername() + "'";
			hql += " and u.password='" + u.getPassword() + "'";
			Query query = session.createQuery(hql);
			result = (ArrayList<User>) query.list();

			if(result.size() == 0){
				return 1;
			}
			u = result.get(0);
			
			if(u.getEmailVerified() == false){
				return 2;
			}
			transcation.commit();
		} catch(HibernateException e){
			e.printStackTrace();
		} finally {
			session.close();
		}
		return 0;
	}

	@Override
	public int addCar(User u, Car c) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try{
			c.setCreateTime(Utility.getCurrentTimestamp());
			c.setCreateBy(u.getId());
			c.setModifyTime(Utility.getCurrentTimestamp());
			c.setModifyBy(u.getId());
			c.setActive(true);
			c.setUserId(u.getId());
					
			transaction = session.beginTransaction();
			session.save(c);
			transaction.commit();
		} catch (HibernateException e){

		} finally {
			session.close();
		}
		return 0;
	}

	@Override
	public int suspendCar(User u, Car c) {
		c.setActive(false);
		return updateCar(u, c);
	}

	public int updateCar(User u, Car c) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try{
			c.setModifyTime(Utility.getCurrentTimestamp());
			c.setModifyBy(u.getId());
					
			transaction = session.beginTransaction();
			session.save(c);
			transaction.commit();
		} catch (HibernateException e){

		} finally {
			session.close();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Car> searchCar(Car c) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transcation = null;
		ArrayList<Car> ret = null;
		String hql = null;

		try{
			transcation = session.beginTransaction();
			
			hql = "FROM Car where active=true";
			hql += " and userid=" + c.getUserId();
			
			Query query = session.createQuery(hql);
			ret = (ArrayList<Car>) query.list();

			transcation.commit();
		} catch(HibernateException e){
			
		} finally {
			session.close();
		}
		return ret;
	}

	@Override
	public int addAddress(User u, Address a) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try{
			a.setCreateTime(Utility.getCurrentTimestamp());
			a.setCreateBy(u.getId());
			a.setModifyTime(Utility.getCurrentTimestamp());
			a.setModifyBy(u.getId());
			a.setActive(true);
			a.setUserId(u.getId());
					
			transaction = session.beginTransaction();
			session.save(a);
			transaction.commit();
		} catch (HibernateException e){

		} finally {
			session.close();
		}
		return 0;
	}

	@Override
	public int suspendAddress(User u, Address a) {
		a.setActive(false);
		return updateAddress(u, a);
	}

	public int updateAddress(User u, Address a) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try{
			a.setModifyTime(Utility.getCurrentTimestamp());
			a.setModifyBy(u.getId());
					
			transaction = session.beginTransaction();
			session.save(a);
			transaction.commit();
		} catch (HibernateException e){

		} finally {
			session.close();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Address> searchAddress(Address a) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transcation = null;
		ArrayList<Address> ret = null;
		String hql = null;

		try{
			transcation = session.beginTransaction();
			
			hql = "FROM Car where active=true";
			hql += " and userid=" + a.getUserId();
			
			Query query = session.createQuery(hql);
			ret = (ArrayList<Address>) query.list();

			transcation.commit();
		} catch(HibernateException e){
			
		} finally {
			session.close();
		}
		return ret;
	}

	public int addAvaliableTime(User u, AvaliableTime a) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try{
			a.setCreateTime(Utility.getCurrentTimestamp());
			a.setCreateBy(u.getId());
			a.setModifyTime(Utility.getCurrentTimestamp());
			a.setModifyBy(u.getId());
			a.setActive(true);
			a.setUserId(u.getId());
					
			transaction = session.beginTransaction();
			session.save(a);
			transaction.commit();
		} catch (HibernateException e){

		} finally {
			session.close();
		}
		return 0;
	}

	public int suspendAvaliableTime(User u, AvaliableTime a) {
		a.setActive(false);
		return updateAvaliableTime(u, a);
	}

	public int updateAvaliableTime(User u, AvaliableTime a) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try{
			a.setModifyTime(Utility.getCurrentTimestamp());
			a.setModifyBy(u.getId());
					
			transaction = session.beginTransaction();
			session.save(a);
			transaction.commit();
		} catch (HibernateException e){

		} finally {
			session.close();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<AvaliableTime> searchAvaliableTime(User u,
			AvaliableTime a) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transcation = null;
		ArrayList<AvaliableTime> ret = null;
		String hql = null;

		try{
			transcation = session.beginTransaction();
			
			hql = "FROM Car where active=true";
			hql += " and userid=" + a.getUserId();
			
			Query query = session.createQuery(hql);
			ret = (ArrayList<AvaliableTime>) query.list();

			transcation.commit();
		} catch(HibernateException e){
			
		} finally {
			session.close();
		}
		return ret;
	}

	@Override
	public int changePassword(int userId, String newPassword) {
		Session session = null;
		int ret = 0;
		
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();
			User user = (User) session.load(User.class, userId);
			user.setPassword(newPassword);
			session.getTransaction().commit();
		} catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
			ret = 1;
		} finally {
			HibernateUtil.closeSession(session);
		}
		return ret;
	}

	@Override
	public Address getUserAddressByUserId(int userId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Address a = null;

		try{
			transaction = session.beginTransaction();
			a = (Address) session.get(Address.class, userId);
			transaction.commit();
		} catch (HibernateException e){

		} finally {
			session.close();
		}
		return a;
	}

	@Override
	public ArrayList<User> getAvaliableServiceProviderList(Time timeFrame, Airport airport) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateUserInformation(User mendor, String nickname,
			String email, Timestamp dob) {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		Transaction transaction = null;
//		User u = null;
//
//		try{
//			transaction = session.beginTransaction();
//			u = (User) session.get(User.class, userId);
//			u.setLastSignInTime(Utility.getCurrentTimestamp());
//			transaction.commit();
//		} catch (HibernateException e){
//
//		} finally {
//			session.close();
//		}
		
		return 0;
	}

	@Override
	public int changeServiceStatus(int userId, boolean serviceStatus) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		User u = null;

		try{
			transaction = session.beginTransaction();
			u = (User) session.get(User.class, userId);
			u.setServiceStatus(serviceStatus);
			transaction.commit();
		} catch (HibernateException e){

		} finally {
			session.close();
		}
		return 0;
	}

	@Override
	public int changeEmailVerificationStatus(int userId, boolean emailStatus) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		User u = null;

		try{
			transaction = session.beginTransaction();
			u = (User) session.get(User.class, userId);
			u.setEmailVerified(emailStatus);
			transaction.commit();
		} catch (HibernateException e){

		} finally {
			session.close();
		}
		return 0;
	}

	@Override
	public int changeLastLoginTime(int userId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		User u = null;

		try{
			transaction = session.beginTransaction();
			u = (User) session.get(User.class, userId);
			u.setLastSignInTime(Utility.getCurrentTimestamp());
			transaction.commit();
		} catch (HibernateException e){

		} finally {
			session.close();
		}
		return 0;
	}

	public int deleteAvaliableTimeByUserId(int userId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		int ret = 0;
		
		try{
			transaction = session.beginTransaction();
			Query query = session.createQuery("delete AvaliableTime where userId = :userId");
			query.setParameter("userId", userId);
			ret = query.executeUpdate();
			transaction.commit();
		} catch (HibernateException e){
			ret = 1;
		} finally {
			session.close();
		}
		return ret;
	}

	@Override
	public int updateAvaliableTimeSchedule(User u, ArrayList<AvaliableTime> a) {
		int userId = u.getId();
		deleteAvaliableTimeByUserId(userId);
		for(AvaliableTime time : a) addAvaliableTime(u, time);
		return 0;
	}

	@Override
	public int updateCarInformationByUserId(int carId, int maxSeats,
			int maxLuggages) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Car c = null;
		int ret = 0;
		
		try{
			transaction = session.beginTransaction();
			c = (Car) session.get(Car.class, carId);
			c.setMaxSeats(maxSeats);
			c.setMaxLuggages(maxLuggages);
			transaction.commit();
		} catch (HibernateException e){
			ret = 1;
		} finally {
			session.close();
		}
		return ret;
	}

	@Override
	public int updateCarImage(int carId, String imageURI) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Car c = null;
		int ret = 0;
		
		try{
			transaction = session.beginTransaction();
			c = (Car) session.get(Car.class, carId);
			c.setImageURI(imageURI);
			transaction.commit();
		} catch (HibernateException e){
			ret = 1;
		} finally {
			session.close();
		}
		return ret;
	}

}
