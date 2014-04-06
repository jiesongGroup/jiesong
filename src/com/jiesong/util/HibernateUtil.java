package com.jiesong.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class HibernateUtil {

    private static SessionFactory factory = null;
    
    static {
    	try{
    		//load Hibernate Configuration File
    		Configuration cfg = new Configuration().configure();
    		factory = cfg.buildSessionFactory();
    	} catch (HibernateException e){
    		e.printStackTrace();	
    	}
    }

    public static Session getSession() {
        Session session = (factory != null) ? factory.openSession():null;
        return session;
    }

    public static SessionFactory getSessionFactory(){
    	return factory;
    }
    
    public static void closeSession(Session session) {
    	if(session != null){
    		if(session.isOpen()){
    			session.close();
    		}
    	}
    }
}
