package com.techelevator.controller;

import com.techelevator.dao.QuotesDao;
import com.techelevator.model.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class QuotesController {
    @Autowired
    private QuotesDao quotesDao;

    @RequestMapping(path = "/quote", method = RequestMethod.GET)
    public Quote getQuote() {
        Quote newQuote = quotesDao.getQuoteById();
        return newQuote;
    }
}



