package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.WordDao;
import com.techelevator.tenmo.model.Word;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WordController {

    private final WordDao wordDao;


    public WordController(WordDao wordDao) {
        this.wordDao = wordDao;
    }

    @RequestMapping(value = "/words", method = RequestMethod.GET)
    public List<Word> getAllWords() {
        return wordDao.findAllWords();
    }

    @RequestMapping(value = "/words/{id}", method = RequestMethod.GET)
    public String getWordByID(@PathVariable int id){
        return wordDao.findWordByID(id);
    }
}
