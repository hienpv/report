package appvn.report.resource;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import appvn.report.service.TransactionService;

@RestController
@RequestMapping("/api")
public class TransactionResource {
    TransactionService transactionService;

    public TransactionResource(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getData")
    public ResponseEntity<Map<String, Object>> getData(int reportId, int month) {
        return new ResponseEntity<>(transactionService.getData(reportId, month), null, HttpStatus.OK);
    }
}
