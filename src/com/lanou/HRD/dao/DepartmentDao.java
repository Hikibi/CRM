package com.lanou.HRD.dao;

import com.lanou.HRD.domain.Crm_department;

import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
public interface DepartmentDao {

    void addDepart(Crm_department crm_department);

    List<Crm_department> findAll();

}
