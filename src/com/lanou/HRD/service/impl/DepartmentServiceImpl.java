package com.lanou.HRD.service.impl;

import com.lanou.HRD.dao.DepartmentDao;
import com.lanou.HRD.domain.Crm_department;
import com.lanou.HRD.service.DepartmentService;
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
        departmentDao.addDepart(crm_department);
    }

    @Override
    public List<Crm_department> findAll() {
        return departmentDao.findAll();
    }

}
