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
    	User user2=new User();
    
    	user2.setName("Nakash");
    	user2.setEmail("kask@gmail.com");
    	user2.setPassword("kask@123");
    	user2.setGender("male");
    	user2.setCity("Delhi");
    	
      Configuration cfg =new Configuration();
      cfg.configure("/in/sp/config/hibernate.cfg.xml");
      
      SessionFactory sessionFactory=cfg.buildSessionFactory();
      Session session=sessionFactory.openSession();
      Transaction transaction=session.beginTransaction();
      
      // for update
      
      try {
    	  User user=session.get(User.class, 3L);
    	  user.setCity("banglore");
    	  
    	  session.saveOrUpdate(user);
    	  transaction.commit();
    	  
    	  System.out.println("User details updated successfully");
      }
      catch(Exception e) {
    	  transaction.rollback();
    	  e.printStackTrace();
    	  System.out.println("User details not updated successfully");
      }
      
      
     
    }
}
