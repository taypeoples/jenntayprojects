package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Word;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcWordDao implements WordDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcWordDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Word> findAllWords() {
        List<Word> wordList = new ArrayList<>();
        String sql = "SELECT word FROM crossword";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            Word resultWord = new Word();
            String word = results.getString("word");
            resultWord.setWord(word);
            wordList.add(resultWord);
        }
        return wordList;
    }

    @Override
    public String findWordByID(int id) {
        String sql = "SELECT word FROM crossword WHERE word_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if(results.next()){
            String resultWord = results.getString("word");
            return resultWord;
        }
        return null;
    }

    @Override
    public String findClueByID(int id){
       String sql ="SELECT clue FROM crossword WHERE word_id = ? ";
       SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
       if(results.next()){
            String resultClue = results.getString("clue");
            return resultClue;
       }
       return null;
    }
}
