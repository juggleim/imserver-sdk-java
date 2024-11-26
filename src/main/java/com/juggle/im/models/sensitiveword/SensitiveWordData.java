package com.juggle.im.models.sensitiveword;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SensitiveWordData {

    @SerializedName("items")
    private List<SensitiveWordResItem> items;

    @SerializedName("total")
    private Integer total;

    @SerializedName("is_finished")
    private Boolean isFinished;

    public SensitiveWordData() {
    }

    public List<SensitiveWordResItem> getItems() {
        return items;
    }

    public void setItems(List<SensitiveWordResItem> items) {
        this.items = items;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }

    private class SensitiveWordResItem {

        @SerializedName("id")
        private String id;

        @SerializedName("word")
        private String word;

        @SerializedName("word_type")
        private Integer wordType;

        public SensitiveWordResItem() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public Integer getWordType() {
            return wordType;
        }

        public void setWordType(Integer wordType) {
            this.wordType = wordType;
        }
    }

}
