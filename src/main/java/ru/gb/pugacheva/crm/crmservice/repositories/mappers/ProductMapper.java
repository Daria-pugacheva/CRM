package ru.gb.pugacheva.crm.crmservice.repositories.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.gb.pugacheva.crm.crmservice.entities.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setId(rs.getLong("id"));
        product.setTitle(rs.getString("title"));
        product.setPrice(rs.getInt("price"));
        return product;
    }

}


