package by.epam.hotelreservation.dao;

import by.epam.hotelreservation.domain.Room;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RoomsDAO{

    final static Logger log = LogManager.getLogger(RoomsDAO.class);

    public void roomAdding(Room r1) throws IOException {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(r1);
        tx1.commit();
        session.close();
        log.info("Room was added.");
}

    public List roomReading() throws IOException {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        ArrayList<Room> rooms = (ArrayList<Room>) session.createQuery("from Room").list();
        log.info("Rooms was obtained.");
        return rooms;
    }

    public void roomDeleting(Room room) throws IOException {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(room);
        tx1.commit();
        session.close();
        log.info("Room was deleted.");
    }
}
