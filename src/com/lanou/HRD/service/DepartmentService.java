package com.lanou.HRD.service;

import com.lanou.HRD.domain.Crm_department;

import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
public interface DepartmentService {

    void addDepart(Crm_department crm_department);

    List<Crm_department> findAll();

}
