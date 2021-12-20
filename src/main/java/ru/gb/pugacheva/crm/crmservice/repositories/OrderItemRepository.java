package ru.gb.pugacheva.crm.crmservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.pugacheva.crm.crmservice.entities.OrderItem;
import ru.gb.pugacheva.crm.crmservice.entities.Product;


import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findAllByProduct(Product product);
}
