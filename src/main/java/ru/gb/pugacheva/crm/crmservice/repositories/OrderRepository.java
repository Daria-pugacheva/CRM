package ru.gb.pugacheva.crm.crmservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.pugacheva.crm.crmservice.entities.Order;


import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByTotalPriceIsGreaterThan(int totalPrice);

}
