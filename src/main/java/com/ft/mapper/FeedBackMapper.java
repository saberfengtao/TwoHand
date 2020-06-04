package com.ft.mapper;

import com.ft.entity.FeedBack;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FeedBackMapper {

    /**
     * 用户提交反馈意见
     * @return
     */
    int addFeedBackUser(@Param("feed")FeedBack feedBack, int userId);

    /**
     * 删除反馈表
     * @param feedId
     * @return
     */
    int delFeedBack(int feedId);

    /**
     * 管理员找到所有的未删除反馈信息（状态为0）
     * @return
     */
    List<FeedBack> findAllFeedBackByState();
}
