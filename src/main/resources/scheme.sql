CREATE TABLE pay_record(
    id BIGINT(20) IDENTITY PRIMARY KEY,
    pay_no BIGINT(20),
    order_no VARCHAR(255),
    product_name VARCHAR(255),
    price BIGINT(20),
    pri1 VARCHAR(255),
    pri2 VARCHAR(255),
    memo VARCHAR(255),
    create_time datetime NOT NULL,
    update_time datetime NOT NULL,
    status INT
);