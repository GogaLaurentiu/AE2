package rest.ticket.system.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import rest.ticket.system.model.Zone;
import rest.ticket.system.services.ZoneServices;
import rest.ticket.system.utlities.JdbcUtil;
/*
 * Dao Layer
 * Hibernate session and Session factory is mainly used
 * All the crud operation of Zone is here
 */
public class ZoneDao {

	private Session session;
	public Zone save(Zone gate) {
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

	public Zone update(Zone gate, int id) {
		return null;
	}

	public Zone get(int id) {

		session = JdbcUtil.getSessionFactory().getCurrentSession();
		Transaction  transaction = session.beginTransaction();
		Zone temp = null;
		try {
        temp=session.get(Zone.class, id);
        transaction.commit();
		}
		catch (Exception e) {
			session.close();
			return null;
		}
		return temp;

	}

	public List<Zone> getAll() {
		session = JdbcUtil.getSessionFactory().getCurrentSession();
		Transaction  transaction = session.beginTransaction();
		List<Zone> temp = null;
		try {
		temp=session.createQuery("from Zone").list(); 
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
		Zone temp=session.load(Zone.class, id);
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
