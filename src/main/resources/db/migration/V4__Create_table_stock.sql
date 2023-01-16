create table if not exists mydb.stock
(
    size_id int not null,
    quantity int not null,
    CONSTRAINT fk_size
        FOREIGN KEY(size_id)
            REFERENCES mydb.size(id)
);




