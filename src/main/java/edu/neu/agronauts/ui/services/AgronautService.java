package edu.neu.agronauts.ui.services;

import java.util.List;
import java.util.Map;

import edu.neu.agronauts.ui.domain.FarmerServiceRequest;
import edu.neu.agronauts.ui.domain.Farmer;

public interface AgronautService {
	void saveOrUpdateObject(Object obj);

	Farmer authenticate(String username, String password);

	void saveOrUpdateRequest(FarmerServiceRequest request);

	List<FarmerServiceRequest> getPendingRequests();

	FarmerServiceRequest getRequestById(long id);

	void saveOrUpdateUser(Farmer user);

	List<FarmerServiceRequest> getRequestsForFarmer(long farmerId);

	<T> T getById(Class<T> theClass, long id);

	@SuppressWarnings("rawtypes")
	List query(String hql, Map<String, Object> params);

	Object queryForOne(String hql, Map<String, Object> params);
}
