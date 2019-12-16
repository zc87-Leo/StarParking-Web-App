package com.zc.parking.web.admin;

import com.zc.parking.po.Comment;
import com.zc.parking.po.User;
import com.zc.parking.service.CommentService;
import com.zc.parking.service.MeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private MeterService meterService;


    @PostMapping("/post")
    public String post(Comment comment, HttpSession session){
        comment.setUser((User)session.getAttribute("user"));
        comment.setMeter(meterService.findOne(comment.getMeter().getId()));
        Comment c = commentService.saveComment(comment);
        return "admin/meter";
    }

}
