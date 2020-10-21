package com.service.impl;

import com.entity.CommentInfo;
import com.entity.PrivateInfo;
import com.entity.User;
import com.entity.WorksInfo;
import com.mapper.UserMapper;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public User findUserByEmailAndPassword(User user) {
        return userMapper.findUserByEmailAndPassword(user);
    }

    @Override
    public Integer updateHeadImage(User user) {
        return userMapper.updateHeadImage(user);
    }

    @Override
    public User findUserByUid(Integer uid) {
        return userMapper.findUserByUid(uid);
    }

    @Override
    public User findUserByEmail(String email) {
        return userMapper.findUserByEmail(email);
    }

    @Override
    public Integer updateUserPassword(User user) {
        return userMapper.updateUserPassword(user);
    }

    @Override
    public Integer updateUserIfo(User user) {
        return userMapper.updateUserIfo(user);
    }

    @Override
    public List<WorksInfo> selectAcgByTypeLimit(String typeName) {
        return userMapper.selectAcgByTypeLimit(typeName);
    }

    @Override
    public List<WorksInfo> selectAcgByType(String typeName) {
        return userMapper.selectAcgByType(typeName);
    }


    @Override
    public Integer addPrivateMsg(PrivateInfo privateInfo) {
        return userMapper.addPrivateMsg(privateInfo);
    }

    @Override
    public List<CommentInfo> selectCommentLimit() {
        return userMapper.selectCommentLimit();
    }

    @Override
    public List<WorksInfo> selectWorksLikeName(String s) {
        return userMapper.selectWorksLikeName(s);
    }

    @Override
    public List<WorksInfo> selectWorksByLookNum() {
        return userMapper.selectWorksByLookNum();
    }

    @Override
    public List<WorksInfo> selectWorksByTime() {
        return userMapper.selectWorksByTime();
    }

    @Override
    public List<User> selectUsersByBombNum() {
        return userMapper.selectUsersByBombNum();
    }

    @Override
    public List<WorksInfo> selectWorksByLookNumLimit6() {
        return userMapper.selectWorksByLookNumLimit6();
    }

    @Override
    public List<WorksInfo> selectWorksByLookNumLimit4() {
        return userMapper.selectWorksByLookNumLimit4();
    }

    @Override
    public List<User> selectUsersByBombNumLimit6() {
        return userMapper.selectUsersByBombNumLimit6();
    }

}
