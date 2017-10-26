package com.lanou.hrd.test;

import com.lanou.hrd.dao.DepartmentDao;
import com.lanou.hrd.dao.StaffDao;
import com.lanou.hrd.domain.Crm_department;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by dllo on 17/10/24.
 */
public class MainTest {
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
    public void init() {
        context = new ClassPathXmlApplicationContext("spring-config.xml");
    }

    @Test
    public void test() {
        StaffDao staffDao = (StaffDao) context.getBean("staffDao");
        System.out.println(staffDao.login("1", "1"));
    }

    @Test
    public void pb() {
        StaffDao staffDao = (StaffDao) context.getBean("staffDao");
        staffDao.findAll(1, 10);
    }


    @Test
    public void add() {
        Crm_department department = new Crm_department();
        department.setDepName("教学部");

        DepartmentDao departmentDao = (DepartmentDao) context.getBean("departmentDao");
        departmentDao.add(department);

        List<Crm_department> departments = departmentDao.findAll("from Crm_department");
        for (Crm_department crm_department : departments) {
            System.out.println(crm_department);
        }

//        getHibernateTemplate().save(department);
//
//        Crm_post post = new Crm_post("2", "偶像");
//
//        department.getPosts().add(post);
//
//        Crm_staff staff = new Crm_staff("小黑", "小黑", "小黑", "小黑", date);
//
//        post.getStaffs().add(staff);

//        getHibernateTemplate().save(department);


    }

}
