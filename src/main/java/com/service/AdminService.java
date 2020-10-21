package com.service;

import com.entity.Admin;
import com.entity.CommentInfo;
import com.entity.User;
import com.entity.WorksInfo;

import java.util.List;

public interface AdminService {

    Admin selectAdmin(Admin admin);
    List<WorksInfo> selectAllWorksInfo();
    Integer deleteWorkByWorkId(Integer workId);
    List<CommentInfo> selectAllComment();
    Integer deleteCommentByCommentId(Integer commentId);
    List<User> selectAllUser();
    Integer deleteUserByUid(Integer uid);
}
