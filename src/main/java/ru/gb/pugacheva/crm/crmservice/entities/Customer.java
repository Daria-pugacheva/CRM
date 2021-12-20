package ru.gb.pugacheva.crm.crmservice.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "birth_day")
    private int birthDay;
    @Column(name = "birth_month")
    private int birthMonth;
    @Column(name = "birth_year")
    private int birthYear;
    @Column(name = "email")
    private String email;

//    @OneToMany(mappedBy = "customer")
//    private List <Order> orders;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
