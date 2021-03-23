package com.sda.diary.backend;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import java.util.List;

public class EntryRepository {
    public Entry saveEntry(Entry entry) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(entry);
        transaction.commit();
        session.close();
        return entry;
    }

    public List<Entry> readAllEntries() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Entry> entries = session.createQuery("FROM Entry").getResultList();
        transaction.commit();
        session.close();
        return entries;
    }
}
