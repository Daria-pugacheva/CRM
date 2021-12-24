package ru.gb.pugacheva.crm.crmservice.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class OrderItem {

    private Long id;
    private Long orderId;
    private Long productId;
    private int quantity;
    private int pricePerProduct;
    private int price;

}

//ВАРИАНТ РЕАЛИЗАЦИИ ПОД Hibernate
//@Data
//@NoArgsConstructor
//@Entity
//@Table(name = "order_items")
//public class OrderItem {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private Order order;
//
//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    private Product product;
//
//    @Column(name = "quantity")
//    private int quantity;
//
//    @Column(name = "price_per_product")
//    private int pricePerProduct;
//
//    @Column(name = "price")
//    private int price;
//
//    @CreationTimestamp
//    @Column(name = "created_at")
//    private LocalDateTime createdAt;
//
//    @UpdateTimestamp
//    @Column(name = "updated_at")
//    private LocalDateTime updatedAt;
//}

