package com.lanou.hrd.service.impl;

import com.lanou.hrd.dao.PostDao;
import com.lanou.hrd.domain.Crm_post;
import com.lanou.hrd.service.PostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/10/25.
 */
@Service("postService")
public class PostServiceImpl implements PostService {

    @Resource
    private PostDao postDao;

    @Override
    public void addDepart(Crm_post crm_post) {
        postDao.addPost(crm_post);
    }
}
