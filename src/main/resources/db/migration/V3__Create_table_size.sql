create table if not exists mydb.size
(
    id        SERIAL not null PRIMARY KEY,
    product_id int not null,
    backSoon boolean not null,
    special boolean not null,
    CONSTRAINT fk_product
        FOREIGN KEY(product_id)
            REFERENCES mydb.product(id)
);



