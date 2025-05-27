package in.smart.HibernateCrudOperations;



import java.util.List;

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
    
    	user.setName("Nakash");
    	user.setEmail("kask@gmail.com");
    	user.setPassword("kask@123");
    	user.setGender("male");
    	user.setCity("Delhi");
    	
      Configuration cfg =new Configuration();
      cfg.configure("/in/sp/config/hibernate.cfg.xml");
      
      SessionFactory sessionFactory=cfg.buildSessionFactory();
      Session session=sessionFactory.openSession();
      Transaction transaction=session.beginTransaction();
      
      //for selection
      
      try {
    	  // User user2=session.get(User.class, 4L);     this is used for specific row
    	  
    	  List<User> users = session.createQuery("from User", User.class).list();
    	  for (User user1 : users) {
    	        System.out.println(user1.getId() + " - " + user1.getName() + " - " + user1.getEmail()
    	        + " - " + user1.getPassword()+ " - " + user1.getGender()+ " - " + user1.getCity());
    	    }
    	  
    
      }
      catch(Exception e) {
    	  e.printStackTrace();
      }
      
      
      
    }
}
