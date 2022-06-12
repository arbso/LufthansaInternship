package session_3.src.main;


import session_3.src.model.entity.Customer;
import session_3.src.model.entity.Employee;
import session_3.src.model.entity.Office;
import session_3.src.model.entity.Order;
import session_3.src.repository.impl.CustomerRepository;
import session_3.src.repository.impl.EmployeeRepository;
import session_3.src.repository.impl.OfficeRepository;
import session_3.src.repository.impl.OrderRepository;

import session_3.src.util.JdbcConnection;



public class Main {

    public static void main(String[] args) throws ClassNotFoundException {

        JdbcConnection.connect();
        EmployeeRepository emp = new EmployeeRepository();
        OfficeRepository off = new OfficeRepository();
        CustomerRepository cus = new CustomerRepository();
        OrderRepository ord = new OrderRepository();

        boolean test1 = emp.exists(1);

        Employee test2 = new Employee(44343,
                "bruh",
                "bruh",
                "x6",
                "bruh@gmail.com",
                "2",
                "1002",
                "pronar");
        emp.save(test2);

        Employee test3 = new Employee(1,
                "sotiri",
                "arbri",
                "x43414",
                "2313@gmail.com",
                "2",
                "1002",
                "pronar");
        emp.update(test2);

        Office test4 = new Office(32,
                "Tirane",
                "+34567890",
                "Stadiumi Arena",
                "",
                "Albania",
                "Albania",
                "1019",
                "SHQYPNI"
        );
        off.save(test4);

        Customer test5 = new Customer(121212,
                "Filan",
                "K1",
                "K2",
                "+567890",
                "",
                "",
                "Durres",
                "Albaniaaaaa",
                "1019",
                "Albania",
                1370,
                900.0
                );


        cus.update(test5);

        Order test6 = new Order(
                90000,
                "2000-01-01",
                "2000-02-02",
                "2000-05-03",
                "Shipped",
                "Check on availabiity",
                363
        );

        ord.update(test6);
    }

}
