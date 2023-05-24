package com.techelevator.dao;

import com.techelevator.model.Message;

public interface MessageDao {

    Message getMessage();

    Message getFirstMessage();

    Message getMessageByKeyWords(String keyword1, String keyword2);


}
