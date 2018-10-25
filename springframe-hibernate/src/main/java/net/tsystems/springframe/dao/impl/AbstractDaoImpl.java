package net.tsystems.springframe.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import net.tsystems.springframe.SessionService;
import net.tsystems.springframe.dao.AbstractDao;
import net.tsystems.springframe.dao.Dao;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractDaoImpl<PK extends Serializable, T> implements Dao, AbstractDao<PK, T> {
    private final Class<T> persistentClass;

    //@Autowired
    //private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public AbstractDaoImpl()
    {
        this.persistentClass = (Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    public Session getSession()
    {
        return SessionService.getSession();
       // return sessionFactory.getCurrentSession();

    }




    @SuppressWarnings("unchecked")
    public T getById(PK id)
    {
        return (T)getSession().get(persistentClass, id);
    }

    @Transactional
    public void create(T entity)
    {
        Session session = getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        }
        catch (Exception ex) {
            if (transaction != null)
                transaction.rollback();
        }
        finally {
            session.close();
        }
    }

    @Transactional
    public void update(T entity)
    {
        Session session = getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        }
        catch (Exception ex) {
            if (transaction != null)
                transaction.rollback();
        }
        finally {
            session.close();
        }
    }

    @Transactional
    public void delete(T entity)
    {
        Session session = getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        }
        catch (Exception ex) {
            if (transaction != null)
                transaction.rollback();
        }
        finally {
            session.close();
        }

    }


    public Criteria getCriteria() {
        return getSession().createCriteria(persistentClass);
    }

    public Query createEntityQuery(String hsql)
    {
        return getSession().createQuery(hsql);
    }



}
