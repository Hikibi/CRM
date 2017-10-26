package com.lanou.hrd.dao.impl;

import com.lanou.hrd.dao.StaffDao;
import com.lanou.hrd.domain.Crm_staff;
import com.lanou.hrd.domain.PageBean;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by dllo on 17/10/24.
 */
public class StaffDaoImpl extends BaseDaoImpl<Crm_staff> implements StaffDao {


    @Override
    public boolean login(String loginName, String loginPwd) {

        Object[] params = {loginName, loginPwd};

        List<Crm_staff> crm_staffs =
                (List<Crm_staff>) getHibernateTemplate().find("from Crm_staff where loginName=? and loginPwd=?", params);

        return crm_staffs.size() > 0;
    }

    public int count(){
//        Session session = currentSession();
        return getHibernateTemplate().find("from Crm_staff ").size();

    }

//    分页查询
    public PageBean<Crm_staff> findAll(int pc, int ps){

//        创建pb
        PageBean<Crm_staff> pb = new PageBean<>();

//			设置 pc, ps
        pb.setPc(pc);
        pb.setPs(ps);

        Session session = currentSession();

//			得到 tr, 总记录数
        int tr = count();
        pb.setTr(tr);

        Query query = session.createQuery("from Crm_staff ");

        query.setFirstResult(((pc - 1) * ps));
        query.setMaxResults((pc * ps));

        List<Crm_staff> crm_staffs = query.list();

        pb.setBeanList(crm_staffs);

        return pb;

    }



}
