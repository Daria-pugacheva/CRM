package ru.gb.pugacheva.crm.crmservice.helpers;

import ru.gb.pugacheva.crm.crmservice.dtos.Letter;

public class ViberLetterSender extends AbstractSending{
    public ViberLetterSender(SendingLetters sendingLetters){
        super(sendingLetters);
    }

    @Override
    public void sendLetter(Letter letter) {
        //тут какая-то логика автоматической рассылки не только на email на заданный адрес заданного текста (берется из письма), но еще и на Viber по номеру телефона (типа расширение функцоинала)
        super.sendLetter(letter);
        System.out.println("Отправка письма : " + letter.getMessage() + " по телефону: " + letter.getPhone());
    }
}
