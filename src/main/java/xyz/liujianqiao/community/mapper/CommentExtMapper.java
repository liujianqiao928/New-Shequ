package xyz.liujianqiao.community.mapper;

import xyz.liujianqiao.community.model.Comment;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}