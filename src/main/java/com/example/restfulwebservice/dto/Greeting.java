package com.example.restfulwebservice.dto;

import java.util.Objects;

public class Greeting {

    private long id;
    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        var greeting = (Greeting) o;
        return id == greeting.id
                && Objects.equals(content, greeting.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content);
    }
}
