COPY mydb.product(id, sequence)
FROM '/opt/data/product.csv'
DELIMITER ','
CSV
