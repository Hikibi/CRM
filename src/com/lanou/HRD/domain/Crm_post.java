package com.lanou.HRD.domain;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by dllo on 17/10/24.
 */
@Component
public class Crm_post {

    private String postId;
    private String postName;
    private Crm_department crm_department;

    private List<Crm_staff> staffs;

    public List<Crm_staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Crm_staff> staffs) {
        this.staffs = staffs;
    }

    public Crm_post(String postName) {
        this.postName = postName;
    }

    public Crm_post(String postName, Crm_department crm_department) {
        this.postName = postName;
        this.crm_department = crm_department;
    }

    public Crm_post(String postId, String postName, Crm_department crm_department) {
        this.postId = postId;
        this.postName = postName;
        this.crm_department = crm_department;
    }

    public Crm_post() {
    }

    @Override
    public String toString() {
        return "Crm_post{" +
                "postId='" + postId + '\'' +
                ", postName='" + postName + '\'' +
                ", crm_department=" + crm_department +
                '}';
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Crm_department getCrm_department() {
        return crm_department;
    }

    public void setCrm_department(Crm_department crm_department) {
        this.crm_department = crm_department;
    }
}
