package com.didipark.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.didipark.pojo.Carport;
import com.didipark.pojo.Favorite;
import com.didipark.pojo.User;

public interface FavoriteDao {
	public void setSessionFactory(SessionFactory sessionFactory);

	/*
	 * param(��������ַ��ʱ�ۣ�������ά�ȣ�����) return carport_id
	 */
	public void saveFavorite(int user_id, int carport_id);
    public void deletFavorite(int user_id, int carport_id);
	public boolean hasSaved(int user_id,int carport_id);
	public List<Favorite> findFavoriteByUserId(int user_id);
}
