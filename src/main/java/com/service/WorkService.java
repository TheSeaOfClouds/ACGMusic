package com.service;

import com.entity.BombRecord;
import com.entity.CommentInfo;
import com.entity.PrivateInfo;
import com.entity.WorksInfo;

import java.util.List;

public interface WorkService {

    Integer addWorks(WorksInfo worksInfo);
    Integer updateWorks(WorksInfo worksInfo);
    Integer updateWorkLookCount(Integer workId);
    Integer updateWorkDownloadCount(Integer workId);

    List<WorksInfo> selectWorksByUid(Integer uid);
    List<WorksInfo> selectWorksByUidLimit(Integer uid);
    WorksInfo selectWorksByWorkId(Integer workId);
    Integer selectWorksCount(Integer uid);

    List<PrivateInfo> selectPrivateByUid(Integer uid);
    Integer updateBombCountByWorkId3(Integer workId);
    Integer updateBombCountByWorkId5(Integer workId);
    Integer updateBombCountByWorkId10(Integer workId);
    Integer addBombRecord(BombRecord bombRecord);
    List<BombRecord> findBombNumByUid(Integer uid);
    BombRecord findBombByUid(Integer uid);
    Integer updateBombNumByUid(BombRecord bombRecord);
    Integer selectWorkBombNumByWorkId(Integer workId);

    Integer addComment(CommentInfo comment);
    Integer selectCommentCountByWorkId(Integer workId);
    Integer selectCommentCountByUid(Integer uid);
    List<CommentInfo> selectCommentByWorkId(Integer workId);
    List<CommentInfo> selectCommentByUid(Integer uid);

    List<WorksInfo> selectWorksRandom7();
}
