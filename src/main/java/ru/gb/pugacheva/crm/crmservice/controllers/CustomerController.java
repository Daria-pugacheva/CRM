package ru.gb.pugacheva.crm.crmservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.pugacheva.crm.crmservice.dtos.CustomerDto;
import ru.gb.pugacheva.crm.crmservice.services.CustomerService;


import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/birthday")
    public List<CustomerDto> findAlByBirthday() {
        LocalDate date = LocalDate.now();
        int day = date.getDayOfMonth();
        int month = date.getMonthValue();
        return customerService.findAllByBirthday(day, month);
    }

    @GetMapping("/{productId}")
    public List<CustomerDto> findAlByProductId(@PathVariable Long productId) {
        return customerService.findAllByProductId(productId);
    }

    @PostMapping("/report/{name}/{reportType}/{productId}")
    public void makeReport(@PathVariable String name, @PathVariable CustomerService.ReportType reportType, @PathVariable (required = false)  Long productId, @RequestBody List<CustomerDto> customers){
        if (productId!=null){
            customerService.makeReport(name,customers,reportType, productId);
        }else{
            customerService.makeReport(name,customers,reportType);
        }

    }



}
