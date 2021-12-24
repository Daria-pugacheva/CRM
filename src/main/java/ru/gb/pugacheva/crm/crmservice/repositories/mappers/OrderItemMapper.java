package ru.gb.pugacheva.crm.crmservice.repositories.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.gb.pugacheva.crm.crmservice.entities.OrderItem;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderItemMapper implements RowMapper<OrderItem> {

    @Override
    public OrderItem mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(rs.getLong("id"));
        orderItem.setOrderId(rs.getLong("order_id"));
        orderItem.setProductId(rs.getLong("product_id"));
        orderItem.setQuantity(rs.getInt("quantity"));
        orderItem.setPricePerProduct(rs.getInt("price_per_product"));
        orderItem.setPrice(rs.getInt("price"));
        return orderItem;
    }

}


