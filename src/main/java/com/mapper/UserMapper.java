package com.mapper;

import com.entity.CommentInfo;
import com.entity.PrivateInfo;
import com.entity.User;
import com.entity.WorksInfo;

import java.util.List;

public interface UserMapper {

    Integer addUser(User user);
    User findUserByEmailAndPassword(User user);
    Integer updateHeadImage(User user);
    User findUserByUid(Integer uid);
    User findUserByEmail(String email);

    Integer updateUserPassword(User user);
    Integer updateUserIfo(User user);

    Integer addPrivateMsg(PrivateInfo privateInfo);

    List<WorksInfo> selectAcgByTypeLimit(String typeName);
    List<WorksInfo> selectAcgByType(String typeName);

    List<CommentInfo> selectCommentLimit();

    List<WorksInfo> selectWorksLikeName(String s);

    List<WorksInfo> selectWorksByLookNum();
    List<WorksInfo> selectWorksByTime();
    List<User> selectUsersByBombNum();

    List<WorksInfo> selectWorksByLookNumLimit6();
    List<WorksInfo> selectWorksByLookNumLimit4();
    List<User> selectUsersByBombNumLimit6();
}
