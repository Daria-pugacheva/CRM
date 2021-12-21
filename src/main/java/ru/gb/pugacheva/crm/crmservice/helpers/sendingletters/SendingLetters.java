package ru.gb.pugacheva.crm.crmservice.helpers.sendingletters;

import ru.gb.pugacheva.crm.crmservice.dtos.Letter;

public interface SendingLetters {
    void sendLetter(Letter letter);
}
