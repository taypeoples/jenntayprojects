package com.techelevator.tenmo.model;


public class Word {

    private int id;
    private String word;
    private String clue;

    public Word(int id, String word, String clue) {
        this.id = id;
        this.word = word;
        this.clue = clue;
    }

    public Word(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getClue() {
        return clue;
    }

    public void setClue(String clue) {
        this.clue = clue;
    }
}
