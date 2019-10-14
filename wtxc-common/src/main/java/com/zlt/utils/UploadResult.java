package com.zlt.utils;

import java.io.Serializable;

public class UploadResult implements Serializable {
    Integer Error;
    String message;
    String url;

    public Integer getError() {
        return Error;
    }

    public void setError(Integer error) {
        Error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
