SELECT * FROM orders
WHERE YEAR(orderDate) = YEAR(DATE("2005-01-01"- interval 1 month)) AND MONTH(orderDate) = MONTH(DATE("2005-01-01"- interval 1 month))