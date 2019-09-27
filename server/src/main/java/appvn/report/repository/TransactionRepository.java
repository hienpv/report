package appvn.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import appvn.report.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>, TransactionRepositoryCustom {
}
