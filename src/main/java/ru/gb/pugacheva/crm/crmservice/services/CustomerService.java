package ru.gb.pugacheva.crm.crmservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.pugacheva.crm.crmservice.dtos.CustomerDto;
import ru.gb.pugacheva.crm.crmservice.entities.Customer;
import ru.gb.pugacheva.crm.crmservice.entities.Order;
import ru.gb.pugacheva.crm.crmservice.entities.Product;
import ru.gb.pugacheva.crm.crmservice.helpers.makereports.AbstractReportMaker;
import ru.gb.pugacheva.crm.crmservice.helpers.makereports.BirthdayReport;
import ru.gb.pugacheva.crm.crmservice.helpers.makereports.ProductReport;
//import ru.gb.pugacheva.crm.crmservice.repositories.CustomerRepository;
import ru.gb.pugacheva.crm.crmservice.repositories.CustomerRepositoryForJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {
    //private final CustomerRepository customerRepository;
    private final CustomerRepositoryForJdbc customerRepositoryForJdbc;
    private final OrderService orderService;
    private final ProductService productService;

    public List<CustomerDto> findAllByBirthday(int day, int month) throws SQLException {
        List<Customer> customers = customerRepositoryForJdbc.findAllByBirthDayAndAndBirthMonth(day, month);
        return customers.stream().map(CustomerDto::new).collect(Collectors.toList());
    }

//НАЧАЛЬНЫЙ ВАРИАНТ
//    public List<CustomerDto> findAllByBirthday(int day, int month) {
//        return customerRepository.findAllByBirthDayAndAndBirthMonth(day, month).
//                stream().map(CustomerDto::new).collect(Collectors.toList());
//    }

    public List<CustomerDto> findAllByProductId(Long productId) throws SQLException{
        List<Order> orders = orderService.findAllOrdersByProductId(productId);
        List<Customer> customers = new ArrayList<>();
        for (Order o : orders) {
            customers.add(customerRepositoryForJdbc.findById(o.getCustomerId()));
        }
        return customers.stream().map(CustomerDto::new).collect(Collectors.toList());
    }

    public void makeReport(String name, List<CustomerDto> customers, ReportType type, Object... objects) {
        AbstractReportMaker reportMaker;
        switch (type) {
            case BIRTH:
                reportMaker = new BirthdayReport();
                reportMaker.makeReport(name, customers);
                break;
            case BONUS:
                reportMaker = new ProductReport();
                Product product = productService.findById((Long) objects[0]);
                reportMaker.makeReport(name, customers, product);
                break;
            default:
                throw new IllegalArgumentException("Создание отчетов такого типа не поддерживается");
        }
    }

    public enum ReportType {
        BIRTH, BONUS
    }


}
