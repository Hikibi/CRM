package com.lanou.HRD.dao.impl;

import com.lanou.HRD.dao.DepartmentDao;
import com.lanou.HRD.domain.Crm_department;
import org.hibernate.Query;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
public class DepartmentDaoImpl extends BaseDaoImpl<Crm_department> implements DepartmentDao {


    /**
     * 添加部门
     * @param crm_department 部门内容
     */
    public void addDepart(Crm_department crm_department){

        Serializable save = getHibernateTemplate().save(crm_department);

    }


    public List<Crm_department> findAll(){

        System.out.println("11");

        Session session = currentSession();

        Query query = session.createQuery("from Crm_department");

        List<Crm_department> list = query.list();

//        List<Crm_department> list = (List<Crm_department>) getHibernateTemplate().find("from Crm_department");

        return list;

    }

}
