package ru.gb.pugacheva.crm.crmservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.pugacheva.crm.crmservice.entities.OrderItem;
import ru.gb.pugacheva.crm.crmservice.entities.Product;
import ru.gb.pugacheva.crm.crmservice.repositories.OrderItemRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;

    public List<OrderItem> findAllByProduct(Product product) {
        return orderItemRepository.findAllByProduct(product);
    }


}
