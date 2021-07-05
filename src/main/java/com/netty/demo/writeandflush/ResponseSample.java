package com.netty.demo.writeandflush;

public class ResponseSample {

    private String data;
    private String code;
    private Long timestamp;

    public ResponseSample(String data, String code, Long timestamp) {
        this.data = data;
        this.code = code;
        this.timestamp = timestamp;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
