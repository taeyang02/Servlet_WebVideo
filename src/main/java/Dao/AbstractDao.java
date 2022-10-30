package Dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;

import Connection.FactoryHibernate;

public class AbstractDao<T> {
	public static final Session session = FactoryHibernate.getFACTORY().openSession();
	
	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		session.close();
		super.finalize();
	}
	
	public T findById(Class<T> clasz, Integer id) {
		return session.find(clasz, id);
	}
	
	public List<T> findAll(Class<T> clasz, boolean ischeck) {
		String entityName = clasz.getName();
		StringBuilder hql = new StringBuilder();
		hql.append("Select o From ").append(entityName).append(" o");
		if (ischeck) {
			hql.append(" where active = 1");
		}
		TypedQuery<T> query = session.createQuery(hql.toString());
		return query.getResultList();	
	}
	public List<T> findAll(Class<T> clasz, boolean ischeck,int pageNumber,int pageSize) {
		String entityName = clasz.getName();
		StringBuilder hql = new StringBuilder();
		hql.append("Select o From ").append(entityName).append(" o");
		if (ischeck) {
			hql.append(" where active = 1");
		}
		TypedQuery<T> query = session.createQuery(hql.toString());
		query.setFirstResult((pageNumber - 1)*pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();	
	}
	
	public T finOne(Class<T> clasz,String hql, Object... params) {
		TypedQuery<T> query = session.createQuery(hql,clasz);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		List<T> result = query.getResultList();
		
		return result.get(0);
	}
	public T create(T entity) {
		try {
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("them thanh cong");
			return entity;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Them That Bai"+entity.getClass().getSimpleName()+"toDB");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public T update(T entity) {
		try {
			session.getTransaction().begin();
			session.merge(entity);
			session.getTransaction().commit();
			System.out.println("sua thanh cong");
			return entity;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("sua That Bai"+entity.getClass().getSimpleName()+"toDB");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public T delete(T entity) {
		try {
			session.getTransaction().begin();
			session.remove(entity);
			session.getTransaction().commit();
			System.out.println("xoa thanh cong");
			return entity;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("xoa That Bai"+entity.getClass().getSimpleName()+"toDB");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public List CreateQuery(String querry, Object... params){
		TypedQuery query = session.createQuery(querry);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		List result = query.getResultList();
		return result;
	}
	public List<T> findAllQuery(Class<T> clasz,String hql, Object... params) {
		TypedQuery<T> query = session.createQuery(hql,clasz);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		List<T> result = query.getResultList();
		return result;
	}
}
