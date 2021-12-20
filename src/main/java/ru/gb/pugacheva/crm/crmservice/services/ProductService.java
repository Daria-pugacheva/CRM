package ru.gb.pugacheva.crm.crmservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.pugacheva.crm.crmservice.entities.Product;
import ru.gb.pugacheva.crm.crmservice.repositories.ProductRepository;


@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product findById(Long productId) {
        return productRepository.findById(productId).get();
    }
}
