package ru.gb.pugacheva.crm.crmservice.helpers.createletters;


import ru.gb.pugacheva.crm.crmservice.dtos.Letter;

public class BirthdayLetterFactory implements LetterFactory{

    @Override
    public Letter createLetter(String address, String phone) {
        return new Letter(address, "С днем рождения!", phone);
    }
}
