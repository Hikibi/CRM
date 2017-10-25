package com.lanou.HRD.dao.impl;

import com.lanou.HRD.dao.StaffDao;
import com.lanou.HRD.domain.Crm_staff;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by dllo on 17/10/24.
 */
public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao {


    @Override
    public boolean login(String loginName, String loginPwd) {

        Object[] params = {loginName, loginPwd};

        List<Crm_staff> crm_staffs =
                (List<Crm_staff>) getHibernateTemplate().find("from Crm_staff where loginName=? and loginPwd=?", params);

        return crm_staffs.size() > 0;
    }

}
