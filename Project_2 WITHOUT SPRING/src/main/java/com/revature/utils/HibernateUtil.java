package com.revature.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil 
{
	//we need to set up our session factory so we can get sessions :)
	private static SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	//we only want one Session... so it will be a singleton
	private static Session ses;
	//this is how we will make ses a singleton
	public static Session getSession()
	{
		//if we do not currently have a session...
		if(ses == null)
		{
			//open one!
			ses = sf.openSession();
		}
		else//we aleady have a session, we do nothing
		{
			//this is totally not needed... but it is fine
		}
		//return the session
		return ses;
	}
	
	//This will close our session, we must call this from this class, or else problems
	public static void closeSession()
	{
		//if we have an open session
		if(ses != null)
		{
			//close the ssssion
			ses.close();
			//set session to null so we know we have to get a new one
			ses = null;
		}
	}

	public static Transaction startTransaction() 
	{
		Transaction tx = ses.beginTransaction();
		//check if a transaction is in progress
		if(!tx.isActive())
		{
			//if no transaction is in progress, begin one
			tx.begin();
		}
		
		return tx;
	}
}
