package edu.neu.agronauts.ui.services.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.neu.agronauts.ui.domain.FarmerServiceRequest;
import edu.neu.agronauts.ui.domain.Farmer;
import edu.neu.agronauts.ui.hibernate.HibernateUtils;
import edu.neu.agronauts.ui.services.AgronautService;

public class AgronautServiceImpl implements AgronautService {

	private static AgronautService instance = new AgronautServiceImpl();

	public static AgronautService getInstance() {
		return instance;
	}

	private AgronautServiceImpl() {
		/** Do not instantiate **/
	}

	@SuppressWarnings("rawtypes")
	public Farmer authenticate(String username, String password) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Query query = session.createQuery("from Farmer u where u.username = :param1 and u.password = :param2");
		query.setParameter("param1", username);
		query.setParameter("param2", password);
		List users = query.list();
		if (users != null && !users.isEmpty()) {
			return (Farmer) users.get(0);
		}
		return null;
	}

	public void saveOrUpdateRequest(FarmerServiceRequest request) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(request);
		tx.commit();
		session.close();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<FarmerServiceRequest> getPendingRequests() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Query query = session.createQuery("from FarmerServiceRequest r where r.status = 'PENDING'");
		List requests = query.list();
		session.close();
		return requests;
	}

	public FarmerServiceRequest getRequestById(long id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		FarmerServiceRequest request = (FarmerServiceRequest) session.get(FarmerServiceRequest.class, id);
		session.close();
		return request;
	}

	public void saveOrUpdateUser(Farmer user) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(user);
		tx.commit();
		session.close();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<FarmerServiceRequest> getRequestsForFarmer(long farmerId) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Query query = session.createQuery("from FarmerServiceRequest r where r.farmer.id = :id");
		query.setParameter("id", farmerId);
		List requests = query.list();
		session.close();
		return requests;
	}

	public void saveOrUpdateObject(Object obj) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(obj);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public <T> T getById(Class<T> theClass, long id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		T object = (T) session.get(theClass, id);
		session.close();
		return object;
	}

	@SuppressWarnings("rawtypes")
	public List query(String hql, Map<String, Object> params) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		for (String key : params.keySet()) {
			query.setParameter(key, params.get(key));
		}
		List objects = query.list();
		session.close();
		return objects;
	}

	@SuppressWarnings("rawtypes")
	public Object queryForOne(String hql, Map<String, Object> params) {
		List results = query(hql, params);
		if (results != null && !results.isEmpty()) {
			return results.get(0);
		}
		return null;
	}

}
