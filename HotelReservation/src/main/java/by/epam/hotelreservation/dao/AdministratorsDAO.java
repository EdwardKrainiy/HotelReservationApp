package by.epam.hotelreservation.dao;


import by.epam.hotelreservation.domain.Administrator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.ArrayList;

public class AdministratorsDAO{

final static Logger log = LogManager.getLogger(AdministratorsDAO.class);

    public void adminAdding(Administrator a1) throws IOException {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(a1);
        tx1.commit();
        session.close();
        log.info("Administrator was added.");
    }

    public ArrayList<Administrator> adminReading() throws IOException {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        ArrayList<Administrator> administrators = (ArrayList<Administrator>) session.createQuery("from Administrator").list();
        log.info("Administrators was obtained.");
        return administrators;
    }

    public Administrator adminReading(String relogin){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        log.info("Administrator was obtained");
        return session.get(Administrator.class, relogin);
    }

    public void adminUpdating(Administrator administrator) throws IOException{
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(administrator);
        tx1.commit();
        session.close();
        log.info("Administrators was updated.");
    }

    public void adminDeleting(Administrator administrator){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(administrator);
        tx1.commit();
        session.close();
        log.info("Administrators was deleted.");
    }
}
