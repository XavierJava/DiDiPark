package com.didipark.dao;

import org.hibernate.SessionFactory;

import com.didipark.pojo.Carport;
import com.didipark.pojo.User;

public interface CidDao {
	public void setSessionFactory(SessionFactory sessionFactory);

	/*
	 * param(��������ַ��ʱ�ۣ�������ά�ȣ�����) return carport_id
	 */
	public void saveCid(String clientid, int id);

	public String findCidById(int id);
}
