package ru.gb.pugacheva.crm.crmservice.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.gb.pugacheva.crm.crmservice.entities.Order;
import ru.gb.pugacheva.crm.crmservice.repositories.mappers.OrderMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryForJDBC {

    private final JdbcTemplate jdbcTemplate;
    private final Map<Long, Order> orderIdentityMap = new HashMap<>();

    public List<Order> findAllByTotalPriceIsGreaterThan(int totalPrice) {
        return jdbcTemplate.query(
                "SELECT * FROM orders WHERE total_price>?",
                new Object[]{totalPrice}, new OrderMapper());
    }

    public Order findById (Long id){
        Order order = orderIdentityMap.get(id);
        if(order==null){
            order=jdbcTemplate.queryForObject(
                    "SELECT * FROM orders WHERE id=?",
                    new Object[]{id}, new OrderMapper());
            if (order!=null){
                orderIdentityMap.put(id,order);
            }
        }
        return order;
    }

}
