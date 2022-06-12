SELECT customers.customerName, COUNT(orders.orderNumber) AS totalOrders FROM customers 
INNER JOIN orders
on customers.customerNumber = orders.customerNumber
GROUP BY customers.customerName
Order by totalOrders desc
LIMIT 1