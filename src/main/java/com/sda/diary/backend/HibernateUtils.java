package com.sda.diary.backend;

import com.sda.diary.config.HibernateConfig;
import org.hibernate.SessionFactory;

import java.util.logging.Level;

public class HibernateUtils {

  private final static SessionFactory sessionFactory;

  static {
    java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
    sessionFactory = HibernateConfig.getSessionFactory();
  }

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }
}


