package com.juggle.im.models.sensitiveword;

import java.util.List;

public class SensitiveWordAddReq {

    private List<SensitiveWordItem> items;

    public SensitiveWordAddReq() {
    }

    public List<SensitiveWordItem> getItems() {
        return items;
    }

    public void setItems(List<SensitiveWordItem> items) {
        this.items = items;
    }


}
