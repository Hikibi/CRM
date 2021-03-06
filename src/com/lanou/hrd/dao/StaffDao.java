package com.lanou.hrd.dao;

import com.lanou.hrd.domain.Crm_staff;
import com.lanou.hrd.domain.PageBean;


/**
 * Created by dllo on 17/10/24.
 */
public interface StaffDao extends BaseDao<Crm_staff> {

    boolean login(String loginName, String loginPwd);

    PageBean<Crm_staff> findAll(int pc, int ps);

}
