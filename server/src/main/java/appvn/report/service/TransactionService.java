package appvn.report.service;

import java.util.Map;

public interface TransactionService {

    Map<String, Object> getData(int reportId, int month);

}
