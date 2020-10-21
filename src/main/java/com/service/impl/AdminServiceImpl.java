package com.service.impl;

import com.entity.Admin;
import com.entity.CommentInfo;
import com.entity.User;
import com.entity.WorksInfo;
import com.mapper.AdminMapper;
import com.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;


    @Override
    public Admin selectAdmin(Admin admin) {
        return adminMapper.selectAdmin(admin);
    }

    @Override
    public List<WorksInfo> selectAllWorksInfo() {
        return adminMapper.selectAllWorksInfo();
    }

    @Override
    public Integer deleteWorkByWorkId(Integer workId) {
        return adminMapper.deleteWorkByWorkId(workId);
    }

    @Override
    public List<CommentInfo> selectAllComment() {
        return adminMapper.selectAllComment();
    }

    @Override
    public Integer deleteCommentByCommentId(Integer commentId) {
        return adminMapper.deleteCommentByCommentId(commentId);
    }

    @Override
    public List<User> selectAllUser() {
        return adminMapper.selectAllUser();
    }

    @Override
    public Integer deleteUserByUid(Integer uid) {
        return adminMapper.deleteUserByUid(uid);
    }
}
