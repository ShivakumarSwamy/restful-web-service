package com.example.restfulwebservice.dto;

import java.util.Objects;
import java.util.UUID;

public class Error {

    private UUID requestId;
    private String message;

    public UUID getRequestId() {
        return requestId;
    }

    public void setRequestId(UUID requestId) {
        this.requestId = requestId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        var error = (Error) o;
        return Objects.equals(requestId, error.requestId)
                && Objects.equals(message, error.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestId, message);
    }

    @Override
    public String toString() {
        return "Error{" + "requestId=" + requestId + ", message='" + message + '\'' + '}';
    }
}
