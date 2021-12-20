package ru.gb.pugacheva.crm.crmservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Letter {
    private String address;
    private String message;
    private String phone;
}
