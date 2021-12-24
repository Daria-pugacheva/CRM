package ru.gb.pugacheva.crm.crmservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.pugacheva.crm.crmservice.entities.Product;
//import ru.gb.pugacheva.crm.crmservice.repositories.ProductRepository;
import ru.gb.pugacheva.crm.crmservice.repositories.ProductRepositoryForJDBC;


@Service
@RequiredArgsConstructor
public class ProductService {
    //private final ProductRepository productRepository;
    private final ProductRepositoryForJDBC productRepositoryForJDBC;

    public Product findById(Long productId) {
        return productRepositoryForJDBC.findById(productId);
    }


//ВАриант под Hibernate
//    public Product findById(Long productId) {
//        return productRepository.findById(productId).get();
//    }
}
