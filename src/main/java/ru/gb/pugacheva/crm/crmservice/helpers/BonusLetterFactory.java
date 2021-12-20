package ru.gb.pugacheva.crm.crmservice.helpers;


import ru.gb.pugacheva.crm.crmservice.dtos.Letter;

public class BonusLetterFactory implements LetterFactory{

    @Override
    public Letter createLetter(String address) {
        return new Letter(address, "За покупку товара вы получаете бонус!");
    }
}
