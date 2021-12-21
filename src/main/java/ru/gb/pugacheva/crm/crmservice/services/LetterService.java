package ru.gb.pugacheva.crm.crmservice.services;

import org.springframework.stereotype.Service;
import ru.gb.pugacheva.crm.crmservice.dtos.Letter;
import ru.gb.pugacheva.crm.crmservice.helpers.createletters.BirthdayLetterFactory;
import ru.gb.pugacheva.crm.crmservice.helpers.createletters.BonusLetterFactory;
import ru.gb.pugacheva.crm.crmservice.helpers.createletters.LetterFactory;
import ru.gb.pugacheva.crm.crmservice.helpers.sendingletters.SendingLetters;
import ru.gb.pugacheva.crm.crmservice.helpers.sendingletters.StandartEmailLetterSender;
import ru.gb.pugacheva.crm.crmservice.helpers.sendingletters.ViberLetterSender;


@Service
public class LetterService {

    public Letter createLetter (String address, String phone, LetterType type){
        return createFactory(type).createLetter(address, phone);
    }

    private LetterFactory createFactory (LetterType type){
        switch (type) {
            case BIRTH:
                return new BirthdayLetterFactory();
            case BONUS:
                return new BonusLetterFactory();
            default:
                throw new IllegalArgumentException("Генерация писем такого типа не поддерживается");
        }
    }

    public void sendLetter(Letter letter) {
        SendingLetters sendingLetters = new StandartEmailLetterSender();
        sendingLetters = new ViberLetterSender(sendingLetters);
        sendingLetters.sendLetter(letter);
    }

    public enum LetterType{
        BIRTH, BONUS
    }

}
