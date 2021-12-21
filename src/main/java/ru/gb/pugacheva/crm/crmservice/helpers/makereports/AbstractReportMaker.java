package ru.gb.pugacheva.crm.crmservice.helpers.makereports;

import ru.gb.pugacheva.crm.crmservice.dtos.CustomerDto;
import ru.gb.pugacheva.crm.crmservice.services.CustomerService;

import java.time.LocalDate;
import java.util.List;

public abstract class AbstractReportMaker {

    public final void makeReport(String name, List<CustomerDto> customers, Object... objects){
        makeHeader(objects);
        makeBody(customers);
        makeFooter(name);
    }

    protected abstract void makeHeader(Object... objects);

    protected abstract void makeBody(List<CustomerDto> customers);

    public final void makeFooter(String name){
        LocalDate currentDate = LocalDate.now();
        System.out.println("Отчет составил " + name + " Дата: "+ currentDate);
    };
}
