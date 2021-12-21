package ru.gb.pugacheva.crm.crmservice.helpers.makereports;

import ru.gb.pugacheva.crm.crmservice.dtos.CustomerDto;

import java.util.List;

public class BirthdayReport extends AbstractReportMaker{
    @Override
    protected void makeHeader(Object... objects) {
        System.out.println("Отчет по отправке писем-поздравлений в День Рождения");
    }

    @Override
    protected void makeBody(List<CustomerDto> customers) {
        System.out.println("Письма-поздравления были направлены следующим покупателям: " + customers);
    }
}
