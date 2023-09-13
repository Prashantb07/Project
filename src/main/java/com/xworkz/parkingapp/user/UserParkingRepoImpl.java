package com.xworkz.parkingapp.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserParkingRepoImpl implements UserParkingRepo {
	
	@Autowired
	private  EntityManagerFactory factory;
	
	public UserParkingRepoImpl() {
		System.out.println("inside UserParkingRepoImpl");
	}
	@Override
	public boolean saveparkingInfo(UserParkingEntity entity) {
		System.out.println("running saveInfo");
		
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(entity);
		manager.getTransaction().commit();
		manager.close();
		
		return true;
	}
	@Override
	public List<UserParkingEntity> findByUserId(int userId) {
		System.out.println("running findByUserId");
		
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Query query = manager.createNamedQuery("fetch");
		query.setParameter("id",userId);
		List<UserParkingEntity> entities = query.getResultList();
		manager.getTransaction().commit();
		System.out.println(entities);
		return entities;
	}
	@Override
	public UserParkingEntity updateByParkId(int parkingId) {
		System.out.println("running updateByParkId");
		
//		EntityManager manager = factory.createEntityManager();
//		manager.getTransaction().begin();
//		Query query = manager.createNamedQuery("fetchpark");
//		query.setParameter("pid",parkingId);
//		Object object = query.getSingleResult();
//		UserParkingEntity result = (UserParkingEntity) object;
//		manager.getTransaction().commit();
//		System.out.println("result from repo"+result);
//		return result;
		
		EntityManager em=factory.createEntityManager();
		em.getTransaction().begin();
		Query query=em.createNamedQuery("fetchpark");
		query.setParameter("pid", parkingId);
		UserParkingEntity entities=(UserParkingEntity) query.getSingleResult();
		em.getTransaction().commit();
		em.close();
		System.out.println("Result from repo " + entities);
		return entities;
	}
	@Override
	public UserParkingEntity updateUserInfo(UserParkingEntity entity) {
		System.out.println("running updateUserInfo ");
		
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		Query query = manager.createNamedQuery("updateuserinfo");
		query.setParameter("loc",entity.getLocation());
		query.setParameter("vtype",entity.getVtype());
		query.setParameter("vclass",entity.getVclassification());
		query.setParameter("ter",entity.getTerm());
		query.setParameter("pr",entity.getPrice());
		query.setParameter("dis",entity.getDiscount());
		query.setParameter("tamount",entity.getTotalAmount());
		query.setParameter("fName",entity.getFileName());
		query.setParameter("pid",entity.getParkingId());
		
		int in = query.executeUpdate();
		manager.getTransaction().commit();
		
		return null;
	}
	@Override
	public UserParkingEntity deleteByParkId(int parkingId) {
		System.out.println("Inside deleteByParkId");
		EntityManager em=factory.createEntityManager();
		em.getTransaction().begin();
		
		Query query=em.createNamedQuery("deleteParkingById");
		query.setParameter("pid", parkingId);
		
		int i=query.executeUpdate();
		
		em.getTransaction().commit();
		
		
		return null;
		}

}
