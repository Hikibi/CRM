package com.lanou.hrd.action;

import com.lanou.hrd.domain.Crm_post;
import com.lanou.hrd.service.PostService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/10/25.
 */
@Controller("postAction")
@Scope("prototype")
public class PostAction extends ActionSupport {

    private String postName;
    private String depId;

    @Resource
    private PostService postService;

    public String addPost(){

        Crm_post crm_post = new Crm_post(postName);

        postService.addDepart(crm_post);

        return SUCCESS;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }
}
