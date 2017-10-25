package com.lanou.HRD.action;

import com.lanou.HRD.domain.Crm_department;
import com.lanou.HRD.service.DepartmentService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends ActionSupport {

    @Resource
    private DepartmentService departmentService;

    private String depName;


    /**
     * 添加部门
     */
    public String addDepart(){

        System.out.println(depName);

        Crm_department crm_department = new Crm_department(depName);

        departmentService.addDepart(crm_department);

        return SUCCESS;
    }

    private List<Crm_department> departments;

    /**
     * 查询部门
     */
    public String findAll(){

        departments = departmentService.findAll();

        return SUCCESS;
    }

    public DepartmentService getDepartmentService() {
        return departmentService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }
}
