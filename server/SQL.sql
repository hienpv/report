CREATE SCHEMA `report_system` ;

CREATE TABLE `report_system`.`report_config` (
  `id` INT NOT NULL,
  `user_id` INT NULL,
  `report_id` INT NULL,
  `report_content` TEXT NULL,
  `report_param` TEXT NULL,
  `data_query` TEXT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE `report_system`.`transaction` (
  `id` INT NOT NULL,
  `account_number` VARCHAR(45) NULL,
  `amount` INT NULL,
  `transaction_time` DATETIME NULL,
  PRIMARY KEY (`id`));
  
INSERT INTO `` (`id`,`user_id`,`report_id`,`report_content`,`report_param`,`data_query`) VALUES (1,1,1,'<div class=\"report\" id=\"report\" style=\"margin: auto;width: 21cm\"> <div class=\"report-header\"> <div style=\"font-weight: bold\">{{configData.BRANCH}}</div> <br> <div class=\"title\" style=\"text-align: center; font-weight: bold\">{{configData.TITLE}}</div> <div class=\"search-param\" style=\"text-align: center\">{{configData.CONDITION_DATE}}</div> <br> </div> <div class=\"report-content\"> <div class=\"currency\" style=\"text-align: right; font-style: italic\">Đơn vị: {{configData.CURRENCY}}</div> <div class=\"content-data\"> <table style=\"width: 100%; border-collapse: collapse; border-spacing: 10px;\"> <thead style=\"text-align: center\"> <tr> <th rowspan=\"2\" style=\"width: 25%\">MÃ GIAO DỊCH</th> <th rowspan=\"2\" style=\"width: 25%\">Số tài khoản</th> <th colspan=\"2\" style=\"width: 50%\">Giao dịch</th> </tr> <tr> <th style=\"width: 25%\">Số tiền</th> <th style=\"width: 25%\">Số ngày</th> </tr> </thead> <tbody> <tr style=\"text-align: center\"> <td>A</td> <td>B</td> <td>C</td> <td>D</td> </tr> <tr *ngFor=\"let dt of data\"> <td> {{dt.TRANSACTION_ID}} </td> <td> {{dt.ACCOUNT_NUMBER}} </td> <td style=\"text-align: right\"> {{dt.AMOUNT|number}} </td> <td> {{dt.TRANSACTION_TIME}} </td> </tr> <tr style=\"text-align: center; font-weight: bold\"> <td>Tổng cộng</td> <td></td> <td style=\"text-align: right\">{{data|sumPipe:\'AMOUNT\'|number}}</td> <td></td> </tr> </tbody> </table> </div> </div> <div class=\"report-footer\"> <br> <div class=\"column\"> <br> <div class=\"footer-lable\" style=\"font-weight: bold\">Người lập</div> <div class=\"footer-asign\" style=\"font-style: italic\">(Ký, họ tên)</div> <br> <br> <div class=\"footer-asign\">{{configData.SCHEDULER}}</div> </div> <div class=\"column\"> <div class=\"footer-date\">{{configData.DATETIME}}</div> <div class=\"footer-lable\" style=\"font-weight: bold\">Thủ trưởng đơn vị</div> <div class=\"footer-asign\" style=\"font-style: italic\">(Ký, họ tên)</div> <br> <br> <div class=\"footer-asign\">{{configData.LEADER}}</div> </div> </div></div>','{ \"param\": [ \"BRANCH\", \"TITLE\", \"CONDITION_DATE\", \"CURRENCY\", \"SCHEDULER\", \"DATETIME\", \"LEADER\" ], \"data\": [ \"TRANSACTION_ID\", \"ACCOUNT_NUMBER\", \"AMOUNT\", \"TRANSACTION_TIME\" ]}','select id, account_number, amount,  DATE_FORMAT(SYSDATE(), \'%d-%m-%Y %h:%i:%s\') transaction_time from transaction');


