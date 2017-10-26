package com.lanou.hrd.service.impl;

import com.lanou.hrd.dao.StaffDao;
import com.lanou.hrd.domain.Crm_staff;
import com.lanou.hrd.domain.PageBean;
import com.lanou.hrd.service.StaffService;
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

    @Override
    public void add(Crm_staff crm_staff) {
        staffDao.add(crm_staff);
    }


}
