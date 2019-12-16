package com.zc.parking.service;

import com.zc.parking.dao.CommentRepository;
import com.zc.parking.po.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    @Override
    public Comment saveComment(Comment comment) {
        comment.setDate(new Date());
        return  commentRepository.save(comment);
    }
}
