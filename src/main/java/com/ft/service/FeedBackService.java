package com.ft.service;

import com.ft.entity.FeedBack;

import java.util.List;

public interface FeedBackService {

    /**
     * 用户提交反馈意见
     * @return
     */
    boolean addFeedBackUser(FeedBack feedBack,String userId);

    /**
     * 删除反馈表
     * @param feedId
     * @return
     */
    boolean delFeedBack(String feedId);

    /**
     * 管理员找到所有的未删除反馈信息（状态为0）
     * @return
     */
    List<FeedBack> findAllFeedBackByState();
}
