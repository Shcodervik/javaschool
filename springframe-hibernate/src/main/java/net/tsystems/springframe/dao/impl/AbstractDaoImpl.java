package net.tsystems.springframe.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import net.tsystems.springframe.SessionService;
import net.tsystems.springframe.dao.AbstractDao;
import net.tsystems.springframe.dao.Dao;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractDaoImpl<PK extends Serializable, T> implements Dao, AbstractDao<PK, T> {
    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public AbstractDaoImpl()
    {
        this.persistentClass = (Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    /*@Autowired
    @Qualifier("SessionService")
    private SessionService sessionService;*/

    public Session getSession()
    {
        return SessionService.getSession();
    }

    @SuppressWarnings("unchecked")
    public T getById(PK id)
    {
        return (T)getSession().get(persistentClass, id);
    }

    @Transactional
    public void create(T entity)
    {
        getSession().persist(entity);
    }

    @Transactional
    public void update(T entity)
    {
        getSession().update(entity);
    }

    @Transactional
    public void delete(T entity)
    {
        getSession().delete(entity);
    }

    public Criteria getCriteria()
    {
        return getSession().createCriteria(persistentClass);
    }

    public Query createEntityQuery(String hsql)
    {
        return getSession().createQuery(hsql);
    }



}
