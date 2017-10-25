package com.lanou.HRD.dao.impl;

import com.lanou.HRD.dao.StaffDao;
import com.lanou.HRD.domain.Crm_staff;
import com.lanou.HRD.domain.PageBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

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
//        List list = query.list();

        query.setFirstResult(((pc - 1) * ps));
        query.setMaxResults((pc * ps));


//        for (Object o : query.list()) {
//            System.out.println(o);
//        };
//        System.out.println(tr);
//        List<Crm_staff> staff = query.list();
//        for (Crm_staff s : staff) {
//            System.out.println(s);
//
//        }

//        System.out.println(query.list());


        List<Crm_staff> crm_staffs = query.list();

        pb.setBeanList(crm_staffs);

        return pb;

    }



}
