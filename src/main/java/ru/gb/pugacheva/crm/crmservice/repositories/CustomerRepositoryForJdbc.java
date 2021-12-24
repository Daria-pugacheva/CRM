package ru.gb.pugacheva.crm.crmservice.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.gb.pugacheva.crm.crmservice.entities.Customer;
import ru.gb.pugacheva.crm.crmservice.repositories.mappers.CustomerMapper;

import java.sql.SQLException;
import java.util.*;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryForJdbc {
    private final JdbcTemplate jdbcTemplate;
    private final Map<Long, Customer> customerIdentityMap=new HashMap<>();

    public List<Customer> findAllByBirthDayAndAndBirthMonth (int day, int month) throws SQLException{
        return jdbcTemplate.query(
                "SELECT * FROM customers WHERE birth_day=?1 AND birth_month=?2",
                new Object[]{day,month}, new CustomerMapper());
    }

    public Customer findById (Long id) throws SQLException{
        Customer customer = customerIdentityMap.get(id);
        if(customer==null){
            customer=jdbcTemplate.queryForObject(
                    "SELECT * FROM customers WHERE id=?",
                    new Object[]{id}, new CustomerMapper());
            if(customer!=null){
                customerIdentityMap.put(id,customer);
            }
        }
        return customer;
    }


}
