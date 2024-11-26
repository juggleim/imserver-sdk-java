package com.juggle.im.models.sensitiveword;

import com.google.gson.annotations.SerializedName;

public class SensitiveWordItem {

    @SerializedName("word")
    private String word;

    /**
     * 1: 拦截敏感词
     * 2: 替换敏感词
     */
    @SerializedName("word_type")
    private Integer wordType;

    public SensitiveWordItem(String word, Integer wordType) {
        this.word = word;
        this.wordType = wordType;
    }

    public String getWord() {
        return word;
    }

    public SensitiveWordItem setWord(String word) {
        this.word = word;
        return this;
    }

    public Integer getWordType() {
        return wordType;
    }

    public SensitiveWordItem setWordType(Integer wordType) {
        this.wordType = wordType;
        return this;
    }
}