CREATE TABLE cluster.inovasi (
	id varchar(50) primary key,
	product_id varchar(50) not null,
	product_name varchar(50) not null,
	amount varchar(50),
	customer_name varchar(50),
	status int,
	transaction_date Date,
	created_by varchar(50) not null,
	created_on Date
);

CREATE TABLE cluster.status_inovasi (
	id varchar(50) primary key,
	name varchar(50) not null
);

ALTER TABLE cluster.inovasi ADD CONSTRAINT fk_status FOREIGN KEY (id) REFERENCES cluster.status_inovasi (id)

INSERT INTO cluster.status_inovasi (id, name) VALUES ('0', 'SUCCESS');
INSERT INTO cluster.status_inovasi (id, name) VALUES ('1', 'FAILED');