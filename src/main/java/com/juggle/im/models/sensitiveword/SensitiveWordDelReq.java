package com.juggle.im.models.sensitiveword;

import java.util.List;

public class SensitiveWordDelReq {

    private List<String> words;

    public SensitiveWordDelReq() {
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

}
