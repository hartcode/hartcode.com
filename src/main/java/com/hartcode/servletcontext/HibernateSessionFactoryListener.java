package com.hartcode.servletcontext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;  

import org.hibernate.Session;

import com.hartcode.libyeast.hibernate.HibernateUtil;
  
 
  
public class HibernateSessionFactoryListener implements ServletContextListener {  
      
    @Override  
    public void contextInitialized(ServletContextEvent arg0) {  
          
        Session session = HibernateUtil.getSessionFactory().openSession();  
        session.beginTransaction();  
    }  
  
    @Override  
    public void contextDestroyed(ServletContextEvent arg0) {  
        HibernateUtil.shutdown();         
    }  
}  