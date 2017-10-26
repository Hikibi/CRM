package com.lanou.hrd.service.impl;

import com.lanou.hrd.dao.DepartmentDao;
import com.lanou.hrd.domain.Crm_department;
import com.lanou.hrd.domain.PageBean;
import com.lanou.hrd.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentDao departmentDao;

    public void addDepart(Crm_department crm_department){
        departmentDao.add(crm_department);
    }

    @Override
    public List<Crm_department> findAll() {

        String hql = "from Crm_department";

        return departmentDao.findAll(hql);
    }

    @Override
    public PageBean<Crm_department> findPaging(int pc, int ps) {

        String hql = "from Crm_department";

        return departmentDao.findPaging(pc, ps, hql);
    }

}
