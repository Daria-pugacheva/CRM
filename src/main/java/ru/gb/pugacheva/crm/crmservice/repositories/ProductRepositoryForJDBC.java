package ru.gb.pugacheva.crm.crmservice.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.gb.pugacheva.crm.crmservice.entities.Product;
import ru.gb.pugacheva.crm.crmservice.repositories.mappers.ProductMapper;

import java.util.HashMap;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryForJDBC {
    private final JdbcTemplate jdbcTemplate;
    private final Map<Long, Product> productIdentityMap = new HashMap<>();

    public Product findById(Long id) {
        Product product = productIdentityMap.get(id);
        if (product == null) {
            product = jdbcTemplate.queryForObject("SELECT * FROM products WHERE id=?", new Object[]{id},
                    new ProductMapper());
            if (product != null) {
                productIdentityMap.put(id, product);
            }
        }
        return product;
    }

// Реализация без IdentityMap
//    public Product findById (Long id){
//        return jdbcTemplate.queryForObject("SELECT * FROM products WHERE id=?",new Object[]{id},
//                new ProductMapper());
//
//    }

}
