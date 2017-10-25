package com.lanou.HRD.service;

import com.lanou.HRD.domain.Crm_staff;
import com.lanou.HRD.domain.PageBean;

/**
 * Created by dllo on 17/10/24.
 */
public interface StaffService {

    boolean login(String loginName, String loginPwd);

    PageBean<Crm_staff> findAll(int pc, int ps);

}
