package com.juggle.im.models.sensitiveword;

import com.google.gson.annotations.SerializedName;

public class SensitiveWordReq {

    @SerializedName("page")
    private Integer page;

    @SerializedName("size")
    private Integer size;

    @SerializedName("word")
    private String word;

    @SerializedName("word_type")
    private Integer wordType;


    public SensitiveWordReq() {
    }

    public Integer getPage() {
        return page;
    }

    public SensitiveWordReq setPage(Integer page) {
        this.page = page;
        return this;
    }

    public Integer getSize() {
        return size;
    }

    public SensitiveWordReq setSize(Integer size) {
        this.size = size;
        return this;
    }

    public String getWord() {
        return word;
    }

    public SensitiveWordReq setWord(String word) {
        this.word = word;
        return this;
    }

    public Integer getWordType() {
        return wordType;
    }

    public SensitiveWordReq setWordType(Integer wordType) {
        this.wordType = wordType;
        return this;
    }


}
