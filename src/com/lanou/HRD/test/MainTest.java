package com.lanou.HRD.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by dllo on 17/10/24.
 */
public class MainTest {

    private SessionFactory sessionFactory;

    @Test
    public void test(){
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
    }

}
