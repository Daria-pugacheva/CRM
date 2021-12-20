package ru.gb.pugacheva.crm.crmservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.pugacheva.crm.crmservice.dtos.Letter;
import ru.gb.pugacheva.crm.crmservice.services.LetterService;


@RestController
@RequestMapping("/api/v1/letters")
@RequiredArgsConstructor
public class LetterController {
    private final LetterService letterService;

    @GetMapping("/{address}/{type}")
    public Letter createLetter(@PathVariable String address, @PathVariable LetterService.LetterType type) {
        return letterService.createLetter(address, type);

    }

}
