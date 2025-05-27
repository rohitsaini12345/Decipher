package in.smart.HibernateCrudOperations;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import n.sp.entities.User;

public class App 
{
    public static void main( String[] args )
    {
    	User user=new User();
    
    	user.setName("Aayush");
    	user.setEmail("aayush@gmail.com");
    	user.setPassword("Aayush@123");
    	user.setGender("male");
    	user.setCity("Patna");
    	
      Configuration cfg =new Configuration();
      cfg.configure("/in/sp/config/hibernate.cfg.xml");
      
      SessionFactory sessionFactory=cfg.buildSessionFactory();
      Session session=sessionFactory.openSession();
      Transaction transaction=session.beginTransaction();
      
      //------for insertion
      
      try {
    	  session.save(user);
          transaction.commit();
      }
      catch(Exception e) {
    	  transaction.rollback();
    	  e.printStackTrace();
      }
      
      
      
    }
}
