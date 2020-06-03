package by.epam.hotelreservation.dao;

import by.epam.hotelreservation.domain.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.ArrayList;
public class ClientsDAO{

    final static Logger log = LogManager.getLogger(ClientsDAO.class);

    public void clientAdding(Client c1) throws IOException {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(c1);
        tx1.commit();
        session.close();
        log.info("Client was added.");
    }

    public ArrayList clientReading() throws IOException {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        ArrayList<Client> clients = (ArrayList<Client>) session.createQuery("from Client ").list();
        log.info("Clients was obtained.");
        return clients;
    }

    public Client clientReading(String relogin){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        log.info("Client was obtained.");
        return session.get(Client.class, relogin);
    }

    public void clientUpdating(Client client1) throws IOException {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(client1);
        tx1.commit();
        session.close();
        log.info("Client was updated.");
    }

    public void clientDeleting(Client client){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(client);
        tx1.commit();
        session.close();
        log.info("Client was deleted.");
    }
}
