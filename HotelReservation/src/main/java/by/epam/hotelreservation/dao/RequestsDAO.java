package by.epam.hotelreservation.dao;

import by.epam.hotelreservation.domain.Request;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.ArrayList;

public class RequestsDAO{

    final static Logger log = LogManager.getLogger(RequestsDAO.class);

    public void requestAdding(Request r1) throws IOException {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(r1);
        tx1.commit();
        session.close();
        log.info("Request was added.");
    }

    public ArrayList requestReading() throws IOException {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        ArrayList<Request> requests = (ArrayList<Request>) session.createQuery("from Request").list();
        log.info("Requests was obtained.");
        return requests;
    }

    public Request requestReading(int requestId){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        log.info("Request was obtained.");
        return session.get(Request.class, requestId);
    }

    public void requestUpdating(Request request) throws IOException {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(request);
        tx1.commit();
        session.close();
        log.info("Request was updated.");
    }

    public void requestDeleting(Request request) throws IOException {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(request);
        tx1.commit();
        session.close();
        log.info("Request was deleted.");
    }
}
