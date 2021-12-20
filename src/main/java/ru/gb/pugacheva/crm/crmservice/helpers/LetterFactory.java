package ru.gb.pugacheva.crm.crmservice.helpers;


import ru.gb.pugacheva.crm.crmservice.dtos.Letter;

public interface LetterFactory {
    Letter createLetter (String address);
}
