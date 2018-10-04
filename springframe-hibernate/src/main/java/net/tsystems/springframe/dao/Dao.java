package net.tsystems.springframe.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;

public interface Dao {

    //TODO: getEntityManager must have return - EntityManager
    //public void getEntityManager();
    //public void setEntityManager();

    //Session getSession();
    Session getEntityManager();

}
