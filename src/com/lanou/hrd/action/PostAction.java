package com.lanou.hrd.action;

import com.lanou.hrd.domain.Crm_department;
import com.lanou.hrd.domain.Crm_post;
import com.lanou.hrd.domain.PageBean;
import com.lanou.hrd.service.DepartmentService;
import com.lanou.hrd.service.PostService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
@Controller("postAction")
@Scope("prototype")
public class PostAction extends ActionSupport {

    private String postName;
    private String postId;
    private String department;

    @Resource
    private PostService postService;

    @Resource
    private DepartmentService departmentService;

    public String addPost() {

        Crm_post post = postService.findSingle(postName);

        if (post != null) {

            addActionError("添加职务名称相同, 请重新填写");

            return INPUT;

        } else {

            if (!StringUtils.isEmpty(postId)) {

                Crm_post po = postService.findID(postId);

                po.setPostName(postId);

                postService.postUpdate(po);

            } else {

                Crm_department depart = departmentService.findID(department);

                Crm_post crm_post = new Crm_post(postName, depart);

                postService.addDepart(crm_post);

            }

            return SUCCESS;
        }
    }


    public void validateAddPost() {

        if (StringUtils.isEmpty(postName)) {
            addActionError("添加职务名称不能为空, 请重新填写");
        }

    }


    private List<Crm_post> posts;

    /**
     * 查询所有职务
     */
    public String findAll() {

        posts = postService.findAll();

        return SUCCESS;
    }


    /**
     * 用 id查询 职务信息
     */
    public String IdPost() {

        Crm_post Crm_post = postService.findID(postId);

        System.out.println(Crm_post);

        return SUCCESS;
    }


    PageBean<Crm_post> pd;

    /**
     * 分页查询所有职务
     */
    public String findPaging() {

//        获得 当前页码数
        int pc = getPc();
//        指定 每页的记录数
        int ps = 10;
//        传递 pc, ps 获得 pageBean
        pd = postService.findPaging(pc, ps);

//        List<Crm_post> beanList = pd.getBeanList();
//
//        for (Crm_post c : beanList) {
//            System.out.println(c);
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

        System.out.println(value);

        if (value == null || value.trim().isEmpty()) {
            return 1;
        }
        return Integer.parseInt(value);
    }


    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Crm_post> getPosts() {
        return posts;
    }

    public void setPosts(List<Crm_post> posts) {
        this.posts = posts;
    }

    public PageBean<Crm_post> getPd() {
        return pd;
    }

    public void setPd(PageBean<Crm_post> pd) {
        this.pd = pd;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }
}
