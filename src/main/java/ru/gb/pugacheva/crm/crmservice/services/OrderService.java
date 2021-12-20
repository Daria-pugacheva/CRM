package ru.gb.pugacheva.crm.crmservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.pugacheva.crm.crmservice.dtos.OrderDto;
import ru.gb.pugacheva.crm.crmservice.entities.Order;
import ru.gb.pugacheva.crm.crmservice.entities.OrderItem;
import ru.gb.pugacheva.crm.crmservice.repositories.OrderRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemService orderItemService;
    private final ProductService productService;

    public List<Order> findAllOrdersByProductId(Long productId) {
        List<OrderItem> orderItems = orderItemService.findAllByProduct(productService.findById(productId));
        List<Order> orders = new ArrayList<>();
        for (OrderItem oi : orderItems) {
            orders.add(oi.getOrder());
        }
        return orders;
    }

    public List<OrderDto> findAllByTotalPriceMoreThan(int totalPrice) {
        return orderRepository.findAllByTotalPriceIsGreaterThan(totalPrice).
                stream().map(OrderDto::new).collect(Collectors.toList());
    }


}
