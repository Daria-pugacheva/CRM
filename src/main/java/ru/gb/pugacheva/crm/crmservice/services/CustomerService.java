package ru.gb.pugacheva.crm.crmservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.pugacheva.crm.crmservice.dtos.CustomerDto;
import ru.gb.pugacheva.crm.crmservice.entities.Customer;
import ru.gb.pugacheva.crm.crmservice.entities.Order;
import ru.gb.pugacheva.crm.crmservice.repositories.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final OrderService orderService;

    public List<CustomerDto> findAllByBirthday(int day, int month) {
        return customerRepository.findAllByBirthDayAndAndBirthMonth(day, month).
                stream().map(CustomerDto::new).collect(Collectors.toList());
    }

    public List<CustomerDto> findAllByProductId(Long productId) {
        List<Order> orders = orderService.findAllOrdersByProductId(productId);
        List<Customer> customers = new ArrayList<>();
        for (Order o : orders) {
            customers.add(o.getCustomer());
        }
        return customers.stream().map(CustomerDto::new).collect(Collectors.toList());
    }


}
