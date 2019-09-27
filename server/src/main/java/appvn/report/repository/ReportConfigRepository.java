package appvn.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import appvn.report.model.ReportConfig;

public interface ReportConfigRepository extends JpaRepository<ReportConfig, Integer> {

}
