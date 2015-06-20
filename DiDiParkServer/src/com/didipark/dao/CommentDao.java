package com.didipark.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.didipark.pojo.Carport;
import com.didipark.pojo.Comment;
import com.didipark.pojo.Favorite;
import com.didipark.pojo.User;

public interface CommentDao {
	public void setSessionFactory(SessionFactory sessionFactory);

	/*
	 * param(��������ַ��ʱ�ۣ�������ά�ȣ�����) return carport_id
	 */
	public int saveComment(Comment comment);
	public Comment finByCommentId(int commentId);
	public List<Comment> finByCarportId(int carportId);
	public List<Comment> finByUserId(int userId);
}
