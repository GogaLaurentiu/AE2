package rest.ticket.system.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import rest.ticket.system.model.TicketMachine;
import rest.ticket.system.utlities.JdbcUtil;
/*
 * Dao Layer
 * Hibernate session and Session factory is mainly used
 * All the crud operation of Machine is here
 */
public class TicketMachineDao {
	private Session session;
	public TicketMachine save(TicketMachine gate) {
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

	public TicketMachine update(TicketMachine ticket, int id) {
		return null;
	}

	public TicketMachine get(int id) {

		session = JdbcUtil.getSessionFactory().getCurrentSession();
		Transaction  transaction = session.beginTransaction();
		TicketMachine temp = null;
		try {
        temp=session.get(TicketMachine.class, id);
        transaction.commit();
		}
		catch (Exception e) {
			session.close();
			return null;
		}
		return temp;

	}

	public List<TicketMachine> getAll() {
		session = JdbcUtil.getSessionFactory().getCurrentSession();
		Transaction  transaction = session.beginTransaction();
		List<TicketMachine> temp = null;
		try {
		temp=session.createQuery("from TicketMachine").list(); 
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
		TicketMachine temp=session.load(TicketMachine.class, id);
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
