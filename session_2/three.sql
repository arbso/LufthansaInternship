select *, sum(payments.amount) as amount from employees
INNER JOIN customers on employees.employeeNumber = customers.salesRepEmployeeNumber
INNER JOIN payments on payments.customerNumber = customers.customerNumber
group by employees.employeeNumber
order by amount desc
