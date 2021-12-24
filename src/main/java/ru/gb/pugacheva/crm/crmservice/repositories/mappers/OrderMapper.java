package ru.gb.pugacheva.crm.crmservice.repositories.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.gb.pugacheva.crm.crmservice.entities.Order;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setId(rs.getLong("id"));
        order.setCustomerId(rs.getLong("customer_id")); // Вот в этом месте маппера: если бы в Order у
        //нас оставалось поле Customer, а не customerId, то потребовалсь бы инжектить сюда CustomerService, получается,
        // и просить его достать Customer  по айдишнику. Так ведь?
        order.setTotalPrice(rs.getInt("total_price"));
        return order;
    }

}


