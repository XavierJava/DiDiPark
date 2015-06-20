package com.didipark.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import com.didipark.pojo.Carport;

public interface CarportDao {
	
	public void setSessionFactory(SessionFactory sessionFactory);
	/*
	 * param(��������ַ��ʱ�ۣ�������ά�ȣ�����)
	 * return carport_id 
	 */
	public Carport saveCarport(String describe,String addr,int perHoursMoney,
			int num,double latitude,double longitude,int id);
	
	public Carport findCarportByID(int id);
	
	public void removeCarportByID(int id);
	
	public List<Carport>  findByUserIdAll(int id);
	
	public List<Carport>  findByUserIdAvilable(int id);
	public void updateCarport(Carport carport);
	
	public List<Carport> findByPoints(double latitude,double longitude);
}
