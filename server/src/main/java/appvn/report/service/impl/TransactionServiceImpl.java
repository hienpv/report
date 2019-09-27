package appvn.report.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import appvn.report.dto.MyObject;
import appvn.report.model.ReportConfig;
import appvn.report.repository.ReportConfigRepository;
import appvn.report.repository.TransactionRepository;
import appvn.report.service.TransactionService;
import appvn.report.util.Constants.ReportPram;
import appvn.report.util.Util;

@Service
public class TransactionServiceImpl implements TransactionService {
    ReportConfigRepository reportConfigRepository;
    TransactionRepository transactionRepository;

    public TransactionServiceImpl(ReportConfigRepository reportConfigRepository,
            TransactionRepository transactionRepository) {
        this.reportConfigRepository = reportConfigRepository;
        this.transactionRepository = transactionRepository;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> getData(int reportId, int month) {
        Optional<ReportConfig> reportConfig = reportConfigRepository.findById(reportId);
        if (reportConfig == null || reportConfig.get() == null) {
            return null;
        }
        // get report config
        Map<String, Object> result = new HashMap<String, Object>();
        String reportQuery = reportConfig.get().getDataQuery();
        String reportContent = reportConfig.get().getReportContent();
        Map<String, Object> reportParam = (Map<String, Object>) Util
                .convertJsonToObject(reportConfig.get().getReportParam(), Map.class);

        // get param value
        List<Object[]> lstDataContent = transactionRepository.getListData(reportQuery, new HashMap<>());
        Map<String, Object> reportPramValue = getReportParamValue(reportParam, lstDataContent);
        result.put("reportParam", reportParam);
        result.put("reportPramValue", reportPramValue);
        result.put("reportContent", reportContent);
        System.out.println((new Gson()).toJson(result));
        return result;
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> getReportParamValue(Map<String, Object> reportParam, List<Object[]> lstData) {
        Map<String, Object> mapPramValue = new HashMap<>();

        List<String> lstParam = (List<String>) reportParam.get("param");
        // Cho nay sau nay can lay tu config
        for (String param : lstParam) {

            if (param.contains(ReportPram.BRANCH)) {
                mapPramValue.put(param, "TỔ CHỨC TÀI CHÍNH HÀ NỘI");
            }
            if (param.contains(ReportPram.TITLE)) {
                mapPramValue.put(param, "BẢNG THÔNG TIN GIAO DỊCH");
            }
            if (param.contains(ReportPram.CONDITION_DATE)) {
                mapPramValue.put(param, "Tháng: 7 Năm: 2019");
            }
            if (param.contains(ReportPram.CURRENCY)) {
                mapPramValue.put(param, "đồng Việt Nam");
            }
            if (param.contains(ReportPram.SCHEDULER)) {
                mapPramValue.put(param, "Nguyễn Văn A");
            }
            if (param.contains(ReportPram.DATETIME)) {
                mapPramValue.put(param, "Ngày 01 tháng 01 năm 2019");
            }
            if (param.contains(ReportPram.LEADER)) {
                mapPramValue.put(param, "Nguyễn văn B");
            }
        }

        MyObject myObject;
        HashMap<String, Object> mapTemp;
        List<MyObject> lstMyObject = new ArrayList<>();
        List<String> lstDataPram = (List<String>) reportParam.get("data");
        for (Object[] object : lstData) {
            mapTemp = new HashMap<>();
            for (int i = 0; i < lstDataPram.size(); i++) {
                mapTemp.put(lstDataPram.get(i), object[i]);
            }
            myObject = new MyObject(mapTemp);
            lstMyObject.add(myObject);
        }

        mapPramValue.put("dataContent", lstMyObject);

        return mapPramValue;
    }
}
