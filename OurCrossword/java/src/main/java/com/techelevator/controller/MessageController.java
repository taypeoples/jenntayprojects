package com.techelevator.controller;


import com.techelevator.dao.MessageDao;
import com.techelevator.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class MessageController {
    @Autowired
    private MessageDao messageDao;
    public MessageHelper helper = new MessageHelper();


    @RequestMapping(path = "/firstResponse", method = RequestMethod.GET)
    public Message getFirstMessage() {
        Message newMessage = messageDao.getFirstMessage();
        return newMessage;
    }

    @RequestMapping(path = "/messages", method = RequestMethod.POST)
    public Message getMessage(@RequestBody Message message) {
        String[] keyWords = helper.filterMessage(message.getMessageBody());
        Message newMessage = messageDao.getMessageByKeyWords(keyWords[0], keyWords[1]);
        return newMessage;
    }

    @RequestMapping(path = "/messages/{keyword_1}/{keyword_2}", method = RequestMethod.GET)
    public Message getMessageByKeyWords(@PathVariable String keyword_1, @PathVariable String keyword_2) {
        Message newMessage = messageDao.getMessageByKeyWords(keyword_1, keyword_2);
        return newMessage;
    }












}
