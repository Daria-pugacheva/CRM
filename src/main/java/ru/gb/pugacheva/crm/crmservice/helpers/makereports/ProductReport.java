package ru.gb.pugacheva.crm.crmservice.helpers.makereports;

import ru.gb.pugacheva.crm.crmservice.dtos.CustomerDto;

import java.util.List;

public class ProductReport extends AbstractReportMaker{
    @Override
    protected void makeHeader(Object... objects) {
        System.out.println("Отчет по продажам продукта " + objects[0]);
    }

    @Override
    protected void makeBody(List<CustomerDto> customers) {
        System.out.println("Указанный продукт был приобретен следующими покупателями: " + customers);
    }
}
