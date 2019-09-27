package appvn.report.repository;

import java.util.List;
import java.util.Map;

public interface TransactionRepositoryCustom {

	List<Object[]> getListData(String sql, Map<String, Object> mapParam);	 
}
