package com.lanou.hrd.service;

import com.lanou.hrd.domain.Crm_staff;
import com.lanou.hrd.domain.PageBean;

/**
 * Created by dllo on 17/10/24.
 */
public interface StaffService {

    boolean login(String loginName, String loginPwd);

    PageBean<Crm_staff> findAll(int pc, int ps);

    void add(Crm_staff crm_staff);

}
