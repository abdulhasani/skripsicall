package com.jmat.skripsicall.support.transfer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.CaseFormat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2/28/2016.
 */
public class ArrayTransfer<T>  {
    private final String resource;
    private List<T> items=new ArrayList<T>();

    public ArrayTransfer(Class<T> entityClass) {
        this.resource = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE,entityClass.toString());
    }

    public ArrayTransfer(Class<T> entityClass, List<T> items) {
        this.resource = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE,entityClass.toString());
        this.items=items;
    }

    @JsonProperty("resource")
    public String getResource() {
        return resource;
    }

    @JsonProperty("items")
    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public void addItem(T item){
        this.items.add(item);
    }


}
