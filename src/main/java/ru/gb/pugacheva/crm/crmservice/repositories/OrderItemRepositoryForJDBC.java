package ru.gb.pugacheva.crm.crmservice.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.gb.pugacheva.crm.crmservice.entities.OrderItem;;
import ru.gb.pugacheva.crm.crmservice.repositories.mappers.OrderItemMapper;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderItemRepositoryForJDBC {

    private final JdbcTemplate jdbcTemplate;

    public List<OrderItem> findAllByProductId(Long productId){
        return jdbcTemplate.query(
                "SELECT * FROM order_items WHERE product_id=?",
                new Object[]{productId}, new OrderItemMapper());
    }

}
