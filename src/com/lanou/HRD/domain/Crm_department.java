package com.lanou.HRD.domain;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by dllo on 17/10/24.
 */
@Component
public class Crm_department {

    private String depID;
    private String depName;

//    public Crm_department(String depID, String depName, List<Crm_post> posts) {
//        this.depID = depID;
//        this.depName = depName;
//        this.posts = posts;
//    }

    private List<Crm_post> posts;

    public List<Crm_post> getPosts() {
        return posts;
    }

    public void setPosts(List<Crm_post> posts) {
        this.posts = posts;
    }

    public Crm_department(String depID, String depName) {
        this.depID = depID;
        this.depName = depName;
    }

    public Crm_department(String depName) {
        this.depName = depName;
    }

    public Crm_department() {
    }

    @Override
    public String toString() {
        return "Crm_department{" +
                "depID='" + depID + '\'' +
                ", depName='" + depName + '\'' +
                '}';
    }

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }
}
