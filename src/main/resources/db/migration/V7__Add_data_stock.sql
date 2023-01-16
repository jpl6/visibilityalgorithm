COPY mydb.stock(size_id, quantity)
FROM '/opt/data/stock.csv'
DELIMITER ','
CSV
