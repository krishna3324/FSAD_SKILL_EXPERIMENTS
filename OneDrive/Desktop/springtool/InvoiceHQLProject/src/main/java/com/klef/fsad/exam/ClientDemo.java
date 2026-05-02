package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class ClientDemo 
{
    public static void main(String[] args) 
    {
        // Create SessionFactory
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // Insert Records
        Transaction tx = session.beginTransaction();

        Invoice i1 = new Invoice("Invoice1", new Date(), "Paid", 1000);
        Invoice i2 = new Invoice("Invoice2", new Date(), "Pending", 2000);

        session.save(i1);
        session.save(i2);

        tx.commit();

        // HQL Query (View all records using positional parameter)
        session.beginTransaction();

        Query<Invoice> query = session.createQuery("from Invoice where 1=?1", Invoice.class);
        query.setParameter(1, 1);

        List<Invoice> list = query.list();

        System.out.println("----- Invoice Records -----");

        for(Invoice inv : list)
        {
            System.out.println(
                inv.getId() + " | " +
                inv.getName() + " | " +
                inv.getDate() + " | " +
                inv.getStatus() + " | " +
                inv.getAmount()
            );
        }

        session.getTransaction().commit();

        session.close();
        factory.close();
    }
}