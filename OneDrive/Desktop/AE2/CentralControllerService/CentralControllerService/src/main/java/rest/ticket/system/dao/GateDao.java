package rest.ticket.system.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import rest.ticket.system.model.Gate;
import rest.ticket.system.services.GateServices;
import rest.ticket.system.utlities.JdbcUtil;
/*
 * Dao Layer
 * Hibernate session and Session factory is mainly used
 * All the crud operation of Gate is here
 */
public class GateDao{

	private Session session;
	public Gate save(Gate gate) {
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

	public Gate update(Gate gate, int id) {
		return null;
	}

	public Gate get(int id) {

		session = JdbcUtil.getSessionFactory().getCurrentSession();
		Transaction  transaction = session.beginTransaction();
		Gate temp = null;
		try {
        temp=session.get(Gate.class, id);
        transaction.commit();
		}
		catch (Exception e) {
			session.close();
			return null;
		}
		return temp;

	}

	public List<Gate> getAll() {
		session = JdbcUtil.getSessionFactory().getCurrentSession();
		Transaction  transaction = session.beginTransaction();
		List<Gate> temp = null;
		try {
		temp=session.createQuery("from Gate").list(); 
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
		Gate temp=session.load(Gate.class, id);
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
