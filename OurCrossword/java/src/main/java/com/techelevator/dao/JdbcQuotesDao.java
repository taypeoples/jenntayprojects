package com.techelevator.dao;

import com.techelevator.model.Quote;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component

public class JdbcQuotesDao implements QuotesDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcQuotesDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Quote getQuoteById() {
        Quote randomQuote = new Quote();
        int id = getRandomNumber();
        String sql = "SELECT quote_text, quote_author FROM quotes\n" +
                "WHERE quote_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
        if(result.next()) {
            randomQuote.setQuoteText(result.getString("quote_text"));
            randomQuote.setAuthor(result.getString("quote_author"));
            return randomQuote;
        }
        return null;
    }

    private int getRandomNumber() {
        int rand = 0;
        int max = 30;
        int min = 1;
        int range = max - min + 1;
        for (int i = 0; i < 30; i++) {
            rand = (int) (Math.random() * range) + min;
        }
        return rand;
    }
}
