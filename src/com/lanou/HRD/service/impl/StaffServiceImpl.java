package com.lanou.HRD.service.impl;

import com.lanou.HRD.dao.StaffDao;
import com.lanou.HRD.domain.Crm_staff;
import com.lanou.HRD.domain.PageBean;
import com.lanou.HRD.service.StaffService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/10/24.
 */
@Service("staffService")
public class StaffServiceImpl implements StaffService {

    @Resource
    private StaffDao staffDao;

    @Override
    public boolean login(String loginName, String loginPwd) {
        return staffDao.login(loginName, loginPwd);
    }

    @Override
    public PageBean<Crm_staff> findAll(int pc, int ps) {
        return staffDao.findAll(pc, ps);
    }
}
