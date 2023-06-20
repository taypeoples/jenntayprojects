package com.techelevator.tenmo.model;


public class Word {

    private int id;
    private String word;
    private String clue;
    private int puzzleID;

    public Word(int id, String word, String clue, int puzzleID) {
        this.id = id;
        this.word = word;
        this.clue = clue;
        this.puzzleID = puzzleID;
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

    public int getPuzzleID() {
        return puzzleID;
    }

    public void setPuzzleID(int puzzleID) {
        this.puzzleID = puzzleID;
    }
}
