package rest.ticket.system.utlities;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import rest.ticket.system.model.Employee;
import rest.ticket.system.model.Gate;
import rest.ticket.system.model.Stations;
import rest.ticket.system.model.TicketMachine;
import rest.ticket.system.model.Zone;

public class JdbcUtil {

	 private static StandardServiceRegistry registry;
	 private static SessionFactory sessionFactory;

	   public static SessionFactory getSessionFactory() {
	      if (sessionFactory == null) {
	         try {
	        	// ResourceBundle bundle = ResourceBundle.getBundle("dbConfig");
	            // String url = bundle.getString("url");
	        	 Configuration configuration = new Configuration()
	        			 	.addAnnotatedClass(Employee.class)
	        			 	.addAnnotatedClass(Gate.class)
	        			 	.addAnnotatedClass(Zone.class)
	        			 	.addAnnotatedClass(TicketMachine.class)
	        			 	.addAnnotatedClass(Stations.class)
	        		        .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect")
	        		        .setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
	        		        .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/ticketSystem")
	        		        .setProperty("hibernate.connection.username", "root")
	        		        .setProperty("hibernate.connection.password", "")
	        		        .setProperty("hibernate.hbm2ddl.auto", "create")
	        		        .setProperty("hibernate.temp.use_jdbc_metadata_defaults", "false")
	        		        .setProperty("hibernate.show_sql", "true")
	        		        .setProperty("hibernate.current_session_context_class", "thread");
	    
	        		    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	        		        .applySettings(configuration.getProperties())
	        		        .build();
	        		    
	        		    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	           
	

	         } catch (Exception e) {
	            e.printStackTrace();
	            if (registry != null) {
	               StandardServiceRegistryBuilder.destroy(registry);
	            }
	         }
	      }
	      return sessionFactory;
	   }

	   public static void shutdown() {
	      if (registry != null) {
	         StandardServiceRegistryBuilder.destroy(registry);
	      }
	   }
}
