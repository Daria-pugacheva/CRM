package ru.gb.pugacheva.crm.crmservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.pugacheva.crm.crmservice.entities.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    //Optional<Product> findById (Long id);

}
