package com.lanou.HRD.action;

import com.lanou.HRD.domain.Crm_staff;
import com.lanou.HRD.service.StaffService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/10/24.
 */
@Controller("loginAction")
@Scope("prototype")
public class StaffAction extends ActionSupport {

    @Resource
    private StaffService staffService;

    private String loginName;
    private String loginPwd;

    public String login() {
        if (staffService.login(loginName, loginPwd)) {
            System.out.println("11");
            return SUCCESS;
        } else {
            System.out.println("aa");
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
}
