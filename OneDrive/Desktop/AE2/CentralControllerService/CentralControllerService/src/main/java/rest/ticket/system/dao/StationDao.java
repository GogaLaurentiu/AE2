package rest.ticket.system.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import rest.ticket.system.model.Stations;
import rest.ticket.system.utlities.JdbcUtil;
/*
 * Dao Layer
 * Hibernate session and Session factory is mainly used
 * All the crud operation of Station is here
 */
public class StationDao{

	private Session session;
	public Stations save(Stations gate) {
		session = JdbcUtil.getSessionFactory().getCurrentSession();
		Transaction  transaction = session.beginTransaction();
		try {
        session.save(gate);
        transaction.commit();
		}
        catch (Exception e) {
			e.printStackTrace();
			session.close();
			return null;
		}
		session.close();
		return gate;
	}

	public Stations update(Stations gate, int id) {
		return null;
	}

	public Stations get(int id) {

		session = JdbcUtil.getSessionFactory().getCurrentSession();
		Transaction  transaction = session.beginTransaction();
		Stations temp = null;
		try {
        temp=session.get(Stations.class, id);
        transaction.commit();
		}
		catch (Exception e) {
			session.close();
			return null;
		}
		return temp;

	}

	public List<Stations> getAll() {
		session = JdbcUtil.getSessionFactory().getCurrentSession();
		Transaction  transaction = session.beginTransaction();
		List<Stations> temp = null;
		try {
		temp=session.createQuery("from Stations").list(); 
		}catch (Exception e) {
			 session.close();
		}
		transaction.commit();
		session.close();
		return temp;
	}


	public int delete(int id) {
		session = JdbcUtil.getSessionFactory().getCurrentSession();
		Transaction  transaction = session.beginTransaction();
		try
		{
		Stations temp=session.load(Stations.class, id);
		session.delete(temp);
		transaction.commit();
		}catch (Exception e) {
			session.close();
			return -1;
			
		}
		session.close();
		return id;
	}

}
