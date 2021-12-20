package ru.gb.pugacheva.crm.crmservice.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.pugacheva.crm.crmservice.entities.Order;


@Data
@NoArgsConstructor
public class OrderDto {

    private Long id;
    private Long customerId;
    //private List<OrderItem> orderItems;
    private int totalPrice;

    public OrderDto(Order order) {
        this.id = order.getId();
        this.customerId = order.getCustomer().getId();
        //   this.orderItems = order.getOrderItems();
        this.totalPrice = order.getTotalPrice();
    }
}
