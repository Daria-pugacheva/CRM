package ru.gb.pugacheva.crm.crmservice.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.pugacheva.crm.crmservice.entities.Customer;


@Data
@NoArgsConstructor
public class CustomerDto {

    private Long id;
    private String name;
    private int birthDay;
    private int birthMonth;
    private int birthYear;
    private String email;
    private String phone;

    // private List<OrderDto> orders;

    public CustomerDto(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.birthDay = customer.getBirthDay();
        this.birthMonth = customer.getBirthMonth();
        this.birthYear = customer.getBirthYear();
        this.email = customer.getEmail();
        this.phone= customer.getPhone();
        // this.orders = customer.getOrders().stream().map(OrderDto::new).collect(Collectors.toList());
    }
}
