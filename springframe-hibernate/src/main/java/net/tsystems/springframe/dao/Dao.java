package net.tsystems.springframe.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;

import javax.persistence.EntityManager;

public interface Dao {

    Session getEntityManager();


}
