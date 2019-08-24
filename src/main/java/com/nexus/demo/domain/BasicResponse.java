package com.nexus.demo.domain;

public class BasicResponse extends Response {

    private Object object;

    public BasicResponse(Object object) {
        this.object = object;
    }

    public BasicResponse() {}

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
