package com.service.impl;

import com.entity.BombRecord;
import com.entity.CommentInfo;
import com.entity.PrivateInfo;
import com.entity.WorksInfo;
import com.mapper.WorkMapper;
import com.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    private WorkMapper mapper;

    @Override
    public Integer addWorks(WorksInfo worksInfo) {
        return mapper.addWorks(worksInfo);
    }

    @Override
    public Integer updateWorks(WorksInfo worksInfo) {
        return mapper.updateWorks(worksInfo);
    }

    @Override
    public Integer updateWorkLookCount(Integer workId) {
        return mapper.updateWorkLookCount(workId);
    }

    @Override
    public Integer updateWorkDownloadCount(Integer workId) {
        return mapper.updateWorkDownloadCount(workId);
    }

    @Override
    public List<WorksInfo> selectWorksByUid(Integer uid) {
        return mapper.selectWorksByUid(uid);
    }

    @Override
    public List<WorksInfo> selectWorksByUidLimit(Integer uid) {
        return mapper.selectWorksByUidLimit(uid);
    }

    @Override
    public WorksInfo selectWorksByWorkId(Integer workId) {
        return mapper.selectWorksByWorkId(workId);
    }

    @Override
    public Integer selectWorksCount(Integer uid) {
        return mapper.selectWorksCount(uid);
    }


    @Override
    public List<PrivateInfo> selectPrivateByUid(Integer uid) {
        return mapper.selectPrivateByUid(uid);
    }

    @Override
    public Integer updateBombCountByWorkId3( Integer workId) {
        return mapper.updateBombCountByWorkId3(workId);
    }
    @Override
    public Integer updateBombCountByWorkId5( Integer workId) {
        return mapper.updateBombCountByWorkId5(workId);
    }
    @Override
    public Integer updateBombCountByWorkId10( Integer workId) {
        return mapper.updateBombCountByWorkId10(workId);
    }

    @Override
    public Integer addBombRecord(BombRecord bombRecord) {
        return mapper.addBombRecord(bombRecord);
    }

    @Override
    public List<BombRecord> findBombNumByUid(Integer uid) {
        return mapper.findBombNumByUid(uid);
    }

    @Override
    public BombRecord findBombByUid(Integer uid) {
        return mapper.findBombByUid(uid);
    }

    @Override
    public Integer updateBombNumByUid(BombRecord bombRecord) {
        return mapper.updateBombNumByUid(bombRecord);
    }

    @Override
    public Integer selectWorkBombNumByWorkId(Integer workId) {
        return mapper.selectWorkBombNumByWorkId(workId);
    }

    @Override
    public Integer addComment(CommentInfo comment) {
        return mapper.addComment(comment);
    }

    @Override
    public Integer selectCommentCountByWorkId(Integer workId) {
        return mapper.selectCommentCountByWorkId(workId);
    }

    @Override
    public Integer selectCommentCountByUid(Integer uid) {
        return mapper.selectCommentCountByUid(uid);
    }

    @Override
    public List<CommentInfo> selectCommentByWorkId(Integer workId) {
        return mapper.selectCommentByWorkId(workId);
    }

    @Override
    public List<CommentInfo> selectCommentByUid(Integer uid) {
        return mapper.selectCommentByUid(uid);
    }

    @Override
    public List<WorksInfo> selectWorksRandom7() {
        return mapper.selectWorksRandom7();
    }
}
