package com.lanou.hrd.action;

import com.lanou.hrd.domain.Crm_department;
import com.lanou.hrd.domain.PageBean;
import com.lanou.hrd.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

    public void addDepartLogin() {
        if (StringUtils.isEmpty(depName)) {
            addActionError("添加部门名称不能为空, 请重新填写");
        }
    }

    private List<Crm_department> departments;

    /**
     * 查询所有部门
     */
    public String findAll(){

        departments = departmentService.findAll();

        for (Crm_department department : departments) {
            System.out.println(department);
        }


        return SUCCESS;
    }

    PageBean<Crm_department> pd;

    /**
     * 分页查询所有部门
     */
    public String findPaging(){

//        HttpServletRequest req = (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);

//        获得 当前页码数
        int pc = getPc();
//        指定 每页的记录数
        int ps = 10;
//        传递 pc, ps 获得 pageBean
        pd = departmentService.findPaging(pc, ps);

//        List<Crm_department> beanList = pd.getBeanList();

//        pd.setUrl(req.getParameter("method"));

//        depName = "sss";


//        for (Crm_department c : beanList) {
//
//            System.out.println(c);
//
//            System.out.println(c.getDepName());
//
//        }

        return SUCCESS;
    }

    //    pc : 页数
    private String pc;

    private int getPc() {
		/*
			1. 得到 pageCode
				> 如果 pc 参数不存在, pc = 1
				> 如果 pc 参数存在, 转成 int 类型
		 */

        String value = pc;
        if (value == null || value.trim().isEmpty()) {
            return 1;
        }
        return Integer.parseInt(value);
    }

    public PageBean<Crm_department> getPd() {
        return pd;
    }

    public void setPd(PageBean<Crm_department> pd) {
        this.pd = pd;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public List<Crm_department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Crm_department> departments) {
        this.departments = departments;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }
}
