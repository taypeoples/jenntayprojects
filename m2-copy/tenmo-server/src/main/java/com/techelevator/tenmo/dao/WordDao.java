package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Word;

import java.util.List;

public interface WordDao {
    List<Word> findAllWords();
    String findWordByID(int id);
}
