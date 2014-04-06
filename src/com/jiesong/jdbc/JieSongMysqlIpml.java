package com.jiesong.jdbc;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jiesong.model.Address;
import com.jiesong.model.AvaliableTime;
import com.jiesong.model.Car;
import com.jiesong.model.User;
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

	@Override
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

	@Override
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

	@Override
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

	@Override
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

	@Override
	public int suspendAvaliableTime(User u, AvaliableTime a) {
		a.setActive(false);
		return updateAvaliableTime(u, a);
	}

	@Override
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

}
