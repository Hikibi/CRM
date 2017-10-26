package com.lanou.hrd.action;

import com.lanou.hrd.domain.Crm_staff;
import com.lanou.hrd.domain.PageBean;
import com.lanou.hrd.service.StaffService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by dllo on 17/10/24.
 */
@Controller("staffAction")
@Scope("prototype")
public class StaffAction extends ActionSupport {

    @Resource
    private StaffService staffService;

//    登录名
    private String loginName;
//    登录密码
    private String loginPwd;
//    姓名
    private String staffName;
//    性别
    private String gender;
//    入职时间
    private Date onDutyDate;
//    所属部门
//    private String crmPost.crmDepartment.depId;


    public String login() {
        if (staffService.login(loginName, loginPwd)) {
            return SUCCESS;
        } else {
            addActionError("用户名或密码错误");
            return ERROR;
        }
    }

    public void validateLogin() {
        if (StringUtils.isEmpty(loginName) || StringUtils.isEmpty(loginPwd)) {

            System.out.println(loginName);
            System.out.println(loginPwd);

            addActionError("用户名或密码不能为空, 请重新登录");
        }
    }




    /**
     * 添加学生
     */
    public String addStaff(){

        Crm_staff crm_staff = new Crm_staff(loginName, loginPwd, staffName, gender, onDutyDate);

        staffService.add(crm_staff);

        return SUCCESS;
    }


    private PageBean<Crm_staff> pd;

//    分页查询全部
    public String findAll(){

//        获得 当前页码数
        int pc = getPc();
//        指定 每页的记录数
        int ps = 10;
//        传递 pc, ps 获得 pageBean
        pd = staffService.findAll(pc, ps);

        pd.getBeanList().size();

        List<Crm_staff> beanList = pd.getBeanList();
//
//        for (Crm_staff c : beanList) {
//            System.out.println(c.getCrm_post());
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

    public PageBean<Crm_staff> getPd() {
        return pd;
    }

    public void setPd(PageBean<Crm_staff> pd) {
        this.pd = pd;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getOnDutyDate() {
        return onDutyDate;
    }

    public void setOnDutyDate(Date onDutyDate) {
        this.onDutyDate = onDutyDate;
    }
}
