package by.epam.hotelreservation.dao;

import by.epam.hotelreservation.domain.Administrator;
import by.epam.hotelreservation.domain.Client;
import by.epam.hotelreservation.domain.Request;
import by.epam.hotelreservation.domain.Room;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Administrator.class);
                configuration.addAnnotatedClass(Client.class);
                configuration.addAnnotatedClass(Request.class);
                configuration.addAnnotatedClass(Room.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}
