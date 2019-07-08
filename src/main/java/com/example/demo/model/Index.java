package com.example.demo.model;

public class Index {
    char word;
    String list;

    public Index(char word, String list) {
        this.word = word;
        this.list = list;
    }

    public char getWord() {
        return word;
    }

    public void setWord(char word) {
        this.word = word;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }
}
