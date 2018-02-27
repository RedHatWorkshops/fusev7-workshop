DROP TABLE IF EXISTS account;
create table account(
	accountid varchar(30),
	balance int,
	dt DATETIME DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO account (accountid, balance) VALUES ('user_one',342);
INSERT INTO account (accountid, balance) VALUES ('user_two',425);
 

DROP TABLE IF EXISTS payment;
create table payment(
	paymentid int NOT NULL AUTO_INCREMENT,
	accountid varchar(30),
	paiddate varchar(30),
	paidamt int,
	PRIMARY KEY (paymentid)
);

INSERT INTO payment (accountid, paidamt, paiddate) VALUES ('user_one', 142, NOW());
INSERT INTO payment (accountid, paidamt, paiddate) VALUES ('user_one', 200, NOW());
INSERT INTO payment (accountid, paidamt, paiddate) VALUES ('user_two', 425, NOW());