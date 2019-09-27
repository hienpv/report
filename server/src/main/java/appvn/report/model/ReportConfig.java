package appvn.report.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "report_config")
public class ReportConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "report_id")
    private int reportId;
    
    @Column(name = "report_content")
    private String reportContent;
    
    
    @Column(name = "report_param")
    private String reportParam;
    
    @Column(name = "data_query")
    private String dataQuery;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public String getReportContent() {
		return reportContent;
	}

	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}

	public String getReportParam() {
		return reportParam;
	}

	public void setReportParam(String reportParam) {
		this.reportParam = reportParam;
	}

	public String getDataQuery() {
		return dataQuery;
	}

	public void setDataQuery(String dataQuery) {
		this.dataQuery = dataQuery;
	}
}
