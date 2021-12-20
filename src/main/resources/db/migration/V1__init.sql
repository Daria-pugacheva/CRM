create table customers
(
    id          bigint auto_increment primary key,
    name        varchar(30) not null,
    birth_day   integer,
    birth_month integer,
    birth_year  integer,
    email       varchar(255),
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp
);
create table orders
(
    id          bigint auto_increment primary key,
    customer_id bigint references customers (id),
    total_price integer,
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp
);
create table products
(
    id         bigint auto_increment primary key,
    title      varchar(255),
    price      int,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);
create table order_items
(
    id                bigint auto_increment primary key,
    order_id          bigint references orders (id),
    product_id        bigint references products (id),
    quantity          integer,
    price_per_product integer,
    price             integer,
    created_at        timestamp default current_timestamp,
    updated_at        timestamp default current_timestamp
);
insert into products (title, price)
values ('Bread', 25),
       ('Milk', 80),
       ('Cheese', 100);
insert into customers (name, birth_day, birth_month, birth_year, email)
values ('Bob', 20, 12, 2000, 'bob_2000@gmail.com'),
       ('Bill', 15, 12, 2001, 'bill_2001@gmail.com');
insert into orders (customer_id, total_price)
values (1, 130),
       (2, 200);
insert into order_items (order_id, product_id, quantity, price_per_product, price)
values (1, 1, 2, 25, 50),
       (1, 2, 1, 80, 80),
       (2, 3, 2, 100, 200);







