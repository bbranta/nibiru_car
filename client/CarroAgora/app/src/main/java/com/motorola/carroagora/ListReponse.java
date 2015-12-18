package com.motorola.carroagora;

import java.util.List;

/**
 * Created by rbresil on 12/17/15.
 */
public class ListReponse<T> {
    private List<T> items;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

}
