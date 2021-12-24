package ru.gb.pugacheva.crm.crmservice.repositories.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.gb.pugacheva.crm.crmservice.entities.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CustomerMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getLong("id"));
        customer.setName(rs.getString("name"));
        customer.setBirthDay(rs.getInt("birth_day"));
        customer.setBirthMonth(rs.getInt("birth_month"));
        customer.setBirthYear(rs.getInt("birth_year"));
        customer.setEmail(rs.getString("email"));
        customer.setPhone(rs.getString("phone"));
        return customer;
    }


}


