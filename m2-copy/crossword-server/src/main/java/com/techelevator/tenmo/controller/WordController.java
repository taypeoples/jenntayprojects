package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.WordDao;
import com.techelevator.tenmo.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class WordController {
    @Autowired
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
