package com.xworkz.parkingapp.user;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepoImpl implements UserRepo {

	@Autowired
	private  EntityManagerFactory factory;
	
	public UserRepoImpl() {
		System.out.println("inside UserParkingRepoImpl");
	}
	@Override
	public boolean saveInfo(UserEntity entity) {
		System.out.println("running saveInfo");
		
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(entity);
		manager.getTransaction().commit();
		manager.close();
		
		return true;
	}
	@Override
	public UserEntity findByUserEmail(String userEmail) {
		System.out.println("inside findbyuseremail");
		EntityManager entityManager = factory.createEntityManager();
		Query query = entityManager.createNamedQuery("findByUserEmail");
		query.setParameter("email", userEmail);
		try {
	   Object obj=query.getSingleResult();
	   return (UserEntity) obj;
		}catch(Exception e) {
			return null;
		}finally {
			entityManager.close();
			
		}
			
	}
	@Override
	public boolean userSignInUpdate(String otp, String userEmail) {
		System.out.println("Inside userSignInUpdate");
		
		EntityManager em=factory.createEntityManager();
		em.getTransaction().begin();
		Query query=em.createNamedQuery("updateOTP");
		query.setParameter("mail", userEmail);
		query.setParameter("oneTime", otp);
		
		int in=query.executeUpdate();
		em.getTransaction().commit();
		em.close();
		
		return true;		
	
}
	@Override
	public UserEntity userLoginRepo(String userEmail) {
		System.out.println("Running userLoginRepo ");

		EntityManager em = this.factory.createEntityManager();
		Query query = em.createNamedQuery("findByUserEmail");
		query.setParameter("email", userEmail);
		Object object = query.getSingleResult();
		UserEntity result = (UserEntity) object;
		System.out.println("Result from repo " + result);
		return result;
	
	
}
	@Override
	public boolean updatedTime(UserEntity entity) {
		System.out.println("Running updatedTime");

		EntityManager em = this.factory.createEntityManager();
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
		em.close();

		return true;
	}
}
	
	/*
	 * @Override public boolean userSignInUpdate(String otp, String userEmail) {
	 * System.out.println("running userSignInUpdate");
	 * 
	 * EntityManager entityManager = factory.createEntityManager();
	 * entityManager.getTransaction().begin(); Query query =
	 * entityManager.createNamedQuery("updateotp");
	 * query.setParameter("mail",userEmail); query.setParameter("oneTime",otp);
	 * 
	 * int i = query.executeUpdate(); entityManager.getTransaction().commit();
	 * entityManager.close(); return true; }
	 * 
	 * @Override public UserEntity userLoginRepo(String userEmail) {
	 * System.out.println("Running userLoginRepo");
	 * 
	 * EntityManager em = this.factory.createEntityManager(); Query query =
	 * em.createNamedQuery("findByUserEmail"); query.setParameter("mail",userEmail);
	 * Object object = query.getSingleResult(); UserEntity result = (UserEntity)
	 * object; System.out.println("Result from repo"+result); return result; }
	 * 
	 * @Override public boolean updatedTime(UserEntity entity) {
	 * System.out.println("Running updateTime");
	 * 
	 * EntityManager em = this.factory.createEntityManager();
	 * em.getTransaction().begin(); em.merge(entity); em.getTransaction().commit();
	 * em.close(); return false; }
	 */



