package com.ft.service.impl;
import com.ft.entity.FeedBack;
import com.ft.mapper.FeedBackMapper;
import com.ft.service.FeedBackService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class FeedBackServiceImpl implements FeedBackService {

    @Resource
    FeedBackMapper feedBackMapper;


    @Override
    public boolean addFeedBackUser(FeedBack feedBack,String userId) {
        int userIdC = Integer.parseInt(userId);
        Date dateType=new Date();
        String current = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateType);
        Timestamp feedTime=Timestamp.valueOf(current);
        feedBack.setFbTime(feedTime);
        return feedBackMapper.addFeedBackUser(feedBack,userIdC)<=0 ? false : true;
    }

    @Override
    public boolean delFeedBack(String feedId) {
        int feedIdC = Integer.parseInt(feedId);
        return feedBackMapper.delFeedBack(feedIdC)<=0 ? false : true;
    }

    @Override
    public List<FeedBack> findAllFeedBackByState() {
        return feedBackMapper.findAllFeedBackByState();
    }
}
