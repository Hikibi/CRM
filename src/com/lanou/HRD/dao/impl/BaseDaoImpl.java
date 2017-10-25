package com.lanou.HRD.dao.impl;

import com.lanou.HRD.dao.BaseDao;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/25.
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

    @Override
    public void add(Class<T> tClass) {
        getHibernateTemplate().save(tClass);
    }

    @Override
    public T findById(Serializable id, Class<T> tClass) {

        Session session = currentSession();

        T t = (T) session.get(tClass, id);

        return t;

    }

    @Override
    public List<T> findAll(String hql) {

        List<T> tList = (List<T>) getHibernateTemplate().find(hql);

        return tList;
    }

    @Override
    public List<T> find(String hql, Map<String, Object> params) {

        List<T> tList = (List<T>) getHibernateTemplate().find(hql, params);

        return tList;
    }

    @Override
    public T findSingle(String hql, Map<String, Object> params) {

        List<T> tList = (List<T>) getHibernateTemplate().find(hql, params);

        if (tList.size() > 0){
            return tList.get(0);
        }

        return null;
    }
}
