package com.ft.controller;


import com.ft.entity.FeedBack;

import com.ft.service.FeedBackService;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/feed")
public class FeedBackController {

    @Resource
    FeedBackService feedBackService;

    @RequestMapping("/addFeedBackUser")
    public String addFeedBackUser(FeedBack feedBack, String userId, Model model) {

        if(feedBackService.addFeedBackUser(feedBack,userId)){
            model.addAttribute("msg","感谢您的反馈，我们会努力做的更好的！");
        return "success";}else {
            model.addAttribute("msg","反馈失败！");
            return "error";}
    }

    @RequestMapping("/getAllFeedBack")
    public String getAllFeedBack(Model model){
        List<FeedBack> feedBackList= feedBackService.findAllFeedBackByState();
        model.addAttribute("feedBackList",feedBackList);
        return "system/admin/user/feedBackMessage";
    }

    @RequestMapping("/delFeedBack")
    public String delFeedBack(Model model,String feedId){
        if(feedBackService.delFeedBack(feedId)){

            return "redirect:/feed/getAllFeedBack";
        }else {
            model.addAttribute("msg","删除失败");
            return "error";}
    }
}
