package appvn.report.repository.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import appvn.report.repository.TransactionRepositoryCustom;
	
@Repository
public class TransactionRepositoryImpl implements TransactionRepositoryCustom {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;
    
    @SuppressWarnings("unchecked")
    @Override
	public List<Object[]> getListData(String sql, Map<String, Object> mapParam ) {
    	Query query = entityManager.createNativeQuery(sql);
    	for (Map.Entry<String, Object> entry : mapParam.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
    	List<Object[]> result = query.getResultList(); 
        return result;
    }

}
