package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ClientDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // Insert records
        Client client1 = new Client();
        client1.setName("John Doe");
        client1.setGender("Male");
        client1.setAge(30);
        client1.setLocation("New York");
        client1.setEmailAddress("johndoe@example.com");
        client1.setMobileNumber("1234567890");

        Client client2 = new Client();
        client2.setName("Jane Smith");
        client2.setGender("Female");
        client2.setAge(25);
        client2.setLocation("Los Angeles");
        client2.setEmailAddress("janesmith@example.com");
        client2.setMobileNumber("0987654321");

        session.save(client1);
        session.save(client2);

        // Commit transaction
        tx.commit();

        // Fetch and display all records
        List<Client> clients = session.createQuery("from Client", Client.class).list();
        for (Client c : clients) {
            System.out.println(c);
        }

        session.close();
        factory.close();
    }
}
