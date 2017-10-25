package com.lanou.HRD.test;

import com.lanou.HRD.dao.StaffDao;
import com.lanou.HRD.domain.Crm_department;
import com.lanou.HRD.domain.Crm_post;
import com.lanou.HRD.domain.Crm_staff;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by dllo on 17/10/24.
 */
public class MainTest extends HibernateDaoSupport {
    private ApplicationContext context;
    //
//    private SessionFactory sessionFactory;
//
//    @Test
//    public void test(){
//        Session session = sessionFactory.getCurrentSession();
//        Transaction transaction = session.beginTransaction();
//    }

    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("spring-config.xml");
    }

    @Test
    public void test(){
        StaffDao staffDao= (StaffDao) context.getBean("staffDao");
        System.out.println(staffDao.login("1", "1"));
    }

    @Test
    public void pb(){
        StaffDao staffDao = (StaffDao) context.getBean("staffDao");
        staffDao.findAll(1, 10);
    }


    @Test
    public void add(){

//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


        Date date = new Date();

        Crm_department department = new Crm_department("2", "轻音部");

        getHibernateTemplate().save(department);

        Crm_post post = new Crm_post("2", "偶像");

        department.getPosts().add(post);

        Crm_staff staff = new Crm_staff("小黑", "小黑", "小黑", "小黑", date);

        post.getStaffs().add(staff);

//        getHibernateTemplate().save(department);


    }

}
