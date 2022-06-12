SELECT customerName, o.* from customers
INNER JOIN orders as o on customers.customerNumber = o.customerNumber
INNER join  orderdetails on o.orderNumber = orderdetails.orderNumber
WHERE o.customerNumber is NOT NULL && customers.country = "Germany" 
ORDER BY customers.customerName