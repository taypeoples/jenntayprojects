package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Word;

import java.util.List;

public interface WordDao {
    List<Word> findAllWords();
    String findWordByID(int id);

    String findClueByID(int id);

    List<Word> findAllWordsByPuzzleID (int puzzleID);
    List<Word> findAllCluesByPuzzleID (int puzzleID);
}
